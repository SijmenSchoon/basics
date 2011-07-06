package cc.co.vijfhoek.basics.commands;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cc.co.vijfhoek.basics.*;
import cc.co.vijfhoek.basics.threads.*;

public class CommandExtinguish {
	public boolean returnValue;
	
	public CommandExtinguish(CommandSender sender) {
		World world = (sender instanceof Player 
				? ((Player)sender).getWorld()
				: BasicsVariables.consoleSelectedWorld);
		if (BasicsVariables.consoleSelectedWorld == null && !(sender instanceof Player)) {
			sender.sendMessage("Please manually select a world:");
			sender.sendMessage("      worldselect <world>");
			sender.sendMessage("-------------------------------");
			sender.sendMessage("   The available worlds are:");
			for (World w : sender.getServer().getWorlds()) {
				sender.sendMessage("- " + w.getName());
			}
		}
		ThreadReplaceBlocks trbFire = new ThreadReplaceBlocks(50, 0, sender, world);
		trbFire.start();
		returnValue = true;
	}
}
