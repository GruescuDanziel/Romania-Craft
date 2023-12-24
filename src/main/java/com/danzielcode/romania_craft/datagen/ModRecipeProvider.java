package com.danzielcode.romania_craft.datagen;

import com.danzielcode.romania_craft.RomaniaCraft;
import com.danzielcode.romania_craft.items.ModItem;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        //Scythe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.scythe.get())
                .pattern("III")
                .pattern("IS ")
                .pattern(" S ")
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pRecipeOutput);

        //Pork Sausage
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItem.pork_sausage.get())
                .requires(Items.COOKED_PORKCHOP, 5)
                .unlockedBy(getHasName(Items.COOKED_PORKCHOP), has(Items.COOKED_PORKCHOP))
                .save(pRecipeOutput);//TODO: Change crafting recepie to have intestines

    }
    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        multipleOreSmelting(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        singularOreSmelting(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        multipleOreSmelting(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
    protected static void oreBlasting(RecipeOutput pRecipeOutput,ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        singularOreSmelting(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void multipleOreSmelting(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            singularOreSmelting(pRecipeOutput, pSerializer, itemlike, pCategory, pResult, pExperience, pCookingTime, pGroup, pSuffix);
        }
    }

    private static void singularOreSmelting(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer,ItemLike pIngredient, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix){
        SimpleCookingRecipeBuilder.generic(
                        Ingredient.of(pIngredient), pCategory, pResult, pExperience, pCookingTime, pSerializer)
                .group(pGroup)
                .unlockedBy(getHasName(pIngredient), has(pIngredient)).save(pRecipeOutput, RomaniaCraft.MODID +":" +  getItemName(pResult) + pSuffix + "_" + getItemName(pIngredient));
    }
}
