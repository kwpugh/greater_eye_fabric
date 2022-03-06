package com.kwpugh.greater_eye;

import com.kwpugh.greater_eye.items.ItemGreaterEye;
import com.kwpugh.greater_eye.items.ItemGreaterEyeEnd;
import com.kwpugh.greater_eye.items.ItemGreaterEyeNether;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

public class GreaterEye implements ModInitializer
{
	public static final String MOD_ID = "greater_eye";
	
    public static final Item GREATER_EYE = new ItemGreaterEye(new Item.Settings().group(ItemGroup.MISC));
    public static final Item GREATER_EYE_NETHER = new ItemGreaterEyeNether(new Item.Settings().group(ItemGroup.MISC));
    public static final Item GREATER_EYE_END = new ItemGreaterEyeEnd(new Item.Settings().group(ItemGroup.MISC));


    public static final TagKey<ConfiguredStructureFeature<?, ?>> VILLAGE = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "village"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> MINESSHAFT = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "mineshaft"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> SHIPWRECK = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "shipwreck"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> BURIED_TREASURE = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "buried_treasure"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> PILLAGER_OUTPOST = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "pillager_outpost"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> MONUMENT = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "monument"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> JUNGLE_PYRAMID = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "jungle_pyramid"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> DESERT_PYRAMID = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "desert_pyramid"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> MANSION = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "mansion"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> STRONGHOLD = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "stronghold"));

    public static final TagKey<ConfiguredStructureFeature<?, ?>> FORTRESS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "fortress"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> BASTION_REMNNANT = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "bastion_remnant"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> NETHER_FOSSIL = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "nether_fossil"));

    public static final TagKey<ConfiguredStructureFeature<?, ?>> END_CITY = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "end_city"));


    @Override
    public void onInitialize()
    {
        Registry.register(Registry.ITEM, new Identifier(GreaterEye.MOD_ID, "greater_eye"), GREATER_EYE);
        Registry.register(Registry.ITEM, new Identifier(GreaterEye.MOD_ID, "greater_eye_nether"), GREATER_EYE_NETHER);
        Registry.register(Registry.ITEM, new Identifier(GreaterEye.MOD_ID, "greater_eye_end"), GREATER_EYE_END);
    }	
}