package com.rake.stream.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseIntArrayWithBox {
	public static void main(String[] args) {
		
		
		/*
		 * List<Integer> intList= Arrays.asList(5,1,7,3,9,6); intList.
		 */
		
		String s= "Hi Hello Java";

		
		int[] array = {1, 2, 3, 4, 5};

        // Convert the array to a List, then reverse it
        Integer[] boxedArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
        
        
        Collections.reverse(Arrays.asList(boxedArray));

        // Convert the List back to an int array
        int[] reversedArray = Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(reversedArray));
	}

}
