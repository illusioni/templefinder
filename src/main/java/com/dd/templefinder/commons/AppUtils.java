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
	
	public static String[] splitSearch(String searchInput) {
		String[] eachWord = searchInput.toLowerCase().split("[\\-., ]");
		return eachWord;
	}

}
