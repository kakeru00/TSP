package com.henry.sa;

import java.math.BigDecimal;

public class test {
	public static void main(String[] args) {
		
		System.out.println(computeCityX(111.980863));
		System.out.println(computeCityX(110.361901));
		System.out.println(computeCityX(116.685971));
		System.out.println(computeCityY(24.303565));
		System.out.println(computeCityY(21.680707));
		System.out.println(computeCityY(21.284643));
	}
	
	static int computeCityX(double x){
		BigDecimal bx = new BigDecimal(x);
		BigDecimal b = new BigDecimal(110.361901);
		return bx.divide(b,5,BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(10000)).intValue() - 10000;
		
	}
	static int computeCityY(double y){
		BigDecimal by = new BigDecimal(y);
		BigDecimal b = new BigDecimal(21.284643);
		return by.divide(b,5,BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(10000)).intValue() - 10000;
	}
	
}
