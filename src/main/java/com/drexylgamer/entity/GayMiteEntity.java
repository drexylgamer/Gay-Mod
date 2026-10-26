package com.drexylgamer.entity;

import com.drexylgamer.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class GayMiteEntity extends PathfinderMob {
    public GayMiteEntity(Level world) {
        this(ModEntityTypes.GAY_MITE, world);
    }

    public GayMiteEntity(EntityType<? extends GayMiteEntity> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createGayMiteAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.TEMPT_RANGE, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.3);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TemptGoal(this, 1, Ingredient.of(ModItems.PURE_CRYSTALLISED_GAY), false));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 4));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }
}
