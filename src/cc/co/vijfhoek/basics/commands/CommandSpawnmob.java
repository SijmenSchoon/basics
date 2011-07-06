package cc.co.vijfhoek.basics.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;

public class CommandSpawnmob {
	public boolean returnValue;
	
	public CommandSpawnmob(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command is for players only");
			returnValue = true;
		}
		if (args.length == 0) {
			returnValue = false;
		}
		
		int intAmount = 1;
		String strAmount = "a";
		if (args.length == 2) {
			try {
				intAmount = Integer.parseInt(args[1]);
			} catch (Exception e) {
				sender.sendMessage("<amount> must be a number");
				returnValue = false;
			}
			if (intAmount < 0) {
				sender.sendMessage("Can't spawn a negative amount of mobs");
				returnValue = true;
			}
		}
		
		String strMobType = args[0] + "s";
		
		switch (intAmount) {
		case 0:
			returnValue = true;
		case 1:
			strAmount = "a";
			strMobType = args[0];
			break;
		case 2:
			strAmount = "two";
			break;
		case 3:
			strAmount = "three";
			break;
		case 4:
			strAmount = "four";
			break;
		case 5:
			strAmount = "five";
			break;
		case 6:
			strAmount = "six";
			break;
		case 7:
			strAmount = "seven";
			break;
		case 8:
			strAmount = "eight";
			break;
		case 9:
			strAmount = "nine";
			break;
		case 10:
			strAmount = "ten";
			break;
		default:
			strAmount = String.valueOf(intAmount);
			break;
		}
		
		Location spawnLocation = ((Player)sender).getTargetBlock(null, 1000).getLocation();
		spawnLocation.setY(spawnLocation.getY() + 1);
		
		CreatureType mobType = null;
		if      (args[0].equalsIgnoreCase("chicken"))      { mobType = CreatureType.CHICKEN;                            }
		else if (args[0].equalsIgnoreCase("cow"))          { mobType = CreatureType.COW;                                }
		else if (args[0].equalsIgnoreCase("creeper"))      { mobType = CreatureType.CREEPER;                            }
		else if (args[0].equalsIgnoreCase("ghast"))        { mobType = CreatureType.GHAST;                              }
		else if (args[0].equalsIgnoreCase("giant"))        { mobType = CreatureType.GIANT;                              }
		else if (args[0].equalsIgnoreCase("monster"))      { mobType = CreatureType.MONSTER;                            }
		else if (args[0].equalsIgnoreCase("pig"))          { mobType = CreatureType.PIG;                                }
		else if (args[0].equalsIgnoreCase("zombiepigman")) { mobType = CreatureType.PIG_ZOMBIE;                         }
		else if (args[0].equalsIgnoreCase("sheep"))        { mobType = CreatureType.SHEEP;                              }
		else if (args[0].equalsIgnoreCase("skeleton"))     { mobType = CreatureType.SKELETON;                           }
		else if (args[0].equalsIgnoreCase("slime"))        { mobType = CreatureType.SLIME;                              }
		else if (args[0].equalsIgnoreCase("spider"))       { mobType = CreatureType.SPIDER;                             }
		else if (args[0].equalsIgnoreCase("squid"))        { mobType = CreatureType.SQUID;                              }
		else if (args[0].equalsIgnoreCase("wolf"))         { mobType = CreatureType.WOLF;                               }
		else if (args[0].equalsIgnoreCase("zombie"))       { mobType = CreatureType.ZOMBIE;                             }
		else                                               { sender.sendMessage("Unknown mobtype"); returnValue = true; }
		
		sender.sendMessage(ChatColor.GRAY + "Spawning " + strAmount + " " + strMobType + "...");
		for (int i = 0; i < intAmount; i++) {
			spawnLocation.getWorld().spawnCreature(spawnLocation, mobType);
		}
		returnValue = true;
	}
}
