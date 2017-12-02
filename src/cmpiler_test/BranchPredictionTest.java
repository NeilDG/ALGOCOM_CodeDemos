package cmpiler_test;

import java.util.Arrays;
import java.util.Random;

import utils.Debug;

public class BranchPredictionTest {

	//32758, 131072, 1048576
	private static final int ARRAY_SIZE = 131072;
	
	public static void randomlySortedTest() {
		// Generate data
        int data[] = new int[ARRAY_SIZE];

        Random rnd = new Random(0);
        for (int c = 0; c < ARRAY_SIZE; ++c)
            data[c] = rnd.nextInt() % 256;

        // Test
        long start = System.nanoTime();
        long sum = 0;

        for (int i = 0; i < 100000; ++i)
        {
            // Primary loop
            for (int c = 0; c < ARRAY_SIZE; ++c)
            {
                if (data[c] >= 128)
                    sum += data[c];
            }
        }

        Debug.log("Time taken for UNSORTED: " +(System.nanoTime() - start) / 1000000000.0);
	}
	
	public static void sortedTest() {
		// Generate data
        int data[] = new int[ARRAY_SIZE];

        Random rnd = new Random(0);
        for (int c = 0; c < ARRAY_SIZE; ++c)
            data[c] = rnd.nextInt() % 256;

        // !!! With this, the next loop runs faster
        Arrays.sort(data);

        // Test
        long start = System.nanoTime();
        long sum = 0;

        for (int i = 0; i < 100000; ++i)
        {
            // Primary loop
            for (int c = 0; c < ARRAY_SIZE; ++c)
            {
                if (data[c] >= 128)
                    sum += data[c];
            }
        }

        Debug.log("Time taken for SORTED: " +(System.nanoTime() - start) / 1000000000.0);
	}
}
