package cc.co.vijfhoek.basics.commands;

import java.util.*;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

import cc.co.vijfhoek.basics.*;

public class CommandLogin {
	private Basics basics;
	
	public CommandLogin(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command is for players only");
		}
		int returnValue = basics.basicsAccounts.login(((Player)sender).getName(), args[0]);
		if (basics.basicsAccounts.checkFrozen(((Player)sender).getName()) == 1) {
			sender.sendMessage(ChatColor.GRAY + "You already are logged in.");
			return;
		}
		if (returnValue == 0) {
			sender.sendMessage(ChatColor.GRAY + "You are now logged in.");
			basics.basicsAccounts.unfreeze(((Player)sender).getName());
		} else if (returnValue == 1) {
			sender.sendMessage(ChatColor.GRAY + "Your name isn't registered.");
		} else if (returnValue == 2) {
			sender.sendMessage(ChatColor.GRAY + "Password incorrect.");
			basics.basicsAccounts.freeze(((Player)sender).getName());
		} else {
			sender.sendMessage(ChatColor.GRAY + "Logging in failed - contact a server admin");
		}
		
		// Put back the inventory
		if (basics.basicsAccounts.stolenInventories.containsKey(((Player)sender).getName())) {
			HashMap<Integer, ItemStack> items = basics.basicsAccounts.stolenInventories.get(((Player)sender).getName());
			for (int i = 0; i < 100; i++) {
				if (!items.containsKey(i)) continue;
				ItemStack item = items.get(i);
				Inventory inventory = ((Player)sender).getInventory();
				inventory.setItem(i, item);
			}
		}
	}
}
