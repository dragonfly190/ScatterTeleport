package me.Dustin.com;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Scatter extends JavaPlugin implements Listener{

	HashMap<String, Integer> cooldown = new HashMap<String, Integer>();
	String prefix = ChatColor.YELLOW + "[Scatter]";

	public void onEnable() {

	}

	public void onDisable() {

	}


	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("scatter")) {

				Location originalLocation = p.getLocation();

				Random random = new Random();

				Location teleportLocation = null;

				int x = random.nextInt(12000) + 1;
				int y = 150;
				int z = random.nextInt(12000) + 1;

				boolean isOnLand = false;

				while (isOnLand == false) {

					teleportLocation = new Location(p.getWorld(), x, y, z);

					if (teleportLocation.getBlock().getType() != Material.AIR) {
						isOnLand = true;
					} else y--;

				}

				p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));

				p.sendMessage(prefix + ChatColor.GREEN + " You have been scattered " + (int)teleportLocation.distance(originalLocation) + " blocks away!");
		}
		return false;
	}
}
