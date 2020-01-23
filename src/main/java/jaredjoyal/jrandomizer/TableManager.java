package jaredjoyal.jrandomizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.google.common.collect.Maps;

import net.minecraft.item.Item;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.WorldEvent.Load;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/*
 * This static class manages our table that maps one item to another random one.
 * It also intercepts events crucial for generating or reading the table per world.
 */
@EventBusSubscriber(modid = JRandomizer.modID)
public class TableManager
{
	// item mappings used to cycle items in a predictable manner
	private static Map<Item, Item> table = Maps.newHashMap();
	
	/*
	 * This function looks up the item that a given item maps to.
	 * If the item does not exist, that same item is returned.
	 * 
	 * item - the item to look up in the table
	 * 
	 * return - the item the inputted item maps to
	 */
	public static Item GetItemFromTable(Item item)
	{
		if (table.containsKey(item))
			return table.get(item);
		return item;
	}
	
	/*
	 * This helper function sets the table, given a full replacement.
	 * 
	 * newTable - the new table to override the class's static table
	 */
	private static void SetTable(Map<Item, Item> newTable)
	{
		table = newTable;
	}
	
	/*
	 * This helper function generates a new table, providing a 1-1 mapping of every item.
	 * 
	 * return - the randomized order of indices of items for serialization purposes
	 */
	private static Integer [] GenerateNewTable()
	{
		table.clear();
		Item [] allItems = ItemRandomizer.GetAllItems();
		ArrayList<Integer> indices = new ArrayList<Integer>(allItems.length);
		
		// construct an ordered indices array [0, allItems.length), then shuffle the order of indices
		for (int i = 0; i < allItems.length; ++i)
			indices.add(i);
		Collections.shuffle(indices);
		
		// map every item [0, allItems.length) to its newly-randomized counterpart by indexing our array of items
		Iterator<Integer> it = indices.iterator();
		int i = 0;
		while (it.hasNext())
			table.put(allItems[i++], allItems[it.next()]);
		
		// create and return an Integer array from our ArrayList
		Integer [] returnVal = new Integer [indices.size()];
		returnVal = indices.toArray(returnVal);
		return returnVal;
	}
	
	/*
	 * This helper function reads a given table file, updating the static map with the given indices.
	 * 
	 * inFile - the file from which to read indices
	 */
	private static void read(File inFile)
	{
		JRandomizer.logger.info("Reading table from TableManager file.");
		
		Map<Item, Item> table = Maps.newHashMap();
		Item [] allItems = ItemRandomizer.GetAllItems();
		int [] indices = new int [allItems.length];
		int i = 0;
		
		// attempt to create a new Scanner given ths inFile
		Scanner inS;
		try
		{
			inS = new Scanner(inFile);
		}
		catch (FileNotFoundException e)
		{
			JRandomizer.logger.error("Weird error in TableManager read: " + e.getMessage());
			return;
		}
		
		// read integers from file
		while (inS.hasNextInt())
		{
			try
			{
				indices[i++] = inS.nextInt();				
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				// if the file has more indices than our allItems array contains, we cannot do a 1-1 mapping
				JRandomizer.logger.error("TableManager file corrupted, regenerating table.");
				
				// instead, just generate a new table and write it to the file
				Integer [] newIndices = GenerateNewTable();
				write(inFile, newIndices);
				inS.close();
				return;
			}
		}
		
		if (i != allItems.length)
		{
			// if the file has less indices than our allItems array contains, we cannot do a 1-1 mapping
			JRandomizer.logger.error("TableManager file corrupted, regenerating table.");
			
			// instead, just generate a new table and write it to the file
			Integer [] newIndices = GenerateNewTable();
			write(inFile, newIndices);
			inS.close();
			return;
		}
		
		// for every item, add it to the map by indexing our array of all items
		for (i = 0; i < allItems.length; ++i)
		{
			if (indices[i] < 0 || indices[i] >= allItems.length)
			{
				// if the parsed index is out-of-bounds, we cannot do a 1-1 mapping
				JRandomizer.logger.error("TableManager file corrupted, regenerating table.");
				
				// instead, just generate a new table and write it to the file
				Integer [] newIndices = GenerateNewTable();
				write(inFile, newIndices);
				inS.close();
				return;
			}
			table.put(allItems[i], allItems[indices[i]]);
		}
		
		// set the table in our mod instance
		SetTable(table);

		// close file
		inS.close();
	}

	/*
	 * This helper function saves to file our randomly-shuffled indices.
	 * 
	 * outFile - the file to which to write
	 * indices - the indices for our item array to save
	 */
	private static void write(File outFile, Integer [] indices)
	{
		JRandomizer.logger.info("Writing table to TableManager file.");
		
		// try to open the file for writing
		FileWriter outFW;
		try
		{
			outFW = new FileWriter(outFile);
		}
		catch (IOException e)
		{
			JRandomizer.logger.error("Weird error in TableManager write: " + e.getMessage());
			return;
		}
		
		// write all the indices to the file, space-separated
		for (int i = 0; i < indices.length; ++i)
		{
			try
			{
				outFW.write(indices[i].toString() + " ");				
			}
			catch (IOException e)
			{
				JRandomizer.logger.error("Error writing to TableManager file: " + e.getMessage());
				break;
			}
		}
		
		// close file
		try
		{
			outFW.close();
		}
		catch (IOException e)
		{
			JRandomizer.logger.error("Error closing TableManager file: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*
	 * This function intercepts the World.Load event to load the table into mod instance memory.
	 * 
	 * event - the intercepted event with world data
	 */
	@SubscribeEvent
	public static void onLoad(Load event)
	{
		// check if world is local to this instance and is a server world
		if (!event.getWorld().isRemote() && event.getWorld() instanceof ServerWorld)
		{
			JRandomizer.logger.info("Intercepting Load event to set TableManager.");
			
			// get the save directory of this world, and ensure the existence of the JRandomizer subfolder
			File outFile = new File(((ServerWorld)event.getWorld()).getSaveHandler().getWorldDirectory().toString() + "\\JRandomizer\\table.dat");
			outFile.getParentFile().mkdirs();
			
			// check if file exists, and create if it doesn't
			if (!outFile.exists())
			{
				JRandomizer.logger.info("TableManager file for this world not found, creating new file.");
				Integer [] indices = GenerateNewTable();
				write(outFile, indices);
			}
			else
			{
				read(outFile);
			}
		}
	}
}
