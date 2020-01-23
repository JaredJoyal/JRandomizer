package jaredjoyal.jrandomizer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.TickEvent.WorldTickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/*
 * This static class intercepts events crucial for randomizing appropriate ItemEntities.
 */
@EventBusSubscriber(modid = JRandomizer.modID)
public class ItemEntityRandomizer
{
	// running list of items to not shuffle
	private static LinkedList<ItemEntity> ignoredItems = new LinkedList<ItemEntity>();
	// running list of items to add to the world
	private static LinkedList<ItemEntity> bufferedAddItems = new LinkedList<ItemEntity>();
	// flag to set when manually adding items that should not be shuffled
	private static boolean manualAddition = false;
	// random number generator
	private static Random r = new Random();
	
	/*
	 * This helper function checks what type of item is being generated. If the item needs
	 * NBT data, it generates the data and sets it to the item.
	 * 
	 * item - the item to potentially fill with NBT data
	 * 
	 * return - item variable changed
	 */
	private static void FillNBT(ItemStack item)
	{
		// give a shulker box a 50% chance of having an item inside it
		if (r.nextInt(2) == 0 && IsShulkerBox(item.getItem()))
		{
			JRandomizer.logger.info("Adding random item to shulker box NBT data.");
			
			// make sure random item is not itself a shulker box
			Item randomItem;
			do
			{
				randomItem = ItemRandomizer.GetRandomItem();
			} while (IsShulkerBox(randomItem));
			
			// get string id of item
			String unlocalizedName = randomItem.getTranslationKey();
			int index = unlocalizedName.indexOf("minecraft.");
			if (index == -1)
			{
				JRandomizer.logger.error("Could not get unlocalized name of object. Giving up.");
				return;
			}
			String randomID = unlocalizedName.substring(index).replace('.', ':');
			
			// generate nbt data
			try
			{
				CompoundNBT nbt = JsonToNBT.getTagFromJson("{BlockEntityTag:{Items:"
						+ "[{Count:1b,Slot:13,id:\"" + randomID + "\"}]}}");
				item.setTag(nbt);
			}
			catch (CommandSyntaxException e)
			{
				JRandomizer.logger.error("Could not generate CompoundNBT tag. Error: " + e.getMessage());
			}
		}
		// give a potion a random potion effect
		else if (IsPotion(item.getItem()))
		{
			JRandomizer.logger.info("Adding random potion effect to potion NBT data.");

			// generate nbt data
			try
			{
				// randomize potion effect properties
				int effectID = r.nextInt(32) + 1;
				int amplifier = r.nextInt(5);
				int duration = r.nextInt(3600) + 1;
				CompoundNBT nbt = JsonToNBT.getTagFromJson("{CustomPotionEffects:[{Id:" + effectID +
						 ",Amplifier:" + amplifier + ",Duration:" + duration + "}]}");
				item.setTag(nbt);
			}
			catch (CommandSyntaxException e)
			{
				JRandomizer.logger.error("Could not generate CompoundNBT tag. Error: " + e.getMessage());
			}
		}
		// give a tipped arrow a random potion effect
		else if (item.getItem().equals(Items.TIPPED_ARROW))
		{
			JRandomizer.logger.info("Adding random potion effect to tipped arrow NBT data.");

			// generate nbt data
			try
			{
				// randomize potion effect properties
				int effectID = r.nextInt(32) + 1;
				int amplifier = r.nextInt(5);
				int duration = r.nextInt(3600) + 1;
				CompoundNBT nbt = JsonToNBT.getTagFromJson("{CustomPotionEffects:[{Id:" + effectID +
						 ",Amplifier:" + amplifier + ",Duration:" + duration + "}]}");
				item.setTag(nbt);
			}
			catch (CommandSyntaxException e)
			{
				JRandomizer.logger.error("Could not generate CompoundNBT tag. Error: " + e.getMessage());
			}
		}
		// give suspicious stew a random potion effect
		else if (item.getItem().equals(Items.SUSPICIOUS_STEW))
		{
			JRandomizer.logger.info("Adding random potion effect to suspicious stew NBT data.");

			// generate nbt data
			try
			{
				// randomize effect properties
				int effectID = r.nextInt(32) + 1;
				int amplifier = r.nextInt(5);
				int duration = r.nextInt(3600) + 1;
				CompoundNBT nbt = JsonToNBT.getTagFromJson("{Effects:[{EffectId:" + effectID +
						",EffectDuration:" + duration + "}]}");
				item.setTag(nbt);
			}
			catch (CommandSyntaxException e)
			{
				JRandomizer.logger.error("Could not generate CompoundNBT tag. Error: " + e.getMessage());
			}
		}
		// put random words in a written book
		else if (item.getItem().equals(Items.WRITTEN_BOOK))
		{
			JRandomizer.logger.info("Adding random text to written book NBT data.");

			// generate nbt data
			try
			{
				// get random sentence and make it play nice with the json parser
				String randomSentence = SentenceGenerator.GetRandomSentence();
				randomSentence.replace("'", "\\'");
				CompoundNBT nbt = JsonToNBT.getTagFromJson("{author:\"JaredJoyal\",title:\"A Short Story\","
						+ "pages:[\'{\"text\":\"" + randomSentence + "\"}\']}");
				item.setTag(nbt);
			}
			catch (CommandSyntaxException e)
			{
				JRandomizer.logger.error("Could not generate CompoundNBT tag. Error: " + e.getMessage());
			}
		}
		// put random enchantment on enchanted book
		else if (item.getItem().equals(Items.ENCHANTED_BOOK))
		{
			JRandomizer.logger.info("Adding random enchantment(s) to enchanted book NBT data.");

			// "jason" sounds like "json". haha funny joke.
			String jason = "{StoredEnchantments:[";
			
			// give it a chance to have multiple enchantments
			int numEnchantments = 0;
			do
			{
				Enchantment ench;
				String enchID;
				// make sure you do not repeat an enchantment
				// potential infinite loop mitigated by numEnchantments cap at 10
				do
				{
					ench = EnchantmentRandomizer.GetRandomEnchantment();
					enchID = ench.getName().replace(' ', '_')
							.replace("enchantment.minecraft.", "minecraft:").toLowerCase();
				} while (jason.contains(enchID));
				
				int enchLvl = r.nextInt(ench.getMaxLevel()) + 1;
				// comma included to separate enchantments in json list
				jason += "{id:\"" + enchID + "\",lvl:" + enchLvl + "},";
				++numEnchantments;
				
				// give it a 1/3 chance to have another enchantment
			} while (r.nextInt(3) == 0 && numEnchantments <= 10);
			
			// generate nbt data
			try
			{
				// substring gets rid of the comma from the last item entry
				CompoundNBT nbt = JsonToNBT.getTagFromJson(jason.substring(0, jason.length() - 1) + "]}");
				item.setTag(nbt);
			}
			catch (CommandSyntaxException e)
			{
				JRandomizer.logger.error("Could not generate CompoundNBT tag. Error: " + e.getMessage());
			}
		}
	}
	
