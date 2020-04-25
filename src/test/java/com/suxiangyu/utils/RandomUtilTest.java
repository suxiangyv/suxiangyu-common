package com.suxiangyu.utils;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.suxiangyu.utils.RandomUtil;

/**
 * 
	*说明:
    * @ClassName: RandomUtilTest
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author suxiangyu(email:3290785479@qq.com)
           *    创建与 @date 2020年4月24日下午7:45:46
    *
 */
public class RandomUtilTest {

	@Test
	public void testNextInt(){
		System.out.println(RandomUtil.nextInt());
	}
	
	@Test
	public void testNextIntByMax(){
		System.out.println(RandomUtil.nextInt(10));
	}
	
	@Test
	public void testNextIntByRange(){
		System.out.println(RandomUtil.nextInt(5, 50));
	}
	
	//创建6位长度的短信验证码
	@Test
	public void testNextIntByRange1(){
		System.out.println(RandomUtil.nextInt(100000, 999999));
	}
	
	//创建6位登录验证码
	@Test
	public void testNextString(){
		System.out.println(RandomUtil.nextString(5));
	}
	
	@Test
	public void testNextIntegers(){
		//从下面集合12人中找出3个不重复的人
		List<String> names = Arrays.asList("孔子", "孟子", "老子", "庄子", "荀子", "墨子", "韩非子", "孙子", "鬼谷子", "列子", "曾子", "晏子");
		
		//要求找的人数
		int num = 3;
		
		//获取随机3个人的索引
		int[] indexes = RandomUtil.nextIntegers(0, names.size(), num);
		
		for (int i = 0; i < indexes.length; i++) {
			//获取人名在List中的索引
			int namesIndex = indexes[i];
			
			//根据索引找到人
			String name = names.get(namesIndex);
			
			//输出
			System.out.println(name);
		}
	}
	
	@Test
	public void testNextSimplifiedChineseCharacter(){
		System.out.println(RandomUtil.nextSimplifiedChineseCharacter());
	}
	
	@Test
	public void testNextSimplifiedChineseString(){
		System.out.println(RandomUtil.nextSimplifiedChineseString(30));
	}
	
	@Test
	public void testGenerateChinesePersonName(){
		for (int i = 0; i < 30; i++) {
			System.out.println(RandomUtil.generateChinesePersonName());
		}
	}

	@Test
	public void testUUID(){
		System.out.println(RandomUtil.uuid());
	}
	
	
}
