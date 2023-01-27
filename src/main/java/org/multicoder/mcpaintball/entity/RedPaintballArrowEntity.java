package org.multicoder.mcpaintball.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.multicoder.mcpaintball.init.entityinit;
import org.multicoder.mcpaintball.init.soundinit;

public class RedPaintballArrowEntity extends PersistentProjectileEntity
{

    public RedPaintballArrowEntity(EntityType<?> entityType, World world) {
        super((EntityType<? extends PersistentProjectileEntity>) entityType, world);
    }

    public RedPaintballArrowEntity(World world, PlayerEntity user)
    {
        super((EntityType<? extends PersistentProjectileEntity>) entityinit.RED_PAINTBALL,user,world);
    }



    @Override
    protected SoundEvent getHitSound() {
        return soundinit.SPLAT;
    }

    @Override
    protected ItemStack asItemStack() {
        return ItemStack.EMPTY;
    }
}
