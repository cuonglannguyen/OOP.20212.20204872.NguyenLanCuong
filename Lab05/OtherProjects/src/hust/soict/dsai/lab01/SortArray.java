package hust.soict.dsai.lab01;

import java.util.Arrays;
public class SortArray {
	public static void main(String args[]) {
		int[] my_array1 = {1789,2035,1899,1456,2013};
		System.out.println("The original numeric array is:" + Arrays.toString(my_array1));

		Arrays.sort(my_array1);
		System.out.println("The sorted numeric array is:" + Arrays.toString(my_array1));
		double sum = 0;
		for(int i=0; i < my_array1.length ; i++) {
			sum += my_array1[i];
		}
		double average = sum/ my_array1.length;
		System.out.println("The sum of all elements in the array is:" + sum);
		System.out.println("The average of all elements in the array is:" + average);
	}

}
