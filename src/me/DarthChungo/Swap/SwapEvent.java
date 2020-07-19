/*
   Swap plugin by DarthChungo

   MIT License
   Copyright (c) 2020 Antonio de Haro

*/

package me.DarthChungo.Swap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class SwapEvent implements Listener {
    private final Swap plugin;

    public SwapEvent(Swap p) {
        this.plugin = p;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDeath(PlayerDeathEvent event) {
        this.plugin.sg.KickPlayer(event.getEntity());
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerQuit(PlayerQuitEvent event) {
        this.plugin.sg.KickPlayer(event.getPlayer());
    }
}
