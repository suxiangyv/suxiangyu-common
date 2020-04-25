package com.suxiangyu.utils;

import java.io.File;

import org.junit.Test;

import com.suxiangyu.utils.FileUtil;

/**
 * 
	*说明:
    * @ClassName: FileUtilTest
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author suxiangyu(email:3290785479@qq.com)
           *    创建与 @date 2020年4月24日下午7:51:52
    *
 */
public class FileUtilTest {

	@Test
	public void testGetFileSuffixName() {
		File file = new File("C:\\Users\\32907\\Desktop\\啊啊啊.txt");
		System.out.println(file.exists());
		System.out.println(FileUtil.getUUIDFileName(file));
	}
	@Test
	public void testDeleteFile() {
		File file = new File("C:\\Users\\32907\\Desktop\\嗷嗷.txt");
		System.out.println(file.exists());
		System.out.println(FileUtil.deleteFile(file));
	}
	@Test
	public void testGetSystemProperty() {
		System.out.println(FileUtil.getClassPath());
	}
	
}
