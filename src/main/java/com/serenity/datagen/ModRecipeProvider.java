package com.serenity.datagen;

import com.serenity.block.ModBlocks;
import com.serenity.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MOONSTONE, RecipeCategory.DECORATIONS, ModBlocks.MOONSTONE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_MOONSTONE, RecipeCategory.DECORATIONS, ModBlocks.POLISHED_MOONSTONE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SUNSTONE, RecipeCategory.DECORATIONS, ModBlocks.SUNSTONE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.POLISHED_SUNSTONE, RecipeCategory.DECORATIONS, ModBlocks.POLISHED_SUNSTONE_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SWEDISH_MEATBALLS, RecipeCategory.DECORATIONS, ModBlocks.SWEDISH_MEATBALL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ALTAR_BLOCK)
                .pattern("   ")
                .pattern(" # ")
                .pattern("###")
                .input('#', Items.SMOOTH_STONE)
                .criterion(hasItem(ModItems.MOONSTONE), conditionsFromItem(ModItems.MOONSTONE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SANDPAPER)
                .input(Items.SAND)
                .input(Items.PAPER)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .offerTo(exporter);
    }
}
