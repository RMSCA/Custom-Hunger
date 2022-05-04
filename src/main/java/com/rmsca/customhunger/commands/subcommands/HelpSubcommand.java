package com.rmsca.customhunger.commands.subcommands;

import com.rmsca.customhunger.commands.CommandManager;
import com.rmsca.customhunger.commands.Subcommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HelpSubcommand extends Subcommand {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    protected void execute(Player p, String[] args) {
        CommandManager subCommandList = new CommandManager();
        p.sendMessage("Available commands:");
        for (int i = 0; i < subCommandList.subcommands.size(); i++) {
            p.sendMessage(subCommandList.subcommands.get(i).getName());
        }
        p.sendMessage("Type \"/ch help <subcommand>\" for usage of commands");
    }

    @Override
    protected void execute(String[] args) {
        CommandManager subCommandList = new CommandManager();
        Bukkit.getConsoleSender().sendMessage("Available commands:");
        for (int i = 0; i < subCommandList.subcommands.size(); i++) {
            Bukkit.getConsoleSender().sendMessage(subCommandList.subcommands.get(i).getName());
        }
        Bukkit.getConsoleSender().sendMessage("Type \"/ch help <subcommand>\" for usage of commands");
    }
}
