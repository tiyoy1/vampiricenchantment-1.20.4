package net.se.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageEffects;

public class ArmorPiercingEnchantment extends Enchantment {
    public ArmorPiercingEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public int getMaxLevel() {return 3;}

    @Override
    public boolean isTreasure() {return true;}

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(level > 0){
        }
        super.onTargetDamaged(user, target, level);
    }
}
