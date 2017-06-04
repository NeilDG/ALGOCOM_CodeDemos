/**
 * 
 */
package sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import sorting.CustomDateFormat.SortingType;
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
    
    /*
	 * Performs counting sort but only returns the COUNTER HOLDER to determine placement of values
	 */
	public static int[] countingSortIndex(int[] numbers) {
		//identify highest range first, which determines K
		int k = findHighest(numbers) + 1; //+1 is needed so it counterHolder doesn't overflow
		
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
		
		return counterHolder;
	}
	
	private static CustomDateFormat[] countingSortByDate(CustomDateFormat[] dateList, CustomDateFormat.SortingType sortingType) {
		CustomDateFormat[] sortedDates = new CustomDateFormat[dateList.length];
		
		//sort month
    	int[] values = new int[dateList.length];
    	for(int i = 0; i < dateList.length; i++) {
    		if(sortingType == SortingType.MONTH) {
    			values[i] = dateList[i].getMonth();
    		}
    		else if(sortingType == SortingType.DAY) {
    			values[i] = dateList[i].getDay();
    		}
    		else if(sortingType == SortingType.YEAR) {
    			values[i] = dateList[i].getYear();
    		}
    	}
    	
    	//re-organize dates using index placement from counting sort
    	int[] numberPlacement = countingSortIndex(values);   
    	Debug.log(TAG, "Number placement: " +Debug.convertArrayNumToString(numberPlacement));
    	for(int i = 0; i < dateList.length; i++) {
    		int counterIndex = values[i];
    		numberPlacement[counterIndex]--;
    			
        	int assignedIndex = numberPlacement[counterIndex];
        	sortedDates[assignedIndex] = dateList[i];	   		
    	}
    	
    	return sortedDates;
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
    
    public static CustomDateFormat[] radixSortDate(CustomDateFormat[] dateList) {
    	CustomDateFormat[] sortedDates = new CustomDateFormat[dateList.length];
    	
    	//sort month
    	sortedDates = countingSortByDate(dateList, CustomDateFormat.SortingType.MONTH);
    	Debug.log(TAG, "Sorted dates using month: " +CustomDateFormat.convertDateFormatsToString(sortedDates));
    	
    	//sort day
    	sortedDates = countingSortByDate(sortedDates, CustomDateFormat.SortingType.DAY);
    	Debug.log(TAG, "Sorted dates using day: " +CustomDateFormat.convertDateFormatsToString(sortedDates));
    	
    	//sort year
    	sortedDates = countingSortByDate(sortedDates, CustomDateFormat.SortingType.YEAR);
    	Debug.log(TAG, "Sorted dates using year: " +CustomDateFormat.convertDateFormatsToString(sortedDates));
    	
    	return sortedDates;
    	
    }

}
