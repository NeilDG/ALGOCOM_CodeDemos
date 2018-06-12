package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import utils.Debug;
import utils.InputConverter;

/**
 * 
 * @author NeilDG
 *
 */
public class Intersection {
	private final static String TAG = "Intersection";
	
	public enum SolutionType {
		BRUTE_FORCE,
		HASHING,
		HASHING_WITH_DUPLICATES
	}
	
	public static void findIntersection(int[] A, int[] B, SolutionType solutionType) {
		if(solutionType == SolutionType.BRUTE_FORCE) {
			bfIntersection(A, B);
		}
		else if(solutionType == SolutionType.HASHING) {
			hashIntersection(A, B);
		}
		else {
			hashIntersectionDuplicate(A, B);
		}
	}
	
	//brute-force. can handle duplicates due to break statement.
	private static void bfIntersection(int[] A, int[] B) {
		LinkedList<Integer> intersection = new LinkedList<Integer>();
		for(int i = 0; i <  A.length; i++) {
			for(int j = 0; j < B.length; j++) {
				if(A[i] == B[j]) {
					intersection.add(B[j]);
					break;
				}
			}
		}
		
		int[] intersectArr = InputConverter.listToArray(intersection);
		Debug.log(TAG, "Intersection: " +Debug.convertArrayNumToString(intersectArr));
		
	}
	
	//cannot handle duplicates
	private static void hashIntersection(int[] A, int[] B) {
		LinkedList<Integer> intersection = new LinkedList<Integer>();
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < A.length; i++) {
			hashMap.put(A[i], A[i]);
		}
		
		for(int i = 0; i < B.length; i++) {
			if(hashMap.containsKey(B[i])) {
				intersection.add(B[i]);
			}
		}
		
		int[] intersectArr = InputConverter.listToArray(intersection);
		Debug.log(TAG, "Intersection: " +Debug.convertArrayNumToString(intersectArr));
	}
	
	//can handle duplicates
	private static void hashIntersectionDuplicate(int[] A, int[] B) {
		LinkedList<Integer> intersection = new LinkedList<Integer>();
		HashMap<Integer, NumberInfo> hashMap = new HashMap<Integer, NumberInfo>();
		
		for(int i = 0; i < A.length; i++) {
			if(!hashMap.containsKey(A[i])) {
				NumberInfo numberInfo = new NumberInfo(A[i], 1);
				hashMap.put(A[i], numberInfo);
			}
			else {
				hashMap.get(A[i]).counter++;
			}
		}
		
		for(int i = 0; i < B.length; i++) {
			if(hashMap.containsKey(B[i]) && hashMap.get(B[i]).counter > 0) {
				intersection.add(B[i]);
				hashMap.get(B[i]).counter--;
			}
		}
		
		int[] intersectArr = InputConverter.listToArray(intersection);
		Debug.log(TAG, "Intersection: " +Debug.convertArrayNumToString(intersectArr));
	}
	
	private static class NumberInfo {
		public int number;
		public int counter = 0;
		
		public NumberInfo(int number, int counter) {
			this.number = number;
			this.counter = counter;
		}
	}
}
