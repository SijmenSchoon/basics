package cc.co.vijfhoek.basics;

import java.io.*;

import org.bukkit.util.config.Configuration;

public class BasicsConfiguration {
	private File fleConfig;
	private File fleConfigDir;
	private Configuration cfgConfig;
	private String strConfigType;
	
	public BasicsConfiguration(String configType) {
		fleConfigDir = new File("plugins" + File.separator + "Basics");
		
		if(configType.equals("config")) {
			fleConfig = new File("plugins" + File.separator + "Basics" + File.separator + "config.yml");
			strConfigType = configType;
		} else if(configType.equals("items")) {
			fleConfig = new File("plugins" + File.separator + "Basics" + File.separator + "items.yml");
			strConfigType = configType;
		} else if(configType.equals("accounts")) {
			fleConfig = new File("plugins" + File.separator + "Basics" + File.separator + "accounts.yml");
			strConfigType = configType;
		} else {
			return;
		}
		
		cfgConfig = new Configuration(fleConfig);
	}
	
	public Configuration getConfiguration() {
		return cfgConfig;
	}
	
	public String convertStreamToString(InputStream is) {
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
	
	public void createIfNotExists() {
		fleConfigDir.mkdirs();
		if(!fleConfig.exists()) {
			try {
				fleConfig.createNewFile();
				PrintWriter prwConfig = new PrintWriter(fleConfig);
				String configString;
				if(strConfigType.equals("config")) {
					InputStream isConfig = Basics.class.getResourceAsStream("/config.yml");
					configString = convertStreamToString(isConfig);
				} else if(strConfigType.equals("items")) {
					InputStream isConfig = Basics.class.getResourceAsStream("/items.yml");
					configString = convertStreamToString(isConfig);
				} else if(strConfigType.equals("accounts")) {
					InputStream isConfig = Basics.class.getResourceAsStream("/accounts.yml");
					configString = convertStreamToString(isConfig);
				} else {
					return;
				}
				
				prwConfig.write(configString);
				prwConfig.flush();
				prwConfig.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
