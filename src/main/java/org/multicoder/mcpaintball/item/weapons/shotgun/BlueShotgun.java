package org.multicoder.mcpaintball.item.weapons.shotgun;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.multicoder.mcpaintball.entity.BluePaintballArrowEntity;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.init.tabinit;

public class BlueShotgun extends Item
{

    public BlueShotgun()
    {
        super(new FabricItemSettings().group(tabinit.paintball));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        user.playSound(soundinit.SINGLE,1.0f,1.0f);
        PersistentProjectileEntity AAE1 = new BluePaintballArrowEntity(world,user);
        PersistentProjectileEntity AAE2 = new BluePaintballArrowEntity(world,user);
        PersistentProjectileEntity AAE3 = new BluePaintballArrowEntity(world,user);
        AAE1.setVelocity(user,user.getPitch(),user.getHeadYaw() - 16f,user.getRoll(),3.0f,0.0f);
        AAE2.setVelocity(user,user.getPitch(),user.getHeadYaw(),user.getRoll(),3.0f,0.0f);
        AAE3.setVelocity(user,user.getPitch(),user.getHeadYaw() + 16f,user.getRoll(),3.0f,0.0f);
        world.spawnEntity(AAE1);
        world.spawnEntity(AAE2);
        world.spawnEntity(AAE3);
        user.getItemCooldownManager().set(this,20);
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
