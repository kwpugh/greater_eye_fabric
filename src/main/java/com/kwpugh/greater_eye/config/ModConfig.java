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
                +"\nTag Settings (experimental)"
                +"\n- requires datapack"
                +"\n- tags are empty by default"
                +"\n***********************")
        public boolean enableDungeonType = false;
        public boolean enableGraveyards = false;
        public boolean enableCustom1 = false;

    }
}