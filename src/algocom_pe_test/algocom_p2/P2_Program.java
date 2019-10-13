package algocom_pe_test.algocom_p2;
/*
 * Ronn Christian C. Chua Chiaco
 * PE2
 * CSALGCM S16
 *
 */
import java.util.*;

public class P2_Program {


	//#1
    public static void analyze (String input)
    {
    	class listelem {
    		public char ch;
    		public int count;

    		listelem (char c, int n)
    		{
    			ch = c;
    			count = n;
    		}
    	}

    	int charctr, printctr, ctr, index;
    	ArrayList<listelem> list = new ArrayList<>();
    	input = input.trim();
    	input = input.toUpperCase();

		for (ctr = 0; ctr < 26; ctr++)
			list.add(new listelem('?', 0));

    	for (charctr = 0; charctr < input.length(); charctr++)
    	{
			if (Character.isLetter(input.charAt(charctr)) == true)
			{
				index = (int)input.charAt(charctr) - 65;
				if (list.get(index).count == 0)
					list.get(index).ch = input.charAt(charctr);

				list.get(index).count++;
			}
    	}

		Collections.sort(list, new Comparator<listelem>()
		{
			@Override
			public int compare(listelem elem1, listelem elem2)
			{
				char ch1 = elem1.ch, ch2 = elem2.ch;
				int num1 = elem1.count, num2 = elem2.count;
				int comp;

				comp = Integer.valueOf(num1).compareTo(Integer.valueOf(num2));
				if (comp == 0)
				{
					comp = Character.valueOf(ch1).compareTo(Character.valueOf(ch2));
					if (comp > 0)
						comp = -1;
					else if (comp < 0)
						comp = 1;
				}

				return comp;
			}
		});

		for (printctr = list.size()-1; printctr > 0; printctr--)
			if (list.get(printctr).count != 0)
				System.out.println(list.get(printctr).ch + " " + list.get(printctr).count);
    }

    //#2
    public static void countSwaps (int length, int[] carriageNumbers)
    {
		int i, j, temp, sorts = 0;

		for (i = 0; i < length-1; i++)
			for (j = 0; j < length-i-1; j++)
				if (carriageNumbers[j] > carriageNumbers[j+1])
				{
					temp = carriageNumbers[j];
					carriageNumbers[j] = carriageNumbers[j+1];
					carriageNumbers[j+1] = temp;
					sorts++;
				}

		System.out.println ("The most optimal train swaps: " + sorts);
    }

    //#3
    public static void checkHarvest (int numVillages, int costToFeed, int[] harvests)
    {
    	int totalFeed = numVillages * costToFeed, totalHarvest = 0, ctr;
    	String text = new String();

    	for (ctr = 0; ctr < numVillages; ctr++)
    		totalHarvest += harvests[ctr];

    	if (totalFeed > totalHarvest)
    		text = "NOT ENOUGH FOOD";
    	else if (totalFeed == totalHarvest)
    		text = "JUST ENOUGH FOR EVERYONE";
    	else
    		text = "PARTY!";

    	System.out.println (text);
    }

    //#4
    public static void printCombination (int N, int K)
    {
    	int ctr;
    	int combination[] = new int[K], nums[] = new int[N];

    	for (ctr = 1; ctr <= N; ctr++)
    		nums[ctr - 1] = ctr;

		makeCombination (nums, combination, 0, N-1, 0, K);
    }

    public static void makeCombination (int nums[], int combination[], int start, int end, int ind, int K)
    {
        if (ind == K)
        {
            for (int j=0; j<K; j++)
                System.out.print(combination[j] + " ");

            System.out.println("");
            return;
        }

        for (int i=start; i<=end && end-i+1 >= K-ind; i++)
        {
            combination[ind] = nums[i];
            makeCombination(nums, combination, i+1, end, ind+1, K);
        }
    }
}