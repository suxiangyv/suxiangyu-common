
    /**  
    * @Title: StringUtile.java
    * @Package com.suxiangyu.utils
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 苏祥宇
    * @date 2020年4月23日
    * @version V1.0  
    */
    
package com.suxiangyu.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
	*说明:
    * @ClassName: StringUtile
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author suxiangyu(email:3290785479@qq.com)
           *    创建与 @date 2020年4月23日下午8:35:45
    *
    */

public final class StringUtile {
	
	public static boolean hasLength(String src) {
		return src !=null && src.length()>0;
	}
	/**
	 * 
	    * @Title: hasText
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param text
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean hasText(String text) {

		if( null == text || "".equals(text.trim()) ) {
			
			return false;	
			
		}
		return true;
		
	}
	/**
	 * 
	    * @Title: isEmail
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param email
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isEmail(String email) {
		if (null==email || "".equals(email)){
	        	return false; 
		}
		String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		boolean matches = Pattern.compile(regex).matcher(email).matches();
		
		return matches;
	}
	/**
	 * 
	    * @Title: isPhone
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param phone
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isPhone(String phone) {
		if (null == phone || "".equals(phone)){
        	return false; 
		}
		String regex = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher = compile.matcher(phone);
		return matcher.matches();
	}
	/**
	 * 
	    * @Title: isLetter
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param src
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isLetter(String src) {
		if(null ==  src || "".equals(src)) {
			return false;
		}
		String regex = "[a-zA-Z]";
		Pattern compile = Pattern.compile(regex);
		for (int i = 0; i < src.length(); i++) {
			Matcher matcher = compile.matcher(src.substring(i,i+1));
			if(matcher.matches()!=true) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 
	    * @Title: hidden
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param src
	    * @param @param start
	    * @param @param end
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public static String hidden(String src , Integer start ,Integer end) {
		if(src == null){
			return src;
		}
		
		StringBuffer result = new StringBuffer();

		if(end == null){
			end = src.length();
		}
		
		char[] chars = src.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if(start != null && start <= i && i < end){
				result.append('*');
			}else{
				result.append(c);
			}
		}

		return result.toString();
	}
}
