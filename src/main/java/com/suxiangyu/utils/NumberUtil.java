
    /**  
    * @Title: NumberUtil.java
    * @Package com.suxiangyu.utils
    * @Description: TODO(用一句话描述该文件做什么)
    * @author 苏祥宇
    * @date 2020年4月23日
    * @version V1.0  
    */
    
package com.suxiangyu.utils;

import java.math.BigDecimal;

/**
	*说明:
    * @ClassName: NumberUtil
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author suxiangyu(email:3290785479@qq.com)
           *    创建与 @date 2020年4月23日下午8:48:58
    *
    */

public class NumberUtil {
	private static final int DEF_DIV_SCALE = 10;
	/**
	* 功能：判断是否全部为数字
	* 示例：
	* NumberUtil.isNUmber("abc") -> false
	* NumberUtil.isNUmber("5.6") -> false
	* NumberUtil.isNUmber("1234") -> true
	*/
	public static boolean isNumber(String src) {
		if(null != src && !"".equals(src.trim()) ) {
			if(src.matches("^[0-9]*$") == false) {
				return false;
			}else {
				return true;
			}
		}
		return false;
	}
	
	/**
	* 功能：判断是否全部为实数
	* 示例：
	* NumberUtil.isNUmber("abc") -> false
	* NumberUtil.isNUmber("5.6") -> true
	* NumberUtil.isNUmber("1234") -> true
	*/
	public static boolean isReal(String src) {
		if(null !=src && src.trim().length()>0) {
			if(src.matches("[-\\+]?\\d+(\\.\\d+)?")) {
				return true;
			}
		}
		return false;
	}
	

	
	/**
	 * 功能：提供精确的加法运算。<br>
	 * double d1 = 0.1;  <br>
	 * double d2 = 0.2;   <br>
	 * double d3 = d1 + d2; ==> 0.30000000000000004 导致不精确。<br>
	 * 该工具方法可以纠正上面的问题。<br>
	 * 
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */
	public static double add(double d1, double d2){
		BigDecimal bigDecimal1 = new BigDecimal(Double.toString(d1));
		BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d2));
		BigDecimal result = bigDecimal1.add(bigDecimal2);
		return result.doubleValue();
	}
	
	

	/**
	 * 提供精确的减法运算。
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1,double v2){
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	
	/**
	 * 提供精确的乘法运算。
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1,double v2){
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}




	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 * 定精度，以后的数字四舍五入。
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1,double v2,int scale){
		if(scale<0){
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}



	/**
	 * 提供精确的小数位四舍五入处理。
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v,int scale){
		if(scale<0){
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
