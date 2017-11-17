package alexndr.plugins.SimpleOres;

import alexndr.api.content.items.SimpleBucketType;
import alexndr.api.helpers.game.ArmorMaterialHelper;
import alexndr.api.logger.LogHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @author AleXndrTheGr8st
 */
public class Content 
{
	// SimpleBucketType
	public static SimpleBucketType copperBucketType;
	
	// Tool Materials
	public static ToolMaterial toolCopper, toolTin, toolMythril,
			toolAdamantium, toolOnyx;

	// Armor Materials
	public static ArmorMaterial armorCopper, armorTin, armorMythril,
			armorAdamantium, armorOnyx;

	
	public static void preInitialize() 
	{
		setToolAndArmorStats();
		setBucketVariants();
		ModItems.configureSimpleItems();
		ModBlocks.configureBlocks(); // don't move this, as needs some items defined in doItems() first.
		ModItems.configureTools();
		ModItems.configureBows();
		ModItems.configureArmor();
//		doAchievements();
	} // end preInitialize()


	/**
	 * completed config revision.
	 */
	public static void setToolAndArmorStats() 
	{
		LogHelper.verbose(ModInfo.ID, "Setting Tool and Armor stats");
		
		// Tools
		if (Settings.copperTools.isEnabled()) {
			toolCopper = EnumHelper.addToolMaterial("COPPER",
					Settings.copperTools.getHarvestLevel(),
					Settings.copperTools.getUses(),
					Settings.copperTools.getHarvestSpeed(),
					Settings.copperTools.getDamageVsEntity(),
					Settings.copperTools.getEnchantability());
		}
		if (Settings.tinTools.isEnabled()) {
			toolTin = EnumHelper.addToolMaterial("TIN",
					Settings.tinTools.getHarvestLevel(),
					Settings.tinTools.getUses(),
					Settings.tinTools.getHarvestSpeed(),
					Settings.tinTools.getDamageVsEntity(),
					Settings.tinTools.getEnchantability());
		}
		if (Settings.mythrilTools.isEnabled()) {
			toolMythril = EnumHelper.addToolMaterial("MYTHRIL",
					Settings.mythrilTools.getHarvestLevel(),
					Settings.mythrilTools.getUses(),
					Settings.mythrilTools.getHarvestSpeed(),
					Settings.mythrilTools.getDamageVsEntity(),
					Settings.mythrilTools.getEnchantability());
		}
		if (Settings.adamantiumTools.isEnabled()) {
			toolAdamantium = EnumHelper.addToolMaterial("ADAMANTIUM",
					Settings.adamantiumTools.getHarvestLevel(),
					Settings.adamantiumTools.getUses(),
					Settings.adamantiumTools.getHarvestSpeed(),
					Settings.adamantiumTools.getDamageVsEntity(),
					Settings.adamantiumTools.getEnchantability());
		}
		if (Settings.onyxTools.isEnabled()) {
			toolOnyx = EnumHelper.addToolMaterial("ONYX",
					Settings.onyxTools.getHarvestLevel(),
					Settings.onyxTools.getUses(),
					Settings.onyxTools.getHarvestSpeed(),
					Settings.onyxTools.getDamageVsEntity(),
					Settings.onyxTools.getEnchantability());
		}
		// Armor
		ResourceLocation soundName = new ResourceLocation("item.armor.equip_generic");
		SoundEvent armorNoise = SoundEvent.REGISTRY.getObject(soundName);
		
		if (Settings.copperArmor.isEnabled()) {
			armorCopper = 
				EnumHelper.addArmorMaterial("COPPER", 
						"copper", Settings.copperArmor.getDurability(), 
						new int[] {
								Settings.copperArmor.getBootsReduction(),
								Settings.copperArmor.getLegsReduction(),
								Settings.copperArmor.getChestReduction(),
								Settings.copperArmor.getHelmReduction() },
						Settings.copperArmor.getEnchantability(), armorNoise, 0.0F );
		}
		if (Settings.tinArmor.isEnabled()) {
			armorTin = EnumHelper.addArmorMaterial("TIN", "tin",
				Settings.tinArmor.getDurability(),
				new int[] { 
                                Settings.tinArmor.getBootsReduction(),
                                Settings.tinArmor.getLegsReduction(),
                                Settings.tinArmor.getChestReduction(),
                                Settings.tinArmor.getHelmReduction() },
				Settings.tinArmor.getEnchantability(), armorNoise, 0.0F);
		}
		if (Settings.mythrilArmor.isEnabled()) {
			armorMythril = EnumHelper.addArmorMaterial("MYTHRIL","mythril",
				Settings.mythrilArmor.getDurability(), new int[] {
                                Settings.mythrilArmor.getBootsReduction(),
                                Settings.mythrilArmor.getLegsReduction(),
                                Settings.mythrilArmor.getChestReduction(),
                                Settings.mythrilArmor.getHelmReduction() },
				Settings.mythrilArmor.getEnchantability(), armorNoise, 0.0F );
		}
		if (Settings.adamantiumArmor.isEnabled()) {
			armorAdamantium = EnumHelper.addArmorMaterial("ADAMANTIUM", "adamantium", 
				Settings.adamantiumArmor.getDurability(),
				new int[] { 
                                Settings.adamantiumArmor.getBootsReduction(),
                                Settings.adamantiumArmor.getLegsReduction(),
                                Settings.adamantiumArmor.getChestReduction(),
                                Settings.adamantiumArmor.getHelmReduction() },
				Settings.adamantiumArmor.getEnchantability(), armorNoise, 1.0F);
		}
		if (Settings.onyxArmor.isEnabled()) {
			armorOnyx = EnumHelper.addArmorMaterial("ONYX", "onyx",
				Settings.onyxArmor.getDurability(), new int[] {
                                Settings.onyxArmor.getBootsReduction(),
                                Settings.onyxArmor.getLegsReduction(),
                                Settings.onyxArmor.getChestReduction(),
                                Settings.onyxArmor.getHelmReduction() },
				Settings.onyxArmor.getEnchantability(), armorNoise, 2.0F);
		}
	} // end setToolAndArmorStats()

