package com.suxiangyu.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
public class CollectionUtilTest {

	@Test
	public void testIsEmpty() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		boolean empty = CollectionUtil.isEmpty(list);
		System.out.println(empty);
	}

}
