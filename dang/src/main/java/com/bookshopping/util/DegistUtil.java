package com.bookshopping.util;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class DegistUtil {
	/**
	 * 密码的加密处理
	 * @param seq：被加密的字符串
	 */
	public static String produceDegistCode(String seq) {
		try {
			//1.使用"MD5"算法为密码字符串生成对应的哈希码
			MessageDigest md5Code = MessageDigest.getInstance("MD5");
			byte[] bTmp = md5Code.digest(seq.getBytes());  //加密得到的字节数组
			
			//采用base64算法将字节数组转换成字符串
			BASE64Encoder base64 = new BASE64Encoder();
			return base64.encode(bTmp);			
		} catch (NoSuchAlgorithmException e) {			
			return null;
		}
	}
	public static void main(String[] args) {
		System.out.println("MM:"+produceDegistCode("111111"));
		System.out.println("MM:"+produceDegistCode("123456"));
	}
}