	/**
	 * completed config revision.
	 */
	public static void setRepairMaterials() 
	{
		LogHelper.verbose(ModInfo.ID,
				"Setting Tool and Armor repair materials");
	
		if (Settings.copperIngot.isEnabled()) 
		{
			if (toolCopper != null) toolCopper.setRepairItem(new ItemStack(ModItems.copper_ingot));
			if (armorCopper != null)
				ArmorMaterialHelper.setRepairItem(armorCopper, new ItemStack(ModItems.copper_ingot));
		}
		if (Settings.tinIngot.isEnabled()) {
			if (toolTin != null) toolTin.setRepairItem(new ItemStack(ModItems.tin_ingot));
			if (armorTin != null)
				ArmorMaterialHelper.setRepairItem(armorTin, new ItemStack(ModItems.tin_ingot));
		}
		if (Settings.mythrilIngot.isEnabled()) {
			if (toolMythril != null) toolMythril.setRepairItem(new ItemStack(ModItems.mythril_ingot));
			if (armorMythril != null) 
				ArmorMaterialHelper.setRepairItem(armorMythril, new ItemStack(ModItems.mythril_ingot));
		}
		if (Settings.adamantiumIngot.isEnabled())
		{
			if (toolAdamantium != null) 
				toolAdamantium.setRepairItem(new ItemStack(ModItems.adamantium_ingot));
			if (armorAdamantium != null)
				ArmorMaterialHelper.setRepairItem(armorAdamantium, new ItemStack(ModItems.adamantium_ingot));
		}
		if (Settings.onyxGem.isEnabled()) {
			if (toolOnyx != null) toolOnyx.setRepairItem(new ItemStack(ModItems.onyx_gem));
			if (armorOnyx != null) 
				ArmorMaterialHelper.setRepairItem(armorOnyx, new ItemStack(ModItems.onyx_gem));
		}
	} // end setRepairMaterials()

