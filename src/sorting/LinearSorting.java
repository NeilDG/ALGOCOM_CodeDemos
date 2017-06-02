/**
 * 
 */
package sorting;

import java.util.Arrays;

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
	
	// A function to do counting sort of arr[] according to
    // the digit represented by exp.
    private static int[] countSortWithExp(int arr[], int exp)
    {
        int output[] = new int[arr.length]; // output array
        int i;
        int count[] = new int[10];
 
        // Store count of occurrences in count[]
        for (i = 0; i < arr.length; i++)
            count[ (arr[i]/exp)%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = arr.length - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < output.length; i++)
            arr[i] = output[i];
        
        return output;
    }
    
 // The main function to that sorts arr[] of size n using
    // Radix Sort
    public static int[] radixSort(int numberList[])
    {
        // Find the maximum number to know number of digits
        int high = findHighest(numberList);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; high/exp > 0; exp *= 10) {
            numberList = countSortWithExp(numberList, exp);
        }
        
        return numberList;
    }

}
