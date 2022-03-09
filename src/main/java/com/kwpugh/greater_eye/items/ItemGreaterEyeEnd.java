package com.kwpugh.greater_eye.items;

import com.kwpugh.greater_eye.util.LocateUtil;
import com.kwpugh.greater_eye.init.TagInit;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

import java.util.List;

public class ItemGreaterEyeEnd extends Item
{
	String structureChoice = "Cities";
	TagKey<ConfiguredStructureFeature<?, ?>> endType = TagInit.CITIES;

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
			ServerWorld serverWorld = (ServerWorld)worldIn;

			if((playerIn.isSneaking() && (serverWorld.getRegistryKey().equals(World.END))))    //shift right-click changes structure type to locate
			{
				playerIn.sendMessage((new TranslatableText("item.greater_eye.greater_eye.message1", structureChoice).formatted(Formatting.DARK_PURPLE)), true);

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
	    tooltip.add(new TranslatableText("item.greater_eye.greater_eye.message2", structureChoice).formatted(Formatting.LIGHT_PURPLE));
	}
}
