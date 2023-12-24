package com.danzielcode.romania_craft.datagen;

import com.danzielcode.romania_craft.RomaniaCraft;
import com.danzielcode.romania_craft.items.ModItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,ExistingFileHelper existingFileHelper) {
        super(output, RomaniaCraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItem.scythe);
        simpleItem(ModItem.pork_sausage);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RomaniaCraft.MODID, "item/" + item.getId().getPath()));
    }
}
