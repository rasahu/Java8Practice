package com.rake.tsys;

import java.math.BigDecimal;

public class WhyBigDecimal {

	public static void main(String[] args) {
		Double d=.1;
		Double d2=.125;
		System.out.println(d2-d);
		
		
		BigDecimal bigd1=new BigDecimal(".1");
		BigDecimal bigd2=new BigDecimal(.125);
		System.out.println(bigd2.subtract(bigd1));

	}

}
