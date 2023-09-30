package com.inetbanking.utilities;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);	
		}catch(Exception e) {
			System.out.println("Exception is: "+e.getMessage());
		}
		
	}
	
	public String getApplicationURL() {
		
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getUsername() {
		
		String username = pro.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
//	public String getcustName() {
//		String cname = pro.getProperty("name");
//		return cname;
//	}
//	public String getcustGender() {
//		String cgender = pro.getProperty("gender");
//		return cgender;
//	}
//	public String getmonth() {
//		String mm= pro.getProperty("month");
//		return mm;
//	}
//	public String getday() {
//		String dd= pro.getProperty("day");
//		return dd;
//	}
//	public String getyear() {
//		String yy= pro.getProperty("year");
//		return yy;
//	}
//	public String getaddress() {
//		String caddress = pro.getProperty("address");
//		return caddress;
//	}
//	public String getcity() {
//		String cCity = pro.getProperty("city");
//		return cCity;
//	}
//	public String getstate() {
//		String cstate = pro.getProperty("state");
//		return cstate;
//	}
//	public String getzipcode() {
//		String czipcode = pro.getProperty("zipcode");
//		return czipcode;
//	}
//	public String gettelephone() {
//		String ctelephoneNum = pro.getProperty("telephone");
//		return ctelephoneNum;
//	}
//	
	
}
