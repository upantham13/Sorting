package homework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	//Merge method that splits the array into halves so it can be sorted properly
	//and then is put back together into one array once its sorted. 
	public static void merge (int intArray[], int low, int mid, int high) {
		//Creates a temporary array to store the results and initializes integer variables. 
		int n = high - low + 1;
		int tempArray[] = new int[n];
		int left = low;
		int right = mid +1;
		int tempArrayIndex = 0;
		//Merges both halves that have unmerged elements. 
		while (left <= mid && right <= high) {
			if (intArray[left] <= intArray[right]) {
				tempArray[tempArrayIndex++] = intArray[left++];
			}
			else {
				tempArray[tempArrayIndex++] = intArray[right++];
			}
		}
		//Items copied into temporary array.
		while (left <= mid) {
			tempArray[tempArrayIndex++] = intArray[left++];
		}
		//Last remaining items copied into temporary array. 
		while (right <= high) {
			tempArray[tempArrayIndex++] = intArray[right++];
		}
		//Merged results copied into the original array. 
		for (int k = 0; k < n; k++) {
			intArray[low + k] = tempArray[k];
		}
		//Deletes the temporary array.
		tempArray = null;
	}	
	//Sorts the halves of the array recursively. 
	public static void mergeSort(int intArray[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			//Divides the array into halves to sort them recursively.
			mergeSort(intArray, low, mid);
			mergeSort(intArray, mid + 1, high);
			//Merges the two sorted arrays.
			merge(intArray, low, mid, high);
		}
	}
	
	public static void main (String[] args) throws FileNotFoundException {
		//Using scanner to read the .txt file and inputing it into an array.
		Scanner s1 = new Scanner(new File("/Users/upantham/Downloads/CS 146/Homework /homework2/homework2/src/MyList-2.txt"));
		int [] array1 = new int [70];
		int i = 0;
		while(s1.hasNextInt()) {
			array1[i++] = s1.nextInt();
		}
		//Using the mergeSort method from above on the array created from the .txt file and printing the merge sorted array.
		mergeSort(array1, 0, array1.length - 1);
		System.out.println(Arrays.toString(array1));
	}
}
