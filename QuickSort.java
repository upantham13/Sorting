package homework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	//Partitions the array into portions so it will make it easier for the array to
	//be sorted in the quickSort method.
	public static int partition(int intArray[], int low, int high) {
		//Creating a pivot.
		int pivot = intArray[high];
		int i = (low - 1);
		//Checking each element in unprocessed areas.
		for (int j = low; j < high; j++) {
			if (intArray[j] <= pivot) {
				i++;
				int temp = intArray[i];
				intArray[i] = intArray[j];
				intArray[j] = temp;  
			}
		}
		//Swapping the pivot
		int temp = intArray[i + 1];
		intArray[i + 1] = intArray[high];
		intArray[high] = temp;
		return i + 1;
	}
	
	//Sorts the arrays by setting the pivot index through calling the partition method
	//of the intArray and then recursively calling itself to sort the array.
	public static void quickSort(int intArray[], int low, int high) {
		if (low < high) {
			//Setting the pivot index by calling the partition method.
			int pivotIndex = partition(intArray, low, high);
			//Recursively calling quickSort to sort the two parts.
			quickSort(intArray, low, pivotIndex - 1);
			quickSort(intArray, pivotIndex + 1, high);
		}
	}
	
	public static void main (String[] args) throws FileNotFoundException {
		//Using scanner to read the .txt file and inputing it into an array.
		Scanner s2 = new Scanner(new File("/Users/upantham/Downloads/CS 146/Homework /homework2/homework2/src/MyList-3.txt"));
		int [] array2 = new int [70];
		int i = 0;
		while(s2.hasNextInt()) {
			array2[i++] = s2.nextInt();
		}
		//Using the quickSort method from above on the array created from the .txt file 
		//and printing the quick sorted array.
		quickSort(array2, 0, array2.length - 1);
		System.out.println(Arrays.toString(array2));
	}
}
