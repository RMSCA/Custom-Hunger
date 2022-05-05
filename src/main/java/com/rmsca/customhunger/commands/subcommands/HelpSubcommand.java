package com.rmsca.customhunger.commands.subcommands;

import com.rmsca.customhunger.commands.CommandManager;
import com.rmsca.customhunger.commands.Subcommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HelpSubcommand extends Subcommand implements TabCompleter {
    ArrayList<Subcommand> subcommands = CommandManager.subcommands;

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getUsage() {
        return "Usage: /ch help <command>";
    }

    @Override
    public void execute(Player p, String[] args) {
        if (args.length > 1) {
            for (Subcommand subcommand : subcommands) {
                if (args[1].equals(subcommand.getName())) {
                    p.sendMessage(subcommand.getUsage());
                    return;
                }
            }
            p.sendMessage("Command not found!");
            p.sendMessage(getUsage());
        } else {
            p.sendMessage("Available commands:");
            for (Subcommand subcommand : subcommands) {
                p.sendMessage(subcommand.getName());
            }
            p.sendMessage(getUsage());
        }
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            for (Subcommand subcommand : subcommands) {
                if (args[1].equals(subcommand.getName())) {
                    Bukkit.getConsoleSender().sendMessage(subcommand.getUsage());
                    return;
                }
            }
            Bukkit.getConsoleSender().sendMessage("Command not found!");
            Bukkit.getConsoleSender().sendMessage(getUsage());
        } else {
            Bukkit.getConsoleSender().sendMessage("Available commands:");
            for (Subcommand subcommand : subcommands) {
                Bukkit.getConsoleSender().sendMessage(subcommand.getName());
            }
            Bukkit.getConsoleSender().sendMessage(getUsage());
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            List<String> tabCompleteSubcommand = new ArrayList<>();
            for (Subcommand subcommand : subcommands) {
                tabCompleteSubcommand.add(subcommand.getName());
            }
            return tabCompleteSubcommand;
        }
        return null;
    }
}
