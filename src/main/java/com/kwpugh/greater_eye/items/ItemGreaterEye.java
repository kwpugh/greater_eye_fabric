package com.kwpugh.greater_eye.items;

import java.util.List;
import java.util.Random;

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
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.StructureFeature;

public class ItemGreaterEye extends Item
{
	String structureType = "Village";
	StructureFeature<?> type = StructureFeature.VILLAGE;
	
	public ItemGreaterEye(Item.Settings settings)
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
			
			if((worldIn instanceof ServerWorld) && (playerIn.isSneaking() && (serverWorld.getRegistryKey().equals(World.OVERWORLD))))    //shift right-click changes structure type to locate
			{
				if(structureType == "Village")
				{
					structureType = "Mineshaft";
					type = StructureFeature.MINESHAFT;
				}
				else if(structureType == "Mineshaft")
				{
					structureType = "Shipwreck";
					type = StructureFeature.SHIPWRECK;
				}
				else if(structureType == "Shipwreck")
				{
					structureType = "Pillager_Outpost";
					type = StructureFeature.PILLAGER_OUTPOST;
				}
				else if(structureType == "Pillager_Outpost")
				{
					structureType = "Monument";
					type = StructureFeature.MONUMENT;
				}
				else if(structureType == "Monument")
				{
					structureType = "Mansion";
					type = StructureFeature.MANSION;
				}
				else if(structureType == "Mansion")
				{
					structureType = "Desert_Pyramid";
					type = StructureFeature.DESERT_PYRAMID;
				}
				else if(structureType == "Desert_Pyramid")
				{
					structureType = "Jungle_Pyramid";
					type = StructureFeature.JUNGLE_PYRAMID;
				}
				else if(structureType == "Jungle_Pyramid")
				{
					structureType = "Stronghold";
					type = StructureFeature.STRONGHOLD;
				}
				else if(structureType == "Stronghold")
				{
					structureType = "Buried Treasure";
					type = StructureFeature.BURIED_TREASURE;
				}
				else if(structureType == "Buried Treasure")
				{
					structureType = "Village";
					type = StructureFeature.VILLAGE;
				}
				
				playerIn.sendMessage((new TranslatableText("item.greater_eye.greater_eye.message1", structureType).formatted(Formatting.LIGHT_PURPLE)), true);

				return TypedActionResult.success(itemStack);
			}
		}
		
		if(!playerIn.isSneaking())   //simple right-click executes
		{
			if(!worldIn.isClient)
			{
				ServerWorld serverWorld = (ServerWorld)worldIn;
				
				if((worldIn instanceof ServerWorld) && (serverWorld.getRegistryKey().equals(World.OVERWORLD)));
				{
					findStructureAndShoot(worldIn, playerIn, itemStack, structureType, type, handIn);

					return TypedActionResult.success(itemStack);
				}
			}		
		}

        return TypedActionResult.success(itemStack);
	}

	
	private static void findStructureAndShoot(World worldIn, PlayerEntity playerIn, ItemStack itemstack, String structureType, StructureFeature<?> type, Hand handIn)
	{
		// A structure will always be found, no matter how far away
		BlockPos playerpos = playerIn.getBlockPos();
		BlockPos locpos = playerpos;
		Random random = new Random();

		locpos = ((ServerWorld)worldIn).getChunkManager().getChunkGenerator().locateStructure((ServerWorld)worldIn, type, playerIn.getBlockPos(), 100, false);	

		ItemStack itemStack = playerIn.getStackInHand(handIn);

		int structureDistance = MathHelper.floor(getDistance(playerpos.getX(), playerpos.getZ(), locpos.getX(), locpos.getZ()));

		playerIn.sendMessage(new TranslatableText("item.greater_eye.greater_eye.message3", structureType, structureDistance).formatted(Formatting.LIGHT_PURPLE), true);

		EyeOfEnderEntity finderentity = new EyeOfEnderEntity(worldIn, playerIn.getX(), playerIn.getBodyY(0.5D), playerIn.getZ());
		finderentity.setItem(itemstack);
		finderentity.initTargetPos(locpos);
		worldIn.spawnEntity(finderentity);

		if (playerIn instanceof ServerPlayerEntity)
		{
			Criteria.USED_ENDER_EYE.trigger((ServerPlayerEntity)playerIn, locpos);
		}

		worldIn.playSound((PlayerEntity)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

		if (!playerIn.isCreative())
		{
			itemStack.decrement(1);
		}

		return;
	}

	private static float getDistance(int x1, int z1, int x2, int z2)
	{
		int i = x2 - x1;
		int j = z2 - z1;

		return MathHelper.sqrt((float)(i * i + j * j));
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
	    tooltip.add(new TranslatableText("item.greater_eye.greater_eye.line1").formatted(Formatting.YELLOW));
	    tooltip.add(new TranslatableText("item.greater_eye.greater_eye.line2").formatted(Formatting.YELLOW));
	    tooltip.add(new TranslatableText("item.greater_eye.greater_eye.message2", structureType).formatted(Formatting.LIGHT_PURPLE));
	}
}
