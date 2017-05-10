package alexndr.plugins.SimpleOres;

import java.io.File;

import alexndr.api.config.ConfigHelper;
import alexndr.api.config.types.ConfigArmor;
import alexndr.api.config.types.ConfigBlock;
import alexndr.api.config.types.ConfigBow;
import alexndr.api.config.types.ConfigEntry;
import alexndr.api.config.types.ConfigItem;
import alexndr.api.config.types.ConfigOre;
import alexndr.api.config.types.ConfigTool;
import alexndr.api.config.types.ConfigValue;
import alexndr.api.core.APIInfo;
import alexndr.api.logger.LogHelper;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author AleXndrTheGr8st
 */
public class Settings 
{
	private static Configuration settings;

	public static void createOrLoadSettings(FMLPreInitializationEvent event) 
	{
		settings = ConfigHelper.GetConfig(event, "AleXndr", ModInfo.ID + ".cfg");

		LogHelper.verbose(ModInfo.ID, "loading settings...");
		try {
			settings.load();
			ConfigHelper.createHelpEntry(settings, ModInfo.URL);
			
			configureBlocks();
			configureOres();
			configureItems();
			configureTools();
			configureBows();
			configureArmor();
		} 
		catch (Exception e) {
			LogHelper.severe(ModInfo.ID, "Failed to load settings");
			e.printStackTrace();
		} 
		finally {
            if(settings.hasChanged())
            	settings.save();
			LogHelper.verbose(ModInfo.ID, "Settings loaded successfully");
		}
	} // end class

	public static void configureItems()
	{
		// Items
		copperIngot = new ConfigItem("Copper Ingot", ConfigHelper.CATEGORY_ITEM).setSmeltingXP(0.4F);
		copperIngot.GetConfig(settings);
		tinIngot = 	new ConfigItem("Tin Ingot", ConfigHelper.CATEGORY_ITEM).setSmeltingXP(0.4F);
		tinIngot.GetConfig(settings);
		mythrilIngot = new ConfigItem("Mythril Ingot", ConfigHelper.CATEGORY_ITEM)
						.setSmeltingXP(0.7F);
		mythrilIngot.GetConfig(settings);
		adamantiumIngot = new ConfigItem("Adamantium Ingot", ConfigHelper.CATEGORY_ITEM)
						.setSmeltingXP(0.7F);
		adamantiumIngot.GetConfig(settings);
		onyxGem = new ConfigItem("Onyx Gem", ConfigHelper.CATEGORY_ITEM).setSmeltingXP(1.0F);
		onyxGem.GetConfig(settings);
		
		mythrilRod = new ConfigItem("Mythril Rod", ConfigHelper.CATEGORY_ITEM);
		mythrilRod.GetConfig(settings);
		onyxRod = new ConfigItem("Onyx Rod", ConfigHelper.CATEGORY_ITEM);
		onyxRod.GetConfig(settings);
		copperBucket = new ConfigItem("Copper Bucket", ConfigHelper.CATEGORY_ITEM);
		copperBucket.GetConfig(settings);
	} // end configureItems()
	
	public static void configureTools()
	{
		// Tools
		copperTools = settings.get(
				new ConfigTool("Copper Tools", "Tools").setUses(185)
						.setHarvestLevel(1).setHarvestSpeed(4.0F)
						.setDamageVsEntity(1.0F).setEnchantability(8))
				.asConfigTool();
		tinTools = settings.get(
				new ConfigTool("Tin Tools", "Tools").setUses(220)
						.setHarvestLevel(1).setHarvestSpeed(3.5F)
						.setDamageVsEntity(1.0F).setEnchantability(8))
				.asConfigTool();
		mythrilTools = settings.get(
				new ConfigTool("Mythril Tools", "Tools").setUses(800)
						.setHarvestLevel(2).setHarvestSpeed(8.0F)
						.setDamageVsEntity(3.0F).setEnchantability(12))
				.asConfigTool();
		adamantiumTools = settings.get(
				new ConfigTool("Adamantium Tools", "Tools").setUses(1150)
						.setHarvestLevel(2).setHarvestSpeed(14.0F)
						.setDamageVsEntity(3.0F).setEnchantability(3))
				.asConfigTool();
		onyxTools = settings.get(
				new ConfigTool("Onyx Tools", "Tools").setUses(3280)
						.setHarvestLevel(4).setHarvestSpeed(10.0F)
						.setDamageVsEntity(5.0F).setEnchantability(15))
				.asConfigTool();
	} // end configureTools()
	
	
	/**
	 * completed config revision.
	 */
	public static void configureBows()
	{
		// Bows
		mythrilBow = new ConfigBow("Mythril Bow");
		mythrilBow.setHasDamageModifier(true).setHasEfficiencyChance(true)
			.setDamageModifier(1.5F).setEfficiencyChance(50).setZoomAmount(0.165F);
		mythrilBow.GetConfig(settings);
		
		onyxBow = new ConfigBow("Onyx Bow");
		onyxBow.setHasDamageModifier(true).setDamageModifier(1.5F).setZoomAmount(0.165F);
		onyxBow.GetConfig(settings);
	} // end configureBows()
	
	
	/**
	 * completed config revision.
	 */
	public static void configureArmor()
	{
		// Armor
		copperArmor = new ConfigArmor("Copper Armor").setDurability(8)
						.setEnchantability(8).setHelmReduction(2)
						.setChestReduction(3).setLegsReduction(2)
						.setBootsReduction(1);
		copperArmor.GetConfig(settings);
		tinArmor = new ConfigArmor("Tin Armor").setDurability(8)
						.setEnchantability(8).setHelmReduction(2)
						.setChestReduction(3).setLegsReduction(2)
						.setBootsReduction(1);
		tinArmor.GetConfig(settings);
		mythrilArmor = new ConfigArmor("Mythril Armor")
						.setDurability(22).setEnchantability(12)
						.setHelmReduction(3).setChestReduction(5)
						.setLegsReduction(4).setBootsReduction(3);
		mythrilArmor.GetConfig(settings);
		adamantiumArmor = new ConfigArmor("Adamantium Armor")
						.setDurability(28).setEnchantability(3)
						.setHelmReduction(3).setChestReduction(8)
						.setLegsReduction(6).setBootsReduction(2);
		adamantiumArmor.GetConfig(settings);
		onyxArmor = new ConfigArmor("Onyx Armor").setDurability(45)
						.setEnchantability(15).setHelmReduction(5)
						.setChestReduction(8).setLegsReduction(6)
						.setBootsReduction(5);
		onyxArmor.GetConfig(settings);
	} // end configureArmor()
	
