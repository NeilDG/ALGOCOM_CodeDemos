package algocom_pe_test.algocom_p2;
import java.util.*;

public class P2_Program
{
    public static void analyze (String input)
    {
        ArrayList<Integer> value = new ArrayList<>();
        int index = 0;
        int temp = 0;
        char[] letters = (input.toUpperCase()).toCharArray();

        for (int i = 0; i < 26; i++)
            value.add(0);
        
        for (int i = 0; i < letters.length; i++){
            if (Character.isLetter(letters[i])){
                index = letters[i] - 65;
                temp = value.get(index);
                temp ++;
                value.set(index, temp);
            }
        }

        int mode = 0;
        for (int i= 1; i < value.size(); i++)
            if (value.get(mode) < value.get(i))
                mode = i;
        
        int count = value.get(mode);

        while (count != 0){
            for (int i = 0; i < value.size(); i++)
                if (value.get(i) == count)
                    System.out.println ((char)(i+65) + " " + value.get(i));
            count -- ;
        }
    }

    public static void countSwaps (int length, int[] carraigeNumbers)
    {
        int count = 0;
        int temp;
        for (int i = 0; i < length-1; i++){
            for (int j = 0; j < length - i - 1; j++){
                if (carraigeNumbers[j] > carraigeNumbers[j+1]){
                    temp = carraigeNumbers[j];
                    carraigeNumbers[j] = carraigeNumbers[j+1];
                    carraigeNumbers[j+1] = temp;
                    count++;
                }
            }
        }

        System.out.println ("The most optimal train swaps: " + count);
    }

    public static void checkHarvest (int numVillages, int costToFeed, int[] harvests)
    {
        int demand = numVillages * costToFeed;
        int supply = 0;

        for (int i = 0; i < numVillages; i++)
            supply += harvests[i];
        
        if (demand == supply)
            System.out.println ("JUST ENOUGH FOR EVERYONE");
        else if (demand < supply)
            System.out.println ("PARTY!");
        else if (demand > supply)
            System.out.println ("NOT ENOUGH FOOD");
    }

    public static void printCombination(int N, int K) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> perLine = new ArrayList<>();

        combination(N,K,1, perLine, result);

        for (int i = 0; i < result.size(); i++){
            ArrayList<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++){
                System.out.print (list.get(j) + " ");
            }
            System.out.println ();
        }
    }

    private static void combination (int N, int K, int start, ArrayList<Integer> perLine, ArrayList<ArrayList<Integer>> result) {
        if(perLine.size() == K) {
            result.add(new ArrayList<>(perLine));
            return;
        }

        for(int i = start; i <= N; i++) {
            perLine.add(i);
            combination(N, K, i+1, perLine, result);
            perLine.remove(perLine.size() - 1);
        }
    }
}