/**
 * 
 */
package sorting;

import utils.Debug;

/**
 * Classical sorting examples here
 * @author NeilDG
 *
 */
public class ClassicalSorting {
	private final static String TAG = "ClassicalSorting";
	
	public static int[] mergeSort(int[] numberList) {
		int low = 0;
		int high = numberList.length - 1;
		
		return mergeSortProper(numberList, low, high);
	}
	
	private static int[] mergeSortProper(int[] numberList, int low, int high) {
		if(low < high) {
			int middle = (low + high) / 2;
			mergeSortProper(numberList, low, middle);
			mergeSortProper(numberList, middle + 1, high);
			merge(numberList, low, middle, high);
		}
		
		return numberList;
	}
	
	private static void merge(int[] mergeList, int low, int mid, int high) {
		int leftSize = mid - low + 1;
		int rightSize = high - mid;
		
		//initialize left and right sub-array such that the corresponding elements from mergeList are copied to its left/right partition
		int[] leftArray = new int[leftSize + 1];
		int[] rightArray = new int[rightSize + 1];
		
		for(int i = 0; i < leftSize; i++) {
			leftArray[i] = mergeList[low + i];
		}
		
		for(int i = 0; i < rightSize; i++) {
			rightArray[i] = mergeList[mid + i + 1];
		}
		
		//add a sentinel value so that any compares with this will guarantee that the the list is already empty
		int sentinel = Integer.MAX_VALUE;
		leftArray[leftSize] = sentinel;
		rightArray[rightSize] = sentinel;
		
		//combine step
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i = low; i <= high; i++) {
			//Debug.log(TAG, "Left: " +leftArray[leftIndex]+ " Right: " +rightArray[rightIndex]);
			if(leftArray[leftIndex] <= rightArray[rightIndex]) {
				mergeList[i] = leftArray[leftIndex];
				leftIndex++;
			}
			else {
				mergeList[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}
	
	 // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private static  void merge2(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public static void mergeSort2(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            mergeSort2(arr, l, m);
            mergeSort2(arr , m+1, r);
 
            // Merge the sorted halves
            merge2(arr, l, m, r);
        }
    }
    
    private static void swap(int[] array, int indexA, int indexB) {
    	int temp = array[indexA];
    	array[indexA] = array[indexB];
    	array[indexB] = temp;
    }
    
    private static int partition(int[] numberList, int low, int high) {
    	int pivot = numberList[high]; //take the last element of the pivot.
    	int index = low - 1;
    	
    	for(int i = low; i < high; i++) {
    		// If current element is smaller than or
            // equal to pivot
            if (numberList[i] <= pivot)
            {
                index++;
                swap(numberList, i, index);
            }
    	}
    	
    	//put the pivot into correct position
    	swap(numberList, index + 1, high);
    	
    	return index + 1;
    	
    }
    
    public static int[] quickSort(int[] numberList, int low, int high) {
    	if(low < high) {
          int pivot = partition(numberList, low, high);
          // Recursively sort elements before
          // partition and after partition
          quickSort(numberList, low, pivot-1);
          quickSort(numberList, pivot+1, high);
    	}
    	
    	return numberList; //sorted
    }
}
