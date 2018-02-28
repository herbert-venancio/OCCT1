package com.sample.integration.utils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.util.Properties;

public class PropertyReader {

	public PropertyReader(String filePath) {
		_properties = _load(_getProjectPath() + filePath);
	}

	public String getProperty(String key) {
		String text = _properties.getProperty(key);

		return text;
	}

	private String _getProjectPath() {
		String projectPath = System.getProperty("user.dir");

		return projectPath;
	}

	private Properties _load(String filePath) {
		Properties properties = new Properties();

		try (FileInputStream is = new FileInputStream(filePath);
			InputStreamReader isr = new InputStreamReader(is, "UTF-8")) {

			properties.load(isr);
		}
		catch (FileNotFoundException fnfe) {
			_log.error("Property file not found: " + filePath, fnfe);
		}
		catch (UnsupportedEncodingException uee) {
			_log.error("Cannot read property file: " + filePath, uee);
		}
		catch (IOException ioe) {
			_log.error(ioe);
		}

		return properties;
	}

	private static final Log _log = LogFactoryUtil.getLog(PropertyReader.class);

	private Properties _properties;

}