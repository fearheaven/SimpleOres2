package alexndr.plugins.SimpleOres;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * @author AleXndrTheGr8st
 */
public class Recipes {
	public static void preInitialize() {
		addOreDictEntries();
	}
	
	public static void initialize() {
		addRecipes();
	}
	
	/**
	 * compeleted config revision.
	 */
	public static void addOreDictEntries() 
	{
		if (Settings.copperOre.isEnabled())
			OreDictionary.registerOre("oreCopper", new ItemStack(Content.copper_ore));
		if (Settings.tinOre.isEnabled())
			OreDictionary.registerOre("oreTin", new ItemStack(Content.tin_ore));
		if (Settings.mythrilOre.isEnabled()) 
		{
			OreDictionary.registerOre("oreMythril", new ItemStack(Content.mythril_ore));
			OreDictionary.registerOre("oreMithril", new ItemStack(Content.mythril_ore));
		}
		if (Settings.adamantiumOre.isEnabled())
		{
			OreDictionary.registerOre("oreAdamantium", new ItemStack(Content.adamantium_ore));
			OreDictionary.registerOre("oreAdamantite", new ItemStack(Content.adamantium_ore));
			OreDictionary.registerOre("oreAdamantine", new ItemStack(Content.adamantium_ore));
		}
		if (Settings.onyxOre.isEnabled())
			OreDictionary.registerOre("oreOnyx", new ItemStack(Content.onyx_ore));
		if (Settings.copperBlock.isEnabled())
			OreDictionary.registerOre("blockCopper", new ItemStack(Content.copper_block));
		if (Settings.tinBlock.isEnabled())
			OreDictionary.registerOre("blockTin", new ItemStack(Content.tin_block));
		if (Settings.mythrilBlock.isEnabled()) {
			OreDictionary.registerOre("blockMythril", new ItemStack(Content.mythril_block));
			OreDictionary.registerOre("blockMithril", new ItemStack(Content.mythril_block));
		}
		if (Settings.adamantiumBlock.isEnabled()) {
			OreDictionary.registerOre("blockAdamantium", new ItemStack(Content.adamantium_block));
			OreDictionary.registerOre("blockAdamantite", new ItemStack(Content.adamantium_block));
			OreDictionary.registerOre("blockAdamantine", new ItemStack(Content.adamantium_block));
		}
		if (Settings.onyxBlock.isEnabled())
			OreDictionary.registerOre("blockOnyx", new ItemStack(Content.onyx_block));
		
		if (Settings.copperIngot.isEnabled())
			OreDictionary.registerOre("ingotCopper", new ItemStack(Content.copper_ingot));
		if (Settings.tinIngot.isEnabled())
			OreDictionary.registerOre("ingotTin", new ItemStack(Content.tin_ingot));
		if (Settings.mythrilIngot.isEnabled()) {
			OreDictionary.registerOre("ingotMythril", new ItemStack(Content.mythril_ingot));
			OreDictionary.registerOre("ingotMithril", new ItemStack(Content.mythril_ingot));
		}
		if (Settings.adamantiumIngot.isEnabled()) {
			OreDictionary.registerOre("ingotAdamantium", new ItemStack(Content.adamantium_ingot));
			OreDictionary.registerOre("ingotAdamantite", new ItemStack(Content.adamantium_ingot));
			OreDictionary.registerOre("ingotAdamantine", new ItemStack(Content.adamantium_ingot));
		}
		if (Settings.onyxGem.isEnabled())
			OreDictionary.registerOre("gemOnyx", new ItemStack(Content.onyx_gem));
	} // end addOreDictEntries()
	
	public static void addRecipes() 
	{
		addBlockRecipes();
		addItemRecipes();
		addToolRecipes();
		addArmorRecipes();
		addSmeltingRecipes();
	}
	
