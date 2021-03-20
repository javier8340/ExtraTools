package javiergg.extratools.Items;

import javiergg.extratools.ExtraTools;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;

public class SpecialItem {

    protected ItemStack item;
    public SpecialItem(Material material, String displayName, String type, int amount){
        item = new ItemStack(material);

        item.setAmount(amount);
        ArrayList<String> lore = new ArrayList<>();
        lore.add("Item especial");


        material = Material.IRON_SHOVEL;
        ItemMeta meta= this.item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(lore);
        NamespacedKey key = SpecialItem.getNamespacedKey();
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, type);
        item.setItemMeta(meta);
    }
    public ItemStack getItem(){
        return this.item;
    }

    public static NamespacedKey getNamespacedKey(){
        return new NamespacedKey(ExtraTools.get(), "tipo");
    }




}
