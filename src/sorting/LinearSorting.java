/**
 * 
 */
package sorting;

import utils.Debug;

/**
 * Linear sorting examples
 * @author NeilDG
 *
 */
public class LinearSorting {
	private final static String TAG = "LinearSorting";
	
	private static int findHighest(int[] numbers) {
		int high = numbers[0];
		
		for(int i = 1; i < numbers.length; i++) {
			if(numbers[i] > high) {
				high = numbers[i];
			}
		}
		
		return high;
	}
	
	/*
	 * Counting sort. Accepts a number array that has a zero in it.
	 */
	public static int[] countingSort(int[] numbers) {
		//identify highest range first, which determines K
		int k = findHighest(numbers) + 1; //+1 is needed so it counterHolder doesn't overflow
		Debug.log(TAG, "K is: " +k);
		
		//declare temp working storage, C
		int[] counterHolder = new int[k];
		
		//tally the corresponding numbers in counterHolder
		for(int i = 0; i < numbers.length; i++) {
			int index = numbers[i];
			counterHolder[index]++;
		}
		
		//get the corresponding count and add it to the next
		for(int i = 1; i < counterHolder.length; i++) {
			counterHolder[i] += counterHolder[i - 1];
		}
		
		//perform sorting based from counter holder placement
		int[] sortedList = new int[numbers.length];
		for(int i = numbers.length - 1; i >= 0; i--) {
			int counterIndex = numbers[i];
			counterHolder[counterIndex]--;
			
			int assignedIndex = counterHolder[counterIndex];
			sortedList[assignedIndex] = numbers[i];	
		}
		
		/*for(int i = 0; i < numbers.length; i++) {
			int counterIndex = numbers[i];
			counterHolder[counterIndex]--;
			
			int assignedIndex = counterHolder[counterIndex];
			sortedList[assignedIndex] = numbers[i];	
		}*/
		
		return sortedList;
	}

}
