package com.suxiangyu.utils;

import java.io.File;

import org.junit.Test;

import com.suxiangyu.utils.StreamUtil;

/**
 * 
	*说明:
    * @ClassName: StreamUtilTest
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author suxiangyu(email:3290785479@qq.com)
           *    创建与 @date 2020年4月24日下午7:58:13
    *
 */
public class StreamUtilTest {

	@Test
	public void testAsString() throws Exception{
		//在自己的工程下的资源，不要按这种方式读取。
		String text1 = StreamUtil.asString(new File("D:/bw/suxiangyu-common/src/test/resources/test.json"), true);
		System.out.println(text1);
		
		//通过类装载器读取，相当于classpath:
		String text2 = StreamUtil.asString(StreamUtilTest.class.getClassLoader().getResourceAsStream("test.json"), "UTF-8");
		System.out.println(text2);
	}
}
