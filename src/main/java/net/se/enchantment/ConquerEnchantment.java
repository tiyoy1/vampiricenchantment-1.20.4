package net.se.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ConquerEnchantment extends Enchantment {
    public ConquerEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        World world = user.getWorld();
        if(user.isAlive()) {
            ((LivingEntity)user).addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200*level, (1*level)));
        }
        super.onUserDamaged(user, attacker, level);
    }
}