	/**
	 * completed config revision.
	 */
	public static void addBlockRecipes() 
	{
		//Storage Content
		if (Settings.copperBlock.isEnabled()) {
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_block, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotCopper"}));
		}
		if (Settings.tinBlock.isEnabled()) {
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.tin_block, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotTin"}));
		}
		if (Settings.mythrilBlock.isEnabled()) {
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_block, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotMythril"}));
		}
		if (Settings.adamantiumBlock.isEnabled()) {
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.adamantium_block, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "ingotAdamantium"}));
		}
		if (Settings.onyxBlock.isEnabled()) {
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_block, true, new Object[]{
					"XXX", "XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
		}
	} // end addBlockRecipes()
	
	/**
	 * complete with config revisions.
	 */
	public static void addItemRecipes() 
	{
		//Ingot Recipes
		if (Settings.copperIngot.isEnabled() && Settings.copperBlock.isEnabled()) {
			GameRegistry.addShapelessRecipe(new ItemStack(Content.copper_ingot, 9), new Object[] { 
					Content.copper_block });
		}
		if (Settings.tinIngot.isEnabled() && Settings.tinBlock.isEnabled()) {
			GameRegistry.addShapelessRecipe(new ItemStack(Content.tin_ingot, 9), new Object[] { 
					Content.tin_block });
		}
		if (Settings.mythrilIngot.isEnabled() && Settings.mythrilBlock.isEnabled()) {
			GameRegistry.addShapelessRecipe(new ItemStack(Content.mythril_ingot, 9), new Object[] { 
					Content.mythril_block });
		}
		if (Settings.adamantiumIngot.isEnabled() && Settings.adamantiumBlock.isEnabled()) {
			GameRegistry.addShapelessRecipe(new ItemStack(Content.adamantium_ingot, 9), new Object[] { 
					Content.adamantium_block });
		}
		if (Settings.onyxGem.isEnabled() && Settings.onyxBlock.isEnabled()) {
			GameRegistry.addShapelessRecipe(new ItemStack(Content.onyx_gem, 9), new Object[] { 
					Content.onyx_block });
		}
		
		//Bucket
		if (Settings.copperBucket.isEnabled()) {
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_bucket, true, new Object[]{
					"X X", " X ", Character.valueOf('X'), "ingotCopper"}));
		}

		//Rods
		if (Settings.mythrilRod.isEnabled()) {
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_rod, true, new Object[]{
					"X", "X", Character.valueOf('X'), "ingotMythril"}));
		}
		if (Settings.onyxRod.isEnabled()) {
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_rod, true, new Object[]{
					"X", "X", Character.valueOf('X'), "gemOnyx"}));
		}
	} // end addItemRecipes()
	
	/**
	 * completed config revision.
	 */
	public static void addToolRecipes() 
	{
		//Copper Tool Recipes
		if (Settings.copperTools.isEnabled()) 
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_pickaxe, true, new Object[] { "XXX", " Y ", " Y ",
					Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_axe, true, new Object[] { "XX ", "XY ", " Y ",
					Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_shovel, true, new Object[] { "X", "Y", "Y",
					Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_sword, true, new Object[] { "X", "X", "Y",
					Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_hoe, true, new Object[] { "XX ", " Y ", " Y ",
					Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "stickWood" }));

			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_shears, true, new Object[]{
					"X ", " X", Character.valueOf('X'), "ingotCopper"}));
		}
		
		//Tin Tool Recipes
		if (Settings.tinTools.isEnabled())
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.tin_pickaxe, true, new Object[] { "XXX", " Y ", " Y ",
					Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.tin_axe, true, new Object[] { "XX ", "XY ", " Y ",
					Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.tin_shovel, true, new Object[] { "X", "Y", "Y",
					Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.tin_sword, true, new Object[] { "X", "X", "Y",
					Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.tin_hoe, true, new Object[] { "XX ", " Y ", " Y ",
					Character.valueOf('X'), "ingotTin", Character.valueOf('Y'), "stickWood" }));

			GameRegistry.addRecipe(new ShapedOreRecipe(Content.tin_shears, true, new Object[]{
					"X ", " X", Character.valueOf('X'), "ingotTin"}));
		}
		//Mythril Tool Recipes
		if (Settings.mythrilTools.isEnabled())
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_pickaxe, true, new Object[] { "XXX", " Y ",
					" Y ", Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_axe, true, new Object[] { "XX ", "XY ", " Y ",
					Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_shovel, true, new Object[] { "X", "Y", "Y",
					Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_sword, true, new Object[] { "X", "X", "Y",
					Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_hoe, true, new Object[] { "XX ", " Y ", " Y ",
					Character.valueOf('X'), "ingotMythril", Character.valueOf('Y'), "stickWood" }));

			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_shears, true, new Object[]{
					"X ", " X", Character.valueOf('X'), "ingotMythril"}));
		}
		//Adamantium Tool Recipes
		if (Settings.adamantiumTools.isEnabled())
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.adamantium_pickaxe, true, new Object[]{
					"XXX", " Y ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.adamantium_axe, true, new Object[]{
					"XX ", "XY ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.adamantium_shovel, true, new Object[]{
					"X", "Y", "Y", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.adamantium_sword, true, new Object[]{
					"X", "X", "Y", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.adamantium_hoe, true, new Object[]{
					"XX ", " Y ", " Y ", Character.valueOf('X'), "ingotAdamantium", Character.valueOf('Y'), "stickWood"}));

			GameRegistry.addRecipe(new ShapedOreRecipe(Content.adamantium_shears, true, new Object[]{
					"X ", " X", Character.valueOf('X'), "ingotAdamantium"}));
		}
		
		//Onyx Tool Recipes
		if (Settings.onyxTools.isEnabled())
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_pickaxe, true, new Object[] { "XXX", " Y ", " Y ",
					Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_axe, true, new Object[] { "XX ", "XY ", " Y ",
					Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_shovel, true, new Object[] { "X", "Y", "Y",
					Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_sword, true, new Object[] { "X", "X", "Y",
					Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_hoe, true, new Object[] { "XX ", " Y ", " Y ",
					Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood" }));

			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_shears, true, new Object[]{
					"X ", " X", Character.valueOf('X'), "gemOnyx"}));
		}
		
		//Bow Recipes
		if (Settings.mythrilBow.isEnabled() && Settings.mythrilRod.isEnabled()) 
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_bow, true,
					new Object[] { " XY", "Z Y", " XY", Character.valueOf('X'), Content.mythril_rod,
							Character.valueOf('Y'), Items.STRING, Character.valueOf('Z'), Items.IRON_INGOT }));
		}
		if (Settings.onyxBow.isEnabled() && Settings.onyxRod.isEnabled()) 
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_bow, true,
					new Object[] { " XY", "ZWY", " XY", Character.valueOf('X'), Content.onyx_rod,
							Character.valueOf('Y'), Items.STRING, Character.valueOf('Z'), Items.DIAMOND,
							Character.valueOf('W'), Items.FLINT_AND_STEEL }));
		}
	} // end addToolRecipes()
	
	/**
	 * completed config revision.
	 */
	public static void addArmorRecipes() 
	{
		//Copper Armor Recipes
		if (Settings.copperArmor.isEnabled())
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_helmet, true, new Object[]{
					"XXX", "X X", Character.valueOf('X'), "ingotCopper"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_chestplate, true, new Object[]{
					"X X", "XXX", "XXX", Character.valueOf('X'), "ingotCopper"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_leggings, true, new Object[]{
					"XXX", "X X", "X X", Character.valueOf('X'), "ingotCopper"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.copper_boots, true, new Object[]{
					"X X", "X X", Character.valueOf('X'), "ingotCopper"}));
		}
		
		//Tin Armor Recipes
		if (Settings.tinArmor.isEnabled())
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.tin_helmet, true, new Object[]{
					"XXX", "X X", Character.valueOf('X'), "ingotTin"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.tin_chestplate, true, new Object[]{
					"X X", "XXX", "XXX", Character.valueOf('X'), "ingotTin"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.tin_leggings, true, new Object[]{
					"XXX", "X X", "X X", Character.valueOf('X'), "ingotTin"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.tin_boots, true, new Object[]{
					"X X", "X X", Character.valueOf('X'), "ingotTin"}));
		}
		
		//Mythril Armor Recipes
		if (Settings.mythrilArmor.isEnabled())
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_helmet, true, new Object[]{
					"XXX", "X X", Character.valueOf('X'), "ingotMythril"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_chestplate, true, new Object[]{
					"X X", "XXX", "XXX", Character.valueOf('X'), "ingotMythril"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_leggings, true, new Object[]{
					"XXX", "X X", "X X", Character.valueOf('X'), "ingotMythril"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.mythril_boots, true, new Object[]{
					"X X", "X X", Character.valueOf('X'), "ingotMythril"}));
		}
		
		//Adamantium Armor Recipes
		if (Settings.adamantiumArmor.isEnabled())
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.adamantium_helmet, true, new Object[]{
					"XXX", "X X", Character.valueOf('X'), "ingotAdamantium"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.adamantium_chestplate, true, new Object[]{
					"X X", "XXX", "XXX", Character.valueOf('X'), "ingotAdamantium"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.adamantium_leggings, true, new Object[]{
					"XXX", "X X", "X X", Character.valueOf('X'), "ingotAdamantium"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.adamantium_boots, true, new Object[]{
					"X X", "X X", Character.valueOf('X'), "ingotAdamantium"}));
		}
		//Onyx Armor Recipes
		if (Settings.onyxArmor.isEnabled())
		{
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_helmet, true, new Object[]{
					"XXX", "X X", Character.valueOf('X'), "gemOnyx"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_chestplate, true, new Object[]{
					"X X", "XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_leggings, true, new Object[]{
					"XXX", "X X", "X X", Character.valueOf('X'), "gemOnyx"}));
			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_boots, true, new Object[]{
					"X X", "X X", Character.valueOf('X'), "gemOnyx"}));
		}
	} // end addArmorRecipes()
	
	/**
	 * complete with config revision.
	 */
	public static void addSmeltingRecipes() 
	{
		if (Settings.copperBucket.isEnabled() && Settings.copperIngot.isEnabled()) {
			GameRegistry.addSmelting(Content.copper_bucket, new ItemStack(Content.copper_ingot, 3, 0), 0.0F);
		}
		if (Settings.copperIngot.isEnabled() && Settings.copperOre.isEnabled()) {
			GameRegistry.addSmelting(Content.copper_ore, new ItemStack(Content.copper_ingot, 1, 0),
					Settings.copperIngot.getSmeltingXP());
		}
		if (Settings.tinIngot.isEnabled() && Settings.tinOre.isEnabled())
			GameRegistry.addSmelting(Content.tin_ore, new ItemStack(Content.tin_ingot, 1, 0), Settings.tinIngot.getSmeltingXP());
		if (Settings.mythrilIngot.isEnabled() && Settings.mythrilOre.isEnabled())
			GameRegistry.addSmelting(Content.mythril_ore, new ItemStack(Content.mythril_ingot, 1, 0), Settings.mythrilIngot.getSmeltingXP());
		if (Settings.adamantiumIngot.isEnabled())
			GameRegistry.addSmelting(Content.adamantium_ore, new ItemStack(Content.adamantium_ingot, 1, 0), Settings.adamantiumIngot.getSmeltingXP());
		if (Settings.onyxGem.isEnabled() && Settings.onyxOre.isEnabled())
			GameRegistry.addSmelting(Content.onyx_ore, new ItemStack(Content.onyx_gem, 1, 0), Settings.onyxGem.getSmeltingXP());
	} // end addSmeltingRecipes()
	
} // end class
