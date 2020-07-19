/*
   Swap plugin by DarthChungo

   MIT License
   Copyright (c) 2020 Antonio de Haro

*/

package me.DarthChungo.Swap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SwapGame {
    private final Swap plugin;

    public boolean running = false;
    public ArrayList<Player> players = new ArrayList<>();

    public SwapGame(Swap p) {
        this.plugin = p;
    }

    public void StartGame(ArrayList<Player> p, int i, CommandSender who) {
        if(this.running){
            who.sendMessage(ChatColor.RED + "There is already a game in progress.");
        } else if(p.size() == 1  || p.size() == 0) {
            who.sendMessage(ChatColor.RED + "Not enough players to start.");
        } else {
            this.plugin.st = new SwapTask(this.plugin, i);
            this.plugin.st.runTaskTimer(this.plugin, 0 , 0);

            this.running = true;
            this.players = p;

            this.plugin.getServer().broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Death swap started with " + i + " seconds intervals!");
        }
    }

    public void KickPlayer(Player p) {
        this.players.remove(p);

        if(this.players.size() == 1) {
            this.plugin.getServer().broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Player " + players.get(0).getDisplayName() + " wins the game!");
            ResetGame();
        }
    }

    public void SwapPlayers() {
        Location first = players.get(0).getLocation();

        for(int i = 0; i < players.size() - 1; i++) {
            players.get(i).teleport(players.get(i + 1));
        }

        players.get(players.size() - 1).teleport(first);
        plugin.getServer().broadcastMessage(ChatColor.GREEN + "Swap!");
    }

    public void StopGame(CommandSender who) {
        if(this.running){
            this.plugin.getServer().broadcastMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Game manually ended.");
            ResetGame();
        } else {
            who.sendMessage(ChatColor.RED + "No game running.");
        }
    }

    public void ResetGame() {
        this.plugin.st.cancel();
        this.players.clear();
        this.running = false;
    }
}
