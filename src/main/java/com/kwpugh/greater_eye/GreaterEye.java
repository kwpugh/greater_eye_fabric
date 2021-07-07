package com.kwpugh.greater_eye;

import com.kwpugh.greater_eye.items.ItemGreaterEye;
import com.kwpugh.greater_eye.items.ItemGreaterEyeEnd;
import com.kwpugh.greater_eye.items.ItemGreaterEyeNether;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GreaterEye implements ModInitializer
{
	public static final String MOD_ID = "greater_eye";
	
    public static final Item GREATER_EYE = new ItemGreaterEye(new Item.Settings().group(ItemGroup.MISC));
    public static final Item GREATER_EYE_NETHER = new ItemGreaterEyeNether(new Item.Settings().group(ItemGroup.MISC));
    public static final Item GREATER_EYE_END = new ItemGreaterEyeEnd(new Item.Settings().group(ItemGroup.MISC));
 
    @Override
    public void onInitialize()
    {
        Registry.register(Registry.ITEM, new Identifier(GreaterEye.MOD_ID, "greater_eye"), GREATER_EYE);
        Registry.register(Registry.ITEM, new Identifier(GreaterEye.MOD_ID, "greater_eye_nether"), GREATER_EYE_NETHER);
        Registry.register(Registry.ITEM, new Identifier(GreaterEye.MOD_ID, "greater_eye_end"), GREATER_EYE_END);
    }	
}