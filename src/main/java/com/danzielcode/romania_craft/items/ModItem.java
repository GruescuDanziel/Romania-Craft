package com.danzielcode.romania_craft.items;

import com.danzielcode.romania_craft.RomaniaCraft;
import com.danzielcode.romania_craft.items.custom.Racke;
import com.danzielcode.romania_craft.items.custom.Scythe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
    public static DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RomaniaCraft.MODID);

    //Tools
    public static RegistryObject<Item> scythe = MOD_ITEMS.register("scythe", () -> new Scythe(new Item.Properties().durability(100)));
    public static RegistryObject<Item> racke = MOD_ITEMS.register("racke",() -> new Racke(Tiers.DIAMOND,1,1,new Item.Properties().durability(100)));


    //Foods
    public static RegistryObject<Item> pork_sausage = MOD_ITEMS.register("pork_sausage", () -> new Item(new Item.Properties().food(ModFood.porkSausage))); //TODO: Add intestines
    public static RegistryObject<Item> cheese = MOD_ITEMS.register("cheese", () -> new Item(new Item.Properties().food(ModFood.chesee))); //TODO: Add a way to let cheese sit and age


    public static void register(IEventBus eventBus){
        MOD_ITEMS.register(eventBus);
    }
}
