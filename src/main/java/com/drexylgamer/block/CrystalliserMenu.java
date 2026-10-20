package com.drexylgamer.block;

import com.drexylgamer.Texmod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;
import java.util.Optional;

public class CrystalliserMenu extends AbstractContainerMenu {
    public Container input = new SimpleContainer(2) {
        @Override
        public void setChanged() {
            super.setChanged();
            CrystalliserMenu.this.slotsChanged(this);
        }
    };

    private final ResultContainer output = new ResultContainer();

    private final ContainerLevelAccess access;

    public CrystalliserMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public CrystalliserMenu(int containerId, Inventory inventory, ContainerLevelAccess access) {
        super(ModMenuTypes.CRYSTALLISER, containerId);

        this.access = access;

        addSlot(new Slot(this.input, 0, 49, 19));
        addSlot(new Slot(this.input, 1, 49, 40));

        addSlot(new CrystallisingResultSlot(this, this.output, 0, 129, 34));

        addStandardInventorySlots(inventory, 8, 84);
    }

    protected void onTake(final Player player, final ItemStack stack) {
        stack.onCraftedBy(player, stack.getCount());
        this.output.awardUsedRecipes(player, List.of(this.input.getItem(0), this.input.getItem(1)));
        this.input.removeItem(0, 1);
        this.input.removeItem(1, 1);
    }

    @Override
    public void slotsChanged(Container container) {
        super.slotsChanged(container);
        if (container != this.input) {
            return;
        }

        this.access.execute(((level, blockPos) -> {
            if(level instanceof ServerLevel serverLevel) {
                this.inputsChanged(serverLevel);
            }
        }));
    }

    private void inputsChanged(ServerLevel level) {
        CrystallisingRecipeInput recipeInput = new CrystallisingRecipeInput(this.input.getItem(0), this.input.getItem(1));
        Optional<RecipeHolder<CrystallisingRecipe>> maybeRecipe = level.recipeAccess().getRecipeFor(Texmod.CRYSTALLISING_RECIPE_TYPE, recipeInput, level);

        if (maybeRecipe.isPresent()) {
            RecipeHolder<CrystallisingRecipe> recipeHolder = maybeRecipe.get();
            CrystallisingRecipe recipe = recipeHolder.value();

            this.output.setRecipeUsed(recipeHolder);
            this.output.setItem(0, recipe.assemble(recipeInput));
        } else {
            this.output.setRecipeUsed(null);
            this.output.setItem(0, ItemStack.EMPTY);
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, ModBlocks.CRYSTALLISER);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.access.execute(((level, blockPos) -> this.clearContainer(player, this.input)));
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack carried, Slot target) {
        return target.container != this.output && super.canTakeItemForPickAll(carried, target);
    }
}
