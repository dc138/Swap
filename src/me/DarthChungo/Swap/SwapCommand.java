package me.DarthChungo.Swap;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SwapCommand implements TabExecutor {
    private final Swap plugin;

    public SwapCommand(Swap p) {
        this.plugin = p;
        Objects.requireNonNull(this.plugin.getCommand("swap")).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String [] args) {
        if(args.length == 1 && args[0].equals("stop")) {
            this.plugin.sg.StopGame(sender);

        } else if(args.length == 2 && args[0].equals("start") && NumberUtils.isNumber(args[1])) {
            this.plugin.sg.StartGame(new ArrayList<Player>(this.plugin.getServer().getOnlinePlayers()), Math.abs(Integer.parseInt(args[1])), sender);

        } else {
            sender.sendMessage(ChatColor.RED + "Invalid usage: /swap <start|stop> <seconds>");
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> options = new ArrayList<>();

        if(strings.length == 1) {
            options.add("start");
            options.add("stop");
        }

        return options;
    }
}
