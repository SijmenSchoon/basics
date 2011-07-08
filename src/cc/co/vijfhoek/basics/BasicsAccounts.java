package cc.co.vijfhoek.basics;

import java.util.*;

import org.bukkit.util.config.*;

public class BasicsAccounts {
	public List<String> frozenPlayers;
	
	private String strDatabaseType;
	private Basics basics;
	private Configuration cfgAccounts;
	
	public BasicsAccounts() {
		if (!basics.bcfConfig.getConfiguration().getBoolean("authentication.register", true)) return;
		strDatabaseType = basics.bcfConfig.getConfiguration().getString("authentication.database-type");
		cfgAccounts = basics.bcfAccounts.getConfiguration();
		frozenPlayers = new LinkedList<String>();
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
		frozenPlayers.remove(name);
		
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
}
