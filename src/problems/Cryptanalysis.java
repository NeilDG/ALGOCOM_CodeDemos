/**
 * 
 */
package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

import problems.Cryptanalysis.LetterTally;
import utils.Debug;

/**
 * 
 * @author NeilDG
 *
 */
public class Cryptanalysis {
	private final static String TAG = "Cryptanalysis";
	
	public static void analyze(String input) {
		Hashtable<Character, LetterTally> letterHash = new Hashtable<Character, LetterTally>();
		
		for(int i = 0; i < input.length(); i++) {
			char letter = Character.toUpperCase(input.charAt(i));
			if(Character.isLetter(letter) && !letterHash.containsKey(letter)) {
				letterHash.put(letter, new LetterTally(letter, 1));
			}
			else if(Character.isLetter(letter) && letterHash.containsKey(letter)) {
				letterHash.get(letter).tally++;
			}
		}
		
		LetterTally[] letters = letterHash.values().toArray(new LetterTally[letterHash.size()]);
		List<LetterTally> letterList = Arrays.asList(letters);
		Collections.sort(letterList, new LetterTallyCompare());
		letters = letterList.toArray(new LetterTally[letterHash.size()]);
		for(int i = 0; i < letters.length; i++) {
			Debug.log(letters[i].letter + " " +letters[i].tally);
		}
	}
	
	public static class LetterTallyCompare implements Comparator<LetterTally> {
		public int compare(LetterTally a, LetterTally b)
	    {
	        return b.tally - a.tally;
	    }
	}
	
	public static class LetterTally {
		public char letter;
		public int tally;
		
		public LetterTally(char letter, int tally) {
			this.letter = Character.toUpperCase(letter);
			this.tally = tally;
		}
	}
}
