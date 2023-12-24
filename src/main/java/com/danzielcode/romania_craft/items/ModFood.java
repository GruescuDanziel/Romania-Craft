package com.danzielcode.romania_craft.items;

import net.minecraft.world.food.FoodProperties;

public class ModFood{

    public static FoodProperties porkSausage = new FoodProperties.Builder()
            .meat()
            .nutrition(20)
            .saturationMod(3)
            .build();
}