	/**
	 * completed config revision.
	 */
	public static void configureBlocks()
	{
		// Blocks
		copperBlock = new ConfigBlock("Block of Copper", ConfigHelper.CATEGORY_BLOCK)
						.setHardness(7.0F).setResistance(12.0F)
						.setLightValue(0).setHarvestLevel(0)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true);
		copperBlock.GetConfig(settings);
		
		tinBlock = new ConfigBlock("Block of Tin", ConfigHelper.CATEGORY_BLOCK).setHardness(7.0F)
						.setResistance(12.0F).setLightValue(0)
						.setHarvestLevel(0).setHarvestTool("pickaxe")
						.setBeaconBase(true);
		tinBlock.GetConfig(settings);
		
		mythrilBlock = 	new ConfigBlock("Block of Mythril", ConfigHelper.CATEGORY_BLOCK)
						.setHardness(7.0F).setResistance(12.0F)
						.setLightValue(0).setHarvestLevel(0)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true);
		mythrilBlock.GetConfig(settings);
		
		adamantiumBlock = new ConfigBlock("Block of Adamantium", ConfigHelper.CATEGORY_BLOCK)
						.setHardness(7.0F).setResistance(12.0F)
						.setLightValue(0).setHarvestLevel(0)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true);
		adamantiumBlock.GetConfig(settings);
		
		onyxBlock = new ConfigBlock("Block of Onyx", ConfigHelper.CATEGORY_BLOCK)
						.setHardness(20.0F).setResistance(30.0F)
						.setLightValue(0).setHarvestLevel(0)
						.setHarvestTool("pickaxe")
						.setBeaconBase(true);
		onyxBlock.GetConfig(settings);
	} // end configureBlocks()

	public static void configureOres ()
	{
		copperOre = settings.get(
				new ConfigBlock("Copper Ore", "Ores").setHardness(1.7F)
						.setResistance(5.0F).setLightValue(0.0F)
						.setHarvestLevel(1).setHarvestTool("pickaxe")
						.setSpawnRate(35).setVeinSize(10).setMinHeight(1)
						.setMaxHeight(90))
				.asConfigBlock();
		tinOre = settings.get(
				new ConfigBlock("Tin Ore", "Ores").setHardness(3.0F)
						.setResistance(5.0F).setLightValue(0.0F)
						.setHarvestLevel(1).setHarvestTool("pickaxe")
						.setSpawnRate(30).setVeinSize(10).setMinHeight(1)
						.setMaxHeight(90))
				.asConfigBlock();
		mythrilOre = settings.get(
				new ConfigBlock("Mythril Ore", "Ores").setHardness(4.0F)
						.setResistance(5.0F).setLightValue(0.0F)
						.setHarvestLevel(2).setHarvestTool("pickaxe")
						.setSpawnRate(10).setVeinSize(8).setMinHeight(1)
						.setMaxHeight(40))
				.asConfigBlock();
		adamantiumOre = settings.get(
				new ConfigBlock("Adamantium Ore", "Ores").setHardness(5.0F)
						.setResistance(5.0F).setLightValue(0.0F)
						.setHarvestLevel(2).setHarvestTool("pickaxe")
						.setSpawnRate(6).setVeinSize(6).setMinHeight(1)
						.setMaxHeight(30))
				.asConfigBlock();
		onyxOre = settings.get(
				new ConfigBlock("Onyx Ore", "Ores").setHardness(7.0F)
						.setResistance(5.0F).setLightValue(0.0F)
						.setHarvestLevel(3).setHarvestTool("pickaxe")
						.setSpawnRate(6).setVeinSize(6).setMinHeight(1)
						.setMaxHeight(127)
						.setDropItem(true)
						.setItemToDrop("simpleores:onyx_gem")
						.setQuantityToDrop(1)).asConfigBlock();
	} // end configureOres()
	
	public static ConfigBlock copperBlock, tinBlock, mythrilBlock, adamantiumBlock,
			onyxBlock;
	public static ConfigOre copperOre, tinOre, mythrilOre, adamantiumOre, onyxOre;
	public static ConfigItem copperIngot, tinIngot, mythrilIngot,
			adamantiumIngot, onyxGem, mythrilRod, onyxRod, copperBucket;
	public static ConfigTool copperTools, tinTools, mythrilTools,
			adamantiumTools, onyxTools;
	public static ConfigArmor copperArmor, tinArmor, mythrilArmor,
			adamantiumArmor, onyxArmor;

	public static ConfigBow mythrilBow, onyxBow;

} // end class
