package by.htp.vk.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
	private static Properties properties = new Properties();
	private static final String PROPERTIES_EX_PATH = "src/test/resources/credentials.properties";

	public static String getProperty(String key) {
		setPropertiesFile();
		return properties.getProperty(key);
	}

	private static void setPropertiesFile() {
		try {
			properties.load(new FileInputStream(new File(PROPERTIES_EX_PATH)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
