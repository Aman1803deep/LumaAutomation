package utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseUtils {

	public static String getConfigValue(String key) throws IOException {
		// TODO Auto-generated method stub

		Properties property = new Properties();
	    FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
	    	property.load(file)	;

	    	return property.getProperty(key);
	}


	}
	

