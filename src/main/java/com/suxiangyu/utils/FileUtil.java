package com.suxiangyu.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.UUID;

/**
 * 
	*说明:
    * @ClassName: FileUtil
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author suxiangyu(email:3290785479@qq.com)
           *    创建与 @date 2020年4月24日下午7:24:36
    *
 */
public abstract class FileUtil {
	/**
	 * 
	    * @Title: getFileSuffixName
	    * @Description: 获取文件的扩展名
	    * @param @param file
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public static String getFileSuffixName(File file) {
		if(null!=file && file.exists()) {
			String fileName = file.getName();
			return fileName.substring(fileName.lastIndexOf("."));
		}
		return null;
	}
	/**
	 * 
	    * @Title: getUUIDFileName
	    * @Description: 获取用UUID生成的文件名
	    * @param @param file
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public static String getUUIDFileName(File file) {
		if(null!=file && file.exists()) {
			return UUID.randomUUID().toString()+getFileSuffixName(file);
		}
		return null;
	}
	/**
	 * 
	    * @Title: deleteFile
	    * @Description: 删除文件,如果是目录，则下面的文件和所有子目录中的文件都要删除
	    * @param @param file
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean deleteFile(File file) {
		try {
			if(null!=file && file.exists()) {
				if(file.isDirectory()) {
					File[] subFiles = file.listFiles();
					for (File subFile : subFiles) {
						deleteFile(new File(file, subFile.getName()));
					}
				}
				file.delete();
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("文件删除失败！");
		}
		return false;
	}
	/**
	 * 
	    * @Title: size
	    * @Description: 返回文件以指定单位大小表示
	    * @param @param file
	    * @param @return    参数
	    * @return long    返回类型
	    * @throws
	 */
	public static long size(File file) {
		if (null!=file && file.exists() && file.isFile()) {
			return file.length();
		}
		return 0;
	}
	/**
	 * 
	    * @Title: getUserHome
	    * @Description: 获取操作系统用户目录
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public static String getUserHome() {
		return System.getProperty("user.home");
	}
	/**
	 * 
	    * @Title: getClassPath
	    * @Description: 获取类路径
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public static String getClassPath() {
		return System.getProperty("java.class.path");
	}
	/**
	 * 
	    * @Title: getClassPath
	    * @Description: 获取当前工作路径
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public static String getWorkingDirectory() {
		return System.getProperty("user.dir");
	}
	/**
	 * 
	    * @Title: copyFile
	    * @Description: 拷贝文件的方法
	    * @param @param fromFile
	    * @param @param toFile
	    * @param @param append  是否追加到目标文件后
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean copyFile(File fromFile,File toFile,boolean append) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(fromFile);
			out = new FileOutputStream(toFile,append);
			byte[] bytes = new byte[1024];
			int length = 0;
			while((length = in.read(bytes))>0) {
				out.write(bytes, 0, length);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				 in.close(); 
				 out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	/**
	 * @Title: writeFile
	 * @Description: 按照指定的编码把内容写入指定的文件中
	 * @param path
	 * @param content
	 * @param charset
	 * @throws IOException
	 * @return: void
	 */
	public static void writeFile(String path, String content, String charset) throws IOException {
		// 创建写入的文件
		File file = new File(path);
		// 判断父目录是否存在
		if (!file.getParentFile().exists()) {
			// 创建父目录
			file.getParentFile().mkdirs();
		}
		// 创建输出流对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		if(content!=null) {
			bw.write(content);
		}
		bw.flush();
		bw.close();
	}

	/**
	 * @Title: readFile
	 * @Description: 读取文件内容
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readFile(File file, String charset) throws IOException {
		// 创建输出流对象
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		// 定义缓冲对象
		StringBuffer sb = new StringBuffer();
		// 定义读取每行的结果
		String content = null;
		// 循环读取
		while ((content = br.readLine()) != null) {
			// 加入缓冲对象
			sb.append(content);
		}
		// 关闭流
		br.close();
		// 返回结果
		return sb.toString();

	}
}
