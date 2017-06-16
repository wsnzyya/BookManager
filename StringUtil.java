package com.java1234.util;
/**
 * 用户工具类
 * @author 华敏
 *
 */
public class StringUtil {
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim()))
		{
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 判断字符串是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null&&!"".equals(str.trim()))
		{
			return true;
		}else{
			return false;
		}
	}

}
