package com.rake.stream.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class MostFrequentFromList {
	public static void main(String[] args) {
		
		
		int[] arr = {1, 2, 1 ,2, 1 ,2, 3, 3, 4 ,4 ,1 ,2 ,5 ,6};

        // Create a HashMap to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Iterate over the array and update the frequency map
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (frequencyMap.containsKey(element)) {
                frequencyMap.put(element, frequencyMap.get(element) + 1);
            } else {
                frequencyMap.put(element, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list= new ArrayList<>(frequencyMap.entrySet());
        
         Collections.sort(list, (o1,o2) ->o2.getValue().compareTo(o1.getValue()));
         list.stream().forEach(System.out::println);
      
         
         List<List<Integer>> wholeList= new ArrayList<>(); 
         List<Integer> occuredItemList=new ArrayList<>();
         for(Map.Entry<Integer, Integer> entry :list) {
        	 int maxFrequency = 0;
        	
        	 occuredItemList.add(entry.getValue());
        	 if(entry.getValue()==maxFrequency) {
        		 occuredItemList.add(entry.getKey());
        	 }
        	 maxFrequency=entry.getValue();
        	 wholeList.add(occuredItemList);
         }
         
         System.out.println("-------------------------------------------------------------");
         wholeList.stream().forEach(System.out::println);
 		/*for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) { if
 		 * (entry.getValue() > maxFrequency) { mostFrequentElement = entry.getKey();
 		 * maxFrequency = entry.getValue(); } }
 		 */
         
         //Integer secondlargest=list.get(1).getKey();
        // Find the element with the highest frequency
        int mostFrequentElement = -1;
        int maxFrequency = 0;
		/*
		 * for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) { if
		 * (entry.getValue() > maxFrequency) { mostFrequentElement = entry.getKey();
		 * maxFrequency = entry.getValue(); } }
		 */

        // Print the most frequent element
       // System.out.println("The Second frequent element is: " + list.get(1).getKey() +" and the most frequency is " +list.get(1).getv);
    }

	}

