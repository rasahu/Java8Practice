package com.rake.stream.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondMostOccurredElement {

    public static void main(String[] args) {
    	int[] arr = {1, 2, 1 ,2, 1 ,2, 3, 3, 4 ,4 ,1 ,2 ,5 ,6};

        // Create a HashMap to store the count of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        // Create a list of tuples from the HashMap, with each tuple containing a character and its frequency
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort the list by frequency in descending order
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // Return the second element of the list (i.e., the character with the second highest frequency)
        int secondMostOccurredElement = list.get(1).getKey();

        System.out.println("The second most occurred element is: " + secondMostOccurredElement);
    }
}