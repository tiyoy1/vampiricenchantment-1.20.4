package net.se;

import net.fabricmc.api.ModInitializer;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.se.enchantment.ShellshockEnchantment;
import net.se.enchantment.ThunderingEnchantment;
import net.se.enchantment.VampiricEnchantment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.PublicKey;

public class SuperEnchantment implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("super-enchantment");
	public static Enchantment VAMPIRIC = new VampiricEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static Enchantment THUNDERING = new ThunderingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static Enchantment SHELLSHOCK = new ShellshockEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});


	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		Registry.register(Registries.ENCHANTMENT, new Identifier("se", "vampiric"),VAMPIRIC);
		Registry.register(Registries.ENCHANTMENT, new Identifier("se", "thundering"), THUNDERING);
		Registry.register(Registries.ENCHANTMENT, new Identifier("se", "shellshock"), SHELLSHOCK);
	}
}