	/*
	 * This helper function checks if a given item is a shulker box of any kind.
	 * 
	 * item - the item to check
	 * 
	 * return - true if the item is any color of shulker box
	 */
	private static boolean IsShulkerBox(Item item)
	{
		return item.equals(Items.SHULKER_BOX) ||
				item.equals(Items.WHITE_SHULKER_BOX) ||
				item.equals(Items.LIGHT_GRAY_SHULKER_BOX) ||
				item.equals(Items.GRAY_SHULKER_BOX) ||
				item.equals(Items.BLACK_SHULKER_BOX) ||
				item.equals(Items.RED_SHULKER_BOX) ||
				item.equals(Items.ORANGE_SHULKER_BOX) ||
				item.equals(Items.YELLOW_SHULKER_BOX) ||
				item.equals(Items.LIME_SHULKER_BOX) ||
				item.equals(Items.GREEN_SHULKER_BOX) ||
				item.equals(Items.LIGHT_BLUE_SHULKER_BOX) ||
				item.equals(Items.CYAN_SHULKER_BOX) ||
				item.equals(Items.BLUE_SHULKER_BOX) ||
				item.equals(Items.PURPLE_SHULKER_BOX) ||
				item.equals(Items.MAGENTA_SHULKER_BOX) ||
				item.equals(Items.PINK_SHULKER_BOX) ||
				item.equals(Items.BROWN_SHULKER_BOX);
	}
	
	/*
	 * This helper function checks if an item is a potion of any kind.
	 * 
	 * item - the item to check
	 * 
	 * return - true if the item is a potion: regular, lingering, or splash
	 */
	private static boolean IsPotion(Item item)
	{
		return item.equals(Items.LINGERING_POTION) ||
				 item.equals(Items.POTION) ||
				 item.equals(Items.SPLASH_POTION);
	}
	
