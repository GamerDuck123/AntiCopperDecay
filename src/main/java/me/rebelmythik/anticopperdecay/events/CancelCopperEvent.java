package me.rebelmythik.anticopperdecay.events;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

import me.rebelmythik.anticopperdecay.AntiCopperDecay;

public class CancelCopperEvent implements Listener {

    public final AntiCopperDecay plugin;
    public final List<Material> copperMats;

    public CancelCopperEvent(AntiCopperDecay plugin) {
        this.plugin = plugin;
        this.copperMats = Stream.of(Material.values()).filter(m -> m.toString().contains("COPPER")).collect(Collectors.toList());
    }

    @EventHandler
    public void CopperBlock(BlockFormEvent event) {
    	Chunk chunk = event.getBlock().getChunk();
    	ArrayList<Block> copper = new ArrayList<Block>();
        for(int y = -64; y <= 319; y++) {
            for(int x = chunk.getX() * 16; x <= (x + 15); x++) {
                for(int z = chunk.getX() * 16; z <= (x + 15); z++) {
                	Location loc = new Location(chunk.getWorld(), x, y, z);
                	Block currentBlock = chunk.getWorld().getBlockAt(loc);
                    String[] name = currentBlock.getType().toString().split("_");
                    int last = name.length - 1;
                    if (name[last].contentEquals("COPPER")) {
                    	copper.add(currentBlock);
                    }
                }
            }
        }
        copper.stream().forEachOrdered((block) -> {
        	Ageable ageable = (Ageable) block.getBlockData();
        	ageable.setAge(0);
        });
    }
}
