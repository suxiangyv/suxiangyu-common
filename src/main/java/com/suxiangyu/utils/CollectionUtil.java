package com.suxiangyu.utils;

import java.util.Collection;
/**
 * 
	*说明:
    * @ClassName: CollectionUtil
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author suxiangyu(email:3290785479@qq.com)
           *    创建与 @date 2020年4月25日下午9:32:33
    *
 */
public class CollectionUtil {
	/**
	 * 
	    * @Title: isEmpty
	    * @Description: 判断集合是否为空
	    * @param @param collection
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isEmpty(Collection<?> collection ) {
		return null==collection || collection.isEmpty();
	}
}
