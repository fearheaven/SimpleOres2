package alexndr.plugins.SimpleOres;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidRegistry;
import alexndr.api.content.blocks.SimpleBlock;
import alexndr.api.content.items.SimpleArmor;
import alexndr.api.content.items.SimpleAxe;
import alexndr.api.content.items.SimpleBow;
import alexndr.api.content.items.SimpleBowEffects;
import alexndr.api.content.items.SimpleBucket;
import alexndr.api.content.items.SimpleBucketType;
import alexndr.api.content.items.SimpleHoe;
import alexndr.api.content.items.SimpleItem;
import alexndr.api.content.items.SimplePickaxe;
import alexndr.api.content.items.SimpleShears;
import alexndr.api.content.items.SimpleShovel;
import alexndr.api.content.items.SimpleSword;
import alexndr.api.helpers.game.StatTriggersHelper;
import alexndr.api.helpers.game.TabHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentCategories;

/**
 * @author AleXndrTheGr8st
 */
public class Content {
	// SimpleBucketType
	public static SimpleBucketType copperBucketType;

	public static void preInitialize() 
	{
		setToolAndArmorStats();
		setBucketVariants();

		doItems();
		doBlocks();
		doTools();
		doArmor();
		doAchievements();
	} // end preInitialize()

	public static void doItems() {
		copper_ingot = new SimpleItem(SimpleOres.plugin,
				ContentCategories.Item.INGOT).setConfigEntry(
				Settings.copperIngot).setUnlocalizedName("copper_ingot");
		tin_ingot = new SimpleItem(SimpleOres.plugin,
				ContentCategories.Item.INGOT).setConfigEntry(Settings.tinIngot)
				.setUnlocalizedName("tin_ingot");
		mythril_ingot = new SimpleItem(SimpleOres.plugin,
				ContentCategories.Item.INGOT).setConfigEntry(
				Settings.mythrilIngot).setUnlocalizedName("mythril_ingot");
		adamantium_ingot = new SimpleItem(SimpleOres.plugin,
				ContentCategories.Item.INGOT).setConfigEntry(
				Settings.adamantiumIngot)
				.setUnlocalizedName("adamantium_ingot");
		onyx_gem = new SimpleItem(SimpleOres.plugin,
				ContentCategories.Item.INGOT).setConfigEntry(Settings.onyxGem)
				.setUnlocalizedName("onyx_gem");

		mythril_rod = new SimpleItem(SimpleOres.plugin,
				ContentCategories.Item.MATERIAL).setConfigEntry(
				Settings.mythrilRod).setUnlocalizedName("mythril_rod");
		onyx_rod = new SimpleItem(SimpleOres.plugin,
				ContentCategories.Item.MATERIAL).setConfigEntry(
				Settings.onyxRod).setUnlocalizedName("onyx_rod");

		// bucket re-write.
		copper_bucket = new SimpleBucket(SimpleOres.plugin, null,
				Content.copperBucketType).setConfigEntry(
				Settings.copperBucket).setUnlocalizedName("copper_bucket");
		
		copper_bucket_water = new SimpleBucket(SimpleOres.plugin,
				 new ItemStack(copper_bucket), Content.copperBucketType)
				.setConfigEntry(Settings.copperBucket)
				.setUnlocalizedName("copper_bucket_water");
		
		copperBucketType.addVariant("water", copper_bucket_water, 
									FluidRegistry.WATER);

	} // end doItems()

