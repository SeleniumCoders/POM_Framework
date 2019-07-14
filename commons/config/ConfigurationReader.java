package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Properties;

public class ConfigurationReader {
	//Create object
	private static ConfigurationReader singleTon = new ConfigurationReader();
	
	//Configurations
	public String url="";
	public String browseType="";
	HashMap<String,HashMap<String,String>> dataCopy = new HashMap<>();
	
	//Make Constructor Static
	private ConfigurationReader(){}
	
	public static ConfigurationReader getInstance()
	{
		return singleTon;
	}
	
		
	public void readConfigFile()
	{
		try{
		FileInputStream filePath = new FileInputStream(".//reasource//Config.properties");
		Properties config = new Properties();
		config.load(filePath);
		browseType =  config.getProperty("browserType");
		url =  config.getProperty("url");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		ExcelDataReader e = new ExcelDataReader();
		dataCopy = e.readExcelFile();
	}
	
	public HashMap<String,String > getRow(String key)
	{
		return dataCopy.get(key);
	}

}
