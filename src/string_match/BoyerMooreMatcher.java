/**
 * 
 */
package string_match;

import java.util.LinkedList;

import utils.Debug;
import utils.InputConverter;

/**
 * String matching using boyer-moore
 * @author NeilDG
 *
 */
public class BoyerMooreMatcher implements IStringMatcher {
	private final static String TAG = "BoyerMooreMatcher";
	
	private static BoyerMooreMatcher sharedInstance = null;
	public static BoyerMooreMatcher getInstance() {
		if(sharedInstance == null) {
			sharedInstance = new BoyerMooreMatcher();
		}
		
		return sharedInstance;
	}
	
	private final int NUM_CHARS = 256; //number of ASCII chars
	private BoyerMooreMatcher() {
		
	}
	
	// A utility function to get maximum of two integers
	private int max (int a, int b) { 
		if(a > b) {
			return a;
		}
		else {
			return b;
		}
	}
	
	private int[] generateBadCharHeur(String pattern) {
		int[] badCharArr = new int[NUM_CHARS];
		
		for(int i = 0; i < badCharArr.length; i++) {
			badCharArr[i] = -1;
		}
		
		// Fill the actual value of last occurrence 
	    // of a character
	    for (int i = 0; i < pattern.length(); i++) {
	         badCharArr[(int) pattern.charAt(i)] = i;
	    }
	    
	    return badCharArr;
	}
	
	public int[] checkMatch(String text, String pattern) {
		LinkedList<Integer> indicesList = new LinkedList<Integer>();
		
		int compares = 0;
		int M = pattern.length();
		int N = text.length();
		int[] badCharArr = this.generateBadCharHeur(pattern);
		
		 int s = 0;  // s is shift of the pattern with 
         // respect to text
		while(s <= (N - M))
		{
		 int j = M - 1;
		
		 /* Keep reducing index j of pattern while 
		    characters of pattern and text are 
		    matching at this shift s */
		 while(j >= 0 && pattern.charAt(j) == text.charAt(s+j)) {
		     j--;
		     compares++;
		 }
		
		 /* If the pattern is present at current
		    shift, then index j will become -1 after
		    the above loop */
		 if (j < 0)
		 {
		     //Debug.log(TAG, "\n pattern occurs at shift = " +s);
		     indicesList.add(s + M);
		     /* Shift the pattern so that the next 
		        character in text aligns with the last 
		        occurrence of it in pattern.
		        The condition s+m < n is necessary for 
		        the case when pattern occurs at the end 
		        of text */
		     s += (s +M < N) ? M - badCharArr[text.charAt(s + M)] : 1;
		     
		     compares++;

		 }
		
		 else
		     /* Shift the pattern so that the bad character
		        in text aligns with the last occurrence of
		        it in pattern. The max function is used to
		        make sure that we get a positive shift. 
		        We may get a negative shift if the last 
		        occurrence  of bad character in pattern
		        is on the right side of the current 
		        character. */
		     s += max(1, j - badCharArr[text.charAt(s + j)]);
		}
		
	    Debug.log("Char comparisons for BM: " +compares);
		return InputConverter.listToArray(indicesList);
	}
}
