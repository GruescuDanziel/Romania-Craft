package com.danzielcode.romania_craft.datagen;

import com.danzielcode.romania_craft.RomaniaCraft;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output,  ExistingFileHelper exFileHelper) {
        super(output, RomaniaCraft.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }

    private void blockWithItem(RegistryObject<Block> block){
       simpleBlockWithItem(block.get(),cubeAll(block.get()));
    }

}
