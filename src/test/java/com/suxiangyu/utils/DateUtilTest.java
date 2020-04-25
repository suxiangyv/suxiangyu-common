package com.suxiangyu.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testRandomDate() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar calendar=Calendar.getInstance();
		calendar.set(2010, 0,1);
		
	}
	
	
	@Test
	public void testgetInitMonth(){
		Date initMonth = DateUtil.getInitMonth(new Date());
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		System.out.println("月初"+simpleDateFormat.format(initMonth));
	}
	@Test
	public void testgetEndMonth(){
		Date initMonth = DateUtil.getEndMonth(new Date());
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		System.out.println("月末"+simpleDateFormat.format(initMonth));
	}
	
	
	

}
