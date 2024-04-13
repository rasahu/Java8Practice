package com.rake.other;

import java.util.HashMap;
import java.util.Iterator;



/**
 *1) Declare the class as final so it can’t be extended.
2) Make all of the fields private so that direct access is not allowed.
3) Don’t provide setter methods for variables.
4) Make all mutable fields final so that a field’s value can be assigned only once.
5) Initialize all fields using a constructor method performing deep copy.
6) Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference
 */
public final class ImmutableClass implements Cloneable{
	
	// fields of the ImmutableClass class
		private final int id;
		
		private final String name;
		
		private final HashMap<String,String> testMap;

		
		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		// Getter function for mutable objects

		public HashMap<String, String> getTestMap() {
			return (HashMap<String, String>) testMap.clone();
		}

		// Constructor method performing deep copy
		
		public ImmutableClass(int i, String n, HashMap<String,String> hm){
			System.out.println("Performing Deep Copy for Object initialization");

			// "this" keyword refers to the current object
			this.id=i;
			this.name=n;

			HashMap<String,String> tempMap=new HashMap<String,String>();

		      hm.forEach((key,value)->tempMap.put(key, value));
			
				/*
				 * String key; Iterator<String> it = hm.keySet().iterator();
				 * while(it.hasNext()){ key=it.next(); tempMap.put(key, hm.get(key)); }
				 */
			this.testMap=tempMap;
		}

		// Test the immutable class

		public static void main(String[] args) {
			HashMap<String, String> h1 = new HashMap<String,String>();
			h1.put("1", "first");
			h1.put("2", "second");
			
			String s = "original";
			
			int i=10;
			
			ImmutableClass ce = new ImmutableClass(i,s,h1);
			
			// print the ce values
			System.out.println("ce id: "+ce.getId());
			System.out.println("ce name: "+ce.getName());
			System.out.println("ce testMap: "+ce.getTestMap());
			// change the local variable values
			i=20;
			s="modified";
			h1.put("3", "third");
			// print the values again
			System.out.println("ce id after local variable change: "+ce.getId());
			System.out.println("ce name after local variable change: "+ce.getName());
			System.out.println("ce testMap after local variable change: "+ce.getTestMap());
			
			HashMap<String, String> hmTest = ce.getTestMap();
			hmTest.put("4", "new");
			
			System.out.println("ce testMap after changing variable from getter methods: "+ce.getTestMap());

		}

}
