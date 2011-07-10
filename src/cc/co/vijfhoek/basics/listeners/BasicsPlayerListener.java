package cc.co.vijfhoek.basics.listeners;

import java.util.HashMap;

import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;

import cc.co.vijfhoek.basics.*;

public class BasicsPlayerListener extends PlayerListener {
	public void onPlayerJoin(PlayerJoinEvent event) {
		Basics basics = new Basics();
		Player player = event.getPlayer();
		if (basics.basicsAccounts.checkExistance(player.getName()) == 0) {
			// Freeze the player
			basics.basicsAccounts.freeze(player.getName());
			
			HashMap<Integer, ItemStack> items = new HashMap<Integer, ItemStack>();
			
			ItemStack item;
			for (int i = 0; i < 36; i++) {
				item = player.getInventory().getItem(i);
				if (item.getAmount() == 0) continue;
				items.put(i, item);
			}
			item = player.getInventory().getBoots();
			if (item.getAmount() != 0)
				items.put(100, item);
			item = player.getInventory().getLeggings();
			if (item.getAmount() != 0)
				items.put(101, item);
			item = player.getInventory().getChestplate();
			if (item.getAmount() != 0)
				items.put(102, item);
			item = player.getInventory().getHelmet();
			if (item.getAmount() != 0)
				items.put(103, item);
			
			player.getInventory().clear();
			player.getInventory().setHelmet(new ItemStack(0));
		}
	}
}
