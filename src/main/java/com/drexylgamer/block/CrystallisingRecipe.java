package com.drexylgamer.block;

import com.drexylgamer.Texmod;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CrystallisingRecipe implements Recipe<CrystallisingRecipeInput> {
    private final ItemStackTemplate result;
    private final Ingredient baseItem;
    private final Ingredient bottleItem;

    public CrystallisingRecipe(ItemStackTemplate result, Ingredient baseItem, Ingredient bottleItem) {
        this.result = result;
        this.baseItem = baseItem;
        this.bottleItem = bottleItem;
    }

    public ItemStackTemplate getResult() {
        return this.result;
    }

    public Ingredient getBaseItem() {
        return baseItem;
    }

    public Ingredient getBottleItem() {
        return bottleItem;
    }

    @Override
    public boolean matches(CrystallisingRecipeInput input, Level level) {
        return this.baseItem.test(input.baseItem()) && this.bottleItem.test(input.bottleItem());
    }

    @Override
    public ItemStack assemble(CrystallisingRecipeInput input) {
        return this.result.create();
    }

    public static final MapCodec<CrystallisingRecipe> CODEC = RecordCodecBuilder.mapCodec(crystallisingRecipeInstance ->
        crystallisingRecipeInstance.group(
                ItemStackTemplate.CODEC.fieldOf("result").forGetter(CrystallisingRecipe::getResult),
                Ingredient.CODEC.fieldOf("baseItem").forGetter(CrystallisingRecipe::getBaseItem),
                Ingredient.CODEC.fieldOf("bottleItem").forGetter(CrystallisingRecipe::getBottleItem)
        ).apply(crystallisingRecipeInstance, CrystallisingRecipe::new)
    );

    public static StreamCodec<RegistryFriendlyByteBuf, CrystallisingRecipe> STREAM_CODEC = StreamCodec.composite(
            ItemStackTemplate.STREAM_CODEC,
            CrystallisingRecipe::getResult,
            Ingredient.CONTENTS_STREAM_CODEC,
            CrystallisingRecipe::getBaseItem,
            Ingredient.CONTENTS_STREAM_CODEC,
            CrystallisingRecipe::getBottleItem,
            CrystallisingRecipe::new
    );

    @Override
    public RecipeSerializer<? extends Recipe<CrystallisingRecipeInput>> getSerializer() {
        return Texmod.CRYSTALLISING_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<CrystallisingRecipeInput>> getType() {
        return Texmod.CRYSTALLISING_RECIPE_TYPE;
    }

    @Override
    public @Nullable RecipeBookCategory recipeBookCategory() {
        return null;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "crystallising";
    }
}
