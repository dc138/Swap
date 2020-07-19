/*
   Swap plugin by DarthChungo

   MIT License
   Copyright (c) 2020 Antonio de Haro

*/

package me.DarthChungo.Swap;

import org.bukkit.plugin.java.JavaPlugin;

public class Swap extends JavaPlugin {
    public SwapGame sg;
    public SwapCommand sc;
    public SwapEvent se;
    public SwapTask st;

    @Override
    public void onEnable() {
        this.sg = new SwapGame(this);
        this.sc = new SwapCommand(this);
        this.se = new SwapEvent(this);

        getLogger().info("Swap plugin by DarthChungo enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Swap plugin by DarthChungo disabled.");
    }
}
