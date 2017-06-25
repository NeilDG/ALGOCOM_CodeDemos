/**
 * 
 */
package string_match;

/**
 * Representation of an FSM state
 * @author NeilDG
 *
 */
public class FSMState {
	private final static String TAG = "FSMState";
	
	private int id;
	private boolean acceptingState;
	
	private char match; //the corresponding match to make the transition
	private FSMState nextState;
	
	public FSMState(int id, boolean acceptingState) {
		this.id = id;
		this.acceptingState = acceptingState;
	}
	
	public void setTransition(FSMState nextState, char match) {
		this.nextState = nextState;
		this.match = match;
	}
	
	public boolean hasTransition(char match) {
		return this.match == match;
	}
	
	public FSMState getTransition() {
		return this.nextState;
	}
	
	public int getID() {
		return this.id;
	}
	
	public boolean isAcceptingState() {
		return this.acceptingState;
	}

}
