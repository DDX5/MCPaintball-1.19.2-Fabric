package org.multicoder.mcpaintball.entity.renderer;

import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.Identifier;
import org.multicoder.mcpaintball.MCPaintball;

public class RedPaintballArrowEntityRenderer extends ProjectileEntityRenderer
{
    public static final Identifier TEXTURE = new Identifier("mcpaintball:textures/entity/projectiles/red_paintball.png");
    public RedPaintballArrowEntityRenderer(EntityRendererFactory.Context context)
    {
        super(context);
    }

    @Override
    public Identifier getTexture(Entity entity) {
        return TEXTURE;
    }

}
