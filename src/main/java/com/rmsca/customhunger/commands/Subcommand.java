package com.rmsca.customhunger.commands;

import org.bukkit.entity.Player;

public abstract class Subcommand {
    public abstract String getName();

    public abstract String getUsage();

    public abstract void execute(Player p, String[] args);

}
