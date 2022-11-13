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

public class ItemGreaterEyeEnd extends Item
{
	static boolean enableEndBuildings = GreaterEye.CONFIG.GENERAL.enableEndBuildings;
	static boolean enableDungeons = GreaterEye.CONFIG.GENERAL.enableDungeonType;

	String structureChoice = "Monuments";
	TagKey<Structure> endType = TagInit.CITIES;

	public ItemGreaterEyeEnd(Item.Settings settings)
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
				switch(structureChoice)
				{
					case "Monuments" -> {
						structureChoice = "Mansions";
						endType = TagInit.MANSIONS;
					}
					case "Mansions" -> {
						if(enableDungeons)  // if buildings enabled in config, use it here
						{
							structureChoice = "Dungeons";
							endType = TagInit.DUNGEONS;
						}
						else // otherwise move on to next
						{
							structureChoice = "Cities";
							endType = TagInit.CITIES;
						}
					}
					case "Dungeons" -> {
						structureChoice = "Cities";
						endType = TagInit.CITIES;
					}
					case "Cities" -> {
						if(enableEndBuildings)  // if buildings enabled in config, use it here
						{
							structureChoice = "End Buildings";
							endType = TagInit.BUILDINGS_END;
						}
						else // otherwise move on to next
						{
							structureChoice = "Monuments";
							endType = TagInit.MONUMENTS;
						}
					}
					case "End Buildings" -> {
						structureChoice = "Monuments";
						endType = TagInit.MONUMENTS;
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
				LocateUtil.findStructureAndShoot(worldIn, playerIn, itemStack, structureChoice, handIn, endType);

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
