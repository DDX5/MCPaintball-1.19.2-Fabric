package org.multicoder.mcpaintball.item.weapons.rifle;

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

public class BlueRifle extends Item
{

    public BlueRifle()
    {
        super(new FabricItemSettings().group(tabinit.paintball));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        user.playSound(soundinit.SINGLE,1.0f,1.0f);
        PersistentProjectileEntity AAE = new BluePaintballArrowEntity(world,user);
        AAE.setVelocity(user,user.getPitch(),user.getHeadYaw(),user.getRoll(),3.0f,0.0f);
        world.spawnEntity(AAE);
        user.getItemCooldownManager().set(this,5);
        return TypedActionResult.pass(user.getStackInHand(hand));
    }
}
