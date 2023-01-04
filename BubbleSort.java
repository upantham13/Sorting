package homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
	
	//Sorts the inputed integer array through the bubble sort method.
	public static void bubbleSort (int intArray[]) {
		int n = intArray.length;
		//Comparing the adjacent pair of numbers
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) {
				if (intArray[j] > intArray[j+1]) {
					//Swapping the elements being compared
					int temp = intArray[j];
					intArray[j] = intArray[j+1];
					intArray[j+1] = temp;
				}
			}
		}
	}
	
	public static void main (String[] args) throws FileNotFoundException {
		//Using scanner to read the .txt file and inputing it into an array.
		Scanner s1 = new Scanner(new File("/Users/upantham/Downloads/CS 146/Homework /homework1/src/arr1-2.txt"));
		int [] array1 = new int [50];
		int i = 0;
		while(s1.hasNextInt()) {
			array1[i++] = s1.nextInt();
		}
		//Using the bubbleSort method from above on the array created from the .txt file and printing the 
		//bubble sorted array. 
		bubbleSort(array1);
		System.out.println(Arrays.toString(array1));
	}
}
