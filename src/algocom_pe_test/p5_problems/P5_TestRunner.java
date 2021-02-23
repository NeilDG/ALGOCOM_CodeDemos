package algocom_pe_test.p5_problems;

public class P5_TestRunner {
	private final static String TAG = "P5_TestRunner";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//P1Test();
		//P2Test();
		P3Test();
	}
	
	private static void P1Test() {
		System.out.println("======P1 TEST BEGIN======");
		String[] input = new String[6];
		input[0] = "5";
		input[1] = "A 3 4";
		input[2] = "B 4 5";
		input[3] = "C 5 20";
		input[4] = "D 20 60";
		input[5] = "E 60 25";
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		
		P5Code.assignTable(input);
		System.out.println();
		
		input = new String[6];
		input[0] = "5";
		input[1] = "A 100 500";
		input[2] = "B 500 325";
		input[3] = "C 325 700";
		input[4] = "D 700 100";
		input[5] = "E 100 500";
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		
		P5Code.assignTable(input);
		System.out.println();
		
		input = new String[8];
		input[0] = "7";
		input[1] = "A 15 35";
		input[2] = "B 35 15";
		input[3] = "C 15 15";
		input[4] = "D 15 20";
		input[5] = "E 20 5";
		input[6] = "F 5 35";
		input[7] = "G 35 5";
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		
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
		input[5] = "11 2";
		input[6] = "21 9";
		input[7] = "18 8";
		input[8] = "12 14";
		input[9] = "17 38";
		input[10] = "18 9";
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		System.out.println();
		P5Code.partyBudget(input);
		System.out.println();
		
		input = new String[15];
		input[0] = "220 14";
		input[1] = "1 15";
		input[2] = "200 10";
		input[3] = "160 16";
		input[4] = "82 9";
		input[5] = "1 2";
		input[6] = "12 8";
		input[7] = "14 3";
		input[8] = "15 3";
		input[9] = "11 7";
		input[10] = "2 2";
		input[11] = "5 5";
		input[12] = "6 5";
		input[13] = "7 7";
		input[14] = "8 2";
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		System.out.println();
		P5Code.partyBudget(input);
		System.out.println();
		
		input = new String[11];
		input[0] = "100 10";
		input[1] = "99 99";
		input[2] = "98 98";
		input[3] = "97 97";
		input[4] = "96 96";
		input[5] = "95 95";
		input[6] = "94 94";
		input[7] = "93 93";
		input[8] = "92 92";
		input[9] = "91 91";
		input[10] = "90 90";
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		System.out.println();
		P5Code.partyBudget(input);
		System.out.println();
		
	}
	
	private static void P3Test() {
		
		System.out.println("======P3 TEST BEGIN======");
		int l = 500;
		int cuts = 10;
		int[] places = new int[]{25, 50, 75, 80, 85, 200, 250, 400, 495, 499};
		
		P5Code.cut(l, cuts, places);
		
		l = 50;
		cuts = 10;
		places = new int[]{1, 2, 3, 4, 5, 40, 45, 46, 47, 50};
		
		P5Code.cut(l, cuts, places);
		
		l = 1000;
		cuts = 5;
		places = new int[]{100, 200, 555, 750, 957};
		
		P5Code.cut(l, cuts, places);
	}

}
