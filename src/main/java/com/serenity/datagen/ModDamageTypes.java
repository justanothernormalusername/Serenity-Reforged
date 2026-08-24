package com.serenity.datagen;

import com.serenity.SerenityReforged;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> SLURRY = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            Identifier.of(SerenityReforged.MOD_ID, "slurry"));

    public static void bootstrap(Registerable<DamageType> context) {
        context.register(SLURRY, new DamageType("slurry", 0.0f, DamageEffects.HURT));
    }

    public static DamageSource create(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().getWrapperOrThrow(RegistryKeys.DAMAGE_TYPE).getOrThrow(key));
    }
}
