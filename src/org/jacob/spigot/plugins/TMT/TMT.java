package org.jacob.spigot.plugins.TMT;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jacob.spigot.plugins.TMT.commands.TmtCommand;
import org.jacob.spigot.plugins.TMT.listeners.TreePlaceListener;

public class TMT extends JavaPlugin {

    private static TMT instance;

    public static TMT getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;

        getCommand("tmt").setExecutor(new TmtCommand());
        Bukkit.getPluginManager().registerEvents(new TreePlaceListener(), this);


    }
}
