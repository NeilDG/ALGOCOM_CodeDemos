package p5_problems;

public class P5_TestRunner {
	private final static String TAG = "P5_TestRunner";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P1Test();
		P2Test();
		P3Test();
	}
	
	private static void P1Test() {
		System.out.println("======P1 TEST BEGIN======");
		String[] input = new String[4];
		input[0] = "3";
		input[1] = "A 10 30";
		input[2] = "B 30 5";
		input[3] = "C 5 60";
		
		P5Code.assignTable(input);
		System.out.println();
		
		input = new String[6];
		input[0] = "5";
		input[1] = "A 4 10";
		input[2] = "B 10 3";
		input[3] = "C 3 12";
		input[4] = "D 12 20";
		input[5] = "E 20 7";
		
		P5Code.assignTable(input);
		System.out.println();
		
		input = new String[5];
		input[0] = "4";
		input[1] = "A 30 35";
		input[2] = "B 35 15";
		input[3] = "C 15 5";
		input[4] = "D 5 10";
		
		P5Code.assignTable(input);
		System.out.println();
		
		System.out.println();
	}
	
	private static void P2Test() {
		System.out.println("======P2 TEST BEGIN======");
		String[] input = new String[11];
		input[0] = "50 10";
		input[1] = "12 3";
		input[2] = "15 8";
		input[3] = "16 9";
		input[4] = "16 6";
		input[5] = "10 2";
		input[6] = "21 9";
		input[7] = "18 4";
		input[8] = "12 4";
		input[9] = "17 8";
		input[10] = "18 9";
		
		P5Code.partyBudget(input);
		System.out.println();
		
		input = new String[11];
		input[0] = "50 10";
		input[1] = "13 8";
		input[2] = "19 10";
		input[3] = "16 8";
		input[4] = "12 9";
		input[5] = "10 2";
		input[6] = "12 8";
		input[7] = "13 5";
		input[8] = "15 5";
		input[9] = "11 7";
		input[10] = "16 2";
		
		P5Code.partyBudget(input);
		System.out.println();
		
		input = new String[11];
		input[0] = "50 10";
		input[1] = "13 4";
		input[2] = "25 10";
		input[3] = "5 5";
		input[4] = "5 5";
		input[5] = "5 6";
		input[6] = "5 10";
		input[7] = "15 1";
		input[8] = "15 10";
		input[9] = "7 7";
		input[10] = "20 10";
		
		P5Code.partyBudget(input);
		System.out.println();
		
	}
	
	private static void P3Test() {
		
		System.out.println("======P3 TEST BEGIN======");
		int l = 100;
		int cuts = 3;
		int[] places = new int[]{25, 50, 75};
		
		P5Code.cut(l, cuts, places);
		
		l = 10;
		cuts = 4;
		places = new int[]{4, 5, 7, 8};
		
		P5Code.cut(l, cuts, places);
		
		l = 40;
		cuts = 5;
		places = new int[]{5, 10, 15, 20, 25};
		
		P5Code.cut(l, cuts, places);
	}

}
