/**
 * 
 */
package algocom_pe_test.algocom_p2;

/**
 * Runner P2 for ALGOCOM
 * @author ERDT
 *
 */
public class RunnerP2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=========TEST # 1===========");
		
		P2_Program.analyze("Count me 1 2 3 4 5! Wow! I love ALGOCOM!");
		System.out.println();
		P2_Program.analyze("Hello World");
		System.out.println();
		P2_Program.analyze("Test test test");
		System.out.println();
		
		System.out.println("=========TEST # 2===========");

		int length = 4;
		int[] A = new int[] {4, 3, 2, 1};
		
		P2_Program.countSwaps(length, A);
		System.out.println();
		
		length = 1;
		A = new int[] {2};
		P2_Program.countSwaps(length, A);
		System.out.println();
		
		length = 4;
		A = new int[] {1, 2, 4, 3};
		P2_Program.countSwaps(length, A);
		System.out.println();
		
		System.out.println("=========TEST # 3===========");
		int numVillages = 5;
		int costToFeed = 500;
		int[] B = new int[] {100,0,300,100,100};
		P2_Program.checkHarvest(numVillages, costToFeed, B);
		System.out.println();
		
		numVillages = 6;
		costToFeed = 200;
		B = new int[] {200,200,400,400,0,0};
		P2_Program.checkHarvest(numVillages, costToFeed, B);
		System.out.println();
		
		numVillages = 5;
		costToFeed = 200;
		B = new int[] {1000,100,100,100,100};
		P2_Program.checkHarvest(numVillages, costToFeed, B);
		System.out.println();
		
		System.out.println("=========TEST # 4===========");
		P2_Program.printCombination(6, 4);
	}

}
