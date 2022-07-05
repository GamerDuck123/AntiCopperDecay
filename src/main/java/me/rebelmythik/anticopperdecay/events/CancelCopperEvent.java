package me.rebelmythik.anticopperdecay.events;

import me.rebelmythik.anticopperdecay.AntiCopperDecay;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class CancelCopperEvent implements Listener {

    public AntiCopperDecay plugin;

    public CancelCopperEvent(AntiCopperDecay plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void CopperBlock(BlockFormEvent event) {
        if (event.getBlock().getType() == Material.COPPER_BLOCK) {
            event.setCancelled(true);
        }
    }
}
