package com.drexylgamer.tag;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.Map;

public interface ModArmorMaterials {
    ArmorMaterial GAY = new ArmorMaterial(42, makeDefense(3, 6, 9, 3, 20), 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 4.0F, 0.2F, ModTags.REPAIRS_GAY_ARMOR, ModEquipmentAssets.GAY);

    static Map<ArmorType, Integer> makeDefense(final int boots, final int legs, final int chest, final int helm, final int body) {
        return Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body);
    }
}
