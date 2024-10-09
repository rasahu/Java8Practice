package com.rake.stream.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseIntWithOutBoxArray {
	public static void main(String[] args) {
		
		
		int[] array = {1,5,3,8};
		
		int[] reverseArray= IntStream.rangeClosed(1, array.length).
				map(e->array[array.length-e]).toArray();

		/*
		 * // Convert the array to a List, then reverse it Integer[] boxedArray =
		 * Arrays.stream(array).boxed().toArray(Integer[]:: new);
		 */

System.out.println(Arrays.toString(reverseArray));
	}

}
