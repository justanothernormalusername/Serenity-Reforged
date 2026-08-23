package com.serenity.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record GrindstoneRecipe(Ingredient inputItem, ItemStack output) implements Recipe<GrindstoneRecipeInput> {

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }



    @Override
    public boolean matches(GrindstoneRecipeInput input, World world) {
        if (world.isClient) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(GrindstoneRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.GRINDSTONE_RECIPE_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.GRINDSTONE_RECIPE_RECIPE_TYPE;
    }

    public static class Serializer implements RecipeSerializer<GrindstoneRecipe> {
        public static final MapCodec<GrindstoneRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(GrindstoneRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(GrindstoneRecipe::output)
        ).apply(inst, GrindstoneRecipe::new));

        public static final PacketCodec<RegistryByteBuf, GrindstoneRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, GrindstoneRecipe::inputItem,
                        ItemStack.PACKET_CODEC, GrindstoneRecipe::output,
                        GrindstoneRecipe::new
                );

        @Override
        public MapCodec<GrindstoneRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, GrindstoneRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
