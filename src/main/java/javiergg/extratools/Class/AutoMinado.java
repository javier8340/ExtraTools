package javiergg.extratools.Class;

import com.sun.tools.sjavac.Log;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.logging.Level;

public class AutoMinado {

    private final BlockFace blockFace;
    private final Block block;
    private final ItemStack herramienta;
    private final String type ;
    private final World mundo ;
    private final Player player ;

    private int maximoBloquesRomper;
    private int bloquesMinados;

    public AutoMinado(BlockFace face, Block block, ItemStack herramienta, String type, Player player){
        this.block = block;
        this.blockFace = face;
        this.herramienta = herramienta;
        this.type = type;
        mundo = block.getWorld();
        this.player = player;
        this.bloquesMinados = 0;
        this.maximoBloquesRomper = 9;
    }


    public void minar(){

        Damageable meta = (Damageable) this.herramienta.getItemMeta();
        int level = 0;
        try{
            level = ((ItemMeta) meta).getEnchants().get(Enchantment.DURABILITY);
        }catch (Exception e){}



        int durabilidad =   herramienta.getType().getMaxDurability()-meta.getDamage();
        int bloques = durabilidad*2;
        int randBloques = (int) ((Math.random() *bloques)+bloques+2);

        if (randBloques<9){

            this.maximoBloquesRomper = randBloques;
        }



        Location l = block.getLocation();

        for (Block b: getblockRadious(block)
             ) {
            breakBlock(b.getLocation());
        }

        if (this.maximoBloquesRomper == 9){
            int damage = (9/2)-level;
            int rand = (int) (Math.random() * damage) + damage+2;

            meta.setDamage(meta.getDamage() + rand);
            herramienta.setItemMeta((ItemMeta) meta);
        }else{
            herramienta.setAmount(0);
        }


    }
    public ArrayList<Block> getblockRadious(Block start){
        int radius = 1;
        ArrayList<Block> blocks = new ArrayList<Block>();
        if (this.blockFace == BlockFace.UP || this.blockFace == BlockFace.DOWN){
            for(double x = start.getLocation().getX() - radius; x <= start.getLocation().getX() + radius; x++){
                    for(double z = start.getLocation().getZ() - radius; z <= start.getLocation().getZ() + radius; z++){
                        Location loc = new Location(start.getWorld(), x, start.getY(), z);
                        blocks.add(loc.getBlock());
                    }

            }
        } else if (this.blockFace == BlockFace.NORTH || this.blockFace == BlockFace.SOUTH){
            for(double x = start.getLocation().getX() - radius; x <= start.getLocation().getX() + radius; x++){
                for(double y = start.getLocation().getY() - radius; y <= start.getLocation().getY() + radius; y++){

                        Location loc = new Location(start.getWorld(), x, y, start.getZ());
                        blocks.add(loc.getBlock());

                }

            }
        }else {

            for (double y = start.getLocation().getY() - radius; y <= start.getLocation().getY() + radius; y++) {
                for (double z = start.getLocation().getZ() - radius; z <= start.getLocation().getZ() + radius; z++) {
                    Location loc = new Location(start.getWorld(), start.getX(), y, z);
                    blocks.add(loc.getBlock());
                }
            }

        }
        return blocks;
    }
    private boolean checkValid(Block block) {
        boolean salida = false;

        switch (type){
            case "pico":
                if (TipoMateriales.getMaterialesPico().contains(block.getType())){
                    salida = true;
                }
                break;
            case "pala":
                if (TipoMateriales.getMaterialesPala().contains(block.getType())){
                    salida = true;
                }
                break;


        }
        return salida;
    }
    private void breakBlock(Location l){
        if (bloquesMinados<maximoBloquesRomper){
            Block bloqueRomper = mundo.getBlockAt(l);
            if (checkValid(bloqueRomper)){
                bloquesMinados++;
                bloqueRomper.breakNaturally(this.herramienta);


            }
        }


    }
}
