package org.livermorevalleyacademy.CustomWeapon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.livermorevalleyacademy.CustomWeapon.events.EntityDamage;

import java.util.ArrayList;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        registerRecipes();
        registerEvents();
    }
    public void registerEvents()
    {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new EntityDamage(), this);
    }

    public void registerRecipes()
    {
        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta itemMeta=item.getItemMeta();
        ArrayList<String> my_lore=new ArrayList<String>();
        my_lore.add("The forbidden hoe");
        itemMeta.setLore(my_lore);
        itemMeta.setDisplayName("Earthbreaker");
        item.setItemMeta(itemMeta);;
        item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT,1);
        item.addEnchantment(Enchantment.DURABILITY,3);
        NamespacedKey key = new NamespacedKey(this, this.getDescription().getName());
        ShapelessRecipe recipe = new ShapelessRecipe(key,item);
        recipe.addIngredient(Material.WOODEN_HOE);
        recipe.addIngredient(Material.DIRT);
        Bukkit.addRecipe(recipe);
    }
}
