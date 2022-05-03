package com.rmsca.customhunger.commands;

import org.bukkit.entity.Player;

public abstract class Subcommand {
    protected abstract String getName();

    protected abstract void execute(Player p, String[] args);

    protected abstract void execute(String[] args);

}
