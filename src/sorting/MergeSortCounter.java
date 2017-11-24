package sorting;

public class MergeSortCounter {
	private static MergeSortCounter sharedInstance = null;
	public static MergeSortCounter getInstance() {
		if(sharedInstance == null) {
			sharedInstance = new MergeSortCounter();
		}
		return sharedInstance;
	}
	
	public int divideCounter = 0;
	public int conquerCounter = 0;
}
