package com.kwpugh.greater_eye.init;

import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

public class TagInit
{
    public static final TagKey<ConfiguredStructureFeature<?, ?>> VILLAGES = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "villages"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> MINESSHAFTS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "mineshafts"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> SHIPWRECKS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "shipwrecks"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> BURIED_TREASURES = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "buried_treasures"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> OUTPOSTS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "outposts"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> MONUMENTS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "monuments"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> PYRAMIDS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "pyramids"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> MANSIONS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "mansions"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> STRONGHOLDS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "strongholds"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> IGLOOS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "igloos"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> HUTS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "witch_huts"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> RUINS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "ruins"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> FORTRESSES = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "fortresses"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> BASTIONS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "bastions"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> NETHER_FOSSILS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "nether_fossils"));
    public static final TagKey<ConfiguredStructureFeature<?, ?>> CITIES = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "cities"));


    public static void init()
    {
        // Force class load
    }
}
