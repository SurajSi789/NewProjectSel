package com.swaglabs.parameters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	Properties property;
	
	public PropertiesReader() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/surajsingh/eclipse-workspace/SwaglabsDemo/src/test/resources/PropertyFiles/driverRepository.properties"));
		property = new Properties();
		property.load(br);
		br.close();
	}
	
	public String getChromeDriverName() {
		return property.getProperty("driverCName");
	}
	
	public String getChromeDriverPath() {
		return property.getProperty("driverCPath");
	}
	
	public String getMainURL() {
		return property.getProperty("mainUrl");
	}
}
