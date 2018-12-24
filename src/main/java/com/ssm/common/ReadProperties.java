package com.ssm.common;

import java.util.ResourceBundle;

public class ReadProperties {

	private static ResourceBundle props = null;
	
	static{
		try {
			reload();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void reload(){
		props = ResourceBundle.getBundle("redis");
	}
	
	public static String getValue(String key){
    	if(props==null) return null;
    	try{
    		return props.getString(key);
    	}catch(Exception e){
    		return null;
    	}
    }
	
	public static String getString(String key, String def){
    	if(props==null) return def;
    	String result = null;
    	try{
    		result = props.getString(key);
    	}catch(Exception e){
    		result = def;
    	}
    	if(result==null) result = def;
    	return result;
    }
	
	public static int getInt(String key, int def){
    	int result;
    	if(props==null) return def;
    	try{
    		result = Integer.parseInt(props.getString(key));
    	}catch(Exception e){
    		result = def;
    	}
    	return result;
    }
	
	public static boolean getBoolean(String key, boolean def){
    	boolean result;
    	if(props==null) return def;
    	try{
    		result = (new Boolean(props.getString(key))).booleanValue();
    	}catch(Exception e){
    		result = def;
    	}
    	return result;
    }
	
	public static void main(String[] args) {
		System.out.println(ReadProperties.getInt("port", 120));
	}

}
