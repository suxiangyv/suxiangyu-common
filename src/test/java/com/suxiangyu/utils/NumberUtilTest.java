package com.suxiangyu.utils;

import org.junit.Test;

public class NumberUtilTest {
	@Test
	public void isNumber() {
		boolean number = NumberUtil.isNumber("");
		System.out.println(number);
	}

	@Test
	public void isReal() {
		boolean number = NumberUtil.isReal("-1.0");
		System.out.println(number);
	}
	
	@Test
	public void add() {
		
		System.out.println(NumberUtil.add(1,2));
	}
	
	@Test
	public void sub() {
		System.out.println(NumberUtil.sub(8.02,3));
	}
	
	@Test
	public void mul() {
		System.out.println(NumberUtil.mul(6,2));
	}
	
	@Test
	public void div() {
		System.out.println(NumberUtil.div(10,3,10));
	}
	
	@Test
	public void round() {
		System.out.println(NumberUtil.round(6.346,2));
	}
}
