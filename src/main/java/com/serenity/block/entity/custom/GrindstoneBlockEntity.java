package com.serenity.block.entity.custom;

import com.serenity.block.entity.ImplementedInventory;
import com.serenity.block.entity.ModBlockEntities;
import com.serenity.item.ModItems;
import com.serenity.screen.custom.GrindstoneScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GrindstoneBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(7, ItemStack.EMPTY);

    private static final int GEM_INPUT_SLOT = 0;

    private static final int STICK_INPUT_SLOT = 1;
    private static final int SANDPAPER_INPUT_SLOT = 2;
    private static final int LUBRICANT_INPUT_SLOT = 3;

    private static final int DUST_OUTPUT_SLOT = 4;
    private static final int GEM_OUTPUT_SLOT = 5;
    private static final int BOTTLE_OUTPUT_SLOT = 6;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;


    public GrindstoneBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GRINDSTONE_BE, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> GrindstoneBlockEntity.this.progress;
                    case 1 -> GrindstoneBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: GrindstoneBlockEntity.this.progress = value;
                    case 1: GrindstoneBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }


    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.serenity.grindstone");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GrindstoneScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }


    public void tick(World world, BlockPos pos, BlockState state) {
        if (hasRecipe()) {
            this.progress++;
            markDirty(world, pos, state);

            if(this.progress >= maxProgress) {
                ItemStack output = new ItemStack(ModItems.POLISHED_MOONSTONE, 2);
                this.removeStack(GEM_INPUT_SLOT, 1);
                this.setStack(GEM_OUTPUT_SLOT, new ItemStack(output.getItem(),
                        this.getStack(GEM_OUTPUT_SLOT).getCount() + output.getCount()));

                // Reset progress
                this.progress = 0;
                this.maxProgress = 72;
            }
        } else {
            // Reset progress
            this.progress = 0;
            this.maxProgress = 72;
        }
    }

    private boolean hasRecipe() {
        Item input = ModItems.MOONSTONE;
        ItemStack output = new ItemStack(ModItems.POLISHED_MOONSTONE, 2);

        return this.getStack(GEM_INPUT_SLOT).isOf(input) && canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(GEM_OUTPUT_SLOT).isEmpty() || this.getStack(GEM_OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.getStack(GEM_OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(GEM_OUTPUT_SLOT).getMaxCount();
        int currentCount = this.getStack(GEM_OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }


    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("grindstone.progress", progress);
        nbt.putInt("grindstone.max_progress", maxProgress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("grindstone.progress");
        maxProgress = nbt.getInt("grindstone.max_progress");
        super.readNbt(nbt, registryLookup);
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}
