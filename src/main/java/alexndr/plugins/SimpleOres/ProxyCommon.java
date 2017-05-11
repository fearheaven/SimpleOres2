package alexndr.plugins.SimpleOres;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.OreGenerator;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentRegistry;

import com.google.common.collect.Lists;

public class ProxyCommon 
{
	public void preInit(FMLPreInitializationEvent event) 
	{
		//Configuration
		ContentRegistry.registerPlugin(SimpleOres.plugin);
		SimpleCoreAPI.tabPreInit();
		Settings.createOrLoadSettings(event);
		
		//Content
		Content.preInitialize();
		Recipes.preInitialize();
	} // end preInit
	
    public void load(FMLInitializationEvent event)
    {
		//Content
		Recipes.initialize();
		setTabIcons();
		Content.setRepairMaterials();
		Content.setAchievementTriggers();
		setOreGenSettings();
    } // end load
    
    public void postInit(FMLPostInitializationEvent event) 
    { 
    } // end postInit()    

	private static void setTabIcons() 
	{
		LogHelper.verbose(ModInfo.ID, "Setting tab icons");
		List<Item> list = Lists.newArrayList(Item.getItemFromBlock(Content.copper_ore), 
					Item.getItemFromBlock(Content.adamantium_block), 
					Content.mythril_ingot, Content.onyx_pickaxe, Content.copper_sword,
					Item.getItemFromBlock(Blocks.FURNACE));
		SimpleCoreAPI.setTabIcons(list);
	}
	
	/**
	 * completed config revision.
	 */
	private static void setOreGenSettings() 
	{
		LogHelper.verbose(ModInfo.ID, "Setting ore gen parameters");
		if (Settings.copperOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(0, Content.copper_ore, Blocks.STONE, 
					Settings.copperOre.getSpawnRate(), Settings.copperOre.getVeinSize(), 
					Settings.copperOre.getMinHeight(), Settings.copperOre.getMaxHeight());
		}
		if (Settings.tinOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(0, Content.tin_ore, Blocks.STONE, 
					Settings.tinOre.getSpawnRate(), Settings.tinOre.getVeinSize(), 
					Settings.tinOre.getMinHeight(), Settings.tinOre.getMaxHeight());
		}
		if (Settings.mythrilOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(0, Content.mythril_ore, Blocks.STONE, 
					Settings.mythrilOre.getSpawnRate(), Settings.mythrilOre.getVeinSize(), 
					Settings.mythrilOre.getMinHeight(), Settings.mythrilOre.getMaxHeight());
		}
		if (Settings.adamantiumOre.isEnableOreGen()) {
		OreGenerator.registerOreForGen(0, Content.adamantium_ore, Blocks.STONE, 
				Settings.adamantiumOre.getSpawnRate(), 
				Settings.adamantiumOre.getVeinSize(), 
				Settings.adamantiumOre.getMinHeight(), 
				Settings.adamantiumOre.getMaxHeight());
		}
		if (Settings.onyxOre.isEnableOreGen()) {
			OreGenerator.registerOreForGen(-1, Content.onyx_ore, Blocks.NETHERRACK, 
					Settings.onyxOre.getSpawnRate(), Settings.onyxOre.getVeinSize(), 
					Settings.onyxOre.getMinHeight(), Settings.onyxOre.getMaxHeight());
		}
	} // end setOreGenSettings()
} // end class
