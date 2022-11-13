package com.kwpugh.greater_eye.util;

import com.kwpugh.greater_eye.GreaterEye;
import com.kwpugh.greater_eye.init.ItemInit;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class GreaterEyeGroup
{
    public static void addGroup()
    {
        // force class run when we want
    }

    private static final ItemGroup GREATER_EYE_GROUP = FabricItemGroup.builder(new Identifier(GreaterEye.MOD_ID, "greater_eye_group"))
            .icon(() -> new ItemStack(ItemInit.GREATER_EYE))
            .entries((enabledFeatures, entries, operatorEnabled) -> {
                entries.add(ItemInit.GREATER_EYE);
                entries.add(ItemInit.GREATER_EYE_NETHER);
                entries.add(ItemInit.GREATER_EYE_END);
            })
            .build();
}
