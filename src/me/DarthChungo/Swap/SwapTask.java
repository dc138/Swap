/*
   Swap plugin by DarthChungo

   MIT License
   Copyright (c) 2020 Antonio de Haro

*/

package me.DarthChungo.Swap;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class SwapTask extends BukkitRunnable {
    private final Swap plugin;
    private final int interval;
    private int counter;

    public SwapTask(Swap p, int i) {
        this.plugin = p;
        this.interval = i * 20;
        this.counter = i * 20;
    }

    @Override
    public void run() {
        if(counter == 0) {
            this.plugin.sg.SwapPlayers();
            counter = interval;
        } else {
            if(counter % 20 == 0 && counter <= 200) {
                this.plugin.getServer().broadcastMessage(ChatColor.RED + "" + counter/20 + " second" + ((counter == 20) ? "" : "s") + " left!");
            } else if (counter % 1200 == 0) {
                this.plugin.getServer().broadcastMessage(ChatColor.RED + "" + counter/1200 + " minute" + ((counter == 1200) ? "" : "s") + " left!");
            } else if (counter == 900 || counter == 600 || counter == 300) {
                this.plugin.getServer().broadcastMessage(ChatColor.RED + "" + counter/20 + " seconds left!");
            }

            counter--;
        }
    }
}
