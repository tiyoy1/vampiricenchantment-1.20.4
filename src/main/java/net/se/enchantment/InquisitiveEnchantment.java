package net.se.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import java.util.Random;

public class InquisitiveEnchantment extends Enchantment {
    public InquisitiveEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }

    @Override
    public int getMaxPower(int level) {
        return 25;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        World world = user.getWorld();
        if(!user.getWorld().isClient) {
            if(!target.isAlive()){
                Random random = new Random();
                world.spawnEntity(new ExperienceOrbEntity(world, target.getX(), target.getY(), target.getZ(),
                        (int)Math.ceil((double)(random.nextFloat(0.5F, 1.0F) *
                                (float)world.random.nextBetween(4, (5 + level) * 2)))));
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}
