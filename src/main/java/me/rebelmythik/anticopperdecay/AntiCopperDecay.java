package me.rebelmythik.anticopperdecay;

import me.rebelmythik.anticopperdecay.events.cancelcopperevent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiCopperDecay extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new cancelcopperevent(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
