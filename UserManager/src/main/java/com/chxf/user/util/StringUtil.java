package com.chxf.user.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class StringUtil {
	/** ================================正则============================= */
	public final static String regex_number="[0-9]*[.]?[0-9]*";//任意数字
	public final static String regex_character = "[a-z]*[A-Z]*";// 全字母
	public final static String regex_character_number = "[a-z]*[A-Z]*[0-9]*";// 字母和数字
	public final static String regex_character_number_underline = "[a-z]*[A-Z]*[0-9]*_*";// 字母、数字和下划线
	public final static String regex_chinese = "[\u4E00-\u9FA5]*";// 中文(单中文.length为1)
	/** ================================数字格式================================ */
	/**整数*/
	public final static DecimalFormat dformat_0 = new DecimalFormat("0");
	/**小数点后1位*/
	public final static DecimalFormat dformat_0p0 = new DecimalFormat("0.0");
	/**小数点后2位*/
	public final static DecimalFormat dformat_0p00 = new DecimalFormat("0.00");
	/**小数点后6位*/
	public final static DecimalFormat dformat_0p000000 = new DecimalFormat("0.000000");
	/** ===============================字节===================================== */
	public final static long KB_l = 1024l;
	public final static long MB_l = 1024 * 1024l;
	public final static long GB_l = 1024 * 1024 * 1024l;
	public final static long TB_l = 1024 * 1024 * 1024 * 1024l;
	public final static double KB_d = 1024.0d;
	public final static double MB_d = 1024 * 1024.0d;
	public final static double GB_d = 1024 * 1024 * 1024.0d;
	public final static double TB_d = 1024 * 1024 * 1024 * 1024.0d;

	/**只要str不为null,则返回str.trim()*/
	public static String trim(String str){
		if(str!=null)
			str=str.trim();
		return str;
	}
	
	/**str为null,返回0;否则返回str.length()*/
	public static int length(String str){
		int i=0;
		if(str!=null)
			i=str.length();
		return i;
	}
	
	/**
	 * @功能：str为null或trim()长度为0为真;否则为假
	 * @参数：
	 * @param str
	 *            字符串
	 * @返回参数：boolean 默认false
	 */
	public static boolean isNotEmpty(String str) {
		boolean bl = false;
		if (str != null && !"".equals(str.trim())) {
			bl = true;
		}
		return bl;
	}

	/**
	 * @功能：字符串str的每个字符(包括空白字符)是否完全匹配正则表达式regex
	 * @参数：
	 * @param str
	 *            字符串
	 * @param regex
	 *            正则表达式
	 * @返回参数：boolean 默认false
	 */
	public static boolean isMatch(String str, String regex) {
		boolean bl = false;
		if (isNotEmpty(str)&&isNotEmpty(regex)) {
			Pattern pattern_number = Pattern.compile(regex);
			bl = pattern_number.matcher(str).matches();
		}
		return bl;
	}

	
	/**
	 * @功能：单位化文件大小:B KB MB GB TB
	 * @参数：
	 * @param byteSize
	 *            字节大小
	 * @param dformat
	 *            保留小数点格式
	 * @返回参数：String 默认返回空串
	 */
	public static String getNumUnitByte(long byteSize, DecimalFormat dformat) {
		String str = "";
		if(dformat!=null){
			if (byteSize <= 0) {
				str+="0 B";
			} else if (byteSize < 1000) {
				str+=(byteSize+" B");
			} else if (byteSize < KB_l * 1000) {
				str+=(dformat.format(byteSize / KB_d)+" KB");
			} else if (byteSize < MB_l * 1000) {
				str+=(dformat.format(byteSize / MB_d)+" MB");
			} else if (byteSize < GB_l * 1000) {
				str+=(dformat.format(byteSize / GB_d)+" GB");
			} else {
				str+=(dformat.format(byteSize / TB_d)+" TB");
			}
		}
		return str;
	}

	/**字符串(不包含空白字符)转数字类型：short,int,long,float,double;参数不匹配返回null,整数超出范围返回null，小数超出返回Infinity*/
	public static Object toNumber(String numStr,Class<?> numClazz){
		Object object=null;
		if(isMatch(numStr, regex_number)&&numClazz!=null){
			if(numStr.indexOf(".")!=-1){//含小数点
				if (Float.class.equals(numClazz)||float.class.equals(numClazz)) {
					object= Float.parseFloat(numStr);
				}else if (Double.class.equals(numClazz)||double.class.equals(numClazz)) {
					object=Double.parseDouble(numStr);
				}
			}else {//不含小数点
				if (Short.class.equals(numClazz)||short.class.equals(numClazz)) {
					if((Short.MAX_VALUE+"").compareTo(numStr)!=-1&&length(numStr)<=5)
						object=Short.parseShort(numStr);
				}else if(Integer.class.equals(numClazz)||int.class.equals(numClazz)){
					if((Integer.MAX_VALUE+"").compareTo(numStr)!=-1&&length(numStr)<=10)
						object=Integer.parseInt(numStr);//不能超过整数最大值
				}else if (Long.class.equals(numClazz)||long.class.equals(numClazz)) {
					if((Long.MAX_VALUE+"").compareTo(numStr)!=-1&&length(numStr)<=19)
						object=Long.parseLong(numStr);
				}else if (Float.class.equals(numClazz)||float.class.equals(numClazz)) {
					object=Float.parseFloat(numStr);
				}else if (Double.class.equals(numClazz)||double.class.equals(numClazz)) {
					object=Double.parseDouble(numStr);
				}
			}
		}
		return object;
	}
	
	/**
	 * @功能：从str截取length长度的字符串,并加上后缀[中文算2个字符，其他算1个字符]
	 * @参数：
	 * @param str
	 *            原字符串
	 * @param length
	 *            截取的指定长度
	 * @param suffix
	 *            补充后缀，默认空串
	 * @返回参数：String 默认返回空串
	 */
	public static String cutStr(String str, int length, String suffix) {
		StringBuffer stringBuffer = new StringBuffer("");
		if (str!=null&&length>0) {
			if (suffix==null)
				suffix = "";//默认值
			int index = 0;
			for (int i = 0; i < str.length(); i++) {
				String retContent = str.substring(i, i + 1);
				// 生成一个Pattern,同时编译一个正则表达式
				boolean isChina = retContent.matches(regex_chinese);
				if (index == length) {
					stringBuffer.append(suffix);
					break; // 退出条件
				}
				if (isChina) {
					index = index + 2; // 中文
				} else {
					index = index + 1; // 数字和字母（中英文标点）
				}
				stringBuffer.append(retContent);
				if (index > length) {
					stringBuffer.append(suffix);
					break;
				}
			}
		}
		return stringBuffer.toString();
	}
	
	/**
	 * @功能：计算字符串的长度[中字长度为2，其余为1]
	 * @参数：
	 * @param chineseStr
	 *            字符串
	 * @返回参数：long 默认返回0
	 */
	public static long lengthByChinese(String chineseStr) {
		long valueLength = 0;
		if (chineseStr!=null) {
			for (int i = 0; i < chineseStr.length(); i++) {
				/* 判断是否为中文字符 */
				if (chineseStr.substring(i, i + 1).matches(regex_chinese)) {
					valueLength += 2;
				} else {
					valueLength += 1;
				}
			}
		}
		return valueLength;
	}

	/**
	 * @功能：根据分隔符split获得字符串str的后缀[不包括分隔符split]
	 * @参数：
	 * @param str
	 *            字符串
	 * @param split
	 *            分隔符
	 * @返回参数：String 默认返回空串
	 */
	public static String getSuffix(String str,String split) {
		String result = "";
		int index =-1;
		if (isNotEmpty(str)&&split!=null&& (index = str.indexOf(split))>0) {
			result = str.substring(index+1);
		}
		return result;
	}

	/**
	 * @功能：根据split去除字符串的后缀
	 * @参数：
	 * @param str
	 *            字符串
	 * @param split
	 *            分隔符
	 * @返回参数：String 默认返回str
	 */
	public static String delSuffix(String str,String split) {
		String result = str;
		int index =-1;
		if(isNotEmpty(str)&&split!=null&&(index = str.indexOf(split)) > 0)
			result = str.substring(0, index);
		return result;
	}

	/**
	 * @功能：根据split分割strs获得数组，该数组是否存在str
	 * @参数：
	 * @param strs
	 *            分割字符串
	 * @param split
	 *            分隔符
	 * @param str
	 *            比较的字符串
	 * @返回参数：boolean 默认返回false
	 */
	public static boolean isSplitStrsExistStr(String strs,String split, String str) {
		boolean bl = false;
		if (isNotEmpty(strs)&&str!=null&&split!=null) {
			String[] idsarr = strs.split(split);
			for (int j = 0; j < idsarr.length; j++) {
				if (idsarr[j].equals(str)) {
					bl = true;
					break;
				}
			}
		}
		return bl;
	}

	/**
	 * @功能：url方式编码字符串
	 * @参数：
	 * @param str
	 *            字符串
	 * @param charset
	 *            字符集 
	 * @返回参数：String 默认返回空串
	 */
	public static String urlEncoder(String str, String charset) throws UnsupportedEncodingException{
		String result = "";
		if (str!=null&&isNotEmpty(charset)) {
			result = URLEncoder.encode(str, charset);
		}
		return result;
	}

	/**
	 * @功能：url方式解码字符串
	 * @参数：
	 * @param str
	 *            字符串
	 * @param charset
	 *            字符集
	 * @返回参数：String 默认返回空串
	 */
	public static String urlDecoder(String str, String charset) throws UnsupportedEncodingException{
		String result = "";
		if (str!=null&&isNotEmpty(charset)) {
			result = URLDecoder.decode(str, charset);
		}
		return result;
	}

	public static void main(String[] args){
		Short d=((Short) toNumber("22766", Short.class));
		System.out.println(d+":"+Short.MAX_VALUE);
	}
}