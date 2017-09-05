package com.alex.ts_parser.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StringResocesHelper {
	final static String StringResourcesPath = "resources/StringResources_CN.properties";
	
	public static String getStringByKey(String key) {
		Properties stringResourcesPreperties = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(StringResourcesPath));
			stringResourcesPreperties.load(in);
			String value = stringResourcesPreperties.getProperty(key);
			return value;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
 