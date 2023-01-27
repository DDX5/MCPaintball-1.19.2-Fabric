package org.multicoder.mcpaintball.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.entity.BluePaintballArrowEntity;
import org.multicoder.mcpaintball.entity.GreenPaintballArrowEntity;
import org.multicoder.mcpaintball.entity.RedPaintballArrowEntity;

public class entityinit
{
    public static final EntityType<?> RED_PAINTBALL = Registry.register(Registry.ENTITY_TYPE,new Identifier(MCPaintball.ModID,"red_paintball"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC,
                    RedPaintballArrowEntity::new).dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static final EntityType<?> BLUE_PAINTBALL = Registry.register(Registry.ENTITY_TYPE,new Identifier(MCPaintball.ModID,"blue_paintball"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC,
                    BluePaintballArrowEntity::new).dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static final EntityType<?> GREEN_PAINTBALL = Registry.register(Registry.ENTITY_TYPE,new Identifier(MCPaintball.ModID,"green_paintball"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC,
                    GreenPaintballArrowEntity::new).dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());


    public static void RegsiterEnity()
    {

    }
}
