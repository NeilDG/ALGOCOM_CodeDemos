/**
 * 
 */
package string_match;

import java.util.LinkedList;

import utils.Debug;
import utils.InputConverter;

/**
 * String matching using Rabin-Karp algorithm
 * @author NeilDG
 *
 */
public class RabinKarpMatcher implements IStringMatcher {
	private final static String TAG = "RabinKarpMatcher";

	private static RabinKarpMatcher sharedInstance = null;
	public static RabinKarpMatcher getInstance() {
		if(sharedInstance == null) {
			sharedInstance = new RabinKarpMatcher();
		}
		return sharedInstance;
	}
	
	private RabinKarpMatcher() {
		
	}
	
	@Override
	public int[] checkMatch(String text, String pattern) {
		LinkedList<Integer> indicesList = new LinkedList<Integer>();
		
		int pLength = pattern.length();
		int n = text.length();

		int falsePositives = 0;
		for(int i = 0; i <= n - pLength; i++) {
			String subString = text.substring(i, i + pLength);
			
			//Debug.log(TAG, "Checking substring " +subString);
			//subString.hashCode() == pattern.hashCode()
			if(customHash(subString, 23) == customHash(pattern, 23)) {
				
				if(this.verify(subString, pattern)) {
					Debug.log(TAG, "Pattern occurs in T");
					indicesList.add(i + pLength);
				}
				else {
					Debug.log(TAG, "False positive! Substring " +subString+ " not the same as "+pattern);
					falsePositives++;
				}
				
			}
		}
		Debug.log(TAG, "False positives: " +falsePositives);
		return InputConverter.listToArray(indicesList);
	}
	
	private int customHash(String stringToHash, int prime) {
		int d = 256; //number of ASCII characters
		int hash = 1;
		 // Calculate the hash value of pattern and first
	    // window of text
		int M = stringToHash.length();
	    for (int i = 0; i < M; i++)
	    {
	        hash = (d*hash + stringToHash.charAt(i))%prime;
	    }
	    
	    return hash;
	}
	
	/*
	 * Verifies if the matched substring hashcode and the pattern hashcode is indeed the pattern we are looking fore
	 */
	private boolean verify(String subString, String pattern) {
		//input own string matching here. In this case, let's use FSM.
		//Debug.log(TAG, "Checking " +subString+ " with " +pattern);
		int[] indices = StringFSM.getInstance().checkMatch(subString, pattern);
		
		return (indices.length > 0);
	}
	
	
	
}
