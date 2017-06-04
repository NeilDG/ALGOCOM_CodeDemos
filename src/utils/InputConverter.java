/**
 * 
 */
package utils;

import sorting.CustomDateFormat;

/**
 * Utility class for conversion of input to proper form
 * @author NeilDG
 *
 */
public class InputConverter {
	private final static String TAG = "InputConverter";
	
	/*
	 * Used for string that contains spaces which can be converted to an integer array
	 */
	public static int[] convertStringToArrayInt(String inputText) {
		String[] strings = inputText.split(" ");
		
		int[] numbers = new int[strings.length];
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(strings[i]);
		}
		
		return numbers;
	}
	
	/*
	 * Assumes it follows MM/DD/YYYY and separated by spaces
	 */
	public static CustomDateFormat[] convertStringToDates(String inputText) {
		String[] strings = inputText.split(" ");
		
		CustomDateFormat[] dates = new CustomDateFormat[strings.length];
		
		for(int i = 0; i < dates.length; i++) {
			dates[i] = new CustomDateFormat(strings[i]);
		}
		
		return dates;
	}

}
