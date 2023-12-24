package com.danzielcode.romania_craft.items;

import net.minecraft.world.food.FoodProperties;

public class ModFood{

    public static FoodProperties porkSausage = new FoodProperties.Builder()
            .meat()
            .nutrition(20)
            .saturationMod(3)
            .build();

    public static FoodProperties chesee = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(1)
            .build();
}
