package com.kwpugh.greater_eye.items;

import com.kwpugh.greater_eye.GreaterEye;
import com.kwpugh.greater_eye.init.TagInit;
import com.kwpugh.greater_eye.util.LocateUtil;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.Structure;

import java.util.List;

public class ItemGreaterEye extends Item
{
	static boolean enableGraveYards = GreaterEye.CONFIG.GENERAL.enableGraveyards;
	static boolean enableBuildings = GreaterEye.CONFIG.GENERAL.enableBuildings;

	String structureChoice = "Villages";
	static TagKey<Structure> overworldType = TagInit.VILLAGES;

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
						overworldType = TagInit.MINESHAFTS;
					}
					case "Mineshafts" -> {
						structureChoice = "Ships";
						overworldType = TagInit.SHIPS;
					}
					case "Ships" -> {
						structureChoice = "Ruins";
						overworldType = TagInit.RUINS;
					}
					case "Ruins" -> {
						structureChoice = "Igloos";
						overworldType = TagInit.IGLOOS;
					}
					case "Igloos" -> {
						structureChoice = "Huts";
						overworldType = TagInit.HUTS;
					}
					case "Huts" -> {
						if(enableGraveYards)  // if graveyards enabled in config, use it here
						{
							structureChoice = "Graveyards";
							overworldType = TagInit.GRAVEYARDS;
						}
						else // otherwise move on to next
						{
							structureChoice = "Strongholds";
							overworldType = TagInit.STRONGHOLDS;
						}
					}
					case "Graveyards" -> {
						structureChoice = "Strongholds";
						overworldType = TagInit.STRONGHOLDS;
					}
					case "Strongholds" -> {
						if(enableBuildings)  // if graveyards enabled in config, use it here
						{
							structureChoice = "Buildings";
							overworldType = TagInit.BUILDINGS;
						}
						else // otherwise move on to next
						{
							structureChoice = "Villages";
							overworldType = TagInit.VILLAGES;
						}
					}
					case "Buildings" -> {
						structureChoice = "Villages";
						overworldType = TagInit.VILLAGES;
					}
				}

				playerIn.sendMessage((Text.translatable("item.greater_eye.greater_eye.message1", structureChoice).formatted(Formatting.BOLD)), true);

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
		tooltip.add(Text.translatable("item.greater_eye.greater_eye.line1").formatted(Formatting.YELLOW));
		tooltip.add(Text.translatable("item.greater_eye.greater_eye.line2").formatted(Formatting.BLUE));
		tooltip.add(Text.translatable("item.greater_eye.greater_eye.message2", structureChoice).formatted(Formatting.LIGHT_PURPLE));
	}
}
