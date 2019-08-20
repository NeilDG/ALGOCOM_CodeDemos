package algocom_pe_test.p5_problems;

public class P5Code {
	
	
	public static void main (String [] args){
		///////////number 1///////////
//		String [] arr = {"A 10 30",
//						 "B 30 5",
//						 "C 5 60"};
		
//		String [] arr = {"A 4 10",
//						 "B 10 3",
//						 "C 3 12",
//						 "D 12 20",
//						 "E 20 7"};
		
//		String [] arr = {"A 40 20",
//		 "B 20 30",
//		 "C 30 10",
//		 "D 10 30"};
		
/////////IF KASAMA FIRST LINE:
		String [] arr = {"3",
						 "A 10 30",
		 				 "B 30 5",
		 				 "C 5 60"};

//		String [] arr = {"5", 
//						 "A 4 10",
//						 "B 10 3",
//						 "C 3 12",
//						 "D 12 20",
//						 "E 20 7"};
		
//		String [] arr = {"4",
//						 "A 40 20",
//						 "B 20 30",
//						 "C 30 10",
//						 "D 10 30"};
		assignTable(arr);

		///////////number 2///////////
		String [] partyInputs = {"50 10",
								 "12 3",
								 "15 8",
								 "16 9",
								 "16 6",
								 "10 2",
								 "21 9",
								 "18 4",
								 "12 4",
								 "17 8",
								 "18 9"};

//		String[] partyInputs = {"50 10",
//								"13 8",
//								"19 10",
//								"16 8",
//								"12 9",
//								"10 2",
//								"12 8",
//								"13 5",
//								"15 5",
//								"11 7",
//								"16 2"};
		
        partyBudget(partyInputs);
		
		///////////number 3///////////
//        int [] places = {25, 50, 75};
//        cut(100, 3, places);     

        int [] places = {4, 5, 7, 8};
        cut(10, 4, places);
        
	}
	
	////////////////////////////////number 1 code ////////////////////////////////
	public static void assignTable(String[] input) {
		//there will be N inputs. Each input is space-separated into A,B and C.
		//Read the input, parse and represent in your own preference.
		//your print statements here
		
//		int newArr [] = new int [input.length+1]; 
		int newArr [] = new int [input.length]; //IF KASAMA FIRST LINE:
		int ind = 0;
//		for (int i=0; i<input.length; i++){
		for (int i=1; i<input.length; i++){ //IF KASAMA FIRST LINE:
			String [] tempStr = input[i].split(" ");
//			System.out.println(tempStr[0]+"_"+tempStr[1]+"_"+tempStr[2]);
			
//			if (i==0) {
			if (i==1) { //IF KASAMA FIRST LINE:
				newArr[ind] = Integer.parseInt(tempStr[1]);
				ind++;
				newArr[ind] = Integer.parseInt(tempStr[2]);
				ind++;
//				System.out.print(Integer.parseInt(tempStr[1])+" "+Integer.parseInt(tempStr[2])+" ");
			}
			else {
				newArr[ind] = Integer.parseInt(tempStr[2]);
				ind++;
//				System.out.print(Integer.parseInt(tempStr[2])+" ");
			}
 		}
//		System.out.println();
		
		
		int n = newArr.length-1;
		int [][] mat = new int[n][n];
		int [][] store = new int[n][n];
		
		for (int i=0; i<n; i++) { 
			mat[i][i] = 0;
		}
		
		for (int row=1; row<n; row++) {
			for (int i=0; i<n-row; i++) { 
				int j = i + row;
				mat[i][j] = Integer.MAX_VALUE; //set to a large value
				for (int k=i; k<j; k++) {
					//calculate cost
					int cost = mat[i][k] + mat[k+1][j] + newArr[i] * newArr[k+1] * newArr[j+1];
					
					if (k == i) {
						mat[i][j] = cost;
						store[i][j] = k;
					} else if (k == i + 1) {
						if (mat[i][j]>cost) {
							mat[i][j] = cost;
							store[i][j] = k;
						}
					} else {
						if (cost<mat[i][j]) {
							mat[i][j] = cost;
							store[i][j] = k;
						}
					}
				}
			}
		}
		
		int parenCnt = 0;
		printOptParenthesis(store, 0, n-1, parenCnt);
		System.out.println();
	}
	
	static void printOptParenthesis(int [][]s, int i, int j, int cnt) { 
		if (i == j) {
			int a= 65+i;
			char c=(char)(a);			
			System.out.print(c+""); 
			cnt++;
		} else {			
			if (cnt==0){
				cnt++;
				printOptParenthesis(s, i, s[i][j], cnt);
				printOptParenthesis(s, s[i][j] + 1, j, cnt);			
			}
			else {
				cnt++;
				System.out.print("(");
				printOptParenthesis(s, i, s[i][j], cnt);
				printOptParenthesis(s, s[i][j] + 1, j, cnt);
				System.out.print(")");				
			}			
		}		
	} 

	////////////////////////////////number 2 code ////////////////////////////////
	public static void partyBudget(String[] inputs) {
		//there will be N inputs. Each input is space-separated into entrance fee, and fun rating.
		//Read the input, parse and represent in your own preference.
		//your print statements here 
		
		String [] tempArr1 = inputs[0].split(" ");
        int maximumCost = Integer.parseInt(tempArr1[0]);
        int numberOfParties = Integer.parseInt(tempArr1[1]);

        int[] funArray = new int[numberOfParties];
        int[] feeArray = new int[numberOfParties]; 

        for(int i=0; i<numberOfParties; i++) {
        	String [] tempArr2 = inputs[i+1].split(" ");
        	funArray[i] = Integer.parseInt(tempArr2[1]);
        	feeArray[i] = Integer.parseInt(tempArr2[0]);
        }
        
        int[][] M = new int[funArray.length+1][maximumCost+1];
        
        for (int i=1; i<=funArray.length; i++) {
        	for (int j=0; j<=maximumCost; j++) {
                if (feeArray[i-1]>j) {
                    M[i][j] = M[i-1][j];
                } else {
                	M[i][j] = Integer.max(M[i-1][j],
                    M[i-1][j-feeArray[i-1]] + funArray[i-1]);
                }
            }
        }

        int n = funArray.length;
        int res = M[n][maximumCost];
        int totalFees = 0;
        int mc = maximumCost;
        
        for (int i=n; i>0 && res>0; i--) {
        	if (!(res==M[i-1][mc])){
            	totalFees += feeArray[i-1];
                res = res-funArray[i-1];
                mc = mc - feeArray[i-1];
            }
        	else {
        		continue;
        	}
        }
        System.out.println(totalFees + " " + M[funArray.length][maximumCost]);
	}

	////////////////////////////////number 3 code ////////////////////////////////
	public static void cut (int l, int cuts, int[] places) {		
		int[] cutsPlaces = new int[cuts+2];
        for (int i=1; i<=cuts; i++) {
        	cutsPlaces[i] = places[i-1];
        }
        cutsPlaces[cuts+1] = l;
	
	    int matrix[][] = new int[cuts+2][cuts+2];
	    
	    for (int i=2; i<cutsPlaces.length; i++) {
	        for (int j=0; j<cutsPlaces.length-i; j++) {
	            int k = i+j;
	            int minCut = Integer.MAX_VALUE;
	            
	            for (int x=j+1; x<k; x++) {
	            	minCut = Math.min(minCut, matrix[j][x] + matrix[x][k]);
	            }	            
	            matrix[j][k] = minCut + cutsPlaces[k] - cutsPlaces[j];
	        }
	    }
	
	    System.out.println("The minimum cutting is "+matrix[0][cuts+1]);	
	}

}

