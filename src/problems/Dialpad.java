package problems;

import java.util.Hashtable;

import utils.Debug;

/*
 * Solution to the dialpad problem
 */
public class Dialpad {
	private final static String TAG = "Dialpad";
	
	public static void hashKeystrokes(String input) {
		Hashtable<Character, Integer> keypadHash = new Hashtable();
		keypadHash.put('A', 2);
		keypadHash.put('B', 2);
		keypadHash.put('C', 2);
		keypadHash.put('D', 3);
		keypadHash.put('E', 3);
		keypadHash.put('F', 3);
		keypadHash.put('G', 4);
		keypadHash.put('H', 4);
		keypadHash.put('I', 4);
		keypadHash.put('J', 5);
		keypadHash.put('K', 5);
		keypadHash.put('L', 5);
		keypadHash.put('M', 6);
		keypadHash.put('N', 6);
		keypadHash.put('O', 6);
		keypadHash.put('P', 7);
		keypadHash.put('Q', 7);
		keypadHash.put('R', 7);
		keypadHash.put('S', 7);
		keypadHash.put('T', 8);
		keypadHash.put('U', 8);
		keypadHash.put('V', 8);
		keypadHash.put('W', 9);
		keypadHash.put('X', 9);
		keypadHash.put('Y', 9);
		keypadHash.put('Z', 9);
		
		String keyCombination = "";
		for(int i = 0; i < input.length(); i++) {
			if(keypadHash.containsKey(input.charAt(i))) {
				keyCombination += keypadHash.get(input.charAt(i)).toString();
			}
			
		}
		
		Debug.log(TAG, "Key combination: " + keyCombination);
	}
	public static void getNumKeystrokes(String input) {
		char[] num_2 = new char[]{'A', 'B', 'C'};
		char[] num_3 = new char[]{'D', 'E', 'F'};
		char[] num_4 = new char[]{'G', 'H', 'I'};
		char[] num_5 = new char[]{'J', 'K', 'L'};
		char[] num_6 = new char[]{'M', 'N', 'O'};
		char[] num_7 = new char[]{'P', 'Q', 'R', 'S'};
		char[] num_8 = new char[]{'T', 'U', 'V'};
		char[] num_9 = new char[]{'W', 'X', 'Y', 'Z'};
		
		int total = 0;
		String keyCombination = "";
	
		for(int i = 0; i < input.length(); i++) {
			boolean found = false;
			char c = input.charAt(i);
			
			//check num_2
			for(int index = 0; index < num_2.length && !found; index++) {
				if(c == num_2[index]) {
					found = true;
					total += index + 1;
					keyCombination += "2";
					break;
				}
			}
			
			//check num_3
			for(int index = 0; index < num_3.length && !found; index++) {
				if(c == num_3[index]) {
					found = true;
					total += index + 1;
					keyCombination += "3";
					break;
				}
			}
			
			//check num_4
			for(int index = 0; index < num_4.length && !found; index++) {
				if(c == num_4[index]) {
					found = true;
					total += index + 1;
					keyCombination += "4";
					break;
				}
			}
			
			//check num_5
			for(int index = 0; index < num_5.length && !found; index++) {
				if(c == num_5[index]) {
					found = true;
					total += index + 1;
					keyCombination += "5";
					break;
				}
			}
			
			//check num_6
			for(int index = 0; index < num_6.length && !found; index++) {
				if(c == num_6[index]) {
					found = true;
					total += index + 1;
					keyCombination += "6";
					break;
				}
			}
			
			//check num_7
			for(int index = 0; index < num_7.length&& !found; index++) {
				if(c == num_7[index]) {
					found = true;
					total += index + 1;
					keyCombination += "7";
					break;
				}
			}
			
			//check num_8
			for(int index = 0; index < num_8.length && !found; index++) {
				if(c == num_8[index]) {
					found = true;
					total += index + 1;
					keyCombination += "8";
					break;
				}
			}
			
			//check num_9
			for(int index = 0; index < num_9.length && !found; index++) {
				if(c == num_9[index]) {
					found = true;
					total += index + 1;
					keyCombination += "9";
					break;
				}
			}
			
		}
		Debug.log(TAG, "Key combination: " + keyCombination+ " Num strokes: " +total);
		
	}
}
