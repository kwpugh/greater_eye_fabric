package com.kwpugh.greater_eye.items;

import com.kwpugh.greater_eye.init.TagInit;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EyeOfEnderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

import java.util.List;
import java.util.Random;

public class ItemGreaterEye extends Item
{
	String structureChoice = "Villages";
	static TagKey<ConfiguredStructureFeature<?, ?>> overworldType = TagInit.VILLAGES;

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
				findStructureAndShoot(worldIn, playerIn, itemStack, structureChoice, handIn);

				return TypedActionResult.success(itemStack);
			}
		}

		return TypedActionResult.success(itemStack);
	}

	private static void findStructureAndShoot(World worldIn, PlayerEntity playerIn, ItemStack itemstack, String structureChoice, Hand handIn)
	{
		// A structure will always be found, no matter how far away
		BlockPos playerpos = playerIn.getBlockPos();
		BlockPos locpos;
		Random random = new Random();
		ServerWorld serverWorld = (ServerWorld) worldIn;

		locpos = serverWorld.locateStructure(overworldType, playerIn.getBlockPos(), 100, false);

		if(locpos == null)
		{
			playerIn.sendMessage(new TranslatableText("Cannot be found! Structure might not exist here.").formatted(Formatting.BOLD), true);

			return;
		}

		ItemStack itemStack = playerIn.getStackInHand(handIn);

		int structureDistance = MathHelper.floor(getDistance(playerpos.getX(), playerpos.getZ(), locpos.getX(), locpos.getZ()));

		playerIn.sendMessage(new TranslatableText("item.greater_eye.greater_eye.message3", structureChoice, structureDistance).formatted(Formatting.BOLD), true);

		EyeOfEnderEntity finderentity = new EyeOfEnderEntity(worldIn, playerIn.getX(), playerIn.getBodyY(0.5D), playerIn.getZ());
		finderentity.setItem(itemstack);
		finderentity.initTargetPos(locpos);
		worldIn.spawnEntity(finderentity);

		if(playerIn instanceof ServerPlayerEntity)
		{
			Criteria.USED_ENDER_EYE.trigger((ServerPlayerEntity) playerIn, locpos);
		}

		worldIn.playSound((PlayerEntity) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

		if(!playerIn.isCreative())
		{
			itemStack.decrement(1);
		}
	}

	private static float getDistance(int x1, int z1, int x2, int z2)
	{
		int i = x2 - x1;
		int j = z2 - z1;

		return MathHelper.sqrt((float) (i * i + j * j));
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
	{
		tooltip.add(new TranslatableText("item.greater_eye.greater_eye.line1").formatted(Formatting.YELLOW));
		tooltip.add(new TranslatableText("item.greater_eye.greater_eye.line2").formatted(Formatting.YELLOW));
		tooltip.add(new TranslatableText("item.greater_eye.greater_eye.message2", structureChoice).formatted(Formatting.LIGHT_PURPLE));
	}
}
