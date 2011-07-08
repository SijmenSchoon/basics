package cc.co.vijfhoek.basics.listeners;

import org.bukkit.entity.*;
import org.bukkit.event.entity.*;

import cc.co.vijfhoek.basics.*;

public class BasicsEntityListener extends EntityListener {
	public void onEntityExplode(EntityExplodeEvent event) {
		Basics basics = new Basics();
		Entity entity = event.getEntity();
		if(entity instanceof TNTPrimed) {
			if (basics.bcfConfig.getConfiguration().getBoolean("prevent.block-damage.tnt", false)) {
				event.setCancelled(true);
			}
		} else if(entity instanceof Creeper) {
			if (basics.bcfConfig.getConfiguration().getBoolean("prevent.block-damage.creeper", false)) {
				event.setCancelled(true);
			}
		}
	}
	
	public void onEntityTarget(EntityTargetEvent event) {
		Entity entTarget = event.getTarget();
		if (!(entTarget instanceof Player)) return;
		
		Player plyTarget = (Player)entTarget;
		Basics basics = new Basics();
		
		if (basics.basicsAccounts.frozenPlayers.contains(plyTarget.getName())) {
			event.setCancelled(true);
		}
	}
}