package com.serenity.datagen;

import com.serenity.block.ModBlocks;
import com.serenity.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TimeCheckLootCondition;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MOONSTONE_BLOCK);
        addDrop(ModBlocks.POLISHED_MOONSTONE_BLOCK);
        addDrop(ModBlocks.SUNSTONE_BLOCK);
        addDrop(ModBlocks.POLISHED_SUNSTONE_BLOCK);
        addDrop(ModBlocks.ALTAR_BLOCK);
        addDrop(ModBlocks.SWEDISH_MEATBALL_BLOCK);

        addDrop(ModBlocks.GRANITE_GEM_ORE, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .with(AlternativeEntry.builder(
                                ItemEntry.builder(ModBlocks.GRANITE_GEM_ORE)
                                        .conditionally(createSilkTouchCondition()),
                                ItemEntry.builder(ModItems.SUNSTONE)
                                        .conditionally(TimeCheckLootCondition.create(BoundedIntUnaryOperator.create(0, 12000)).period(24000))
                                        .apply(ApplyBonusLootFunction.oreDrops(
                                                this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)
                                        ))
                                        .apply(ExplosionDecayLootFunction.builder()),
                                ItemEntry.builder(ModItems.MOONSTONE)
                                        .conditionally(TimeCheckLootCondition.create(BoundedIntUnaryOperator.create(12000, 24000)).period(24000))
                                        .apply(ApplyBonusLootFunction.oreDrops(
                                                this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)
                                        ))
                                        .apply(ExplosionDecayLootFunction.builder())
                        ))
        ));

        addDrop(ModBlocks.MOONSTONE_STAIRS);
        addDrop(ModBlocks.MOONSTONE_WALL);
        addDrop(ModBlocks.MOONSTONE_BUTTON);
        addDrop(ModBlocks.MOONSTONE_TRAPDOOR);
        addDrop(ModBlocks.MOONSTONE_FENCE);
        addDrop(ModBlocks.MOONSTONE_FENCE_GATE);
        addDrop(ModBlocks.MOONSTONE_PRESSURE_PLATE);

        addDrop(ModBlocks.MOONSTONE_SLAB, slabDrops(ModBlocks.MOONSTONE_SLAB));
        addDrop(ModBlocks.MOONSTONE_DOOR, doorDrops(ModBlocks.MOONSTONE_DOOR));
    }
}