	public static void doBlocks() {
		copper_ore = new SimpleBlock(SimpleOres.plugin, Material.ROCK,
				ContentCategories.Block.ORE).setConfigEntry(Settings.copperOre)
				.setStepSound(SoundType.STONE)
				.setUnlocalizedName("copper_ore");
		tin_ore = new SimpleBlock(SimpleOres.plugin, Material.ROCK,
				ContentCategories.Block.ORE).setConfigEntry(Settings.tinOre)
				.setStepSound(SoundType.STONE)
				.setUnlocalizedName("tin_ore");
		mythril_ore = new SimpleBlock(SimpleOres.plugin, Material.ROCK,
				ContentCategories.Block.ORE)
				.setConfigEntry(Settings.mythrilOre)
				.setStepSound(SoundType.STONE)
				.setUnlocalizedName("mythril_ore");
		adamantium_ore = new SimpleBlock(SimpleOres.plugin, Material.ROCK,
				ContentCategories.Block.ORE)
				.setConfigEntry(Settings.adamantiumOre)
				.setStepSound(SoundType.STONE)
				.setUnlocalizedName("adamantium_ore");
		onyx_ore = new SimpleBlock(SimpleOres.plugin, Material.ROCK,
				ContentCategories.Block.ORE).setConfigEntry(Settings.onyxOre)
				.setStepSound(SoundType.STONE)
				.setUnlocalizedName("onyx_ore");

		copper_block = new SimpleBlock(SimpleOres.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.copperBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("copper_block");
		tin_block = new SimpleBlock(SimpleOres.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.tinBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("tin_block");
		mythril_block = new SimpleBlock(SimpleOres.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.mythrilBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("mythril_block");
		adamantium_block = new SimpleBlock(SimpleOres.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.adamantiumBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("adamantium_block");
		onyx_block = new SimpleBlock(SimpleOres.plugin, Material.IRON,
				ContentCategories.Block.GENERAL)
				.setConfigEntry(Settings.onyxBlock)
				.setStepSound(SoundType.METAL)
				.setUnlocalizedName("onyx_block");
	} // end doBlocks()

	public static void doTools() {
		copper_pickaxe = new SimplePickaxe(SimpleOres.plugin,
				Content.toolCopper).setConfigEntry(Settings.copperTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("copper_pickaxe");
		copper_axe = new SimpleAxe(SimpleOres.plugin, Content.toolCopper, 7.0F, -3.1F)
				.setConfigEntry(Settings.copperTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("copper_axe");
		copper_shovel = new SimpleShovel(SimpleOres.plugin,
				Content.toolCopper).setConfigEntry(Settings.copperTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("copper_shovel");
		copper_hoe = new SimpleHoe(SimpleOres.plugin, Content.toolCopper)
				.setConfigEntry(Settings.copperTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("copper_hoe");
		copper_sword = new SimpleSword(SimpleOres.plugin, Content.toolCopper)
				.setConfigEntry(Settings.copperTools)
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("copper_sword");
		copper_shears = new SimpleShears(SimpleOres.plugin,
				Content.toolCopper).setConfigEntry(Settings.copperTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("copper_shears");

		tin_pickaxe = new SimplePickaxe(SimpleOres.plugin, Content.toolTin)
				.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("tin_pickaxe");
		tin_axe = new SimpleAxe(SimpleOres.plugin, Content.toolTin, 6.0F, -3.0F)
				.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("tin_axe");
		tin_shovel = new SimpleShovel(SimpleOres.plugin, Content.toolTin)
				.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("tin_shovel");
		tin_hoe = new SimpleHoe(SimpleOres.plugin, Content.toolTin)
				.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("tin_hoe");
		tin_sword = new SimpleSword(SimpleOres.plugin, Content.toolTin)
				.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("tin_sword");
		tin_shears = new SimpleShears(SimpleOres.plugin, Content.toolTin)
				.setConfigEntry(Settings.tinTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("tin_shears");

		mythril_pickaxe = new SimplePickaxe(SimpleOres.plugin,
				Content.toolMythril).setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("mythril_pickaxe");
		mythril_axe = new SimpleAxe(SimpleOres.plugin, Content.toolMythril, 8.0F, -3.2F)
				.setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("mythril_axe");
		mythril_shovel = new SimpleShovel(SimpleOres.plugin,
				Content.toolMythril).setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("mythril_shovel");
		mythril_hoe = new SimpleHoe(SimpleOres.plugin, Content.toolMythril)
				.setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("mythril_hoe");
		mythril_sword = new SimpleSword(SimpleOres.plugin,
				Content.toolMythril).setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("mythril_sword");
		mythril_shears = new SimpleShears(SimpleOres.plugin,
				Content.toolMythril).setConfigEntry(Settings.mythrilTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("mythril_shears");
		mythril_bow = new SimpleBow(SimpleOres.plugin, 750)
				.setEffect(SimpleBowEffects.damageEffect,
						Settings.mythrilBowDamageModifier.asFloat())
				.setEffect(SimpleBowEffects.efficiencyEffect,
						Settings.mythrilBowEfficiencyChance.asInt())
				.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
				.addToolTip("tips.efficiencyTooltip", TextFormatting.GREEN)
				.setRepairMaterial(new ItemStack(mythril_rod))
				.setZoomAmount(Settings.mythrilBowZoomAmount.asFloat())
				.setConfigEntry(Settings.mythrilBow)
				.setUnlocalizedName("mythril_bow");

		adamantium_pickaxe = new SimplePickaxe(SimpleOres.plugin,
				Content.toolAdamantium)
				.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("adamantium_pickaxe");
		adamantium_axe = new SimpleAxe(SimpleOres.plugin,
				Content.toolAdamantium, 8.0F, -3.0F)
				.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("adamantium_axe");
		adamantium_shovel = new SimpleShovel(SimpleOres.plugin,
				Content.toolAdamantium)
				.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("adamantium_shovel");
		adamantium_hoe = new SimpleHoe(SimpleOres.plugin,
				Content.toolAdamantium)
				.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("adamantium_hoe");
		adamantium_sword = new SimpleSword(SimpleOres.plugin,
				Content.toolAdamantium)
				.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("adamantium_sword");
		adamantium_shears = new SimpleShears(SimpleOres.plugin,
				Content.toolAdamantium)
				.setConfigEntry(Settings.adamantiumTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("adamantium_shears");

		onyx_pickaxe = new SimplePickaxe(SimpleOres.plugin, Content.toolOnyx)
				.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("onyx_pickaxe");
		onyx_axe = new SimpleAxe(SimpleOres.plugin, Content.toolOnyx, 9.0F, -3.0F)
				.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("onyx_axe");
		onyx_shovel = new SimpleShovel(SimpleOres.plugin, Content.toolOnyx)
				.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("onyx_shovel");
		onyx_hoe = new SimpleHoe(SimpleOres.plugin, Content.toolOnyx)
				.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("onyx_hoe");
		onyx_sword = new SimpleSword(SimpleOres.plugin, Content.toolOnyx)
				.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("onyx_sword");
		onyx_shears = new SimpleShears(SimpleOres.plugin, Content.toolOnyx)
				.setConfigEntry(Settings.onyxTools)
				.setCreativeTab(TabHelper.toolsTab())
				.setUnlocalizedName("onyx_shears");
		onyx_bow = new SimpleBow(SimpleOres.plugin, 1000)
				.setEffect(SimpleBowEffects.damageEffect,
						Settings.onyxBowDamageModifier.asFloat())
				.setEffect(SimpleBowEffects.critFlameEffect)
				.addToolTip("tips.damageTooltip", TextFormatting.GREEN)
				.addToolTip("tips.flameTooltip", TextFormatting.GREEN)
				.setRepairMaterial(new ItemStack(onyx_rod))
				.setZoomAmount(Settings.onyxBowZoomAmount.asFloat())
				.setConfigEntry(Settings.onyxBow)
				.setUnlocalizedName("onyx_bow");
	} // end doTools()

	public static void doArmor() {
		copper_helmet = new SimpleArmor(SimpleOres.plugin,
				Content.armorCopper, EntityEquipmentSlot.HEAD)
				.setConfigEntry(Settings.copperArmor).setType("copper")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("copper_helmet");
		copper_chestplate = new SimpleArmor(SimpleOres.plugin,
				Content.armorCopper, EntityEquipmentSlot.CHEST)
				.setConfigEntry(Settings.copperArmor).setType("copper")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("copper_chestplate");
		copper_leggings = new SimpleArmor(SimpleOres.plugin,
				Content.armorCopper, EntityEquipmentSlot.LEGS)
				.setConfigEntry(Settings.copperArmor).setType("copper")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("copper_leggings");
		copper_boots = new SimpleArmor(SimpleOres.plugin,
				Content.armorCopper, EntityEquipmentSlot.FEET)
				.setConfigEntry(Settings.copperArmor).setType("copper")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("copper_boots");

		tin_helmet = new SimpleArmor(SimpleOres.plugin, Content.armorTin,
				EntityEquipmentSlot.HEAD).setConfigEntry(Settings.tinArmor)
				.setType("tin").setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("tin_helmet");
		tin_chestplate = new SimpleArmor(SimpleOres.plugin,
				Content.armorTin, EntityEquipmentSlot.CHEST)
				.setConfigEntry(Settings.tinArmor).setType("tin")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("tin_chestplate");
		tin_leggings = new SimpleArmor(SimpleOres.plugin, Content.armorTin,
				EntityEquipmentSlot.LEGS).setConfigEntry(Settings.tinArmor)
				.setType("tin").setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("tin_leggings");
		tin_boots = new SimpleArmor(SimpleOres.plugin, Content.armorTin,
				EntityEquipmentSlot.FEET).setConfigEntry(Settings.tinArmor)
				.setType("tin").setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("tin_boots");

		mythril_helmet = new SimpleArmor(SimpleOres.plugin,
				Content.armorMythril, EntityEquipmentSlot.HEAD)
				.setConfigEntry(Settings.mythrilArmor).setType("mythril")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("mythril_helmet");
		mythril_chestplate = new SimpleArmor(SimpleOres.plugin,
				Content.armorMythril, EntityEquipmentSlot.CHEST)
				.setConfigEntry(Settings.mythrilArmor).setType("mythril")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("mythril_chestplate");
		mythril_leggings = new SimpleArmor(SimpleOres.plugin,
				Content.armorMythril, EntityEquipmentSlot.LEGS)
				.setConfigEntry(Settings.mythrilArmor).setType("mythril")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("mythril_leggings");
		mythril_boots = new SimpleArmor(SimpleOres.plugin,
				Content.armorMythril, EntityEquipmentSlot.FEET)
				.setConfigEntry(Settings.mythrilArmor).setType("mythril")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("mythril_boots");

		adamantium_helmet = new SimpleArmor(SimpleOres.plugin,
				Content.armorAdamantium, EntityEquipmentSlot.HEAD)
				.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("adamantium_helmet");
		adamantium_chestplate = new SimpleArmor(SimpleOres.plugin,
				Content.armorAdamantium, EntityEquipmentSlot.CHEST)
				.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("adamantium_chestplate");
		adamantium_leggings = new SimpleArmor(SimpleOres.plugin,
				Content.armorAdamantium, EntityEquipmentSlot.LEGS)
				.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("adamantium_leggings");
		adamantium_boots = new SimpleArmor(SimpleOres.plugin,
				Content.armorAdamantium, EntityEquipmentSlot.FEET)
				.setConfigEntry(Settings.mythrilArmor).setType("adamantium")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("adamantium_boots");

		onyx_helmet = new SimpleArmor(SimpleOres.plugin, Content.armorOnyx,
				EntityEquipmentSlot.HEAD).setConfigEntry(Settings.onyxArmor)
				.setType("onyx").setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("onyx_helmet");
		onyx_chestplate = new SimpleArmor(SimpleOres.plugin,
				Content.armorOnyx, EntityEquipmentSlot.CHEST)
				.setConfigEntry(Settings.onyxArmor).setType("onyx")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("onyx_chestplate");
		onyx_leggings = new SimpleArmor(SimpleOres.plugin,
				Content.armorOnyx, EntityEquipmentSlot.LEGS)
				.setConfigEntry(Settings.onyxArmor).setType("onyx")
				.setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("onyx_leggings");
		onyx_boots = new SimpleArmor(SimpleOres.plugin, Content.armorOnyx,
				EntityEquipmentSlot.FEET).setConfigEntry(Settings.onyxArmor)
				.setType("onyx").setCreativeTab(TabHelper.combatTab())
				.setUnlocalizedName("onyx_boots");
	} // end doArmor()

	public static void doAchievements() {
		copperAch = new Achievement("achievement.copperAch", "copperAch", 8, 1,
				copper_ore, AchievementList.BUILD_BETTER_PICKAXE).registerStat();
		copperPickAch = new Achievement("achievement.copperPickAch",
				"copperPickAch", 9, 3, copper_pickaxe, copperAch)
				.registerStat();
		copperBucketAch = new Achievement("achievement.copperBucketAch",
				"copperBucketAch", 9, 5, copper_bucket_water, copperAch)
				.registerStat();

		tinAch = new Achievement("achievement.tinAch", "tinAch", 10, 1,
				tin_ore, AchievementList.BUILD_BETTER_PICKAXE).registerStat();
		tinChestplateAch = new Achievement("achievement.tinChestplateAch",
				"tinChestplateAch", 11, 3, tin_chestplate, tinAch)
				.registerStat();
		tinShearsAch = new Achievement("achievement.tinShearsAch",
				"tinShearsAch", 11, 5, tin_shears, tinAch).registerStat();

		mythrilAch = new Achievement("achievement.mythrilAch", "mythrilAch",
				12, 1, mythril_ore, AchievementList.BUILD_BETTER_PICKAXE)
				.registerStat();
		mythrilAxeAch = new Achievement("achievement.mythrilAxeAch",
				"mythrilAxeAch", 13, 3, mythril_axe, mythrilAch).registerStat();
		mythrilBowAch = new Achievement("achievement.mythrilBowAch",
				"mythrilBowAch", 13, 5, mythril_bow, mythrilAch).registerStat();

		adamantiumAch = new Achievement("achievement.adamantiumAch",
				"adamantiumAch", 14, 1, adamantium_ore,
				AchievementList.BUILD_BETTER_PICKAXE).registerStat();
		adamantiumLegsAch = new Achievement("achievement.adamantiumLegsAch",
				"adamantiumLegsAch", 15, 3, adamantium_leggings, adamantiumAch)
				.registerStat();
		adamantiumShearsAch = new Achievement(
				"achievement.adamantiumShearsAch", "adamantiumShearsAch", 15,
				5, adamantium_shears, adamantiumAch).registerStat();

		onyxAch = new Achievement("achievement.onyxAch", "onyxAch", 16, 1,
				onyx_ore, AchievementList.BUILD_BETTER_PICKAXE).setSpecial()
				.registerStat();
		onyxSwordAch = new Achievement("achievement.onyxSwordAch",
				"onyxSwordAch", 17, 3, onyx_sword, onyxAch).registerStat();
		onyxBowAch = new Achievement("achievement.onyxBowAch", "onyxBowAch",
				17, 5, onyx_bow, onyxAch).registerStat();
	} // end doAchievements()

	public static void setToolAndArmorStats() 
	{
		LogHelper.verbose("SimpleOres 2", "Setting Tool and Armor stats");
		
		// Tools
		toolCopper = EnumHelper.addToolMaterial("COPPER",
				Settings.copperTools.getHarvestLevel(),
				Settings.copperTools.getUses(),
				Settings.copperTools.getHarvestSpeed(),
				Settings.copperTools.getDamageVsEntity(),
				Settings.copperTools.getEnchantability());
		toolTin = EnumHelper.addToolMaterial("TIN",
				Settings.tinTools.getHarvestLevel(),
				Settings.tinTools.getUses(),
				Settings.tinTools.getHarvestSpeed(),
				Settings.tinTools.getDamageVsEntity(),
				Settings.tinTools.getEnchantability());
		toolMythril = EnumHelper.addToolMaterial("MYTHRIL",
				Settings.mythrilTools.getHarvestLevel(),
				Settings.mythrilTools.getUses(),
				Settings.mythrilTools.getHarvestSpeed(),
				Settings.mythrilTools.getDamageVsEntity(),
				Settings.mythrilTools.getEnchantability());
		toolAdamantium = EnumHelper.addToolMaterial("ADAMANTIUM",
				Settings.adamantiumTools.getHarvestLevel(),
				Settings.adamantiumTools.getUses(),
				Settings.adamantiumTools.getHarvestSpeed(),
				Settings.adamantiumTools.getDamageVsEntity(),
				Settings.adamantiumTools.getEnchantability());
		toolOnyx = EnumHelper.addToolMaterial("ONYX",
				Settings.onyxTools.getHarvestLevel(),
				Settings.onyxTools.getUses(),
				Settings.onyxTools.getHarvestSpeed(),
				Settings.onyxTools.getDamageVsEntity(),
				Settings.onyxTools.getEnchantability());

		// Armor
		ResourceLocation soundName = new ResourceLocation("item.armor.equip_generic");
		SoundEvent armorNoise = SoundEvent.REGISTRY.getObject(soundName);
		
		armorCopper = 
				EnumHelper.addArmorMaterial("COPPER", 
						"copper", Settings.copperArmor.getDurability(), 
						new int[] {
								Settings.copperArmor.getHelmReduction(),
								Settings.copperArmor.getChestReduction(),
								Settings.copperArmor.getLegsReduction(),
								Settings.copperArmor.getBootsReduction() },
						Settings.copperArmor.getEnchantability(), armorNoise, 0.0F );
		
		armorTin = EnumHelper.addArmorMaterial("TIN", "tin",
				Settings.tinArmor.getDurability(),
				new int[] { Settings.tinArmor.getHelmReduction(),
						Settings.tinArmor.getChestReduction(),
						Settings.tinArmor.getLegsReduction(),
						Settings.tinArmor.getBootsReduction() },
				Settings.tinArmor.getEnchantability(), armorNoise, 0.0F);
		
		armorMythril = EnumHelper.addArmorMaterial("MYTHRIL","mythril",
				Settings.mythrilArmor.getDurability(), new int[] {
						Settings.mythrilArmor.getHelmReduction(),
						Settings.mythrilArmor.getChestReduction(),
						Settings.mythrilArmor.getLegsReduction(),
						Settings.mythrilArmor.getBootsReduction() },
				Settings.mythrilArmor.getEnchantability(), armorNoise, 0.0F );
		
		armorAdamantium = EnumHelper.addArmorMaterial("ADAMANTIUM", "adamantium", 
				Settings.adamantiumArmor.getDurability(),
				new int[] { Settings.adamantiumArmor.getHelmReduction(),
						Settings.adamantiumArmor.getChestReduction(),
						Settings.adamantiumArmor.getLegsReduction(),
						Settings.adamantiumArmor.getBootsReduction() },
				Settings.adamantiumArmor.getEnchantability(), armorNoise, 1.0F);
		
		armorOnyx = EnumHelper.addArmorMaterial("ONYX", "onyx",
				Settings.onyxArmor.getDurability(), new int[] {
						Settings.onyxArmor.getHelmReduction(),
						Settings.onyxArmor.getChestReduction(),
						Settings.onyxArmor.getLegsReduction(),
						Settings.onyxArmor.getBootsReduction() },
				Settings.onyxArmor.getEnchantability(), armorNoise, 2.0F);
	} // end setToolAndArmorStats()

	public static void setRepairMaterials() {
		LogHelper.verbose("SimpleOres 2",
				"Setting Tool and Armor repair materials");
		// Tools
		toolCopper.setRepairItem(new ItemStack(Content.copper_ingot));
		toolTin.setRepairItem(new ItemStack(Content.tin_ingot));
		toolMythril.setRepairItem(new ItemStack(Content.mythril_ingot));
		toolAdamantium.setRepairItem(new ItemStack(Content.adamantium_ingot));
		toolOnyx.setRepairItem(new ItemStack(Content.onyx_gem));

		// Armor
		armorCopper.customCraftingMaterial = Content.copper_ingot;
		armorTin.customCraftingMaterial = Content.tin_ingot;
		armorMythril.customCraftingMaterial = Content.mythril_ingot;
		armorAdamantium.customCraftingMaterial = Content.adamantium_ingot;
		armorOnyx.customCraftingMaterial = Content.onyx_gem;
	}

	public static void setBucketVariants() 
	{
		LogHelper.verbose("SimpleOres 2", "Setting bucket variants");
		copperBucketType = new SimpleBucketType("copper");
		copperBucketType.setDestroyOnLava(true);
		
//		// should no longer need empty bucket variant...
//		copperBucketType.addVariant("water", Content.copper_bucket_water, 
//									FluidRegistry.WATER);
	}

	public static void setAchievementTriggers() {
		LogHelper.verbose("SimpleOres 2", "Setting achievement triggers");
		// Pickup Triggers
		StatTriggersHelper.addPickupTrigger(
				Item.getItemFromBlock(Content.copper_ore), Content.copperAch);
		StatTriggersHelper.addPickupTrigger(
				Item.getItemFromBlock(Content.tin_ore), Content.tinAch);
		StatTriggersHelper.addPickupTrigger(
				Item.getItemFromBlock(Content.mythril_ore), Content.mythrilAch);
		StatTriggersHelper.addPickupTrigger(
				Item.getItemFromBlock(Content.adamantium_ore),
				Content.adamantiumAch);
		StatTriggersHelper.addPickupTrigger(Content.onyx_gem, Content.onyxAch);

		// Crafting Triggers
		StatTriggersHelper.addCraftingTrigger(Content.copper_pickaxe,
				Content.copperPickAch);
		StatTriggersHelper.addCraftingTrigger(Content.copper_bucket,
				Content.copperBucketAch);
		StatTriggersHelper.addCraftingTrigger(Content.tin_chestplate,
				Content.tinChestplateAch);
		StatTriggersHelper.addCraftingTrigger(Content.tin_shears,
				Content.tinShearsAch);
		StatTriggersHelper.addCraftingTrigger(Content.mythril_axe,
				Content.mythrilAxeAch);
		StatTriggersHelper.addCraftingTrigger(Content.mythril_bow,
				Content.mythrilBowAch);
		StatTriggersHelper.addCraftingTrigger(Content.adamantium_leggings,
				Content.adamantiumLegsAch);
		StatTriggersHelper.addCraftingTrigger(Content.adamantium_shears,
				Content.adamantiumShearsAch);
		StatTriggersHelper.addCraftingTrigger(Content.onyx_sword,
				Content.onyxSwordAch);
		StatTriggersHelper.addCraftingTrigger(Content.onyx_bow,
				Content.onyxBowAch);

		// Smelting Triggers
		StatTriggersHelper
				.addSmeltingTrigger(Content.onyx_gem, Content.onyxAch);
	} // end setAchievementTriggers()

	// Tool Materials
	public static ToolMaterial toolCopper, toolTin, toolMythril,
			toolAdamantium, toolOnyx;

	// Armor Materials
	public static ArmorMaterial armorCopper, armorTin, armorMythril,
			armorAdamantium, armorOnyx;

	public static Block copper_ore, tin_ore, mythril_ore, adamantium_ore,
			onyx_ore, copper_block, tin_block, mythril_block, adamantium_block,
			onyx_block;

	public static Item copper_ingot, tin_ingot, mythril_ingot,
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

	public static Achievement copperAch, tinAch, mythrilAch, adamantiumAch,
			onyxAch, copperPickAch, tinChestplateAch, mythrilAxeAch,
			adamantiumLegsAch, onyxSwordAch, copperBucketAch, tinShearsAch,
			mythrilBowAch, adamantiumShearsAch, onyxBowAch;
} // end class()
