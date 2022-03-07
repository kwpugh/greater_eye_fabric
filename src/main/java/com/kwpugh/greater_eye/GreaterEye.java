package com.kwpugh.greater_eye;

import com.kwpugh.greater_eye.items.ItemInit;
import com.kwpugh.greater_eye.items.TagInit;
import net.fabricmc.api.ModInitializer;

public class GreaterEye implements ModInitializer
{
	public static final String MOD_ID = "greater_eye";


    @Override
    public void onInitialize()
    {
        ItemInit.init();
        TagInit.init();
    }	
}