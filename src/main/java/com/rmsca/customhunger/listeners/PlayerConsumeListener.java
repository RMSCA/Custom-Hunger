package com.rmsca.customhunger.listeners;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
public class PlayerConsumeListener implements Listener {
    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        if(e.getItem().getType() == Material.BREAD) {
            System.out.println("Event Triggered!");
            if(p.getFoodLevel() > 16) {
                p.setFoodLevel(20);
            } else {
                p.setFoodLevel(p.getFoodLevel() + 4);
            }
            System.out.println("Process complete!");
        }
    }
}
