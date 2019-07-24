package algocom_pe_test;

public class MainRunner {

	public static void main(String[] args) {
		
		//#1
		String str = "Hello world!";
		Program.analyze(str);
		
		System.out.println("==========================");
		System.out.println();
		
		//#2
		int trainLength = 4;
		int A[]= {1,2,4,3};
		Program.countSwaps(trainLength, A);
		
		System.out.println("==========================");
		System.out.println();
		
		//#3
		int harvests[]= {200,200,400,400,0,0};
		int numVillage = 6;
		int costToFeed = 200;
		Program.checkHarvest(numVillage, costToFeed, harvests);
		
		System.out.println("==========================");
		System.out.println();
		
		//#4
		Program.printCombination(6, 4);
	}

}
