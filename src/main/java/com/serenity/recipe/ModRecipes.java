package com.serenity.recipe;

import com.serenity.SerenityReforged;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<GrindstoneRecipe> GRINDSTONE_RECIPE_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(SerenityReforged.MOD_ID, "grindstone"
            ), new GrindstoneRecipe.Serializer());

    public static final RecipeType<GrindstoneRecipe> GRINDSTONE_RECIPE_RECIPE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(SerenityReforged.MOD_ID, "grindstone"), new RecipeType<GrindstoneRecipe>() {
                @Override
                public String toString() {
                    return "grindstone";
                }
            });

    public static void registerRecipes() {
        SerenityReforged.LOGGER.info("Registering Custom Recipes for " + SerenityReforged.MOD_ID);
    }
}
