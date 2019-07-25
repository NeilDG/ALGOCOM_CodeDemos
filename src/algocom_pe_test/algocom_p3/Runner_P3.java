package algocom_pe_test.algocom_p3;

public class Runner_P3 {
	
	/*public static class Building {
		  public int left;  //the left X-coordinate
		  public int right; //the right X-coordinate
		  public int height; //the height
		  
		  public Building(int left, int right, int height) {
			  this.left = left;
			  this.right = right;
			  this.height = height;
		  }
	}
	
	public static class Pt {
		  public int x;  //X-coordinate
		  public int y; // Y-coordinate
		  
		  public Pt(int x, int y) {
			  this.x = x; 
			  this.y = y;
		  }
	}*/
	
	public static void main(String[] args) {
		
		//#1
		P3_Program.Building[] B = new P3_Program.Building[10];
		B[0] = new P3_Program.Building(); B[0].left = 1; B[0].height = 11; B[0].right = 5;
		B[1] = new P3_Program.Building(); B[1].left = 2; B[1].height = 6; B[1].right = 7;
		B[2] = new P3_Program.Building(); B[2].left = 3; B[2].height = 13; B[2].right = 9;
		B[3] = new P3_Program.Building(); B[3].left = 12; B[3].height = 7; B[3].right = 16;
		B[4] = new P3_Program.Building(); B[4].left = 14; B[4].height = 3; B[4].right = 25;
		B[5] = new P3_Program.Building(); B[5].left = 19; B[5].height = 18; B[5].right = 22;
		B[6] = new P3_Program.Building(); B[6].left = 23; B[6].height = 13; B[6].right = 29;
		B[7] = new P3_Program.Building(); B[7].left = 24; B[7].height = 4; B[7].right = 28;
		B[8] = new P3_Program.Building(); B[8].left = 25; B[8].height = 2; B[8].right = 29;
		B[9] = new P3_Program.Building(); B[9].left = 26; B[9].height = 21; B[9].right = 32;
		
		P3_Program.skyline(B);
		
		System.out.println("==========================");
		System.out.println();
		
		int[] A = new int[] {9,8,7,6,2,2,0};
		P3_Program.mergesort(A);
		
		System.out.println("==========================");
		System.out.println();
		
		P3_Program.Pt[] P = new P3_Program.Pt[8];
		P[0] = new P3_Program.Pt(); P[0].x = 1; P[0].y = 1;
		P[1] = new P3_Program.Pt(); P[1].x = 14; P[1].y = 2;
		P[2] = new P3_Program.Pt(); P[2].x = 8; P[2].y = 7;
		P[3] = new P3_Program.Pt(); P[3].x = 2; P[3].y = 2;
		P[4] = new P3_Program.Pt(); P[4].x = 9; P[4].y = 2;
		P[5] = new P3_Program.Pt(); P[5].x = 16; P[5].y = 12;
		P[6] = new P3_Program.Pt(); P[6].x = 7; P[6].y = 4;
		P[7] = new P3_Program.Pt(); P[7].x = 34; P[7].y = 53;
		
		P3_Program.closestPair(P);
	}
}
