package cmpiler_test;

import utils.Debug;

public class CmpilerTests {

	private final static String TAG = "";
	
	public CmpilerTests() {
		
	}
	
	public void varTest() {
		final float MULTIPLIER = 2.0f;
		final float DIVIDER = 1.5f;
		
		int x = 0, y = 0, z = 0;
		
		x += 4;
		y += 5;
		z += 6;
		
		float finalValue = (((x + y) * MULTIPLIER) / DIVIDER + x + y) - y * MULTIPLIER;
		
		Debug.log(TAG, "Value is: " +(finalValue * MULTIPLIER * MULTIPLIER));
	}
	public void arrayTest() {
		final int BOUNDS = 10;
		int[] myArray = new int[BOUNDS];
		
		int total = 0;
		
		for(int i = 0; i < BOUNDS; i++) {
			myArray[i] = Debug.askInput("Enter number: ");
			total += myArray[i];
			
			Debug.log("Running total: " +total);
		}
	}
	
	public void arrayTest2() {
		int numbers = Debug.askInput("How many numbers? ");
		
		int sizeArray = 0;
		
		for(int i = 0; i < numbers; i++) {
			sizeArray += Debug.askInput("Enter number: ");
		}
		
		char[] myArray = new char[sizeArray];
		Debug.log("Size of my array is: " +myArray.length);
	}
	
	public int count7(int n) {
		  if (n < 1) return 0;
		  if (n % 10 == 7) return 1 + count7(n/10);
		  else return count7(n/10);
	}
}
