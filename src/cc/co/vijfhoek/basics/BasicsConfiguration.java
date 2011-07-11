package cc.co.vijfhoek.basics;

import java.io.*;

public class BasicsConfiguration {
	public enum ConfigType {
		ACCOUNTS, CONFIG, ITEMS
	}
	
	private String convertStreamToString(InputStream is) {
		if (is == null) {
			return "";
		}
		
		Writer writer = new StringWriter();
		char[] buffer = new char[1024];
		try {
			Reader reader = new BufferedReader(new InputStreamReader(is));
			int n;
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}
	
	public void createFolders() {
		new File("plugins" + File.separator + "Basics").mkdirs();
	}
	
	public File getFile(ConfigType configType) {
		if (configType == ConfigType.ACCOUNTS) {
			return (new File("plugins" + File.separator + "Basics" + File.separator + "accounts.yml"));
		} else if (configType == ConfigType.CONFIG) {
			return (new File("plugins" + File.separator + "Basics" + File.separator + "config.yml"));
		} else if (configType == ConfigType.ITEMS) {
			return (new File("plugins" + File.separator + "Basics" + File.separator + "items.yml"));
		}
		return null;
	}
	
	public void createConfig(ConfigType configType) {
		try {
			if (configType == ConfigType.ACCOUNTS) {
				File fleConfig = new File("plugins" + File.separator + "Basics" + File.separator + "accounts.yml");
				if (fleConfig.exists()) return;
				
				InputStream isConfig = Basics.class.getResourceAsStream("/accounts.yml");
				PrintWriter prwConfig = new PrintWriter(fleConfig);
				String strConfig = convertStreamToString(isConfig);
				
				fleConfig.createNewFile();
				prwConfig.write(strConfig);
				prwConfig.flush();
				prwConfig.close();
			} else if (configType == ConfigType.CONFIG) {
				File fleConfig = new File("plugins" + File.separator + "Basics" + File.separator + "config.yml");
				if (fleConfig.exists()) return;
				
				InputStream isConfig = Basics.class.getResourceAsStream("/config.yml");
				PrintWriter prwConfig = new PrintWriter(fleConfig);
				String strConfig = convertStreamToString(isConfig);
				
				fleConfig.createNewFile();
				prwConfig.write(strConfig);
				prwConfig.flush();
				prwConfig.close();
			} else if (configType == ConfigType.ITEMS) {
				File fleConfig = new File("plugins" + File.separator + "Basics" + File.separator + "items.yml");
				if (fleConfig.exists()) return;
				
				InputStream isConfig = Basics.class.getResourceAsStream("/items.yml");
				PrintWriter prwConfig = new PrintWriter(fleConfig);
				String strConfig = convertStreamToString(isConfig);
				
				fleConfig.createNewFile();
				prwConfig.write(strConfig);
				prwConfig.flush();
				prwConfig.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
