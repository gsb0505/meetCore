package com.kd.core.util;

import java.util.ResourceBundle;

public class OtherUtil {
	private static ResourceBundle rb ;
	
	
	static{
		rb = ResourceBundle.getBundle("other");
	}
	

	public static String getParmas(String key) {
		
		return rb.getString(key);
	}
}
