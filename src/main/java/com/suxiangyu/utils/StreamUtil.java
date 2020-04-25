package com.suxiangyu.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 
	*说明:
    * @ClassName: StreamUtil
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author suxiangyu(email:3290785479@qq.com)
           *    创建与 @date 2020年4月24日下午7:26:25
    *
 */
public class StreamUtil {
	
	public static void closings(AutoCloseable... closeables){
		for(AutoCloseable closeable : closeables){
			if(closeable != null){
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
		return copy(inputStream, outputStream, true, true);
	}
	
	public static int copy(InputStream inputStream, OutputStream outputStream, boolean closeInputStream, boolean closeOutputStream) throws IOException {
		int total = 0;
		
		if(inputStream == null || outputStream == null){
			return total;
		}
		
		try {
			byte[] buffer = new byte[8192];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
				total+=bytesRead;
			}
		} 
		finally{
			if(closeInputStream){
				closings(inputStream);
			}
			if(closeOutputStream){
				closings(outputStream);
			}
		}
		
		return total;
	}
	
	public static String asString(InputStream inputStream, String encode) throws IOException {
		return asString(inputStream, encode, true);
	}
	
	public static String asString(InputStream inputStream, String encode, boolean isClose) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		copy(inputStream, outputStream, isClose, true);
		return outputStream.toString();
	}
	
	public static String asString(File textFile, boolean isClose) throws IOException {
		InputStream inputStream = new FileInputStream(textFile);
		String text = asString(inputStream, "UTF-8", isClose);
		return text;
	}
	
	public static String asString(File textFile, String encode, boolean isClose) throws IOException {
		InputStream inputStream = new FileInputStream(textFile);
		String text = asString(inputStream, encode, isClose);
		return text;
	}
}
