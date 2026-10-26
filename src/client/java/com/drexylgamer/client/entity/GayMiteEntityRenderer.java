package com.drexylgamer.client.entity;

import com.drexylgamer.Texmod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class GayMiteEntityRenderer extends MobRenderer {
    private static final Identifier TEXTURE = Texmod.id("textures/entity/gay_mite.png");

    public GayMiteEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new GayMiteEntityModel(context.bakeLayer(ModEntityModelLayers.GAY_MITE)), 0.375F);
    }
    @Override
    public EntityRenderState createRenderState() {
        return new GayMiteEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState state) {
        return TEXTURE;
    }


}
