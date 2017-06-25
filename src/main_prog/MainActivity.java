/**
 * 
 */
package main_prog;

import java.util.Scanner;

import sorting.ClassicalSorting;
import sorting.CustomDateFormat;
import sorting.LinearSorting;
import string_match.RabinKarpMatcher;
import string_match.StringFSM;
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
		
		/*String myString = Debug.askStringInput(TAG, "Input numbers separated by spaces: ");
		int[] numberList = InputConverter.convertStringToArrayInt(myString);
		ClassicalSorting.binarySearch(numberList, 1, 0, numberList.length - 1);*/
		
		//merge sort
		/*int[] numberList = InputConverter.convertStringToArrayInt(myString);
		int[] sortedList = ClassicalSorting.mergeSort(numberList);
		//ClassicalSorting.mergeSort2(numberList, 0, numberList.length - 1);
		Debug.log(TAG, "Sorted num using merge sort: "+ Debug.convertArrayNumToString(sortedList));
		
		//quick sort
		numberList = InputConverter.convertStringToArrayInt(myString);
		sortedList = ClassicalSorting.quickSort(numberList, 0, numberList.length - 1);
		Debug.log(TAG, "Sorted num using quick sort: "+ Debug.convertArrayNumToString(sortedList));*/
		
		String text = Debug.askStringInput(TAG, "Input text string: ");
		String pattern = Debug.askStringInput(TAG, "Input pattern to search for in " +text+": ");
		int[] lastIndices = StringFSM.getInstance().checkMatch(text, pattern);
		Debug.printIndices(TAG, "FSM", lastIndices);
		
		lastIndices = RabinKarpMatcher.getInstance().checkMatch(text, pattern);
		Debug.printIndices(TAG, "RabinKarp", lastIndices);
		
	}

}
