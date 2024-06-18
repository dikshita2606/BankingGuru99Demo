package com.BankingAutomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configuration/Config.properties");
		
		try {
			FileInputStream fin = new FileInputStream(src);
			pro = new Properties();
			pro.load(fin);
		}
		catch(IOException ex){
			System.out.println("Encountered Error : "+ex.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String userName = pro.getProperty("username");
		return userName;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
}
