package org.multicoder.mcpaintball.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class BluePaintballArrowEntityRenderer extends ProjectileEntityRenderer
{
    public static final Identifier TEXTURE = new Identifier("mcpaintball:textures/entity/projectiles/blue_paintball.png");
    public BluePaintballArrowEntityRenderer(EntityRendererFactory.Context context)
    {
        super(context);
    }

    @Override
    public Identifier getTexture(Entity entity) {
        return TEXTURE;
    }

}
