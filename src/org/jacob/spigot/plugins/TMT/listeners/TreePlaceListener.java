package org.jacob.spigot.plugins.TMT.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.jacob.spigot.plugins.TMT.commands.TmtCommand;

public class TreePlaceListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();

        if(TmtCommand.treedPlayers.contains(p.getUniqueId())) {

            Location loc1 = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY()
                    - 2, p.getLocation().getBlockZ());

            loc1.getBlock().setType(Material.DIRT);

            Location loc2 = new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY()
                    - 1, p.getLocation().getBlockZ());

            loc2.getBlock().setType(Material.JUNGLE_SAPLING);

        }
    }
}
