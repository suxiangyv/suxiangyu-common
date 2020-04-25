package com.suxiangyu.utils;

import java.io.File;

import org.junit.Test;

public class IOUtilTest {

	@Test
	public void testClose() {
		
	}

	@Test
	public void testCopyFile() {
		File from = new File("C:\\Users\\32907\\Desktop\\苏祥宇\\24号作业.mp4");
		File to = new File("C:\\Users\\32907\\Desktop\\今天作业效果.mp4");
		boolean success = IOUtil.copyFile(from, to, true);
		System.out.println(success);
	}
	@Test
	public void testReadFileByLine() {
		File file = new File("C:\\Users\\32907\\Desktop\\IOUtilTest.java");
		IOUtil.readFileByChar(file);
	}
	@Test
	public void testWrite() {
		File file = new File("C:\\Users\\32907\\Desktop\\IOUtilTest.java");
		File to = new File("C:\\Users\\32907\\Desktop\\aaa.txt");
		IOUtil.writeFileByBuffered(file, to);
	}

}
