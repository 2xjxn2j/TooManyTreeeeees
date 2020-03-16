package org.jacob.spigot.plugins.TMT.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TmtCommand implements CommandExecutor {

    public static List<UUID> treedPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equalsIgnoreCase("tmt")) {
            if(!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "You must be a player!");
                return true;

            }
            Player p = (Player) commandSender;

            if(strings.length == 0) {
                p.sendMessage(ChatColor.YELLOW + "TooManyTrees " + ChatColor.GREEN + "v1.0. Created by " + ChatColor.YELLOW + "2xjtn");
                p.sendMessage(ChatColor.GOLD + "/tmt - "+ChatColor.YELLOW + "Brings up this list.");
                p.sendMessage(ChatColor.GOLD + "/tmt toggle - " + ChatColor.YELLOW + "Toggles the tree creation tool.");

                return true;

            }

            if(strings.length == 1) {
                if(strings[0].equalsIgnoreCase("toggle")) {
                    if(treedPlayers.contains(p.getUniqueId())) {
                        treedPlayers.remove(p.getUniqueId());
                        p.sendMessage(ChatColor.YELLOW + "Tree creation " + ChatColor.RED + "disabled " + ChatColor.YELLOW + "for "
                                + ChatColor.GOLD + p.getName());
                    } else {
                        treedPlayers.add(p.getUniqueId());
                        p.sendMessage(ChatColor.YELLOW + "Tree creation " + ChatColor.GREEN + "enabled " + ChatColor.YELLOW + "for "
                                + ChatColor.GOLD + p.getName());
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Invalid argument.");
                }
            }

        }
        return true;
    }
}
