package com.kwpugh.greater_eye.util;

import com.mojang.datafixers.util.Pair;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.EyeOfEnderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.TagKey;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.Optional;
import java.util.Random;

public class LocateUtil
{
    public static void findStructureAndShoot(World worldIn, PlayerEntity playerIn, ItemStack itemstack, String structureChoice, Hand handIn, TagKey<StructureFeature> type)
    {
        // A structure will always be found, no matter how far away
        BlockPos playerpos = playerIn.getBlockPos();
        BlockPos locpos = playerpos;
        Random random = new Random();
        ServerWorld serverWorld = (ServerWorld) worldIn;

        locpos = serverWorld.locateStructure(type, playerpos, 100, false);

        if(locpos == null)
        {
            playerIn.sendMessage(new TranslatableText("item.greater_eye.greater_eye.message5").formatted(Formatting.BOLD), true);

            return;
        }

        ItemStack itemStack = playerIn.getStackInHand(handIn);

        int structureDistance = MathHelper.floor(getDistance(playerpos.getX(), playerpos.getZ(), locpos.getX(), locpos.getZ()));



        // TESTING
        Optional<RegistryEntryList.Named<StructureFeature>> optional = serverWorld.getRegistryManager().get(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY).getEntryList(type);

        if(optional.isPresent())
        {
            Pair<BlockPos, RegistryEntry<StructureFeature>> pair = serverWorld.getChunkManager().getChunkGenerator().locateStructure(serverWorld, optional.get(), playerpos, 100, false);
            if(pair != null)
            {
                RegistryEntry<StructureFeature> value = pair.getSecond();
                playerIn.sendMessage(new TranslatableText("item.greater_eye.greater_eye.message3", value.getKey().get().getValue().getPath(), structureDistance).formatted(Formatting.BOLD), true);
            }
            else
            {
                playerIn.sendMessage(new TranslatableText("item.greater_eye.greater_eye.message3", structureChoice, structureDistance).formatted(Formatting.BOLD), true);
            }
        }
        // TESTING




        EyeOfEnderEntity finderentity = new EyeOfEnderEntity(worldIn, playerIn.getX(), playerIn.getBodyY(0.5D), playerIn.getZ());
        finderentity.setItem(itemstack);
        finderentity.initTargetPos(locpos);
        worldIn.spawnEntity(finderentity);

        if(playerIn instanceof ServerPlayerEntity)
        {
            Criteria.USED_ENDER_EYE.trigger((ServerPlayerEntity) playerIn, locpos);
        }

        worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

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
}
