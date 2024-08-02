package net.se.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class ShellshockEnchantment extends Enchantment {
    public ShellshockEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {return 2;}

    @Override
    public boolean isTreasure() {return true;}

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            ServerWorld world = (ServerWorld)  user.getWorld();
            world.createExplosion(user, target.getX(), target.getY(), target.getZ(), level, World.ExplosionSourceType.NONE);
        }
        super.onTargetDamaged(user, target, level);
    }
}
