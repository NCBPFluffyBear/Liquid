package io.github.seggan.liquid;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import io.github.seggan.liquid.machinery.Melter;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class LiquidMetal extends SlimefunItem {

    private static final HashBiMap<ItemStack, SlimefunItemStack> MELTED_METALS = HashBiMap.create();
    private static final HashBiMap<ItemStack, SlimefunItemStack> MELTED_CRYSTALS = HashBiMap.create();
    private static final HashBiMap<ItemStack, SlimefunItemStack> MELTED_ORES = HashBiMap.create();
    private static final List<ItemStack> metals = Arrays.asList(
        SlimefunItems.ALUMINUM_BRASS_INGOT,
        SlimefunItems.ALUMINUM_BRONZE_INGOT,
        SlimefunItems.ALUMINUM_INGOT,
        SlimefunItems.DURALUMIN_INGOT,
        SlimefunItems.COBALT_INGOT,
        SlimefunItems.NICKEL_INGOT,
        SlimefunItems.GILDED_IRON,
        SlimefunItems.GOLD_4K,
        SlimefunItems.GOLD_6K,
        SlimefunItems.GOLD_8K,
        SlimefunItems.GOLD_10K,
        SlimefunItems.GOLD_12K,
        SlimefunItems.GOLD_14K,
        SlimefunItems.GOLD_16K,
        SlimefunItems.GOLD_18K,
        SlimefunItems.GOLD_20K,
        SlimefunItems.GOLD_22K,
        SlimefunItems.GOLD_24K,
        SlimefunItems.STEEL_INGOT,
        SlimefunItems.DAMASCUS_STEEL_INGOT,
        SlimefunItems.COPPER_INGOT,
        SlimefunItems.BRASS_INGOT,
        SlimefunItems.BRONZE_INGOT,
        SlimefunItems.CORINTHIAN_BRONZE_INGOT,
        SlimefunItems.HARDENED_METAL_INGOT,
        SlimefunItems.REINFORCED_ALLOY_INGOT,
        SlimefunItems.REDSTONE_ALLOY,
        SlimefunItems.TIN_INGOT,
        SlimefunItems.ZINC_INGOT,
        SlimefunItems.LEAD_INGOT,
        SlimefunItems.SILVER_INGOT,
        SlimefunItems.MAGNESIUM_INGOT,
        SlimefunItems.CARBON,
        SlimefunItems.URANIUM,
        SlimefunItems.BOOSTED_URANIUM,
        SlimefunItems.NEPTUNIUM,
        SlimefunItems.PLUTONIUM,
        SlimefunItems.SILICON,
        SlimefunItems.FERROSILICON,
        SlimefunItems.SOLDER_INGOT,
        SlimefunItems.BILLON_INGOT,
        SlimefunItems.SULFATE,
        Items.SLAG,
        VanillaItems.IRON_INGOT,
        VanillaItems.IRON_ORE,
        VanillaItems.GOLD_INGOT,
        VanillaItems.REDSTONE,
        VanillaItems.NETHERITE
    );
    private static final List<ItemStack> crystals = Arrays.asList(
        VanillaItems.LAPIS,
        VanillaItems.DIAMOND,
        VanillaItems.EMERALD,
        SlimefunItems.CARBONADO
    );

    private static final List<ItemStack> ores = Arrays.asList(
        VanillaItems.IRON_ORE,
        VanillaItems.GOLD_ORE,
        VanillaItems.REDSTONE_ORE,
        VanillaItems.LAPIS_ORE,
        VanillaItems.DIAMOND_ORE,
        VanillaItems.EMERALD_ORE,
        VanillaItems.NETHERITE_ORE
    );

    public LiquidMetal(SlimefunItemStack item) {
        super(Items.category, item, Melter.RECIPE_TYPE, new ItemStack[]{
            item, null, null,
            null, null, null,
            null, null, null
        });

        addItemHandler((ItemUseHandler) PlayerRightClickEvent::cancel);
    }

    public static List<ItemStack> getMetals() {
        return metals;
    }

    public static void addLiquid(ItemStack metal, SlimefunItemStack liquid) {
        MELTED_METALS.put(metal, liquid);
    }

    public static void addCrystal(ItemStack crystal, SlimefunItemStack liquid) {
        MELTED_CRYSTALS.put(crystal, liquid);
    }

    public static void addOre(ItemStack ore, SlimefunItemStack liquid) {
        MELTED_ORES.put(ore, liquid);
    }


    public static BiMap<ItemStack, SlimefunItemStack> getLiquids() {
        return MELTED_METALS;
    }

    public static BiMap<ItemStack, SlimefunItemStack> getLiquidCrystals() {
        return MELTED_CRYSTALS;
    }

    public static BiMap<ItemStack, SlimefunItemStack> getLiquidOres() {
        return MELTED_CRYSTALS;
    }

    public static List<ItemStack> getCrystals() {
        return crystals;
    }

    public static List<ItemStack> getOres() {
        return ores;
    }

}
