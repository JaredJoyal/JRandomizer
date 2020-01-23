package jaredjoyal.jrandomizer;

import java.util.Random;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;

/*
 * This static class is responsible for generating a random enchantment upon request.
 */
public class EnchantmentRandomizer
{
	// list of all possible enchantments
	private static Enchantment [] allEnchantments =
			{Enchantments.PROTECTION,
			Enchantments.FIRE_PROTECTION,
			Enchantments.FEATHER_FALLING,
			Enchantments.BLAST_PROTECTION,
			Enchantments.PROJECTILE_PROTECTION,
			Enchantments.RESPIRATION,
			Enchantments.AQUA_AFFINITY,
			Enchantments.THORNS,
			Enchantments.DEPTH_STRIDER,
			Enchantments.FROST_WALKER,
			Enchantments.BINDING_CURSE,
			Enchantments.SHARPNESS,
			Enchantments.SMITE,
			Enchantments.BANE_OF_ARTHROPODS,
			Enchantments.KNOCKBACK,
			Enchantments.FIRE_ASPECT,
			Enchantments.LOOTING,
			Enchantments.SWEEPING,
			Enchantments.EFFICIENCY,
			Enchantments.SILK_TOUCH,
			Enchantments.UNBREAKING,
			Enchantments.FORTUNE,
			Enchantments.POWER,
			Enchantments.PUNCH,
			Enchantments.FLAME,
			Enchantments.INFINITY,
			Enchantments.LUCK_OF_THE_SEA,
			Enchantments.LURE,
			Enchantments.LOYALTY,
			Enchantments.IMPALING,
			Enchantments.RIPTIDE,
			Enchantments.CHANNELING,
			Enchantments.MULTISHOT,
			Enchantments.QUICK_CHARGE,
			Enchantments.PIERCING,
			Enchantments.MENDING,
			Enchantments.VANISHING_CURSE};
	// random number generator
	private static Random r = new Random();
	
	/*
	 * This function generates a random enchantment from the list of all enchantments
	 */
	public static Enchantment GetRandomEnchantment()
	{
		return allEnchantments[r.nextInt(allEnchantments.length)];
	}
}
