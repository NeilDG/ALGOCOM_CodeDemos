package algocom_pe_test;

public class MainRunner {

	public static void main(String[] args) {
		
		//#1
		String str = "Test test test!";
		ProgExer2.analyze(str);
		
		//#2
		int trainLength = 4;
		int A[]= {1,2,4,3};
		ProgExer2.countSwaps(4, A);
		
		//#3
		int harvests[]= {200,200,400,400,0,0};
		int numVillage = 6;
		int costToFeed = 200;
		ProgExer2.checkharvest(numVillage, costToFeed, harvests);
		
		//#4
		ProgExer2.printCombination(6, 4);
	}

}
