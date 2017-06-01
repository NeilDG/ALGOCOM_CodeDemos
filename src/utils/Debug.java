/**
 * 
 */
package utils;

import java.util.Scanner;

/**
 * Convenience class for printing in console with a TAG
 * @author NeilDG
 *
 */
public class Debug {

	public static void log(String tag, String message) {
		System.out.println("["+tag+"]: " +message);
	}
	
	public static int askInput(String tag, String message) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("["+tag+"]: " +message);
		
		int number = inputScanner.nextInt();
		
		return number;
	}
	
	public static String askStringInput(String tag, String message) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("["+tag+"]: " +message);
		
		String text = inputScanner.nextLine();
		
		return text;
	}
	
	public static String convertArrayNumToString(int[] numbers) {
		String message = "";
		
		for(int i = 0; i < numbers.length; i++) {
			message += numbers[i] + " ";
		}
		
		return message;
	}
}