	/*
	 * This function intercepts the EntityJoinWorldEvent to check if a new entity is an item entity.
	 * If the entity is a newly-spawned item (with some exceptions), it will be randomized.
	 * 
	 * event - the intercepted event with world/entity data
	 */
	@SubscribeEvent
	public static void onEntityJoinWorldEvent(EntityJoinWorldEvent event)
	{
		boolean bLocalWorld = !event.getWorld().isRemote();
		boolean bIsItem = event.getEntity() instanceof ItemEntity;
		boolean bNoLastPosition = new Vec3d(event.getEntity().prevPosX, event.getEntity().prevPosY, event.getEntity().prevPosZ).equals(Vec3d.ZERO);
		// if entity has no last position, it was just spawned. this avoids item shuffling on chunk/world reloading
		if (!manualAddition && bLocalWorld && bIsItem && bNoLastPosition)
		{
			JRandomizer.logger.info("Intercepting EntityJoinWorldEvent to change item drop.");
			ItemEntity iEntity = (ItemEntity)event.getEntity();
			
			// check if this item is intended to be ignored
			if (ignoredItems.contains(iEntity))
			{
				JRandomizer.logger.info("Randomization ignored due to ItemTossEvent.");
				ignoredItems.remove(iEntity);
				return;
			}
			
			JRandomizer.logger.info("Item started as: " + iEntity.getItem());
			
			// get corresponding item from table for randomization
			Item newItem = TableManager.GetItemFromTable(iEntity.getItem().getItem());
			int itemCount = iEntity.getItem().getCount();
			
			// make sure max stacks are maintained
			while (itemCount != 0)
			{
				ItemStack newItemStack = new ItemStack(newItem, itemCount);
				int thisStackCount = Math.min(itemCount, newItem.getItemStackLimit(newItemStack));
				newItemStack.setCount(thisStackCount);
				
				FillNBT(newItemStack);
				iEntity.setItem(newItemStack);
				Vec3d ieP = iEntity.getPositionVec();
				itemCount -= thisStackCount;
				
				// if there are more items than the item stack limit, we need to spawn a new ItemEntity
				// however, if we spawn it now, the server thread may lock on world load; buffer it
				if (itemCount > 0)
				{
					ItemEntity ie = new ItemEntity(iEntity.getEntityWorld(), ieP.x, ieP.y, ieP.z, newItemStack);
					bufferedAddItems.add(ie);
				}
			}
		}
	}
	
	/*
	 * This function intercepts the ItemTossEvent to ignore randomizing items that players drop.
	 * 
	 * event - the intercepted event with entity data
	 */
	@SubscribeEvent
	public static void onItemTossEvent(ItemTossEvent event)
	{
		JRandomizer.logger.info("Intercepting ItemTossEvent to ignore item randomization.");
		ignoredItems.add(event.getEntityItem());
	}
	
	/*
	 * This function intercepts the LivingDropsEvent to ignore randomizing items dropped by a player on death.
	 * 
	 * event - the intercepted event with entity data
	 */
	@SubscribeEvent
	public static void onLivingDropsEvent(LivingDropsEvent event)
	{
		// check if the entity that died was a player
		if (event.getEntity().getType().getName().getString().equals(new String("Player")))
		{
			JRandomizer.logger.info("Intercepting LivingDropsEvent to ignore item randomization on player death.");

			// add all items the player dropped to our ignored list
			Iterator<ItemEntity> it = event.getDrops().iterator();
			while (it.hasNext())
			{
				ignoredItems.add(it.next());
			}
		}
	}
	
	/*
	 * This function intercepts the WorldTickEvent to progressively spawn buffered ItemEntities.
	 * Oh Lord help me for using a Tick Event.
	 * 
	 * event - the intercepted event with world data
	 */
	@SubscribeEvent
	public static void onWorldTickEvent(WorldTickEvent event)
	{
		// check if we have any items to spawn and the world is local to this instance
		if (!bufferedAddItems.isEmpty() && !event.world.isRemote())
		{
			JRandomizer.logger.info("Intercepting WorldTickEvent to add buffered item entities.");
			
			// only spawn the first of our buffered items - wouldn't want the server thread to lock (for some reason)
			ItemEntity ie = bufferedAddItems.remove(0);
			// let the onEntityJoinWorldEvent function know that we do not want this item randomized
			manualAddition = true;
			event.world.addEntity(ie);
			manualAddition = false;
		}
	}
}
