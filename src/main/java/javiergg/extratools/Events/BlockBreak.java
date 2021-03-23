package javiergg.extratools.Events;

import javiergg.extratools.Class.AutoMinado;
import javiergg.extratools.Items.SpecialItem;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;

public class BlockBreak implements Listener {

    private HashMap<Player,BlockFace> blockFaces;

    public BlockBreak(){
        blockFaces = new HashMap<>();
    }

    @EventHandler
    public void playerInteract(PlayerInteractEvent event){
        blockFaces.put(event.getPlayer(), event.getBlockFace());
    }
    @EventHandler
    public void blockBreak(BlockBreakEvent event){
        Player p = event.getPlayer();
        if (this.blockFaces.containsKey(event.getPlayer())){
            ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
            String data = "";
            try{
                data= item.getItemMeta().getPersistentDataContainer().get(SpecialItem.getNamespacedKey(), PersistentDataType.STRING);
                if (data.equals("pico") || data.equals("pala")){
                    AutoMinado autoMinado = new AutoMinado(this.blockFaces.get(p),event.getBlock(), item, data , p);
                    autoMinado.minar();
                }
            }catch (Exception e){
//                e.printStackTrace();
            }




        }

    }
}
