package net.moosecraft.FlowerBloom;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class FlowerBloom extends JavaPlugin implements Listener {
    
    public static ArrayList<Material> flowers = new ArrayList<Material>(
    		Arrays.asList(Material.DANDELION,Material.POPPY,Material.BLUE_ORCHID,Material.ALLIUM,Material.AZURE_BLUET,
                          Material.RED_TULIP,Material.ORANGE_TULIP,Material.WHITE_TULIP,Material.PINK_TULIP,
                          Material.OXEYE_DAISY,Material.CORNFLOWER,Material.LILY_OF_THE_VALLEY));
    
    @Override
	public void onEnable(){
		
        getLogger().info("FlowerBloom has been enabled");
        getServer().getPluginManager().registerEvents(this, this);

    }
    
    @Override
    public void onDisable(){
        
    	getLogger().info("FlowerBloom has been disabled");
    	
    }
    
    @EventHandler
    public void onInteract(PlayerInteractEvent event) throws InterruptedException{
        Block flowerblock = event.getClickedBlock();

        if(event.getItem() != null
        && event.getItem().getType() == Material.BONE_MEAL
        && flowerblock != null) {
            Material flowertype = flowerblock.getBlockData().getMaterial();
            if (flowers.contains(flowertype)) {
                ItemStack dropflower = new ItemStack(flowertype);
                flowerblock.getWorld().dropItemNaturally(flowerblock.getLocation(), dropflower);

            }
        }
    }
}
