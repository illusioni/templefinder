package com.dd.templefinder.commons;
/**
 *  
 * @author aditya
 *
 */
public class AppUtils {
	
	public static String normalizeString(String inputStr) {
		return inputStr.replaceAll("\\s","").toLowerCase();
	}

}
