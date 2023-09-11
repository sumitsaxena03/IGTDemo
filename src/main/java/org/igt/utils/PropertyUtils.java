package org.igt.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.igt.constants.FrameworkConstants;
import org.igt.exceptions.PropertyFileExceptions;

/**
 * Class to provide methods to read value from property file.
 * Mar 14, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see FileInputStream
 * @see FrameworkConstants
 */
public class PropertyUtils {

	private PropertyUtils() {};
	private static Properties properties = new Properties();
	private static Map<String, String> map = new HashMap<>();
	/**
	 * Static block to load file in MAP which will be used while calling getValue method.
	 * @author Mandeep Sheoran
	 */
	static {		
		try (FileInputStream inputstream = new FileInputStream(FrameworkConstants.configFilePath)){
			properties.load(inputstream);
		}  catch (IOException e1) {
			e1.printStackTrace();
			System.exit(0);         //To exit JVM gracefully
		}
		properties.entrySet().forEach(e->map.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));
	}

	/**
	 * Method to provide value of the key passed by calling method.
	 * @author Mandeep Sheoran
	 */
	public static String getValue(String key) {
		if (Objects.isNull(key) || Objects.isNull(map.get(key))) {                 
			throw new PropertyFileExceptions("Property name " + key + " not found. Please check config.properties file");
		}
		return map.get(key);
	}
}