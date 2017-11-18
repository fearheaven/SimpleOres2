package alexndr.plugins.SimpleOres;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author AleXndrTheGr8st
 */
public class Recipes 
{
	
	public static void addRecipes() 
	{
//		addBlockRecipes();
//		addItemRecipes();
//		addToolRecipes();
//		addArmorRecipes();
		addSmeltingRecipes();
	}
	
	/**
	 * completed config revision.
	 */
	public static void addBlockRecipes() 
	{
//		//Storage Content
//		if (Settings.onyxBlock.isEnabled()) {
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_block, true, new Object[]{
//					"XXX", "XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
//		}
	} // end addBlockRecipes()
	
	/**
	 * complete with config revisions.
	 */
	public static void addItemRecipes() 
	{
//		//Ingot Recipes
//		if (Settings.onyxGem.isEnabled() && Settings.onyxBlock.isEnabled()) {
//			GameRegistry.addShapelessRecipe(new ItemStack(Content.onyx_gem, 9), new Object[] { 
//					Content.onyx_block });
//		}
//		
//		//Rods
//		if (Settings.onyxRod.isEnabled()) {
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_rod, true, new Object[]{
//					"X", "X", Character.valueOf('X'), "gemOnyx"}));
//		}
	} // end addItemRecipes()
	
	/**
	 * completed config revision.
	 */
	public static void addToolRecipes() 
	{
		
//		//Onyx Tool Recipes
//		if (Settings.onyxTools.isEnabled())
//		{
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_pickaxe, true, new Object[] { "XXX", " Y ", " Y ",
//					Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood" }));
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_axe, true, new Object[] { "XX ", "XY ", " Y ",
//					Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood" }));
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_shovel, true, new Object[] { "X", "Y", "Y",
//					Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood" }));
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_sword, true, new Object[] { "X", "X", "Y",
//					Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood" }));
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_hoe, true, new Object[] { "XX ", " Y ", " Y ",
//					Character.valueOf('X'), "gemOnyx", Character.valueOf('Y'), "stickWood" }));
//
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_shears, true, new Object[]{
//					"X ", " X", Character.valueOf('X'), "gemOnyx"}));
//		}
//		
//		//Bow Recipes
//		if (Settings.onyxBow.isEnabled() && Settings.onyxRod.isEnabled()) 
//		{
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_bow, true,
//					new Object[] { " XY", "ZWY", " XY", Character.valueOf('X'), Content.onyx_rod,
//							Character.valueOf('Y'), Items.STRING, Character.valueOf('Z'), Items.DIAMOND,
//							Character.valueOf('W'), Items.FLINT_AND_STEEL }));
//		}
	} // end addToolRecipes()
	
	/**
	 * completed config revision.
	 */
	public static void addArmorRecipes() 
	{
//		//Onyx Armor Recipes
//		if (Settings.onyxArmor.isEnabled())
//		{
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_helmet, true, new Object[]{
//					"XXX", "X X", Character.valueOf('X'), "gemOnyx"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_chestplate, true, new Object[]{
//					"X X", "XXX", "XXX", Character.valueOf('X'), "gemOnyx"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_leggings, true, new Object[]{
//					"XXX", "X X", "X X", Character.valueOf('X'), "gemOnyx"}));
//			GameRegistry.addRecipe(new ShapedOreRecipe(Content.onyx_boots, true, new Object[]{
//					"X X", "X X", Character.valueOf('X'), "gemOnyx"}));
//		}
	} // end addArmorRecipes()
	
	/**
	 * complete with config revision.
	 */
	public static void addSmeltingRecipes() 
	{
		if (Settings.copperBucket.isEnabled() && Settings.copperIngot.isEnabled()) {
			GameRegistry.addSmelting(ModItems.copper_bucket, 
									new ItemStack(ModItems.copper_ingot, 3, 0), 0.0F);
		}
		if (Settings.copperIngot.isEnabled() && Settings.copperOre.isEnabled()) {
			GameRegistry.addSmelting(ModBlocks.copper_ore, new ItemStack(ModItems.copper_ingot, 1, 0),
					Settings.copperIngot.getSmeltingXP());
		}
		if (Settings.tinIngot.isEnabled() && Settings.tinOre.isEnabled())
			GameRegistry.addSmelting(ModBlocks.tin_ore, new ItemStack(ModItems.tin_ingot, 1, 0), Settings.tinIngot.getSmeltingXP());
		if (Settings.mythrilIngot.isEnabled() && Settings.mythrilOre.isEnabled())
			GameRegistry.addSmelting(ModBlocks.mythril_ore, new ItemStack(ModItems.mythril_ingot, 1, 0), Settings.mythrilIngot.getSmeltingXP());
		if (Settings.adamantiumIngot.isEnabled())
			GameRegistry.addSmelting(ModBlocks.adamantium_ore, new ItemStack(ModItems.adamantium_ingot, 1, 0), Settings.adamantiumIngot.getSmeltingXP());
		if (Settings.onyxGem.isEnabled() && Settings.onyxOre.isEnabled())
			GameRegistry.addSmelting(ModBlocks.onyx_ore, new ItemStack(ModItems.onyx_gem, 1, 0), Settings.onyxGem.getSmeltingXP());
	} // end addSmeltingRecipes()
	
} // end class
