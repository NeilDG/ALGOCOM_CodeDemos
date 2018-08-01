package string_match;

import java.util.LinkedList;

import utils.Debug;
import utils.InputConverter;

public class BruteForceMatcher implements IStringMatcher {

	private static BruteForceMatcher sharedInstance = null;
	public static BruteForceMatcher getInstance() {
		if(sharedInstance == null) {
			sharedInstance = new BruteForceMatcher();
		}
		return sharedInstance;
	}
	
	@Override
		public int[] checkMatch(String text, String pattern) {
		
			LinkedList<Integer> indicesList = new LinkedList<Integer>();
			// TODO Auto-generated method stub
			int length = text.length();//length of the text
			int plength = pattern.length();//length of the pattern;
			int compares = 0;

			//loop condition
			for(int i=0;i<length-plength;i++){
				//initialization of j
				int j=0;
				while((j < plength) && (text.charAt(i+j) == pattern.charAt(j))){
					j++;
					compares++;
				}
				if(j == plength){
					indicesList.add(i);
				}
			}
			Debug.log("Char comparisons for BruteForce: " +compares);
			return InputConverter.listToArray(indicesList);
		}
}
