package io.github.seggan.liquid.machinery;

import com.google.common.collect.BiMap;
import io.github.seggan.liquid.LiquidMetal;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.HeatedPressureChamber;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Crystallizer extends AContainer implements RecipeDisplayItem {

    public Crystallizer(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    protected void registerDefaultRecipes() {
        BiMap<SlimefunItemStack, ItemStack> liquids = LiquidMetal.getLiquidCrystals().inverse();
        for (SlimefunItemStack liquid : liquids.keySet()) {
            registerRecipe(
                60,
                new ItemStack[]{liquid},
                new ItemStack[]{liquids.get(liquid), new ItemStack(Material.BUCKET)}
            );
        }
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.DIAMOND);
    }

    @Override
    public int getEnergyConsumption() {
        return 8;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public String getMachineIdentifier() {
        return "CRYSTALLIZER";
    }

    @Override
    public int getCapacity() {
        return 16;
    }
}
