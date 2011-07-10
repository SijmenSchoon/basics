package cc.co.vijfhoek.basics;

import java.util.*;

import org.bukkit.inventory.*;
import org.bukkit.util.config.*;

public class BasicsAccounts {
	public List<String> frozenPlayers;
	public HashMap<String, HashMap<Integer, ItemStack>> stolenInventories;
	
	private String strDatabaseType;
	private Basics basics;
	private Configuration cfgAccounts;
	
	public BasicsAccounts() {
		System.out.println();
		Configuration config = null;
		try {
			config = basics.bcfConfig.getConfiguration();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("-=-=-=-=-=-=-=-");
			System.out.println(e.getMessage());
			System.out.println("-=-=-=-=-=-=-=-");
			System.out.println(e.getCause().getMessage());
		}
		if (!config.getBoolean("authentication.register", true)) return;
		strDatabaseType = basics.bcfConfig.getConfiguration().getString("authentication.database-type");
		cfgAccounts = basics.bcfAccounts.getConfiguration();
		frozenPlayers = new LinkedList<String>();
		stolenInventories = new HashMap<String, HashMap<Integer,ItemStack>>();
	}
	
	/* Return codes:
	 *   0 - Created successfully
	 *   1 - Already exists
	 *   2 - Creation failed
	 *   
	 * TODO:
	 *     - Make the method save/load once in the X minutes to lower IO access
	 */
	public int createAccount(String name, String password) {
		cfgAccounts.load();
		
		if (!strDatabaseType.equalsIgnoreCase("yaml")) return 2;
		if (cfgAccounts.getString(name + ".password") != null) return 1;
		int hashPassword = password.hashCode();
		cfgAccounts.setProperty(name + ".password", hashPassword);
		cfgAccounts.setProperty(name + ".created", Integer.getInteger(Long.toString((new Date()).getTime())));
		cfgAccounts.setProperty(name + ".lastaccessed", Integer.getInteger(Long.toString((new Date()).getTime())));
		
		cfgAccounts.save();
		return 0;
	}
	
	/* Return codes:
	 *   0 - Username and password correct
	 *   1 - Username doesn't exist
	 *   2 - Password incorrect
	 *   3 - Logging in failed
	 * 
	 * TODO:
	 *     - Make the method load once in the X minutes to lower IO access
	 */
	public int login(String name, String password) {
		cfgAccounts.load();
		
		if (!strDatabaseType.equalsIgnoreCase("yaml")) return 3;
		if (cfgAccounts.getString(name + ".password") == null) return 1;
		if (cfgAccounts.getInt(name + ".password", 0) != password.hashCode()) return 2;
		cfgAccounts.setProperty(name + ".lastaccessed", Integer.getInteger(Long.toString((new Date()).getTime())));
		
		cfgAccounts.save();
		return 0;
	}
	
	/* Return codes:
	 *   0 - Exists
	 *   1 - Doesn't exist
	 *   2 - Checking failed
	 *   
	 * TODO:
	 *     - Make the method load once in the X minutes to lower IO access
	 */
	public int checkExistance(String name) {
		cfgAccounts.load();
		
		if (!strDatabaseType.equalsIgnoreCase("yaml")) return 2;
		if (cfgAccounts.getString(name + ".password") == null) return 1;
		return 0;
	}
	
	/* Return codes:
	 *   0 - Frozen
	 *   1 - Not frozen
	 */
	public int checkFrozen(String name) {
		if (frozenPlayers.contains(name)) return 0;
		return 1;
	}
	
	/* Return codes:
	 *   0 - Successfully frozen
	 *   1 - Already frozen
	 */
	public int freeze(String name) {
		if (frozenPlayers.contains(name)) return 1;
		frozenPlayers.add(name);
		return 0;
	}
	
	/* Return codes:
	 *   0 - Successfully unfrozen
	 *   1 - Already unfrozen
	 */
	public int unfreeze(String name) {
		if (!frozenPlayers.contains(name)) return 1;
		frozenPlayers.remove(name);
		return 0;
	}
}
