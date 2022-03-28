package com.kwpugh.greater_eye.init;

import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.StructureFeature;

public class TagInit
{
    // Standard tags
    public static final TagKey<StructureFeature> VILLAGES = of("greater_eye",  "villages");
    public static final TagKey<StructureFeature> MINESHAFTS = of("greater_eye",  "mineshafts");
    public static final TagKey<StructureFeature> SHIPS = of("greater_eye",  "ships");
    public static final TagKey<StructureFeature> BURIED_TREASURES = of("greater_eye",  "buried_treasures");
    public static final TagKey<StructureFeature> OUTPOSTS = of("greater_eye",  "outposts");
    public static final TagKey<StructureFeature> MONUMENTS = of("greater_eye",  "monuments");
    public static final TagKey<StructureFeature> PYRAMIDS = of("greater_eye",  "pyramids");
    public static final TagKey<StructureFeature> MANSIONS = of("greater_eye",  "mansions");
    public static final TagKey<StructureFeature> STRONGHOLDS = of("greater_eye",  "strongholds");
    public static final TagKey<StructureFeature> IGLOOS = of("greater_eye",  "igloos");
    public static final TagKey<StructureFeature> HUTS = of("greater_eye",  "huts");
    public static final TagKey<StructureFeature> RUINS = of("greater_eye",  "ruins");
    public static final TagKey<StructureFeature> TEMPLES = of("greater_eye",  "temples");
    public static final TagKey<StructureFeature> FORTRESSES = of("greater_eye",  "fortresses");
    public static final TagKey<StructureFeature> BASTIONS = of("greater_eye",  "bastions");
    public static final TagKey<StructureFeature> FOSSILS = of("greater_eye",  "fossils");
    public static final TagKey<StructureFeature> CITIES = of("greater_eye",  "cities");

    // Datapack required tags
    public static final TagKey<StructureFeature> DUNGEONS = of("greater_eye",  "dungeons");
    public static final TagKey<StructureFeature> GRAVEYARDS = of("greater_eye",  "graveyards");
    public static final TagKey<StructureFeature> BUILDINGS = of("greater_eye",  "buildings");
    public static final TagKey<StructureFeature> BUILDINGS_NETHER = of("greater_eye",  "buildings_nether");
    public static final TagKey<StructureFeature> BUILDINGS_END = of("greater_eye",  "buildings_end");

    private static TagKey<StructureFeature> of(String namespace, String path)
    {
        return TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier(namespace, path));
    }

    public static void init()
    {
        // Force class load
    }
}








//import net.minecraft.tag.TagKey;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
//
//public class TagInit
//{
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> VILLAGES = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "villages"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> MINESHAFTS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "mineshafts"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> SHIPS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "ships"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> BURIED_TREASURES = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "buried_treasures"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> OUTPOSTS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "outposts"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> MONUMENTS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "monuments"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> PYRAMIDS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "pyramids"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> MANSIONS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "mansions"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> STRONGHOLDS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "strongholds"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> IGLOOS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "igloos"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> HUTS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "huts"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> RUINS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "ruins"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> TEMPLES = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "temples"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> FORTRESSES = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "fortresses"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> BASTIONS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "bastions"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> FOSSILS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "fossils"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> CITIES = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "cities"));
//
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> DUNGEONS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "dungeons"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> GRAVEYARDS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "graveyards"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> BUILDINGS = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "buildings"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> BUILDINGS_NETHER = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "buildings_nether"));
//    public static final TagKey<ConfiguredStructureFeature<?, ?>> BUILDINGS_END = TagKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, new Identifier("greater_eye",  "buildings_end"));
//
//    public static void init()
//    {
//        // Force class load
//    }
//}
