package com.nopcommerce.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;
    
    public ReadConfig(){
    try {
          FileInputStream fis=new FileInputStream("./Configuration/config.properties");
          pro = new Properties();
          pro.load(fis);
    }
    catch (Exception e) {
		System.out.println("Exception is " + e.getMessage());
	}
    }
    
	public String getApplicationURL()
	{
	String url=pro.getProperty("baseURL");
	return url;
	}
	
	public String getUseremail()
	{
	String username=pro.getProperty("useremail");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getEdgePath()
	{
	String iepath=pro.getProperty("edgepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	
}
