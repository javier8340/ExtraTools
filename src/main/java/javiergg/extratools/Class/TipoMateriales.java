package javiergg.extratools.Class;

import org.bukkit.Material;

import java.util.ArrayList;

public class TipoMateriales {
    public static ArrayList<Material> getMaterialesPico(){
        ArrayList<Material> materials = new ArrayList<>();
        //stone
        materials.add(Material.STONE);
        materials.add(Material.STONE_BRICKS);
        materials.add(Material.COBBLESTONE);
        //stone especial
        materials.add(Material.ANDESITE);
        materials.add(Material.DIORITE);
        materials.add(Material.GRANITE);
        //ores
        materials.add(Material.IRON_ORE);
        materials.add(Material.DIAMOND_ORE);
        materials.add(Material.GOLD_ORE);
        materials.add(Material.REDSTONE_ORE);
        materials.add(Material.LAPIS_ORE);
        materials.add(Material.COAL_ORE);
        materials.add(Material.EMERALD_ORE);
        //metales bloques
        materials.add(Material.IRON_BLOCK);
        materials.add(Material.DIAMOND_BLOCK);
        materials.add(Material.GOLD_BLOCK);
        materials.add(Material.REDSTONE_BLOCK);
        materials.add(Material.LAPIS_BLOCK);
        materials.add(Material.COAL_BLOCK);
        materials.add(Material.EMERALD_BLOCK);

        //otros
        materials.add(Material.NETHER_BRICK);
        materials.add(Material.MAGMA_BLOCK);

        //todo añadir terracota



        return materials;
    }
    public static ArrayList<Material> getMaterialesPala(){
        ArrayList<Material> materials = new ArrayList<>();
        materials.add(Material.DIRT);
        materials.add(Material.GRASS_BLOCK);
        materials.add(Material.SAND);
        materials.add(Material.SOUL_SAND);
        materials.add(Material.RED_SAND);
        materials.add(Material.GRAVEL);
        materials.add(Material.SNOW);
        materials.add(Material.SNOW_BLOCK);


        return materials;
    }
}
