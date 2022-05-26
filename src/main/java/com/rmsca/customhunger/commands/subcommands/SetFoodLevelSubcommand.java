package com.rmsca.customhunger.commands.subcommands;

import com.rmsca.customhunger.utils.ChHelper;
import com.rmsca.customhunger.commands.Subcommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SetFoodLevelSubcommand extends Subcommand implements TabCompleter {
    @Override
    public String getName() {
        return "setfoodlevel";
    }

    @Override
    public String getUsage() {
        return "Usage: /ch setfoodlevel <player> <food level>";
    }

    @Override
    public void execute(Player p, String[] args) {
        if (args.length > 1) {
            if (ChHelper.isInteger(args[1])) {
                p.setFoodLevel(Integer.parseInt(args[1]));
                ChHelper.sendMessage(p, "Your food level is now set to " + Integer.parseInt(args[1]));
            } else {
                if (args.length > 2) {
                    try {
                        Player targetPlayer = Bukkit.getPlayerExact(args[1]);
                        targetPlayer.setFoodLevel(Integer.parseInt(args[2]));
                        ChHelper.sendMessage(p, targetPlayer.getDisplayName() + "'s food level is now set to " + Integer.parseInt(args[2]))
                    } catch (Exception e) {
                        ChHelper.sendMessage(p, "Target player doesn't exist, please check the username you typed!");
                    }
                } else {
                    ChHelper.sendMessage(p, getUsage());
                }
            }
        } else {
            ChHelper.sendMessage(p, getUsage());
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> tabCompletePlayerName = new ArrayList<>();
        Player[] players = new Player[Bukkit.getOnlinePlayers().size()];
        Bukkit.getOnlinePlayers().toArray(players);
        for (Player player : players) {
            tabCompletePlayerName.add(player.getName());
        }
        return tabCompletePlayerName;
    }
}
