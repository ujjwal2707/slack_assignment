package com.slack.genericUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;

	private final String propertyFilePath = ".\\Configuration.properties";

	public ConfigFileReader() {
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

	public String getBaseURI() {
		String URI = properties.getProperty("base_URI");
		if (URI != null)
			return URI;
		else
			throw new RuntimeException("baseURI not specified in the Configuration.properties file.");
	}

	public String getToken() {
		String token = properties.getProperty("token");
		if (token != null)
			return token;
		else
			throw new RuntimeException("Token not specified in the Configuration.properties file.");
	}

	public String getCreateChannelResource() {
		String resourceCreateChannel = properties.getProperty("resourceCreateChannel");
		if (resourceCreateChannel != null)
			return resourceCreateChannel;
		else
			throw new RuntimeException("getCreateChannelResource not specified in the Configuration.properties file.");
	}

	public String getJoinChannelResource() {
		String resourceJoinChannel = properties.getProperty("resourceJoinChannel");
		if (resourceJoinChannel != null)
			return resourceJoinChannel;
		else
			throw new RuntimeException("getJoinChannelResource not specified in the Configuration.properties file.");
	}

	public String getRenameChannelResource() {
		String resourceRenameChannel = properties.getProperty("resourceRenameChannel");
		if (resourceRenameChannel != null)
			return resourceRenameChannel;
		else
			throw new RuntimeException("getRenameChannelResource not specified in the Configuration.properties file.");
	}

	public String getArchiveChannelResource() {
		String resourceArchiveChannel = properties.getProperty("resourceArchiveChannel");
		if (resourceArchiveChannel != null)
			return resourceArchiveChannel;
		else
			throw new RuntimeException("getArchiveChannelResource not specified in the Configuration.properties file.");
	}

	public String getListChannelResource() {
		String resourceGetListChannel = properties.getProperty("resourceGetListChannel");
		if (resourceGetListChannel != null)
			return resourceGetListChannel;
		else
			throw new RuntimeException("getListChannelResource not specified in the Configuration.properties file.");
	}

}
