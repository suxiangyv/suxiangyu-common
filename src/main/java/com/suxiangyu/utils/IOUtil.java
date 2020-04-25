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
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
	*说明:
    * @ClassName: IOUtil
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author suxiangyu(email:3290785479@qq.com)
           *    创建与 @date 2020年4月25日下午9:32:56
    *
 */
public class IOUtil {
	/**
	 * 
	    * @Title: close
	    * @Description: 关闭流
	    * @param @param autoCloseables    参数
	    * @return void    返回类型
	    * @throws
	 */
	public static void close(AutoCloseable...autoCloseables) {
		if(null!=autoCloseables && autoCloseables.length>0) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("流关闭失败！");
				}
			}
		}
	}
	/**
	 * 
	    * @Title: copyFile
	    * @Description: 拷贝文件的方法
	    * @param @param fromFile
	    * @param @param toFile
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean copyFile(File fromFile,File toFile) {
		return copyFile(fromFile, toFile,false);
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
			close(in);
			close(out);
		}
		return true;
	}
	/**
	 * 
	    * @Title: readFileByLine
	    * @Description: 按行读取文本文件，默认为utf8
	    * @param @param file    参数
	    * @return List<String>    返回各行的文本数据
	    * @throws
	 */
	public static List<String> readFileByLine(File file) {
		return readFileByLine(file, "utf8");
	}
	/**
	 * 
	    * @Title: readFileByLine
	    * @Description: 按指定的编码集，按行读取文本文件
	    * @param @param file
	    * @param @param charset
	    * @param @return    参数
	    * @return List<String>    返回各行的文本数据
	    * @throws
	 */
	public static List<String> readFileByLine(File file,String charset) {
		List<String> content = new LinkedList<String>();
		InputStream in = null;
		Reader reader = null;
		BufferedReader bufferedReader = null;
		try {
			in = new FileInputStream(file);
			reader = new InputStreamReader(in,charset);
			bufferedReader = new BufferedReader(reader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				content.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(bufferedReader,reader,in);
		}
		return content;
	}
	/**
	 * 
	    * @Title: ReadFileByBytes
	    * @Description: 按字节读取文件(gbk时中文会乱码)
	    * @param @param file    参数
	    * @return void    返回类型
	    * @throws
	 */
	public static void ReadFileByBytes(File file) {
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			int index = 0;
			while (-1 != (index = in.read())) {
				System.out.write(index);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	    * @Title: readFileByChar
	    * @Description: 按字符读取文件,默认为utf8
	    * @param @param file    参数
	    * @return void    返回类型
	    * @throws
	 */
	public static void readFileByChar(File file) {
		readFileByChar(file,"utf8");
	}
	/**
	 * 
	    * @Title: readFileByChar
	    * @Description: 按指定的字符集，字符读取文件
	    * @param @param file
	    * @param @param charset    参数
	    * @return void    返回类型
	    * @throws
	 */
	public static void readFileByChar(File file,String charset) {
		InputStream in = null;
		Reader reader = null;
		try {
			in = new FileInputStream(file);
			reader = new InputStreamReader(in,charset);
			int index = 0;
			while (-1 != (index = reader.read())) {
				System.out.print((char) index);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != in) {
					in.close();
				}
				if (null != reader) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	    * @Title: writeFileByBuffered
	    * @Description: 将文本写入文本文件，默认不追加
	    * @param @param content
	    * @param @param file    参数
	    * @return void    返回类型
	    * @throws
	 */
	public static void writeFileByBuffered(String content,File file) {
		writeFileByBuffered(content, file, false, "utf8");
	}
	public static void writeFileByBuffered(String content,File file,boolean append) {
		writeFileByBuffered(content, file, append,"utf8");
	}
	public static void writeFileByBuffered(String content,File file,String charset) {
		writeFileByBuffered(content, file, false, charset);
	}
	/**
	 * 
	    * @Title: writeFileByBuffered
	    * @Description: 将文本写入文本文件，可选择是否追加
	    * @param @param content
	    * @param @param file    参数
	    * @param @param append  是否追加
	    * @param @param charset  编码集
	    * @return void    返回类型
	    * @throws
	 */
	public static void writeFileByBuffered(String content,File file,boolean append,String charset) {
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			if (!file.exists()) {
			file.createNewFile();
			}
			fos = new FileOutputStream(file,append);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			bw.write(new String(content.getBytes(), charset));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(bw,osw,fos);
		}
	}
	/**
	 * 
	    * @Title: writeFileByBuffered
	    * @Description: 将文本从一个文件写入另一个文件，默认不追加，utf-8
	    * @param @param content
	    * @param @param file    参数
	    * @return void    返回类型
	    * @throws
	 */
	public static void writeFileByBuffered(File from,File to) {
		writeFileByBuffered(from, to, false, "utf8");
	}
	public static void writeFileByBuffered(File from,File to,boolean append) {
		writeFileByBuffered(from, to, append,"utf8");
	}
	public static void writeFileByBuffered(File from,File to,String charset) {
		writeFileByBuffered(from, to, false, charset);
	}
	/**
	 * 
	    * @Title: writeFileByBuffered
	    * @Description: 将文本从一个文件写入另一个文件
	    * @param @param from
	    * @param @param to
	    * @param @param append   是否追加
	    * @param @param charset  字符集类型
	    * @return void    返回类型
	    * @throws
	 */
	public static void writeFileByBuffered(File from,File to,boolean append,String charset) {
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		String line = null;
		try {
			if (!to.exists()) {
				to.createNewFile();
			}
			fis = new FileInputStream(from);
			isr = new InputStreamReader(fis, charset);
			br = new BufferedReader(isr);
			fos = new FileOutputStream(to,append);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			while(null!=(line=br.readLine())) {
				bw.write(new String(line.getBytes(), charset));
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(bw,osw,fos);
			close(br,isr,fis);
		}
	}
	/**
	 * 
	    * @Title: download
	    * @Description: 网络文件下载
	    * @param @param realPath
	    * @param @param request
	    * @param @param response
	    * @param @param filename
	    * @param @throws FileNotFoundException    参数
	    * @return void    返回类型
	    * @throws
	 */
	public static void download(String realPath,HttpServletRequest
			request,HttpServletResponse response,String filename) throws
			FileNotFoundException {
		InputStream inStream = new FileInputStream(realPath+filename);//
		response.reset();
		response.setContentType("bin");
		response.addHeader("Content-Disposition", "attachment;filename=" + filename);
		byte[] b = new byte[1024];
		int len;
		try {
			while ((len = inStream.read(b)) > 0) {
				response.getOutputStream().write(b, 0, len);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
