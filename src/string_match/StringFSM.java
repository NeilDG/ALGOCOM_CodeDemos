/**
 * 
 */
package string_match;

import java.util.LinkedList;

import utils.Debug;
import utils.InputConverter;

/**
 * Manager for the string matching FSM. Assume we only accept a P that do not have 
 * regular expressions such as * and +.
 * @author NeilDG
 *
 */
public class StringFSM implements IStringMatcher{
	private static String TAG = "StringFSM";
	
	private static StringFSM sharedInstance = null;
	public static StringFSM getInstance() {
		if(sharedInstance == null) {
			sharedInstance = new StringFSM();
		}
		return sharedInstance;
	}
	
	private LinkedList<FSMState> transitionList = new LinkedList<FSMState>();
	private FSMState currentState;
	
	
	private StringFSM() {
		
	}
	
	public int[] checkMatch(String text, String pattern) {
		this.buildFSM(pattern);
		
		FSMState initialState = this.currentState;
		LinkedList<Integer> indexList = new LinkedList<Integer>();
		
		//traverse the text and record the last index of the accepting state
		for(int i = 0; i < text.length(); i++) {
			if(this.currentState.hasTransition(text.charAt(i))) {
				this.currentState = this.currentState.getTransition();
				
				if(this.currentState.isAcceptingState()) {
					indexList.add(i + 1);
				}
			}
			else {
				this.currentState = initialState;
			}
		}
		
		//reset FSM
		this.transitionList.clear();
		this.currentState = null;
		return InputConverter.listToArray(indexList);
	}
	
	private void buildFSM(String pattern) {
		
		int numStates = pattern.length() + 1;
		//initialize all states first
		for(int i = 0; i < numStates; i++) {
			boolean accepting = (i == numStates - 1);
			FSMState state = new FSMState(i, accepting);
			this.transitionList.add(state);
		}
		
		this.currentState = this.transitionList.get(0);
		
		//create transitions by automatically connecting the previous state with the next state for every char found in P.
		int index = 0;
		for(int i = 1; i < this.transitionList.size(); i++) {
			FSMState state = this.transitionList.get(i - 1);
			FSMState nextState = this.transitionList.get(i);
			
			//Debug.log(TAG, "Created transition for char " +pattern.charAt(index));
			state.setTransition(nextState, pattern.charAt(index));
			index++;
		}
	}
}
