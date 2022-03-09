package com.kwpugh.greater_eye.items;

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

public class ItemGreaterEyeNether extends Item
{
	String structureChoice = "Fortresses";
    static TagKey<ConfiguredStructureFeature<?, ?>> netherType = TagInit.FORTRESSES;

	public ItemGreaterEyeNether(Item.Settings settings)
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
					case "Fortresses" -> {
						structureChoice = "Fossils";
						netherType = TagInit.NETHER_FOSSILS;
					}
					case "Fossils" -> {
						structureChoice = "Bastions";
						netherType = TagInit.BASTIONS;
					}
					case "Bastions" -> {
						structureChoice = "Fortresses";
						netherType = TagInit.FORTRESSES;
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
				LocateUtil.findStructureAndShoot(worldIn, playerIn, itemStack, structureChoice, handIn, netherType);

				return TypedActionResult.success(itemStack);
			}
		}

        return TypedActionResult.success(itemStack);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
	    tooltip.add(new TranslatableText("item.greater_eye.greater_eye.line1").formatted(Formatting.YELLOW));
	    tooltip.add(new TranslatableText("item.greater_eye.greater_eye.line2").formatted(Formatting.YELLOW));
	    tooltip.add(new TranslatableText("item.greater_eye.greater_eye.message2", structureChoice).formatted(Formatting.LIGHT_PURPLE));
	}
}
