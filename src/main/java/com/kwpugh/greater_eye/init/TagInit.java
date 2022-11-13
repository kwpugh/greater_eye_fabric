package com.kwpugh.greater_eye.init;

import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKeys;
import net.minecraft.world.gen.structure.Structure;

public class TagInit
{
    // Standard tags
    public static final TagKey<Structure> VILLAGES = of("greater_eye",  "villages");
    public static final TagKey<Structure> MINESHAFTS = of("greater_eye",  "mineshafts");
    public static final TagKey<Structure> SHIPS = of("greater_eye",  "ships");
    public static final TagKey<Structure> BURIED_TREASURES = of("greater_eye",  "buried_treasures");
    public static final TagKey<Structure> OUTPOSTS = of("greater_eye",  "outposts");
    public static final TagKey<Structure> MONUMENTS = of("greater_eye",  "monuments");
    public static final TagKey<Structure> PYRAMIDS = of("greater_eye",  "pyramids");
    public static final TagKey<Structure> MANSIONS = of("greater_eye",  "mansions");
    public static final TagKey<Structure> STRONGHOLDS = of("greater_eye",  "strongholds");
    public static final TagKey<Structure> IGLOOS = of("greater_eye",  "igloos");
    public static final TagKey<Structure> HUTS = of("greater_eye",  "huts");
    public static final TagKey<Structure> RUINS = of("greater_eye",  "ruins");
    public static final TagKey<Structure> TEMPLES = of("greater_eye",  "temples");
    public static final TagKey<Structure> FORTRESSES = of("greater_eye",  "fortresses");
    public static final TagKey<Structure> BASTIONS = of("greater_eye",  "bastions");
    public static final TagKey<Structure> FOSSILS = of("greater_eye",  "fossils");
    public static final TagKey<Structure> CITIES = of("greater_eye",  "cities");

    // Datapack required tags
    public static final TagKey<Structure> DUNGEONS = of("greater_eye",  "dungeons");
    public static final TagKey<Structure> GRAVEYARDS = of("greater_eye",  "graveyards");
    public static final TagKey<Structure> BUILDINGS = of("greater_eye",  "buildings");
    public static final TagKey<Structure> BUILDINGS_NETHER = of("greater_eye",  "buildings_nether");
    public static final TagKey<Structure> BUILDINGS_END = of("greater_eye",  "buildings_end");

    private static TagKey<Structure> of(String namespace, String path)
    {
        return TagKey.of(RegistryKeys.STRUCTURE_WORLDGEN, new Identifier(namespace, path));
    }

    public static void init()
    {
        // Force class load
    }
}

