package cc.co.vijfhoek.basics.commands;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cc.co.vijfhoek.basics.BasicsVariables;

public class CommandStopfire {
	public boolean returnValue;
	
	public CommandStopfire(CommandSender sender) {
		String worldName = (sender instanceof Player 
				? ((Player)sender).getWorld().getName()
				: BasicsVariables.consoleSelectedWorld.getName());
		
		if (worldName == null && !(sender instanceof Player)) {
			sender.sendMessage("Please manually select a world:");
			sender.sendMessage("      worldselect <world>");
			sender.sendMessage("-------------------------------");
			sender.sendMessage("   The available worlds are:");
			for (World world : sender.getServer().getWorlds()) {
				sender.sendMessage("- " + world.getName());
			}
			returnValue = true;
		}
		
		BasicsVariables.fireDisabledWorlds.add(worldName);
		returnValue = true;
	}
}
