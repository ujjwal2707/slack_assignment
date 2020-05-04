package com.slack.generic_utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	
	private final String propertyFilePath= ".\\Configuration.properties";
	
	
	public ConfigFileReader(){
		 BufferedReader reader;
		 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
		 try {
		 properties.load(reader);
		 reader.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		 } 
		 }
		 
		 
		 public String get_baseURI() {
		 String URI = properties.getProperty("base_URI");
		 if(URI != null) return URI;
		 else throw new RuntimeException("base_URI not specified in the Configuration.properties file.");
		 }
		 
		 public String get_token() {
			 String token = properties.getProperty("token");
			 if(token != null) return token;
			 else throw new RuntimeException("Token not specified in the Configuration.properties file.");
			 }
		 
		 public String get_create_channel_resource() {
			 String resource_create_channel = properties.getProperty("resource_create_channel");
			 if(resource_create_channel != null) return resource_create_channel;
			 else throw new RuntimeException("resource_create_channel not specified in the Configuration.properties file.");
			 }
		 
		 public String get_join_channel_resource() {
			 String resource_join_channel = properties.getProperty("resource_join_channel");
			 if(resource_join_channel != null) return resource_join_channel;
			 else throw new RuntimeException("resource_join_channel not specified in the Configuration.properties file.");
			 }
		 
		 public String get_rename_channel_resource() {
			 String resource_rename_channel = properties.getProperty("resource_rename_channel");
			 if(resource_rename_channel != null) return resource_rename_channel;
			 else throw new RuntimeException("resource_rename_channel not specified in the Configuration.properties file.");
			 }
		 
		 public String get_archive_channel_resource() {
			 String resource_archive_channel = properties.getProperty("resource_archive_channel");
			 if(resource_archive_channel != null) return resource_archive_channel;
			 else throw new RuntimeException("resource_archive_channel not specified in the Configuration.properties file.");
			 }
		 
		 public String get_list_channel_resource() {
			 String resource_get_list_channel = properties.getProperty("resource_get_list_channel");
			 if(resource_get_list_channel != null) return resource_get_list_channel;
			 else throw new RuntimeException("resource_get_list_channel not specified in the Configuration.properties file.");
			 }

}