	/**
	 * completed config revision.
	 */
	public static void setBucketVariants() 
	{
		LogHelper.verbose(ModInfo.ID, "Setting bucket variants");
		if (Settings.copperBucket.isEnabled()) {
			copperBucketType = new SimpleBucketType("copper");
			copperBucketType.setDestroyOnLava(true);
		}
	}

//	public static void doAchievements() 
//	{
//		copperAch = new Achievement("achievement.copperAch", "copperAch", 8, 1,
//				copper_ore, AchievementList.BUILD_BETTER_PICKAXE).registerStat();
//		copperPickAch = new Achievement("achievement.copperPickAch",
//				"copperPickAch", 9, 3, copper_pickaxe, copperAch)
//				.registerStat();
//		copperBucketAch = new Achievement("achievement.copperBucketAch",
//				"copperBucketAch", 9, 5, copper_bucket_water, copperAch)
//				.registerStat();
//
//		tinAch = new Achievement("achievement.tinAch", "tinAch", 10, 1,
//				tin_ore, AchievementList.BUILD_BETTER_PICKAXE).registerStat();
//		tinChestplateAch = new Achievement("achievement.tinChestplateAch",
//				"tinChestplateAch", 11, 3, tin_chestplate, tinAch)
//				.registerStat();
//		tinShearsAch = new Achievement("achievement.tinShearsAch",
//				"tinShearsAch", 11, 5, tin_shears, tinAch).registerStat();
//
//		mythrilAch = new Achievement("achievement.mythrilAch", "mythrilAch",
//				12, 1, mythril_ore, AchievementList.BUILD_BETTER_PICKAXE)
//				.registerStat();
//		mythrilAxeAch = new Achievement("achievement.mythrilAxeAch",
//				"mythrilAxeAch", 13, 3, mythril_axe, mythrilAch).registerStat();
//		mythrilBowAch = new Achievement("achievement.mythrilBowAch",
//				"mythrilBowAch", 13, 5, mythril_bow, mythrilAch).registerStat();
//
//		adamantiumAch = new Achievement("achievement.adamantiumAch",
//				"adamantiumAch", 14, 1, adamantium_ore,
//				AchievementList.BUILD_BETTER_PICKAXE).registerStat();
//		adamantiumLegsAch = new Achievement("achievement.adamantiumLegsAch",
//				"adamantiumLegsAch", 15, 3, adamantium_leggings, adamantiumAch)
//				.registerStat();
//		adamantiumShearsAch = new Achievement(
//				"achievement.adamantiumShearsAch", "adamantiumShearsAch", 15,
//				5, adamantium_shears, adamantiumAch).registerStat();
//
//		onyxAch = new Achievement("achievement.onyxAch", "onyxAch", 16, 1,
//				onyx_ore, AchievementList.BUILD_BETTER_PICKAXE).setSpecial()
//				.registerStat();
//		onyxSwordAch = new Achievement("achievement.onyxSwordAch",
//				"onyxSwordAch", 17, 3, onyx_sword, onyxAch).registerStat();
//		onyxBowAch = new Achievement("achievement.onyxBowAch", "onyxBowAch",
//				17, 5, onyx_bow, onyxAch).registerStat();
//	} // end doAchievements()
 
	
//	public static void setAchievementTriggers() 
//	{
//		LogHelper.verbose(ModInfo.ID, "Setting achievement triggers");
//		
//		// Pickup Triggers
//		StatTriggersHelper.addPickupTrigger(
//				Item.getItemFromBlock(Content.copper_ore), Content.copperAch);
//		StatTriggersHelper.addPickupTrigger(
//				Item.getItemFromBlock(Content.tin_ore), Content.tinAch);
//		StatTriggersHelper.addPickupTrigger(
//				Item.getItemFromBlock(Content.mythril_ore), Content.mythrilAch);
//		StatTriggersHelper.addPickupTrigger(
//				Item.getItemFromBlock(Content.adamantium_ore),
//				Content.adamantiumAch);
//		StatTriggersHelper.addPickupTrigger(Content.onyx_gem, Content.onyxAch);
//
//		// Crafting Triggers
//		StatTriggersHelper.addCraftingTrigger(Content.copper_pickaxe,
//				Content.copperPickAch);
//		StatTriggersHelper.addCraftingTrigger(Content.copper_bucket,
//				Content.copperBucketAch);
//		StatTriggersHelper.addCraftingTrigger(Content.tin_chestplate,
//				Content.tinChestplateAch);
//		StatTriggersHelper.addCraftingTrigger(Content.tin_shears,
//				Content.tinShearsAch);
//		StatTriggersHelper.addCraftingTrigger(Content.mythril_axe,
//				Content.mythrilAxeAch);
//		StatTriggersHelper.addCraftingTrigger(Content.mythril_bow,
//				Content.mythrilBowAch);
//		StatTriggersHelper.addCraftingTrigger(Content.adamantium_leggings,
//				Content.adamantiumLegsAch);
//		StatTriggersHelper.addCraftingTrigger(Content.adamantium_shears,
//				Content.adamantiumShearsAch);
//		StatTriggersHelper.addCraftingTrigger(Content.onyx_sword,
//				Content.onyxSwordAch);
//		StatTriggersHelper.addCraftingTrigger(Content.onyx_bow,
//				Content.onyxBowAch);
//
//		// Smelting Triggers
//		StatTriggersHelper
//				.addSmeltingTrigger(Content.onyx_gem, Content.onyxAch);
//	} // end setAchievementTriggers()


//	public static Achievement copperAch, tinAch, mythrilAch, adamantiumAch,
//			onyxAch, copperPickAch, tinChestplateAch, mythrilAxeAch,
//			adamantiumLegsAch, onyxSwordAch, copperBucketAch, tinShearsAch,
//			mythrilBowAch, adamantiumShearsAch, onyxBowAch;
} // end class()
