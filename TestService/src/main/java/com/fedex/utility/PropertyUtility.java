package com.fedex.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {

	
	static Properties props=new Properties();
	
	
	public static String readProperty(String str) 
	{
		String s=null;
		try {
			/*
			 * if(System.getenv()!=null) {
			 * if(System.getenv().get("environment").equalsIgnoreCase("L1")) {
			 * System.out.println("Environment"+System.getenv().get("environment"));
			 * //props.load(new
			 * FileInputStream("//tmp//config"+System.getenv().get("environment")+
			 * ".properties")); props.load(new
			 * FileInputStream("//tmp//config"+System.getenv().get("environment")+
			 * ".properties")); s=props.getProperty(str); } }
			 */
			
				
					
					props.load(new FileInputStream("//tmp//application.properties"));
					s=props.getProperty(str);
				
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return s;
	}
}

