package com.chxf.user.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import org.apache.shiro.crypto.hash.SimpleHash;

import com.google.gson.Gson;

/**
 * 常用工具了 Created by Gaojun.Zhou 2019年8月5日
 */
public class BaseUtil {

	public static Object toBean(Class beanClass,HttpServletRequest request ) throws UnsupportedEncodingException {
		//请求解决乱码
		request.setCharacterEncoding("utf-8");

		Map parameterMap = request.getParameterMap();
		JSONObject json = new JSONObject();
		Iterator paIter = parameterMap.keySet().iterator();
		while (paIter.hasNext()) {
			String key = paIter.next().toString();
			String[] values = (String[]) parameterMap.get(key);
			json.put(key, values[0]);
		}
		return JSONObject.toBean(json, beanClass);
	}


	/**
	 * 转换为JSON字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		// TODO Auto-generated method stub
		if (object != null) {
			return new Gson().toJson(object);
		}
		return "";
	}

	/**
	 * 获取当前网络ip
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request){
		String ipAddress = request.getHeader("x-forwarded-for");
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
				//根据网卡取本机配置的IP
				InetAddress inet=null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress= inet.getHostAddress();
			}
		}
		//对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
			if(ipAddress.indexOf(",")>0){
				ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
	/**
	 * UUID
	 * 
	 * @return
	 */
	public static String gitUuid() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
	}

	/**
	 * MD5
	 * 
	 * @param pwd
	 * @return
	 */
	public static String MD5(String pwd) {
		// 用于加密的字符
		char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			// 使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
			byte[] btInput = pwd.getBytes();

			// 信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
			MessageDigest mdInst = MessageDigest.getInstance("MD5");

			// MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
			mdInst.update(btInput);

			// 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
			byte[] md = mdInst.digest();

			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) { // i = 0
				byte byte0 = md[i]; // 95
				str[k++] = md5String[byte0 >>> 4 & 0xf]; // 5
				str[k++] = md5String[byte0 & 0xf]; // F
			}

			// 返回经过加密后的字符串
			return new String(str);

		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 验证是否为Ajax
	 * @param request
	 * @return
	 */
	public static boolean isAjax( HttpServletRequest request ) {
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With")) ? true : false;
	}
	
	/**
	 * 重定向
	 * @param request
	 * @param response
	 */
	public static void clearRedirectLogin(HttpServletRequest request,HttpServletResponse response){
		try {
			request.getSession().invalidate();
			response.sendRedirect("/login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 密码盐值加密
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String md51024Pwd(String password,Object salt){
		return new SimpleHash("MD5", password, salt, 1024).toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(gitUuid());
		System.out.println(md51024Pwd("12345","25222"));
	}
}
