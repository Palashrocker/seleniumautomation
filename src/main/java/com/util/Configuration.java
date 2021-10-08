package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	 private Properties prop;

	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/configs/config.properties");
			try {
				prop.load(fis);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return prop;
	}
}
