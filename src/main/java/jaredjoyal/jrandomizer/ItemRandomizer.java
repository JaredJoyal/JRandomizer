package jaredjoyal.jrandomizer;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

/*
 * This static class offers a list of all items and a way to get a random item.
 */
public class ItemRandomizer
{
	// list of all items desired, ignoring some creative mode or debug items
	private static Item [] allItems = new Item []
	{
		//Items.AIR,
		Items.STONE,
		Items.GRANITE,
		Items.POLISHED_GRANITE,
		Items.DIORITE,
		Items.POLISHED_DIORITE,
		Items.ANDESITE,
		Items.POLISHED_ANDESITE,
		Items.GRASS_BLOCK,
		Items.DIRT,
		Items.COARSE_DIRT,
		Items.PODZOL,
		Items.COBBLESTONE,
		Items.OAK_PLANKS,
		Items.SPRUCE_PLANKS,
		Items.BIRCH_PLANKS,
		Items.JUNGLE_PLANKS,
		Items.ACACIA_PLANKS,
		Items.DARK_OAK_PLANKS,
		Items.OAK_SAPLING,
		Items.SPRUCE_SAPLING,
		Items.BIRCH_SAPLING,
		Items.JUNGLE_SAPLING,
		Items.ACACIA_SAPLING,
		Items.DARK_OAK_SAPLING,
		Items.BEDROCK,
		Items.SAND,
		Items.RED_SAND,
		Items.GRAVEL,
		Items.GOLD_ORE,
		Items.IRON_ORE,
		Items.COAL_ORE,
		Items.OAK_LOG,
		Items.SPRUCE_LOG,
		Items.BIRCH_LOG,
		Items.JUNGLE_LOG,
		Items.ACACIA_LOG,
		Items.DARK_OAK_LOG,
		Items.STRIPPED_OAK_LOG,
		Items.STRIPPED_SPRUCE_LOG,
		Items.STRIPPED_BIRCH_LOG,
		Items.STRIPPED_JUNGLE_LOG,
		Items.STRIPPED_ACACIA_LOG,
		Items.STRIPPED_DARK_OAK_LOG,
		Items.STRIPPED_OAK_WOOD,
		Items.STRIPPED_SPRUCE_WOOD,
		Items.STRIPPED_BIRCH_WOOD,
		Items.STRIPPED_JUNGLE_WOOD,
		Items.STRIPPED_ACACIA_WOOD,
		Items.STRIPPED_DARK_OAK_WOOD,
		Items.OAK_WOOD,
		Items.SPRUCE_WOOD,
		Items.BIRCH_WOOD,
		Items.JUNGLE_WOOD,
		Items.ACACIA_WOOD,
		Items.DARK_OAK_WOOD,
		Items.OAK_LEAVES,
		Items.SPRUCE_LEAVES,
		Items.BIRCH_LEAVES,
		Items.JUNGLE_LEAVES,
		Items.ACACIA_LEAVES,
		Items.DARK_OAK_LEAVES,
		Items.SPONGE,
		Items.WET_SPONGE,
		Items.GLASS,
		Items.LAPIS_ORE,
		Items.LAPIS_BLOCK,
		Items.DISPENSER,
		Items.SANDSTONE,
		Items.CHISELED_SANDSTONE,
		Items.CUT_SANDSTONE,
		Items.NOTE_BLOCK,
		Items.POWERED_RAIL,
		Items.DETECTOR_RAIL,
		Items.STICKY_PISTON,
		Items.COBWEB,
		Items.GRASS,
		Items.FERN,
		Items.DEAD_BUSH,
		Items.SEAGRASS,
		Items.SEA_PICKLE,
		Items.PISTON,
		Items.WHITE_WOOL,
		Items.ORANGE_WOOL,
		Items.MAGENTA_WOOL,
		Items.LIGHT_BLUE_WOOL,
		Items.YELLOW_WOOL,
		Items.LIME_WOOL,
		Items.PINK_WOOL,
		Items.GRAY_WOOL,
		Items.LIGHT_GRAY_WOOL,
		Items.CYAN_WOOL,
		Items.PURPLE_WOOL,
		Items.BLUE_WOOL,
		Items.BROWN_WOOL,
		Items.GREEN_WOOL,
		Items.RED_WOOL,
		Items.BLACK_WOOL,
		Items.DANDELION,
		Items.POPPY,
		Items.BLUE_ORCHID,
		Items.ALLIUM,
		Items.AZURE_BLUET,
		Items.RED_TULIP,
		Items.ORANGE_TULIP,
		Items.WHITE_TULIP,
		Items.PINK_TULIP,
		Items.OXEYE_DAISY,
		Items.CORNFLOWER,
		Items.LILY_OF_THE_VALLEY,
		Items.WITHER_ROSE,
		Items.BROWN_MUSHROOM,
		Items.RED_MUSHROOM,
		Items.GOLD_BLOCK,
		Items.IRON_BLOCK,
		Items.OAK_SLAB,
		Items.SPRUCE_SLAB,
		Items.BIRCH_SLAB,
		Items.JUNGLE_SLAB,
		Items.ACACIA_SLAB,
		Items.DARK_OAK_SLAB,
		Items.STONE_SLAB,
		Items.SMOOTH_STONE_SLAB,
		Items.SANDSTONE_SLAB,
		Items.CUT_SANDSTONE_SLAB,
		Items.PETRIFIED_OAK_SLAB,
		Items.COBBLESTONE_SLAB,
		Items.BRICK_SLAB,
		Items.STONE_BRICK_SLAB,
		Items.NETHER_BRICK_SLAB,
		Items.QUARTZ_SLAB,
		Items.RED_SANDSTONE_SLAB,
		Items.CUT_RED_SANDSTONE_SLAB,
		Items.PURPUR_SLAB,
		Items.PRISMARINE_SLAB,
		Items.PRISMARINE_BRICK_SLAB,
		Items.DARK_PRISMARINE_SLAB,
		Items.SMOOTH_QUARTZ,
		Items.SMOOTH_RED_SANDSTONE,
		Items.SMOOTH_SANDSTONE,
		Items.SMOOTH_STONE,
		Items.BRICKS,
		Items.TNT,
		Items.BOOKSHELF,
		Items.MOSSY_COBBLESTONE,
		Items.OBSIDIAN,
		Items.TORCH,
		Items.END_ROD,
		Items.CHORUS_PLANT,
		Items.CHORUS_FLOWER,
		Items.PURPUR_BLOCK,
		Items.PURPUR_PILLAR,
		Items.PURPUR_STAIRS,
		Items.SPAWNER,
		Items.OAK_STAIRS,
		Items.CHEST,
		Items.DIAMOND_ORE,
		Items.DIAMOND_BLOCK,
		Items.CRAFTING_TABLE,
		Items.FARMLAND,
		Items.FURNACE,
		Items.LADDER,
		Items.RAIL,
		Items.COBBLESTONE_STAIRS,
		Items.LEVER,
		Items.STONE_PRESSURE_PLATE,
		Items.OAK_PRESSURE_PLATE,
		Items.SPRUCE_PRESSURE_PLATE,
		Items.BIRCH_PRESSURE_PLATE,
		Items.JUNGLE_PRESSURE_PLATE,
		Items.ACACIA_PRESSURE_PLATE,
		Items.DARK_OAK_PRESSURE_PLATE,
		Items.REDSTONE_ORE,
		Items.REDSTONE_TORCH,
		Items.STONE_BUTTON,
		Items.SNOW,
		Items.ICE,
		Items.SNOW_BLOCK,
		Items.CACTUS,
		Items.CLAY,
		Items.JUKEBOX,
		Items.OAK_FENCE,
		Items.SPRUCE_FENCE,
		Items.BIRCH_FENCE,
		Items.JUNGLE_FENCE,
		Items.ACACIA_FENCE,
		Items.DARK_OAK_FENCE,
		Items.PUMPKIN,
		Items.CARVED_PUMPKIN,
		Items.NETHERRACK,
		Items.SOUL_SAND,
		Items.GLOWSTONE,
		Items.JACK_O_LANTERN,
		Items.OAK_TRAPDOOR,
		Items.SPRUCE_TRAPDOOR,
		Items.BIRCH_TRAPDOOR,
		Items.JUNGLE_TRAPDOOR,
		Items.ACACIA_TRAPDOOR,
		Items.DARK_OAK_TRAPDOOR,
		Items.INFESTED_STONE,
		Items.INFESTED_COBBLESTONE,
		Items.INFESTED_STONE_BRICKS,
		Items.INFESTED_MOSSY_STONE_BRICKS,
		Items.INFESTED_CRACKED_STONE_BRICKS,
		Items.INFESTED_CHISELED_STONE_BRICKS,
		Items.STONE_BRICKS,
		Items.MOSSY_STONE_BRICKS,
		Items.CRACKED_STONE_BRICKS,
		Items.CHISELED_STONE_BRICKS,
		Items.BROWN_MUSHROOM_BLOCK,
		Items.RED_MUSHROOM_BLOCK,
		Items.MUSHROOM_STEM,
		Items.IRON_BARS,
		Items.GLASS_PANE,
		Items.MELON,
		Items.VINE,
		Items.OAK_FENCE_GATE,
		Items.SPRUCE_FENCE_GATE,
		Items.BIRCH_FENCE_GATE,
		Items.JUNGLE_FENCE_GATE,
		Items.ACACIA_FENCE_GATE,
		Items.DARK_OAK_FENCE_GATE,
		Items.BRICK_STAIRS,
		Items.STONE_BRICK_STAIRS,
		Items.MYCELIUM,
		Items.LILY_PAD,
		Items.NETHER_BRICKS,
		Items.NETHER_BRICK_FENCE,
		Items.NETHER_BRICK_STAIRS,
		Items.ENCHANTING_TABLE,
		Items.END_PORTAL_FRAME,
		Items.END_STONE,
		Items.END_STONE_BRICKS,
		Items.DRAGON_EGG,
		Items.REDSTONE_LAMP,
		Items.SANDSTONE_STAIRS,
		Items.EMERALD_ORE,
		Items.ENDER_CHEST,
		Items.TRIPWIRE_HOOK,
		Items.EMERALD_BLOCK,
		Items.SPRUCE_STAIRS,
		Items.BIRCH_STAIRS,
		Items.JUNGLE_STAIRS,
		//Items.COMMAND_BLOCK,
		Items.BEACON,
		Items.COBBLESTONE_WALL,
		Items.MOSSY_COBBLESTONE_WALL,
		Items.BRICK_WALL,
		Items.PRISMARINE_WALL,
		Items.RED_SANDSTONE_WALL,
		Items.MOSSY_STONE_BRICK_WALL,
		Items.GRANITE_WALL,
		Items.STONE_BRICK_WALL,
		Items.NETHER_BRICK_WALL,
		Items.ANDESITE_WALL,
		Items.RED_NETHER_BRICK_WALL,
		Items.SANDSTONE_WALL,
		Items.END_STONE_BRICK_WALL,
		Items.DIORITE_WALL,
		Items.OAK_BUTTON,
		Items.SPRUCE_BUTTON,
		Items.BIRCH_BUTTON,
		Items.JUNGLE_BUTTON,
		Items.ACACIA_BUTTON,
		Items.DARK_OAK_BUTTON,
		Items.ANVIL,
		Items.CHIPPED_ANVIL,
		Items.DAMAGED_ANVIL,
		Items.TRAPPED_CHEST,
		Items.LIGHT_WEIGHTED_PRESSURE_PLATE,
		Items.HEAVY_WEIGHTED_PRESSURE_PLATE,
		Items.DAYLIGHT_DETECTOR,
		Items.REDSTONE_BLOCK,
		Items.NETHER_QUARTZ_ORE,
		Items.HOPPER,
		Items.CHISELED_QUARTZ_BLOCK,
		Items.QUARTZ_BLOCK,
		Items.QUARTZ_PILLAR,
		Items.QUARTZ_STAIRS,
		Items.ACTIVATOR_RAIL,
		Items.DROPPER,
		Items.WHITE_TERRACOTTA,
		Items.ORANGE_TERRACOTTA,
		Items.MAGENTA_TERRACOTTA,
		Items.LIGHT_BLUE_TERRACOTTA,
		Items.YELLOW_TERRACOTTA,
		Items.LIME_TERRACOTTA,
		Items.PINK_TERRACOTTA,
		Items.GRAY_TERRACOTTA,
		Items.LIGHT_GRAY_TERRACOTTA,
		Items.CYAN_TERRACOTTA,
		Items.PURPLE_TERRACOTTA,
		Items.BLUE_TERRACOTTA,
		Items.BROWN_TERRACOTTA,
		Items.GREEN_TERRACOTTA,
		Items.RED_TERRACOTTA,
		Items.BLACK_TERRACOTTA,
		//Items.BARRIER,
		Items.IRON_TRAPDOOR,
		Items.HAY_BLOCK,
		Items.WHITE_CARPET,
		Items.ORANGE_CARPET,
		Items.MAGENTA_CARPET,
		Items.LIGHT_BLUE_CARPET,
		Items.YELLOW_CARPET,
		Items.LIME_CARPET,
		Items.PINK_CARPET,
		Items.GRAY_CARPET,
		Items.LIGHT_GRAY_CARPET,
		Items.CYAN_CARPET,
		Items.PURPLE_CARPET,
		Items.BLUE_CARPET,
		Items.BROWN_CARPET,
		Items.GREEN_CARPET,
		Items.RED_CARPET,
		Items.BLACK_CARPET,
		Items.TERRACOTTA,
		Items.COAL_BLOCK,
		Items.PACKED_ICE,
		Items.ACACIA_STAIRS,
		Items.DARK_OAK_STAIRS,
		Items.SLIME_BLOCK,
		Items.GRASS_PATH,
		Items.SUNFLOWER,
		Items.LILAC,
		Items.ROSE_BUSH,
		Items.PEONY,
		Items.TALL_GRASS,
		Items.LARGE_FERN,
		Items.WHITE_STAINED_GLASS,
		Items.ORANGE_STAINED_GLASS,
		Items.MAGENTA_STAINED_GLASS,
		Items.LIGHT_BLUE_STAINED_GLASS,
		Items.YELLOW_STAINED_GLASS,
		Items.LIME_STAINED_GLASS,
		Items.PINK_STAINED_GLASS,
		Items.GRAY_STAINED_GLASS,
		Items.LIGHT_GRAY_STAINED_GLASS,
		Items.CYAN_STAINED_GLASS,
		Items.PURPLE_STAINED_GLASS,
		Items.BLUE_STAINED_GLASS,
		Items.BROWN_STAINED_GLASS,
		Items.GREEN_STAINED_GLASS,
		Items.RED_STAINED_GLASS,
		Items.BLACK_STAINED_GLASS,
		Items.WHITE_STAINED_GLASS_PANE,
		Items.ORANGE_STAINED_GLASS_PANE,
		Items.MAGENTA_STAINED_GLASS_PANE,
		Items.LIGHT_BLUE_STAINED_GLASS_PANE,
		Items.YELLOW_STAINED_GLASS_PANE,
		Items.LIME_STAINED_GLASS_PANE,
		Items.PINK_STAINED_GLASS_PANE,
		Items.GRAY_STAINED_GLASS_PANE,
		Items.LIGHT_GRAY_STAINED_GLASS_PANE,
		Items.CYAN_STAINED_GLASS_PANE,
		Items.PURPLE_STAINED_GLASS_PANE,
		Items.BLUE_STAINED_GLASS_PANE,
		Items.BROWN_STAINED_GLASS_PANE,
		Items.GREEN_STAINED_GLASS_PANE,
		Items.RED_STAINED_GLASS_PANE,
		Items.BLACK_STAINED_GLASS_PANE,
		Items.PRISMARINE,
		Items.PRISMARINE_BRICKS,
		Items.DARK_PRISMARINE,
		Items.PRISMARINE_STAIRS,
		Items.PRISMARINE_BRICK_STAIRS,
		Items.DARK_PRISMARINE_STAIRS,
		Items.SEA_LANTERN,
		Items.RED_SANDSTONE,
		Items.CHISELED_RED_SANDSTONE,
		Items.CUT_RED_SANDSTONE,
		Items.RED_SANDSTONE_STAIRS,
		//Items.REPEATING_COMMAND_BLOCK,
		//Items.CHAIN_COMMAND_BLOCK,
		Items.MAGMA_BLOCK,
		Items.NETHER_WART_BLOCK,
		Items.RED_NETHER_BRICKS,
		Items.BONE_BLOCK,
		//Items.STRUCTURE_VOID,
		Items.OBSERVER,
		Items.SHULKER_BOX,
		Items.WHITE_SHULKER_BOX,
		Items.ORANGE_SHULKER_BOX,
		Items.MAGENTA_SHULKER_BOX,
		Items.LIGHT_BLUE_SHULKER_BOX,
		Items.YELLOW_SHULKER_BOX,
		Items.LIME_SHULKER_BOX,
		Items.PINK_SHULKER_BOX,
		Items.GRAY_SHULKER_BOX,
		Items.LIGHT_GRAY_SHULKER_BOX,
		Items.CYAN_SHULKER_BOX,
		Items.PURPLE_SHULKER_BOX,
		Items.BLUE_SHULKER_BOX,
		Items.BROWN_SHULKER_BOX,
		Items.GREEN_SHULKER_BOX,
		Items.RED_SHULKER_BOX,
		Items.BLACK_SHULKER_BOX,
		Items.WHITE_GLAZED_TERRACOTTA,
		Items.ORANGE_GLAZED_TERRACOTTA,
		Items.MAGENTA_GLAZED_TERRACOTTA,
		Items.LIGHT_BLUE_GLAZED_TERRACOTTA,
		Items.YELLOW_GLAZED_TERRACOTTA,
		Items.LIME_GLAZED_TERRACOTTA,
		Items.PINK_GLAZED_TERRACOTTA,
		Items.GRAY_GLAZED_TERRACOTTA,
		Items.LIGHT_GRAY_GLAZED_TERRACOTTA,
		Items.CYAN_GLAZED_TERRACOTTA,
		Items.PURPLE_GLAZED_TERRACOTTA,
		Items.BLUE_GLAZED_TERRACOTTA,
		Items.BROWN_GLAZED_TERRACOTTA,
		Items.GREEN_GLAZED_TERRACOTTA,
		Items.RED_GLAZED_TERRACOTTA,
		Items.BLACK_GLAZED_TERRACOTTA,
		Items.WHITE_CONCRETE,
		Items.ORANGE_CONCRETE,
		Items.MAGENTA_CONCRETE,
		Items.LIGHT_BLUE_CONCRETE,
		Items.YELLOW_CONCRETE,
		Items.LIME_CONCRETE,
		Items.PINK_CONCRETE,
		Items.GRAY_CONCRETE,
		Items.LIGHT_GRAY_CONCRETE,
		Items.CYAN_CONCRETE,
		Items.PURPLE_CONCRETE,
		Items.BLUE_CONCRETE,
		Items.BROWN_CONCRETE,
		Items.GREEN_CONCRETE,
		Items.RED_CONCRETE,
		Items.BLACK_CONCRETE,
		Items.WHITE_CONCRETE_POWDER,
		Items.ORANGE_CONCRETE_POWDER,
		Items.MAGENTA_CONCRETE_POWDER,
		Items.LIGHT_BLUE_CONCRETE_POWDER,
		Items.YELLOW_CONCRETE_POWDER,
		Items.LIME_CONCRETE_POWDER,
		Items.PINK_CONCRETE_POWDER,
		Items.GRAY_CONCRETE_POWDER,
		Items.LIGHT_GRAY_CONCRETE_POWDER,
		Items.CYAN_CONCRETE_POWDER,
		Items.PURPLE_CONCRETE_POWDER,
		Items.BLUE_CONCRETE_POWDER,
		Items.BROWN_CONCRETE_POWDER,
		Items.GREEN_CONCRETE_POWDER,
		Items.RED_CONCRETE_POWDER,
		Items.BLACK_CONCRETE_POWDER,
		Items.TURTLE_EGG,
		Items.DEAD_TUBE_CORAL_BLOCK,
		Items.DEAD_BRAIN_CORAL_BLOCK,
		Items.DEAD_BUBBLE_CORAL_BLOCK,
		Items.DEAD_FIRE_CORAL_BLOCK,
		Items.DEAD_HORN_CORAL_BLOCK,
		Items.TUBE_CORAL_BLOCK,
		Items.BRAIN_CORAL_BLOCK,
		Items.BUBBLE_CORAL_BLOCK,
		Items.FIRE_CORAL_BLOCK,
		Items.HORN_CORAL_BLOCK,
		Items.TUBE_CORAL,
		Items.BRAIN_CORAL,
		Items.BUBBLE_CORAL,
		Items.FIRE_CORAL,
		Items.HORN_CORAL,
		Items.DEAD_BRAIN_CORAL,
		Items.DEAD_BUBBLE_CORAL,
		Items.DEAD_FIRE_CORAL,
		Items.DEAD_HORN_CORAL,
		Items.DEAD_TUBE_CORAL,
		Items.TUBE_CORAL_FAN,
		Items.BRAIN_CORAL_FAN,
		Items.BUBBLE_CORAL_FAN,
		Items.FIRE_CORAL_FAN,
		Items.HORN_CORAL_FAN,
		Items.DEAD_TUBE_CORAL_FAN,
		Items.DEAD_BRAIN_CORAL_FAN,
		Items.DEAD_BUBBLE_CORAL_FAN,
		Items.DEAD_FIRE_CORAL_FAN,
		Items.DEAD_HORN_CORAL_FAN,
		Items.BLUE_ICE,
		Items.CONDUIT,
		Items.POLISHED_GRANITE_STAIRS,
		Items.SMOOTH_RED_SANDSTONE_STAIRS,
		Items.MOSSY_STONE_BRICK_STAIRS,
		Items.POLISHED_DIORITE_STAIRS,
		Items.MOSSY_COBBLESTONE_STAIRS,
		Items.END_STONE_BRICK_STAIRS,
		Items.STONE_STAIRS,
		Items.SMOOTH_SANDSTONE_STAIRS,
		Items.SMOOTH_QUARTZ_STAIRS,
		Items.GRANITE_STAIRS,
		Items.ANDESITE_STAIRS,
		Items.RED_NETHER_BRICK_STAIRS,
		Items.POLISHED_ANDESITE_STAIRS,
		Items.DIORITE_STAIRS,
		Items.POLISHED_GRANITE_SLAB,
		Items.SMOOTH_RED_SANDSTONE_SLAB,
		Items.MOSSY_STONE_BRICK_SLAB,
		Items.POLISHED_DIORITE_SLAB,
		Items.MOSSY_COBBLESTONE_SLAB,
		Items.END_STONE_BRICK_SLAB,
		Items.SMOOTH_SANDSTONE_SLAB,
		Items.SMOOTH_QUARTZ_SLAB,
		Items.GRANITE_SLAB,
		Items.ANDESITE_SLAB,
		Items.RED_NETHER_BRICK_SLAB,
		Items.POLISHED_ANDESITE_SLAB,
		Items.DIORITE_SLAB,
		Items.SCAFFOLDING,
		Items.IRON_DOOR,
		Items.OAK_DOOR,
		Items.SPRUCE_DOOR,
		Items.BIRCH_DOOR,
		Items.JUNGLE_DOOR,
		Items.ACACIA_DOOR,
		Items.DARK_OAK_DOOR,
		Items.REPEATER,
		Items.COMPARATOR,
		//Items.STRUCTURE_BLOCK,
		//Items.field_226633_iW_,
		Items.COMPOSTER,
		Items.TURTLE_HELMET,
		Items.SCUTE,
		Items.IRON_SHOVEL,
		Items.IRON_PICKAXE,
		Items.IRON_AXE,
		Items.FLINT_AND_STEEL,
		Items.APPLE,
		Items.BOW,
		Items.ARROW,
		Items.COAL,
		Items.CHARCOAL,
		Items.DIAMOND,
		Items.IRON_INGOT,
		Items.GOLD_INGOT,
		Items.IRON_SWORD,
		Items.WOODEN_SWORD,
		Items.WOODEN_SHOVEL,
		Items.WOODEN_PICKAXE,
		Items.WOODEN_AXE,
		Items.STONE_SWORD,
		Items.STONE_SHOVEL,
		Items.STONE_PICKAXE,
		Items.STONE_AXE,
		Items.DIAMOND_SWORD,
		Items.DIAMOND_SHOVEL,
		Items.DIAMOND_PICKAXE,
		Items.DIAMOND_AXE,
		Items.STICK,
		Items.BOWL,
		Items.MUSHROOM_STEW,
		Items.GOLDEN_SWORD,
		Items.GOLDEN_SHOVEL,
		Items.GOLDEN_PICKAXE,
		Items.GOLDEN_AXE,
		Items.STRING,
		Items.FEATHER,
		Items.GUNPOWDER,
		Items.WOODEN_HOE,
		Items.STONE_HOE,
		Items.IRON_HOE,
		Items.DIAMOND_HOE,
		Items.GOLDEN_HOE,
		Items.WHEAT_SEEDS,
		Items.WHEAT,
		Items.BREAD,
		Items.LEATHER_HELMET,
		Items.LEATHER_CHESTPLATE,
		Items.LEATHER_LEGGINGS,
		Items.LEATHER_BOOTS,
		Items.CHAINMAIL_HELMET,
		Items.CHAINMAIL_CHESTPLATE,
		Items.CHAINMAIL_LEGGINGS,
		Items.CHAINMAIL_BOOTS,
		Items.IRON_HELMET,
		Items.IRON_CHESTPLATE,
		Items.IRON_LEGGINGS,
		Items.IRON_BOOTS,
		Items.DIAMOND_HELMET,
		Items.DIAMOND_CHESTPLATE,
		Items.DIAMOND_LEGGINGS,
		Items.DIAMOND_BOOTS,
		Items.GOLDEN_HELMET,
		Items.GOLDEN_CHESTPLATE,
		Items.GOLDEN_LEGGINGS,
		Items.GOLDEN_BOOTS,
		Items.FLINT,
		Items.PORKCHOP,
		Items.COOKED_PORKCHOP,
		Items.PAINTING,
		Items.GOLDEN_APPLE,
		Items.ENCHANTED_GOLDEN_APPLE,
		Items.OAK_SIGN,
		Items.SPRUCE_SIGN,
		Items.BIRCH_SIGN,
		Items.JUNGLE_SIGN,
		Items.ACACIA_SIGN,
		Items.DARK_OAK_SIGN,
		Items.BUCKET,
		Items.WATER_BUCKET,
		Items.LAVA_BUCKET,
		Items.MINECART,
		Items.SADDLE,
		Items.REDSTONE,
		Items.SNOWBALL,
		Items.OAK_BOAT,
		Items.LEATHER,
		Items.MILK_BUCKET,
		Items.PUFFERFISH_BUCKET,
		Items.SALMON_BUCKET,
		Items.COD_BUCKET,
		Items.TROPICAL_FISH_BUCKET,
		Items.BRICK,
		Items.CLAY_BALL,
		Items.SUGAR_CANE,
		Items.KELP,
		Items.DRIED_KELP_BLOCK,
		Items.BAMBOO,
		Items.PAPER,
		Items.BOOK,
		Items.SLIME_BALL,
		Items.CHEST_MINECART,
		Items.FURNACE_MINECART,
		Items.EGG,
		Items.COMPASS,
		Items.FISHING_ROD,
		Items.CLOCK,
		Items.GLOWSTONE_DUST,
		Items.COD,
		Items.SALMON,
		Items.TROPICAL_FISH,
		Items.PUFFERFISH,
		Items.COOKED_COD,
		Items.COOKED_SALMON,
		Items.INK_SAC,
		Items.RED_DYE,
		Items.GREEN_DYE,
		Items.COCOA_BEANS,
		Items.LAPIS_LAZULI,
		Items.PURPLE_DYE,
		Items.CYAN_DYE,
		Items.LIGHT_GRAY_DYE,
		Items.GRAY_DYE,
		Items.PINK_DYE,
		Items.LIME_DYE,
		Items.YELLOW_DYE,
		Items.LIGHT_BLUE_DYE,
		Items.MAGENTA_DYE,
		Items.ORANGE_DYE,
		Items.BONE_MEAL,
		Items.BLUE_DYE,
		Items.BROWN_DYE,
		Items.BLACK_DYE,
		Items.WHITE_DYE,
		Items.BONE,
		Items.SUGAR,
		Items.CAKE,
		Items.WHITE_BED,
		Items.ORANGE_BED,
		Items.MAGENTA_BED,
		Items.LIGHT_BLUE_BED,
		Items.YELLOW_BED,
		Items.LIME_BED,
		Items.PINK_BED,
		Items.GRAY_BED,
		Items.LIGHT_GRAY_BED,
		Items.CYAN_BED,
		Items.PURPLE_BED,
		Items.BLUE_BED,
		Items.BROWN_BED,
		Items.GREEN_BED,
		Items.RED_BED,
		Items.BLACK_BED,
		Items.COOKIE,
		Items.FILLED_MAP,
		Items.SHEARS,
		Items.MELON_SLICE,
		Items.DRIED_KELP,
		Items.PUMPKIN_SEEDS,
		Items.MELON_SEEDS,
		Items.BEEF,
		Items.COOKED_BEEF,
		Items.CHICKEN,
		Items.COOKED_CHICKEN,
		Items.ROTTEN_FLESH,
		Items.ENDER_PEARL,
		Items.BLAZE_ROD,
		Items.GHAST_TEAR,
		Items.GOLD_NUGGET,
		Items.NETHER_WART,
		Items.POTION,
		Items.GLASS_BOTTLE,
		Items.SPIDER_EYE,
		Items.FERMENTED_SPIDER_EYE,
		Items.BLAZE_POWDER,
		Items.MAGMA_CREAM,
		Items.BREWING_STAND,
		Items.CAULDRON,
		Items.ENDER_EYE,
		Items.GLISTERING_MELON_SLICE,
		Items.BAT_SPAWN_EGG,
		Items.field_226634_mw_, // bee spawn egg
		Items.BLAZE_SPAWN_EGG,
		Items.CAT_SPAWN_EGG,
		Items.CAVE_SPIDER_SPAWN_EGG,
		Items.CHICKEN_SPAWN_EGG,
		Items.COD_SPAWN_EGG,
		Items.COW_SPAWN_EGG,
		Items.CREEPER_SPAWN_EGG,
		Items.DOLPHIN_SPAWN_EGG,
		Items.DONKEY_SPAWN_EGG,
		Items.DROWNED_SPAWN_EGG,
		Items.ELDER_GUARDIAN_SPAWN_EGG,
		Items.ENDERMAN_SPAWN_EGG,
		Items.ENDERMITE_SPAWN_EGG,
		Items.EVOKER_SPAWN_EGG,
		Items.FOX_SPAWN_EGG,
		Items.GHAST_SPAWN_EGG,
		Items.GUARDIAN_SPAWN_EGG,
		Items.HORSE_SPAWN_EGG,
		Items.HUSK_SPAWN_EGG,
		Items.LLAMA_SPAWN_EGG,
		Items.MAGMA_CUBE_SPAWN_EGG,
		Items.MOOSHROOM_SPAWN_EGG,
		Items.MULE_SPAWN_EGG,
		Items.OCELOT_SPAWN_EGG,
		Items.PANDA_SPAWN_EGG,
		Items.PARROT_SPAWN_EGG,
		Items.PHANTOM_SPAWN_EGG,
		Items.PIG_SPAWN_EGG,
		Items.PILLAGER_SPAWN_EGG,
		Items.POLAR_BEAR_SPAWN_EGG,
		Items.PUFFERFISH_SPAWN_EGG,
		Items.RABBIT_SPAWN_EGG,
		Items.RAVAGER_SPAWN_EGG,
		Items.SALMON_SPAWN_EGG,
		Items.SHEEP_SPAWN_EGG,
		Items.SHULKER_SPAWN_EGG,
		Items.SILVERFISH_SPAWN_EGG,
		Items.SKELETON_SPAWN_EGG,
		Items.SKELETON_HORSE_SPAWN_EGG,
		Items.SLIME_SPAWN_EGG,
		Items.SPIDER_SPAWN_EGG,
		Items.SQUID_SPAWN_EGG,
		Items.STRAY_SPAWN_EGG,
		Items.TRADER_LLAMA_SPAWN_EGG,
		Items.TROPICAL_FISH_SPAWN_EGG,
		Items.TURTLE_SPAWN_EGG,
		Items.VEX_SPAWN_EGG,
		Items.VILLAGER_SPAWN_EGG,
		Items.VINDICATOR_SPAWN_EGG,
		Items.WANDERING_TRADER_SPAWN_EGG,
		Items.WITCH_SPAWN_EGG,
		Items.WITHER_SKELETON_SPAWN_EGG,
		Items.WOLF_SPAWN_EGG,
		Items.ZOMBIE_SPAWN_EGG,
		Items.ZOMBIE_HORSE_SPAWN_EGG,
		Items.ZOMBIE_PIGMAN_SPAWN_EGG,
		Items.ZOMBIE_VILLAGER_SPAWN_EGG,
		Items.EXPERIENCE_BOTTLE,
		Items.FIRE_CHARGE,
		Items.WRITABLE_BOOK,
		Items.WRITTEN_BOOK,
		Items.EMERALD,
		Items.ITEM_FRAME,
		Items.FLOWER_POT,
		Items.CARROT,
		Items.POTATO,
		Items.BAKED_POTATO,
		Items.POISONOUS_POTATO,
		Items.MAP,
		Items.GOLDEN_CARROT,
		Items.SKELETON_SKULL,
		Items.WITHER_SKELETON_SKULL,
		Items.PLAYER_HEAD,
		Items.ZOMBIE_HEAD,
		Items.CREEPER_HEAD,
		Items.DRAGON_HEAD,
		Items.CARROT_ON_A_STICK,
		Items.NETHER_STAR,
		Items.PUMPKIN_PIE,
		Items.FIREWORK_ROCKET,
		Items.FIREWORK_STAR,
		Items.ENCHANTED_BOOK,
		Items.NETHER_BRICK,
		Items.QUARTZ,
		Items.TNT_MINECART,
		Items.HOPPER_MINECART,
		Items.PRISMARINE_SHARD,
		Items.PRISMARINE_CRYSTALS,
		Items.RABBIT,
		Items.COOKED_RABBIT,
		Items.RABBIT_STEW,
		Items.RABBIT_FOOT,
		Items.RABBIT_HIDE,
		Items.ARMOR_STAND,
		Items.IRON_HORSE_ARMOR,
		Items.GOLDEN_HORSE_ARMOR,
		Items.DIAMOND_HORSE_ARMOR,
		Items.LEATHER_HORSE_ARMOR,
		Items.LEAD,
		Items.NAME_TAG,
		//Items.COMMAND_BLOCK_MINECART,
		Items.MUTTON,
		Items.COOKED_MUTTON,
		Items.WHITE_BANNER,
		Items.ORANGE_BANNER,
		Items.MAGENTA_BANNER,
		Items.LIGHT_BLUE_BANNER,
		Items.YELLOW_BANNER,
		Items.LIME_BANNER,
		Items.PINK_BANNER,
		Items.GRAY_BANNER,
		Items.LIGHT_GRAY_BANNER,
		Items.CYAN_BANNER,
		Items.PURPLE_BANNER,
		Items.BLUE_BANNER,
		Items.BROWN_BANNER,
		Items.GREEN_BANNER,
		Items.RED_BANNER,
		Items.BLACK_BANNER,
		Items.END_CRYSTAL,
		Items.CHORUS_FRUIT,
		Items.POPPED_CHORUS_FRUIT,
		Items.BEETROOT,
		Items.BEETROOT_SEEDS,
		Items.BEETROOT_SOUP,
		Items.DRAGON_BREATH,
		Items.SPLASH_POTION,
		Items.SPECTRAL_ARROW,
		Items.TIPPED_ARROW,
		Items.LINGERING_POTION,
		Items.SHIELD,
		Items.ELYTRA,
		Items.SPRUCE_BOAT,
		Items.BIRCH_BOAT,
		Items.JUNGLE_BOAT,
		Items.ACACIA_BOAT,
		Items.DARK_OAK_BOAT,
		Items.TOTEM_OF_UNDYING,
		Items.SHULKER_SHELL,
		Items.IRON_NUGGET,
		//Items.KNOWLEDGE_BOOK,
		//Items.DEBUG_STICK,
		Items.MUSIC_DISC_13,
		Items.MUSIC_DISC_CAT,
		Items.MUSIC_DISC_BLOCKS,
		Items.MUSIC_DISC_CHIRP,
		Items.MUSIC_DISC_FAR,
		Items.MUSIC_DISC_MALL,
		Items.MUSIC_DISC_MELLOHI,
		Items.MUSIC_DISC_STAL,
		Items.MUSIC_DISC_STRAD,
		Items.MUSIC_DISC_WARD,
		Items.MUSIC_DISC_11,
		Items.MUSIC_DISC_WAIT,
		Items.TRIDENT,
		Items.PHANTOM_MEMBRANE,
		Items.NAUTILUS_SHELL,
		Items.HEART_OF_THE_SEA,
		Items.CROSSBOW,
		Items.SUSPICIOUS_STEW,
		Items.LOOM,
		Items.FLOWER_BANNER_PATTERN,
		Items.CREEPER_BANNER_PATTERN,
		Items.SKULL_BANNER_PATTERN,
		Items.MOJANG_BANNER_PATTERN,
		Items.GLOBE_BANNER_PATTERN,
		Items.BARREL,
		Items.SMOKER,
		Items.BLAST_FURNACE,
		Items.CARTOGRAPHY_TABLE,
		Items.FLETCHING_TABLE,
		Items.GRINDSTONE,
		Items.LECTERN,
		Items.SMITHING_TABLE,
		Items.STONECUTTER,
		Items.BELL,
		Items.LANTERN,
		Items.SWEET_BERRIES,
		Items.CAMPFIRE,
		Items.field_226635_pU_, // honey- and bee-related items
		Items.field_226636_pV_, // "
		Items.field_226637_pW_, // "
		Items.field_226638_pX_, // "
		Items.field_226639_pY_, // "
		Items.field_226640_pZ_  // "
	};
	// random number generator
	private static Random r = new Random();
	
	/*
	 * This function generates a random item from the list of preferred items.
	 * 
	 * return - random item
	 */
	public static Item GetRandomItem()
	{
		return allItems[r.nextInt(allItems.length)];
	}
	
	/*
	 * This function gets the container of all preferred items.
	 * 
	 * return - array of all items
	 */
	public static Item [] GetAllItems()
	{
		return allItems;
	}
}