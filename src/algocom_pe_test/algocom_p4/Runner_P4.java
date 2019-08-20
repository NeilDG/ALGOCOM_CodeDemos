/**
 * 
 */
package algocom_pe_test.algocom_p4;

/**
 * @author delgallegon
 *
 */
public class Runner_P4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = new String[3];
		input[0] = "4 5";
		input[1] = "4 5 3 5";
		input[2] = "3 5 2 6 4";
		
		P4_Program.assignTable(input);
		System.out.println();
		
		input = new String[3];
		input[0] = "6 6";
		input[1] = "3 4 5 5 5 2";
		input[2] = "4 4 4 4 4 4";
		
		P4_Program.assignTable(input);
		System.out.println();
		
		input = new String[3];
		input[0] = "4 5";
		input[1] = "5 4 3 3";
		input[2] = "3 3 3 4 5";
		
		P4_Program.assignTable(input);
		System.out.println();
		System.out.println("========================");
		
		int[] jobTime = {1, 2, 100, 45, 5};
		int[] fine = {350, 55, 25, 5, 15};
		
		P4_Program.shoemaker(jobTime, fine);
		System.out.println();
		System.out.println("========================");
		
		int[] floors = {8, -11, -9, 2, 5, 18, -17, -15, 4};
		P4_Program.design(floors);
		System.out.println();
		System.out.println("========================");
	}

}
