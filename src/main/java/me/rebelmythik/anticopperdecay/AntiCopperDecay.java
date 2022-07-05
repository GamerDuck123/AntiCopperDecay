package me.rebelmythik.anticopperdecay;

import me.rebelmythik.anticopperdecay.events.CancelCopperEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiCopperDecay extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new CancelCopperEvent(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
