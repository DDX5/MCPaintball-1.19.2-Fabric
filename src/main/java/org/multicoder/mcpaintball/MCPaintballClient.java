package org.multicoder.mcpaintball;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import org.multicoder.mcpaintball.entity.renderer.*;
import org.multicoder.mcpaintball.init.entityinit;

public class MCPaintballClient implements ClientModInitializer
{

    @Override
    public void onInitializeClient()
    {
        EntityRendererRegistry.register((EntityType<? extends PersistentProjectileEntity>) entityinit.RED_PAINTBALL,RedPaintballArrowEntityRenderer::new);
        EntityRendererRegistry.register((EntityType<? extends PersistentProjectileEntity>) entityinit.GREEN_PAINTBALL,GreenPaintballArrowEntityRenderer::new);
        EntityRendererRegistry.register((EntityType<? extends PersistentProjectileEntity>) entityinit.BLUE_PAINTBALL,BluePaintballArrowEntityRenderer::new);
    }
}
