package com.serenity.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent SWEDISH_MEATBALLS = new FoodComponent.Builder().nutrition(4).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 400), 0.5f).build();

    public static final FoodComponent ICED_TEA = new FoodComponent.Builder().nutrition(1).saturationModifier(4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), 0.5f).build();
}
