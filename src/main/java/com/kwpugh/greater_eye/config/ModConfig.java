package com.kwpugh.greater_eye.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "greater_eye")
public class ModConfig extends PartitioningSerializer.GlobalData
{
    public General GENERAL = new General();

    @Config(name = "general")
    public static class General implements ConfigData
    {
        @Comment("***********************"
                +"\nDungeons Tag Settings (experimental)"
                +"\n- requires datapack"
                +"\n- datapack contains Better Dungeons mod structures"
                +"\n- other structures can be added if desired"
                +"\n***********************")
        public boolean enableDungeonType = false;

        @Comment("***********************"
                +"\nGraveyard Tag Settings (experimental)"
                +"\n- requires datapack"
                +"\n- datapack contains The Graveyard mod structures"
                +"\n- other structures can be added if desired"
                +"\n***********************")
        public boolean enableGraveyards = false;

        @Comment("***********************"
                +"\nBuildings Tag Settings (experimental)"
                +"\n- requires datapack"
                +"\n- datapack contains Awesome Dungeons, Oceans,"
                +"\nNether, and End mod structures"
                +"\n- other structures can be added if desired"
                +"\n***********************")
        public boolean enableBuildings = false;
        public boolean enableNetherBuildings = false;
        public boolean enableEndBuildings = false;
    }
}