package com.kwpugh.greater_eye.init;

import com.kwpugh.greater_eye.GreaterEye;
import com.kwpugh.greater_eye.items.ItemGreaterEye;
import com.kwpugh.greater_eye.items.ItemGreaterEyeEnd;
import com.kwpugh.greater_eye.items.ItemGreaterEyeNether;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registries;
import net.minecraft.util.registry.Registry;

public class ItemInit
{
    public static final Item GREATER_EYE = new ItemGreaterEye(new Item.Settings());
    public static final Item GREATER_EYE_NETHER = new ItemGreaterEyeNether(new Item.Settings());
    public static final Item GREATER_EYE_END = new ItemGreaterEyeEnd(new Item.Settings());

    public static void init()
    {
        Registry.register(Registries.ITEM, new Identifier(GreaterEye.MOD_ID, "greater_eye"), GREATER_EYE);
        Registry.register(Registries.ITEM, new Identifier(GreaterEye.MOD_ID, "greater_eye_nether"), GREATER_EYE_NETHER);
        Registry.register(Registries.ITEM, new Identifier(GreaterEye.MOD_ID, "greater_eye_end"), GREATER_EYE_END);
    }
}
