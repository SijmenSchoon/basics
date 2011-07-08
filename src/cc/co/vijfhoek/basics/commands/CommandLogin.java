package cc.co.vijfhoek.basics.commands;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import cc.co.vijfhoek.basics.*;

public class CommandLogin {
	private Basics basics;
	
	public CommandLogin(CommandSender sender, String[] args) {
		int returnValue = basics.basicsAccounts.login(((Player)sender).getName(), args[0]);
		if (returnValue == 0) {
			sender.sendMessage(ChatColor.GRAY + "You are now logged in.");
		} else if (returnValue == 1) {
			sender.sendMessage(ChatColor.GRAY + "Your name isn't registered.");
		} else if (returnValue == 2) {
			sender.sendMessage(ChatColor.GRAY + "Password incorrect.");
		} else {
			sender.sendMessage(ChatColor.GRAY + "Logging in failed - contact a server admin");
		}
	}
}
