package com.serenity.item.custom;

import com.serenity.datagen.ModDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ClaySlurryBottleItem extends Item {

    public ClaySlurryBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {

        if (!world.isClient() && user instanceof PlayerEntity player) {
            player.damage(ModDamageTypes.create(world, ModDamageTypes.SLURRY), 4f);
        }

        return super.finishUsing(stack, world, user);
    }
}
