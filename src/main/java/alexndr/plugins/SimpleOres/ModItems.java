package alexndr.plugins.SimpleOres;

import alexndr.api.content.items.SimpleArmor;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleBow;
import alexndr.api.content.items.SimpleBowEffects;
import alexndr.api.content.items.SimpleBucket;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShears;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.core.SimpleCoreAPI;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentCategories;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fluids.FluidRegistry;

public class ModItems 
{
	public static SimpleItem copper_ingot = 
			new SimpleItem("copper_ingot", SimpleOres.plugin, ContentCategories.Item.INGOT);

	public static Item tin_ingot, mythril_ingot,
	adamantium_ingot, onyx_gem, mythril_rod, onyx_rod, copper_bucket,
	copper_bucket_water;

public static Item copper_pickaxe, tin_pickaxe, mythril_pickaxe,
	adamantium_pickaxe, onyx_pickaxe, copper_axe, tin_axe, mythril_axe,
	adamantium_axe, onyx_axe, copper_shovel, tin_shovel,
	mythril_shovel, adamantium_shovel, onyx_shovel, copper_hoe,
	tin_hoe, mythril_hoe, adamantium_hoe, onyx_hoe, copper_sword,
	tin_sword, mythril_sword, adamantium_sword, onyx_sword,
	copper_shears, tin_shears, mythril_shears, adamantium_shears,
	onyx_shears, mythril_bow, onyx_bow;

public static Item copper_helmet, copper_chestplate, copper_leggings,
	copper_boots, tin_helmet, tin_chestplate, tin_leggings, tin_boots,
	mythril_helmet, mythril_chestplate, mythril_leggings,
	mythril_boots, adamantium_helmet, adamantium_chestplate,
	adamantium_leggings, adamantium_boots, onyx_helmet,
	onyx_chestplate, onyx_leggings, onyx_boots;


/**
 * completed config revision.
 */
//public static void doItems() 
//{
//	LogHelper.verbose(ModInfo.ID, "Creating ingots and misc items");
//	
//	copper_ingot = Settings.copperIngot.isEnabled()
//			? new SimpleItem(SimpleOres.plugin, ContentCategories.Item.INGOT)
//					.setConfigEntry(Settings.copperIngot)
//					.setUnlocalizedName("copper_ingot")
//					.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin))
//			: null;
//	tin_ingot = Settings.tinIngot.isEnabled() 
//			? new SimpleItem(SimpleOres.plugin,
//			ContentCategories.Item.INGOT).setConfigEntry(Settings.tinIngot)
//			.setUnlocalizedName("tin_ingot")
//			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin))
//			: null;
//	mythril_ingot = Settings.mythrilIngot.isEnabled() 
//			? new SimpleItem(SimpleOres.plugin,
//			ContentCategories.Item.INGOT).setConfigEntry(
//			Settings.mythrilIngot).setUnlocalizedName("mythril_ingot")
//	                .setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin))
//	        : null;
//	adamantium_ingot = Settings.adamantiumIngot.isEnabled() 
//			? new SimpleItem(SimpleOres.plugin,
//			ContentCategories.Item.INGOT).setConfigEntry(
//			Settings.adamantiumIngot)
//			.setUnlocalizedName("adamantium_ingot")
//			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin))
//			: null;
//	onyx_gem = Settings.onyxGem.isEnabled() 
//			? new SimpleItem(SimpleOres.plugin,
//			ContentCategories.Item.INGOT).setConfigEntry(Settings.onyxGem)
//			.setUnlocalizedName("onyx_gem")
//			.setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin))
//			: null;
//
//	mythril_rod = Settings.mythrilRod.isEnabled()
//			? new SimpleItem(SimpleOres.plugin, ContentCategories.Item.MATERIAL).setConfigEntry(Settings.mythrilRod)
//					.setUnlocalizedName("mythril_rod").setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin))
//			: null;
//	onyx_rod = Settings.onyxRod.isEnabled() 
//			? new SimpleItem(SimpleOres.plugin,
//			ContentCategories.Item.MATERIAL).setConfigEntry(
//			Settings.onyxRod).setUnlocalizedName("onyx_rod")
//	                .setCreativeTab(TabHelper.materialsTab(SimpleCoreAPI.plugin))
//	        : null;
//
//	// bucket re-write.
//	// empty copper bucket
//	if (Settings.copperBucket.isEnabled())
//	{
//		copper_bucket = new SimpleBucket(SimpleOres.plugin, null, Content.copperBucketType)
//				.setUnlocalizedName("copper_bucket")
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
//		// copper bucket filled with water
//		copper_bucket_water = new SimpleBucket(SimpleOres.plugin, new ItemStack(copper_bucket), 
//				Content.copperBucketType)
//				.setUnlocalizedName("copper_bucket_water")
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin));
//		Content.copperBucketType.addVariant("water", copper_bucket_water, FluidRegistry.WATER);
//	}
//} // end doItems()
//
///**
// * completed config revision.
// */
//public static void doBows()
//{
//	LogHelper.verbose(ModInfo.ID, "Creating bows");
//	if (Settings.mythrilBow.isEnabled()) 
//	{
//		mythril_bow = new SimpleBow(SimpleOres.plugin, 750)
//				.setEffect(SimpleBowEffects.damageEffect,
//						Settings.mythrilBow.getDamageModifier())
//				.setEffect(SimpleBowEffects.efficiencyEffect,
//						Settings.mythrilBow.getEfficiencyChance())
//				.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
//				.addToolTip("tips.efficiencyTooltip", TextFormatting.GREEN)
//				.setRepairMaterial(new ItemStack(mythril_rod))
//				.setZoomAmount(Settings.mythrilBow.getZoomAmount())
//				.setConfigEntry(Settings.mythrilBow)
//				.setUnlocalizedName("mythril_bow")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
//	}
//	if (Settings.onyxBow.isEnabled())
//	{
//		onyx_bow = new SimpleBow(SimpleOres.plugin, 1000)
//				.setEffect(SimpleBowEffects.damageEffect,
//						Settings.onyxBow.getDamageModifier())
//				.setEffect(SimpleBowEffects.critFlameEffect)
//				.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
//				.addToolTip("tips.flameTooltip", TextFormatting.GREEN)
//				.setRepairMaterial(new ItemStack(onyx_rod))
//				.setZoomAmount(Settings.onyxBow.getZoomAmount())
//				.setConfigEntry(Settings.onyxBow)
//				.setUnlocalizedName("onyx_bow")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin));
//	}
//} // end doBows()
//
//public static void doTools() 
//{
//	LogHelper.verbose(ModInfo.ID, "Creating tools");
//	if (Settings.copperTools.isEnabled())
//	{
//		copper_pickaxe = new SimplePickaxe(SimpleOres.plugin,
//				Content.toolCopper).setConfigEntry(Settings.copperTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("copper_pickaxe");
//		copper_axe = new SimpleAxe(SimpleOres.plugin, Content.toolCopper, 7.0F, -3.1F)
//				.setConfigEntry(Settings.copperTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("copper_axe");
//		copper_shovel = new SimpleShovel(SimpleOres.plugin,
//				Content.toolCopper).setConfigEntry(Settings.copperTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("copper_shovel");
//		copper_hoe = new SimpleHoe(SimpleOres.plugin, Content.toolCopper)
//				.setConfigEntry(Settings.copperTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("copper_hoe");
//		copper_sword = new SimpleSword(SimpleOres.plugin, Content.toolCopper)
//				.setConfigEntry(Settings.copperTools)
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("copper_sword");
//		copper_shears = new SimpleShears(SimpleOres.plugin,
//				Content.toolCopper).setConfigEntry(Settings.copperTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("copper_shears");
//	} // end-if copper tools enabled
//	
//	if (Settings.tinTools.isEnabled())
//	{
//		tin_pickaxe = new SimplePickaxe(SimpleOres.plugin, Content.toolTin)
//				.setConfigEntry(Settings.tinTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("tin_pickaxe");
//		tin_axe = new SimpleAxe(SimpleOres.plugin, Content.toolTin, 6.0F, -3.0F)
//				.setConfigEntry(Settings.tinTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("tin_axe");
//		tin_shovel = new SimpleShovel(SimpleOres.plugin, Content.toolTin)
//				.setConfigEntry(Settings.tinTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("tin_shovel");
//		tin_hoe = new SimpleHoe(SimpleOres.plugin, Content.toolTin)
//				.setConfigEntry(Settings.tinTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("tin_hoe");
//		tin_sword = new SimpleSword(SimpleOres.plugin, Content.toolTin)
//				.setConfigEntry(Settings.tinTools)
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("tin_sword");
//		tin_shears = new SimpleShears(SimpleOres.plugin, Content.toolTin)
//				.setConfigEntry(Settings.tinTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("tin_shears");
//	} // end-if tin tools enabled
//	
//	if (Settings.mythrilTools.isEnabled())
//	{
//		mythril_pickaxe = new SimplePickaxe(SimpleOres.plugin,
//				Content.toolMythril).setConfigEntry(Settings.mythrilTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("mythril_pickaxe");
//		mythril_axe = new SimpleAxe(SimpleOres.plugin, Content.toolMythril, 8.0F, -3.2F)
//				.setConfigEntry(Settings.mythrilTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("mythril_axe");
//		mythril_shovel = new SimpleShovel(SimpleOres.plugin,
//				Content.toolMythril).setConfigEntry(Settings.mythrilTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("mythril_shovel");
//		mythril_hoe = new SimpleHoe(SimpleOres.plugin, Content.toolMythril)
//				.setConfigEntry(Settings.mythrilTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("mythril_hoe");
//		mythril_sword = new SimpleSword(SimpleOres.plugin,
//				Content.toolMythril).setConfigEntry(Settings.mythrilTools)
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("mythril_sword");
//		mythril_shears = new SimpleShears(SimpleOres.plugin,
//				Content.toolMythril).setConfigEntry(Settings.mythrilTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("mythril_shears");
//	} // end-if mythril tools enabled.
//	
//	if (Settings.adamantiumTools.isEnabled())
//	{
//		adamantium_pickaxe = new SimplePickaxe(SimpleOres.plugin,
//				Content.toolAdamantium)
//				.setConfigEntry(Settings.adamantiumTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("adamantium_pickaxe");
//		adamantium_axe = new SimpleAxe(SimpleOres.plugin,
//				Content.toolAdamantium, 8.0F, -3.0F)
//				.setConfigEntry(Settings.adamantiumTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("adamantium_axe");
//		adamantium_shovel = new SimpleShovel(SimpleOres.plugin,
//				Content.toolAdamantium)
//				.setConfigEntry(Settings.adamantiumTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("adamantium_shovel");
//		adamantium_hoe = new SimpleHoe(SimpleOres.plugin,
//				Content.toolAdamantium)
//				.setConfigEntry(Settings.adamantiumTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("adamantium_hoe");
//		adamantium_sword = new SimpleSword(SimpleOres.plugin,
//				Content.toolAdamantium)
//				.setConfigEntry(Settings.adamantiumTools)
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("adamantium_sword");
//		adamantium_shears = new SimpleShears(SimpleOres.plugin,
//				Content.toolAdamantium)
//				.setConfigEntry(Settings.adamantiumTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("adamantium_shears");
//	} // end-if adamantium tools enabled.
//	
//	if (Settings.onyxTools.isEnabled()) {
//		onyx_pickaxe = new SimplePickaxe(SimpleOres.plugin, Content.toolOnyx)
//				.setConfigEntry(Settings.onyxTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("onyx_pickaxe");
//		onyx_axe = new SimpleAxe(SimpleOres.plugin, Content.toolOnyx, 9.0F, -3.0F)
//				.setConfigEntry(Settings.onyxTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("onyx_axe");
//		onyx_shovel = new SimpleShovel(SimpleOres.plugin, Content.toolOnyx)
//				.setConfigEntry(Settings.onyxTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("onyx_shovel");
//		onyx_hoe = new SimpleHoe(SimpleOres.plugin, Content.toolOnyx)
//				.setConfigEntry(Settings.onyxTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("onyx_hoe");
//		onyx_sword = new SimpleSword(SimpleOres.plugin, Content.toolOnyx)
//				.setConfigEntry(Settings.onyxTools)
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("onyx_sword");
//		onyx_shears = new SimpleShears(SimpleOres.plugin, Content.toolOnyx)
//				.setConfigEntry(Settings.onyxTools)
//				.setCreativeTab(TabHelper.toolsTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("onyx_shears");
//	} // end-if onyx tools enabled
//} // end doTools()
//
///**
// * updated config revision complete.
// */
//public static void doArmor() 
//{
//	LogHelper.verbose(ModInfo.ID, "Creating armors");
//	if (Settings.copperArmor.isEnabled()) 
//	{
//		copper_helmet = new SimpleArmor(SimpleOres.plugin,
//				Content.armorCopper, EntityEquipmentSlot.HEAD)
//				.setConfigEntry(Settings.copperArmor).setType("copper")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("copper_helmet");
//		copper_chestplate = new SimpleArmor(SimpleOres.plugin,
//				Content.armorCopper, EntityEquipmentSlot.CHEST)
//				.setConfigEntry(Settings.copperArmor).setType("copper")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("copper_chestplate");
//		copper_leggings = new SimpleArmor(SimpleOres.plugin,
//				Content.armorCopper, EntityEquipmentSlot.LEGS)
//				.setConfigEntry(Settings.copperArmor).setType("copper")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("copper_leggings");
//		copper_boots = new SimpleArmor(SimpleOres.plugin,
//				Content.armorCopper, EntityEquipmentSlot.FEET)
//				.setConfigEntry(Settings.copperArmor).setType("copper")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("copper_boots");
//	} 
//	if (Settings.tinArmor.isEnabled()) 
//	{
//		tin_helmet = new SimpleArmor(SimpleOres.plugin, Content.armorTin,
//				EntityEquipmentSlot.HEAD).setConfigEntry(Settings.tinArmor)
//				.setType("tin").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("tin_helmet");
//		tin_chestplate = new SimpleArmor(SimpleOres.plugin,
//				Content.armorTin, EntityEquipmentSlot.CHEST)
//				.setConfigEntry(Settings.tinArmor).setType("tin")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("tin_chestplate");
//		tin_leggings = new SimpleArmor(SimpleOres.plugin, Content.armorTin,
//				EntityEquipmentSlot.LEGS).setConfigEntry(Settings.tinArmor)
//				.setType("tin").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("tin_leggings");
//		tin_boots = new SimpleArmor(SimpleOres.plugin, Content.armorTin,
//				EntityEquipmentSlot.FEET).setConfigEntry(Settings.tinArmor)
//				.setType("tin").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("tin_boots");
//	}
//	if (Settings.mythrilArmor.isEnabled()) 
//	{
//		mythril_helmet = new SimpleArmor(SimpleOres.plugin,
//				Content.armorMythril, EntityEquipmentSlot.HEAD)
//				.setConfigEntry(Settings.mythrilArmor).setType("mythril")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("mythril_helmet");
//		mythril_chestplate = new SimpleArmor(SimpleOres.plugin,
//				Content.armorMythril, EntityEquipmentSlot.CHEST)
//				.setConfigEntry(Settings.mythrilArmor).setType("mythril")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("mythril_chestplate");
//		mythril_leggings = new SimpleArmor(SimpleOres.plugin,
//				Content.armorMythril, EntityEquipmentSlot.LEGS)
//				.setConfigEntry(Settings.mythrilArmor).setType("mythril")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("mythril_leggings");
//		mythril_boots = new SimpleArmor(SimpleOres.plugin,
//				Content.armorMythril, EntityEquipmentSlot.FEET)
//				.setConfigEntry(Settings.mythrilArmor).setType("mythril")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("mythril_boots");
//	}
//	if (Settings.adamantiumArmor.isEnabled())
//	{
//		adamantium_helmet = new SimpleArmor(SimpleOres.plugin,
//				Content.armorAdamantium, EntityEquipmentSlot.HEAD)
//				.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("adamantium_helmet");
//		adamantium_chestplate = new SimpleArmor(SimpleOres.plugin,
//				Content.armorAdamantium, EntityEquipmentSlot.CHEST)
//				.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("adamantium_chestplate");
//		adamantium_leggings = new SimpleArmor(SimpleOres.plugin,
//				Content.armorAdamantium, EntityEquipmentSlot.LEGS)
//				.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("adamantium_leggings");
//		adamantium_boots = new SimpleArmor(SimpleOres.plugin,
//				Content.armorAdamantium, EntityEquipmentSlot.FEET)
//				.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("adamantium_boots");
//	}
//	if (Settings.onyxArmor.isEnabled())
//	{
//		onyx_helmet = new SimpleArmor(SimpleOres.plugin, Content.armorOnyx,
//				EntityEquipmentSlot.HEAD).setConfigEntry(Settings.onyxArmor)
//				.setType("onyx").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("onyx_helmet");
//		onyx_chestplate = new SimpleArmor(SimpleOres.plugin,
//				Content.armorOnyx, EntityEquipmentSlot.CHEST)
//				.setConfigEntry(Settings.onyxArmor).setType("onyx")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("onyx_chestplate");
//		onyx_leggings = new SimpleArmor(SimpleOres.plugin,
//				Content.armorOnyx, EntityEquipmentSlot.LEGS)
//				.setConfigEntry(Settings.onyxArmor).setType("onyx")
//				.setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("onyx_leggings");
//		onyx_boots = new SimpleArmor(SimpleOres.plugin, Content.armorOnyx,
//				EntityEquipmentSlot.FEET).setConfigEntry(Settings.onyxArmor)
//				.setType("onyx").setCreativeTab(TabHelper.combatTab(SimpleCoreAPI.plugin))
//				.setUnlocalizedName("onyx_boots");
//	}
//} // end doArmor()

} // end class
