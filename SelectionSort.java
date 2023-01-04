package homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	
	//Sorts the inputed integer array through the selection sort method.
	public static void selectionSort (int intArray[]) {
		int n = intArray.length;
		for (int i = 0; i < n-1; i++) {
			//Finding the element that is the lowest value and its index.
			int minIndex = i;
			for (int j = i+1; j < n; j++) {
				if (intArray[j] < intArray[minIndex]) {
					minIndex = j;
				}
			}
			//Swapping the element with the lowest value with the first element.
			int temp = intArray[minIndex];
			intArray[minIndex] = intArray[i];
			intArray[i] = temp;
		}
	}
	
	public static void main (String[] args) throws FileNotFoundException {
		//Using scanner to read the .txt file and inputing it into an array.
		Scanner s2 = new Scanner(new File("/Users/upantham/Downloads/CS 146/Homework /homework1/src/arr2-1.txt"));
		int [] array2 = new int [50];
		int i = 0;
		while(s2.hasNextInt()) {
		   array2[i++] = s2.nextInt();
		}
		//Using the selectionSort method from above on the array created from the .txt file and printing the 
		//selection sorted array. 
		selectionSort(array2);
		System.out.println(Arrays.toString(array2));
	}
}
