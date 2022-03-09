package com.kwpugh.greater_eye;

import com.kwpugh.greater_eye.config.ModConfig;
import com.kwpugh.greater_eye.init.ItemInit;
import com.kwpugh.greater_eye.init.TagInit;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.ModInitializer;

public class GreaterEye implements ModInitializer
{
	public static final String MOD_ID = "greater_eye";
    public static final ModConfig CONFIG = AutoConfig.register(ModConfig.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new)).getConfig();


    @Override
    public void onInitialize()
    {
        ItemInit.init();
        TagInit.init();
    }	
}