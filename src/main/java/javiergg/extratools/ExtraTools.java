package javiergg.extratools;

import javiergg.extratools.Events.BlockBreak;
import javiergg.extratools.Items.SpecialItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExtraTools extends JavaPlugin {
    private static ExtraTools plugin;
    public static ExtraTools get(){
        return plugin;
    }
    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        registerEvents();
        registerRecipes();

    }

    public void registerRecipes(){
       registerPickaxeRecipe(Material.STONE_PICKAXE, Material.COBBLESTONE );
       registerPickaxeRecipe(Material.IRON_PICKAXE, Material.IRON_INGOT );
       registerPickaxeRecipe(Material.GOLDEN_PICKAXE, Material.GOLD_INGOT );
       registerPickaxeRecipe(Material.DIAMOND_PICKAXE, Material.DIAMOND );

       registerShovelRecipe(Material.STONE_SHOVEL, Material.COBBLESTONE );
       registerShovelRecipe(Material.IRON_SHOVEL, Material.IRON_INGOT );
       registerShovelRecipe(Material.GOLDEN_SHOVEL, Material.GOLD_INGOT );
       registerShovelRecipe(Material.DIAMOND_SHOVEL, Material.DIAMOND );

    }

    private void registerPickaxeRecipe(Material material, Material ingot){
        SpecialItem itemStack= new SpecialItem(material, "Extra pico", "pico",1);
        ItemStack item = itemStack.getItem();
        NamespacedKey namespacedKey = new NamespacedKey(this, "ExtraPico-"+material.getKey().getKey());
        ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, item);
        shapedRecipe.shape("III","ISI", " S ");
        shapedRecipe.setIngredient('I', ingot);
        shapedRecipe.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(shapedRecipe);
    }
    private void registerShovelRecipe(Material material, Material ingot){
        SpecialItem itemStack= new SpecialItem(material, "Extra pala", "pala",1);
        ItemStack item = itemStack.getItem();
        NamespacedKey namespacedKey = new NamespacedKey(this, "ExtraPala-"+material.getKey().getKey());
        ShapedRecipe shapedRecipe = new ShapedRecipe(namespacedKey, item);
        shapedRecipe.shape(" II"," SI", "S  ");
        shapedRecipe.setIngredient('I', ingot);
        shapedRecipe.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(shapedRecipe);
    }
    public void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new BlockBreak(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
