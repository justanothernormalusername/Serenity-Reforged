package com.serenity.datagen;

import com.serenity.SerenityReforged;
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
import net.minecraft.util.Identifier;

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HONEY_DOP_STICK)
                .pattern(" X")
                .pattern("# ")
                .input('X', Items.HONEYCOMB)
                .input('#', Items.STICK)
                .group("honey_dop_stick")
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(exporter, Identifier.of(SerenityReforged.MOD_ID, "honey_dop_stick_from_comb"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HONEY_DOP_STICK)
                .pattern(" X")
                .pattern("# ")
                .input('X', Items.HONEY_BOTTLE)
                .input('#', Items.STICK)
                .group("honey_dop_stick")
                .criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
                .offerTo(exporter, Identifier.of(SerenityReforged.MOD_ID, "honey_dop_stick_from_bottle"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLIME_DOP_STICK)
                .pattern(" X")
                .pattern("# ")
                .input('X', Items.SLIME_BALL)
                .input('#', Items.STICK)
                .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INFERNAL_DOP_STICK)
                .pattern(" X")
                .pattern("# ")
                .input('X', Items.MAGMA_CREAM)
                .input('#', Items.BLAZE_ROD)
                .criterion(hasItem(Items.MAGMA_CREAM), conditionsFromItem(Items.MAGMA_CREAM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LOUPE)
                .pattern("cxc")
                .pattern("c#c")
                .pattern("crc")
                .input('x', Items.GLASS_PANE)
                .input('#', Items.AMETHYST_SHARD)
                .input('r', Items.RABBIT_HIDE)
                .input('c', Items.COPPER_INGOT)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);
    }
}
