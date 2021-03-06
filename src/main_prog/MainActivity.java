/**
 * 
 */
package main_prog;

import problems.Cryptanalysis;
import problems.Dialpad;
import problems.Intersection;
import problems.Intersection.SolutionType;
import string_match.BoyerMooreMatcher;
import string_match.BruteForceMatcher;
import string_match.KMPMatcher;
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
		
		/*char x = 'c';
		switch(x) {
			case 'c': Debug.log(TAG, "Test switch"); break;
		}*/
		
		/*String myString = Debug.askStringInput(TAG, "Input numbers separated by spaces: ");
		int[] numberList = InputConverter.convertStringToArrayInt(myString);
		int index = ClassicalSorting.binarySearch(numberList, 8, 0, numberList.length - 1);
		Debug.log(TAG, "Value is found. Index: " +index);*/
		
		
		//BranchPredictionTest.randomlySortedTest();
		//BranchPredictionTest.sortedTest();
		
		//CmpilerTests test = new CmpilerTests();
		//test.varTest();
		//test.arrayTest();
		//test.arrayTest2();		
		//int x = 127;
		//Debug.log("Number of 7's: " +test.count7(x));
		
		//merge sort
		/*String myString = Debug.askStringInput(TAG, "Input numbers separated by spaces: ");
		int[] numberList = InputConverter.convertStringToArrayInt(myString);
		int[] sortedList = ClassicalSorting.mergeSort(numberList);
		//ClassicalSorting.mergeSort2(numberList, 0, numberList.length - 1);
		Debug.log(TAG, "Sorted num using merge sort: "+ Debug.convertArrayNumToString(sortedList));
		Debug.log(TAG, "Divide steps: "+ MergeSortCounter.getInstance().divideCounter+ " Conquer steps: " +MergeSortCounter.getInstance().conquerCounter);*/
		
		//quick sort
		/*numberList = InputConverter.convertStringToArrayInt(myString);
		sortedList = ClassicalSorting.quickSort(numberList, 0, numberList.length - 1);
		Debug.log(TAG, "Sorted num using quick sort: "+ Debug.convertArrayNumToString(sortedList));*/
		
		String text = Debug.askStringInput(TAG, "Input text string: ");
		String pattern = Debug.askStringInput(TAG, "Input pattern to search for in " +text+": ");
		//int[] lastIndices = StringFSM.getInstance().checkMatch(text, pattern);
		//Debug.printIndices(TAG, "FSM", lastIndices);
		
		int[] lastIndices = RabinKarpMatcher.getInstance().checkMatch(text, pattern);
		Debug.printIndices(TAG, "RabinKarp", lastIndices);
		
		//lastIndices = BoyerMooreMatcher.getInstance().checkMatch(text, pattern);
		//Debug.printIndices(TAG, "BoyerMoore", lastIndices);
		
		//lastIndices = BruteForceMatcher.getInstance().checkMatch(text, pattern);
		//Debug.printIndices(TAG, "BruteForce", lastIndices);
		
		//KMPMatcher.getInstance().KMPSearch(pattern, text);
		
		//String text = Debug.askStringInput(TAG, "Input text string: ");
		//Dialpad.getNumKeystrokes(text);
		//Dialpad.hashKeystrokes(text);
		//Cryptanalysis.analyze(text);
		
		/*String myString = Debug.askStringInput(TAG, "Input numbers separated by spaces for list A: ");
		int[] A = InputConverter.convertStringToArrayInt(myString);
		
		myString = Debug.askStringInput(TAG, "Input numbers separated by spaces for list B: ");
		int[] B = InputConverter.convertStringToArrayInt(myString);
		Intersection.findIntersection(A, B, SolutionType.BRUTE_FORCE);
		Intersection.findIntersection(A, B, SolutionType.HASHING);
		Intersection.findIntersection(A, B, SolutionType.HASHING_WITH_DUPLICATES);*/
	}

}
