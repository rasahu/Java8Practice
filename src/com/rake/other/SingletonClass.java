package com.rake.other;

/**
 * 1. Ensure that only one instance of the class exists. 2. Provide global
 * access to that instance by
 * Declaring all constructors of the class to be private. 
 * Providing a static method that returns a reference to the instance. 
 * The lazy initialization concept is used to write the static methods. 
 * The instance is stored as  private static variable. Example of singleton classes is Runtime class,
 * Action Servlet, and Service Locator. Private constructors and factory methods
 * are also an example of the singleton class.
 */
public class SingletonClass {

	private static SingletonClass instance;

	private SingletonClass() {
	}

	public static synchronized SingletonClass getSingletonClass() {
		if (instance == null) {
			instance = new SingletonClass();
		}
		return instance;
	}

}
