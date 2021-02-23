package algocom_pe_test.p5_problems;

public class P5Code {
	public static void assignTable(String[] input) {
        int numOfMatrix = Integer.parseInt(input[0]);
        int table [] = new int [numOfMatrix+1];
        int ctr = 0;
        for (int i=0; i<numOfMatrix; i++){
            String [] inputCut = input[i+1].split(" ");
//			System.out.println(inputCut[0]+"_"+inputCut[1]+"_"+inputCut[2]);

            if (i==0){
                table[ctr] = Integer.parseInt(inputCut[1]);
                ctr++;
                table[ctr] = Integer.parseInt(inputCut[2]);
                ctr++;
//                System.out.print(Integer.parseInt(inputCut[1])+" "+Integer.parseInt(inputCut[2])+" ");
            }
            else {
                table[ctr] = Integer.parseInt(inputCut[2]);
                ctr++;
//                System.out.print(Integer.parseInt(inputCut[2])+" ");
            }
        }

//        System.out.println();


        int n = table.length-1;
        int [][] m = new int[n][n];
        int [][] s = new int[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        for (int row = 1; row < n; row++) {
            for (int i = 0; i < n - row; i++) {
                int j = i + row;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + table[i]* table[k + 1] * table[j + 1];
                    if (k == i) {
                        m[i][j] = q;
                        s[i][j] = k;
                    } 	else if (k == i + 1) {
                        if (m[i][j] > q) {
                            m[i][j] = q;
                            s[i][j] = k;
                        }
                    } else {
                        if (q < m[i][j]) {
                            m[i][j] = q;
                            s[i][j] = k;
                        }
                    }
                }

                if (row == table.length - 2) {
//                    System.out.println("\nOptimal Cost is : " + m[i][j]);
                }
            }
        }

        int startPrint = 0;
        printParenthesis(s, 0, n-1, startPrint);
        System.out.println();
//        System.out.println();
    }

    static void printParenthesis(int [][]s, int i, int j, int ctr) {
        if (i == j) {
            int a= 65+i;
            char c=(char)(a);
            System.out.print(c+"");
            ctr++;
        } else {
            if (ctr==0){
                ctr++;
                printParenthesis(s, i, s[i][j], ctr);
                printParenthesis(s, s[i][j] + 1, j, ctr);
            }
            else {
                ctr++;
                System.out.print("(");
                printParenthesis(s, i, s[i][j], ctr);
                printParenthesis(s, s[i][j] + 1, j, ctr);
                System.out.print(")");
            }
        }

    }


    public static void partyBudget(String[] inputs) {

        int maxCost = Integer.parseInt(inputs[0].split(" ")[0]);
        int numParties = Integer.parseInt(inputs[0].split(" ")[1]);

//        System.out.println(maxCost);
//        System.out.println(numParties);

        int[] funArr = new int[numParties]; // v
        int[] costArr = new int[numParties]; // w

        for(int i=0; i<numParties; i++){
            int cost = Integer.parseInt(inputs[i+1].split(" ")[0]);
            int fun = Integer.parseInt(inputs[i+1].split(" ")[1]);
//            System.out.println(cost + " - " + fun);

            funArr[i] = fun;
            costArr[i] = cost;
        }
        knapSack(funArr, costArr, maxCost);
    }

    public static void knapSack(int[] funArr, int[] costArr, int W)
    {

        int numParties = funArr.length;
        int[][] Table = new int[funArr.length + 1][W + 1];

        for (int i = 1; i <= funArr.length; i++)
        {
            for (int j = 0; j <= W; j++)
            {

//                System.out.println("I = " + i + " J = " + j); // indexes
//                System.out.println(costArr[i-1] + " > " + j); // checking cost of
                if (costArr[i-1] > j) {
//                    System.out.println("Table[i-1][j] = " + Table[i-1][j]);
                    Table[i][j] = Table[i-1][j];
                } else {
//                    System.out.println("Table[i][j] = " + Integer.max(Table[i-1][j], Table[i-1][j-costArr[i-1]] + funArr[i-1]));
//                    System.out.println("Get max of " + Table[i-1][j] + " or " + Table[i-1][j-costArr[i-1]] + funArr[i-1]);
                    Table[i][j] = Integer.max(Table[i-1][j],
                            Table[i-1][j-costArr[i-1]] + funArr[i-1]);
                }
//                System.out.println();
            }
        }

        int total = Table[numParties][W];
//        System.out.println(total);
        int totalCost = 0;
        int w = W;
        for (int i = numParties; i > 0 && total > 0; i--) {

//            System.out.println("i = " + i + " w = " + w + " |||| Res = " + res + " T[i-1][w] = " + T[i - 1][w]);

            if (total == Table[i - 1][w]) {

            }
            else {
//                System.out.println(costArr[i - 1] + " ");
                totalCost += costArr[i-1];

//                System.out.println(costArr[i-1]  + " " + funArr[i-1] );
                total = total - funArr[i - 1];
                w = w - costArr[i - 1];
            }
        }
//
//        System.out.println();
//        System.out.println();

//        for (int i = 1; i <= funArr.length; i++) {
//            // consider all weights from 0 to maximum capacity W
//            for (int j = 0; j <= W; j++) {
//                System.out.print(T[i][j] + "    ");
//            }
//            System.out.print("  I = " + i);
//
//            System.out.println();
//
//        }
//        System.out.println("-------------------------------------------------");
//        for (int i=0; i<=W; i++){
//            System.out.print(i);
//            if(i < 10)
//                System.out.print("    ");
//            else if(i< 25)
//                System.out.print("   ");
//            else
//                System.out.print("    ");
//
//        }


//        System.out.println();
//        System.out.println();
//        System.out.println();
        System.out.println(totalCost + " " + Table[funArr.length][W]);
    }


    public static void cut (int l, int cuts, int[] places) {

        int[] whereToCut = new int[cuts+2];
            for (int i = 1; i <= cuts; i++)
                whereToCut[i] = places[i-1];
        whereToCut[cuts + 1] = l;


        int m[][] = new int[cuts + 2][cuts + 2];

        for (int z = 2; z < whereToCut.length; z++) {
            for (int i = 0; i < whereToCut.length - z; i++) {
                int j = z + i;

                int cutMin = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++)
                    cutMin = Math.min(cutMin, m[i][k] + m[k][j]);

                m[i][j] = cutMin + whereToCut[j] - whereToCut[i];
            }
        }

        System.out.println("The minimum cutting is " + m[0][cuts + 1]);

//        for (int i=0; i<cuts+2; i++){
//            for (int j=0; j< cuts+2; j++){
//                System.out.print(m[i][j] + "    ");
//            }
//            System.out.println();
//        }


    }

}

