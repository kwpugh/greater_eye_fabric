package com.kwpugh.greater_eye.items;

import com.kwpugh.greater_eye.GreaterEye;
import com.kwpugh.greater_eye.util.LocateUtil;
import com.kwpugh.greater_eye.init.TagInit;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

import java.util.List;

public class ItemGreaterEye extends Item
{
	String structureChoice = "Villages";
	static TagKey<ConfiguredStructureFeature<?, ?>> overworldType = TagInit.VILLAGES;

	static boolean enableCustom1 = GreaterEye.CONFIG.GENERAL.enableCustom1;

	public ItemGreaterEye(Settings settings)
	{
		super(settings);
	}

	public TypedActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		ItemStack itemStack = playerIn.getStackInHand(handIn);

		playerIn.setCurrentHand(handIn);

		if(!worldIn.isClient)
		{
			if(playerIn.isSneaking())
			{
				switch (structureChoice)
				{
					case "Villages" -> {
						structureChoice = "Mineshafts";
						overworldType = TagInit.MINESSHAFTS;
					}
					case "Mineshafts" -> {
						structureChoice = "Shipwrecks";
						overworldType = TagInit.SHIPWRECKS;
					}
					case "Shipwrecks" -> {
						structureChoice = "Outposts";
						overworldType = TagInit.OUTPOSTS;
					}
					case "Outposts" -> {
						structureChoice = "Monuments";
						overworldType = TagInit.MONUMENTS;
					}
					case "Monuments" -> {
						structureChoice = "Mansions";
						overworldType = TagInit.MANSIONS;
					}
					case "Mansions" -> {
						structureChoice = "Pyramids";
						overworldType = TagInit.PYRAMIDS;
					}
					case "Pyramids" -> {
						structureChoice = "Strongholds";
						overworldType = TagInit.STRONGHOLDS;
					}
					case "Strongholds" -> {
						structureChoice = "Buried Treasures";
						overworldType = TagInit.BURIED_TREASURES;
					}
					case "Buried Treasures" -> {
						structureChoice = "Ruins";
						overworldType = TagInit.RUINS;
					}
					case "Ruins" -> {
						structureChoice = "Igloos";
						overworldType = TagInit.IGLOOS;
					}
					case "Igloos" -> {
						if(enableCustom1)  // if custom enabled, use it here
						{
							structureChoice = "Custom1";
							overworldType = TagInit.CUSTOM1;
						}
						else // otherwise move on to next
						{
							structureChoice = "Huts";
							overworldType = TagInit.HUTS;
						}
					}
					case "Custom1" -> {
						structureChoice = "Huts";
						overworldType = TagInit.HUTS;
					}
					case "Huts" -> {
						structureChoice = "Villages";
						overworldType = TagInit.VILLAGES;
					}
				}

				playerIn.sendMessage((new TranslatableText("item.greater_eye.greater_eye.message1", structureChoice).formatted(Formatting.BOLD)), true);

				return TypedActionResult.success(itemStack);
			}
		}

		if(!playerIn.isSneaking())   //simple right-click executes
		{
			if(!worldIn.isClient)
			{
				LocateUtil.findStructureAndShoot(worldIn, playerIn, itemStack, structureChoice, handIn, overworldType);

				return TypedActionResult.success(itemStack);
			}
		}

		return TypedActionResult.success(itemStack);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
	{
		tooltip.add(new TranslatableText("item.greater_eye.greater_eye.line1").formatted(Formatting.YELLOW));
		tooltip.add(new TranslatableText("item.greater_eye.greater_eye.line2").formatted(Formatting.YELLOW));
		tooltip.add(new TranslatableText("item.greater_eye.greater_eye.message2", structureChoice).formatted(Formatting.LIGHT_PURPLE));
	}
}
