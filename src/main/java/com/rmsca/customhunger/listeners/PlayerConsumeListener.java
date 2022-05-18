package com.rmsca.customhunger.listeners;

import com.rmsca.customhunger.CustomHunger;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.Plugin;

public class PlayerConsumeListener implements Listener {
    Plugin plugin = CustomHunger.getPlugin(CustomHunger.class);
    
    /**
     * Map giving the food value for each of the food Material
     * configured in the plugin's configuration
     */
    private static Map<Material, Integer> foodValues = null;
    
    /**
     * Returns the configured value for the given material
     * or (null) if no such configured value exists.
     */
    private Integer getConfiguredFoodValue(Material material) {
        Integer foodValue = null;
        
        // If the map of {edible_foods, configured_value} is not setup yet do it now:
        // create the map object and load it with all values from the config file
        if (foodValueMap == null) {
            foodValueMap = new HashMap<Material, Integer>();
            for (Material m : Material.values()) {
                if (m.isEdible()) {
                    Integer configValue = plugin.getConfig().getInt(m.name());
                    // I assume the method above returns (null) if no such configuration
                    // value exists for the given edible material.
                    if (configValue != null) {
                        foodValueMap.put(m, configValue);
                    }
                }
            }
        }
        
        // At this point we should have the foodValueMap already loaded.
        // Just try to get the configured value for the material we're given.
        if (foodValueMap.containsKey(material)) {
            foodValue = foodValueMap.get(material);
        }
        
        return foodValue;
    }

    @EventHandler
    public void onPlayerConsume(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        
        // e.getItem().getType() seems to return a Material
        // (https://github.com/Bukkit/Bukkit/blob/f210234e59275330f83b994e199c76f6abd41ee7/src/main/java/org/bukkit/inventory/ItemStack.java#L143)
        Integer configuredFoodLevel = getConfiguredFoodValue(e.getItem().getType());
        
        // This is replicating the original logic you had for the BREAD case, generalized for
        // any kind of food. You may want to adjust it as needed.
        if (configuredFoodLevel != null) {
            if (p.getFoodLevel() > (20 - configuredFoodLevel)) {
                p.setFoodLevel(20);
            } else {
                p.setFoodLevel(p.getFoodLevel() + configuredFoodLevel - 5);
            }
        }
        
        // if the material consumed is not present in the config file, the food level remains unchanged.
    }
}
