package cc.co.vijfhoek.basics.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn {
	public boolean returnValue;
	
	public CommandSpawn(CommandSender sender) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command is for players only");
			returnValue = true;
		}
		sender.sendMessage(ChatColor.GRAY + "Teleporting to spawn...");
		((Player)sender).teleport(((Player)sender).getWorld().getSpawnLocation());
		returnValue = true;
	}
}
