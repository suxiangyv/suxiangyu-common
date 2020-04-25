package com.suxiangyu.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
	
	@Test
	public void hasLength() {
		
		boolean bo = StringUtile.hasLength(" ");
		
		System.out.println(bo);
	}

	@Test
	public void hasText() {
	
	  boolean text = StringUtile.hasText("");
	  
	  System.out.println(text);
	 
	
	}
	
	@Test
	public void isEmail() {
		
		boolean email = StringUtile.isEmail("948315767@qq.com");
		
		System.out.println(email);
		
	}
	
	@Test
	public void isPhone() {
		
		boolean phone = StringUtile.isPhone("15879352381"); 
		
		System.out.println(phone); 
		
	}
	
	@Test
	public void isLetter() {
		
		boolean letter = StringUtile.isLetter("aaa");
		
		System.out.println(letter);
	}

	
	@Test
	public void hidden() {
		
		String phone = "13823588392";
		String hiddenPhone = StringUtile.hidden(phone, 3, 7);
		System.out.println(hiddenPhone);
		Assert.assertEquals(hiddenPhone, "138****8392");
		
		String username = "suxiangyu";
		String hiddenUsername = StringUtile.hidden(username, 1, username.length() - 1);
		System.out.println(hiddenUsername);
		Assert.assertEquals(hiddenUsername, "s*******u");
		
		String name = "苏祥宇";
		String hiddenName = StringUtile.hidden(name, 1, null);
		System.out.println(hiddenName);
		Assert.assertEquals(hiddenName, "苏**");
		
		String str1 = "中华人民共和国";
		String hiddenStr = StringUtile.hidden(str1, null, null);
		System.out.println(hiddenStr);
		Assert.assertEquals(hiddenStr, hiddenStr);
		
		String str2 = "中华人民共和国";
		String hiddenStr2 = StringUtile.hidden(str2, null, 100);
		System.out.println(hiddenStr2);
		Assert.assertEquals(hiddenStr2, hiddenStr2);
		
	}
}
