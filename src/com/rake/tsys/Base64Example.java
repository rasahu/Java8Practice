package com.rake.tsys;

import java.util.Base64;

public class Base64Example {

	public static void main(String[] args) {
		String originalInput = "Hello World !!!";
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes()); // aGVsbG8gd29ybGQ=

		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes); // 
		System.out.println("decodedString :: " + decodedString);
	}

}
