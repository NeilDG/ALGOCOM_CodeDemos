/**
 * 
 */
package main_prog;

import java.util.Scanner;

import sorting.ClassicalSorting;
import sorting.CustomDateFormat;
import sorting.LinearSorting;
import utils.Debug;
import utils.InputConverter;

/**
 * Entry points for various algorithm demos
 * @author NeilDG
 *
 */
public class MainActivity {
	private final static String TAG = "MainActivity";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*String myString = Debug.askStringInput(TAG, "Input numbers separated by spaces: ");
		Debug.log(TAG, myString);
		
		int[] numberList = InputConverter.convertStringToArrayInt(myString);
		int[] sortedList = LinearSorting.countingSort(numberList);
		
		Debug.log(TAG, "Sorted num using counting sort: "+ Debug.convertArrayNumToString(sortedList));
		
		sortedList = LinearSorting.radixSort(numberList);
		
		Debug.log(TAG, "Sorted num using radix sort: "+ Debug.convertArrayNumToString(sortedList));
		
		String dateString = Debug.askStringInput(TAG, "Input dates following MM/DD/YYYY format, separated by spaces: ");
		
		CustomDateFormat[] dates = InputConverter.convertStringToDates(dateString);
		LinearSorting.radixSortDate(dates);  */
		
		
		//bucket sort test
		/*String myString = Debug.askStringInput(TAG, "Input numbers separated by spaces: ");
		
		int[] numberList = InputConverter.convertStringToArrayInt(myString);
		int[] sortedList = LinearSorting.recursiveBucketSort(numberList, 3);
		Debug.log(TAG, "Sorted num using counting sort: "+ Debug.convertArrayNumToString(sortedList));*/
		
		String myString = Debug.askStringInput(TAG, "Input numbers separated by spaces: ");
		
		//merge sort
		int[] numberList = InputConverter.convertStringToArrayInt(myString);
		int[] sortedList = ClassicalSorting.mergeSort(numberList);
		//ClassicalSorting.mergeSort2(numberList, 0, numberList.length - 1);
		Debug.log(TAG, "Sorted num using merge sort: "+ Debug.convertArrayNumToString(sortedList));
		
		//quick sort
		numberList = InputConverter.convertStringToArrayInt(myString);
		sortedList = ClassicalSorting.quickSort(numberList, 0, numberList.length - 1);
		Debug.log(TAG, "Sorted num using quick sort: "+ Debug.convertArrayNumToString(sortedList));
	}

}
