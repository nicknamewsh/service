package com.pt.ssm.util;

import java.security.MessageDigest;

public class MD5Util {
	/**
	 * md5解密 登录使用此方法32位解密
	 * @param sourceStr
	 * @return
	 */
	public static String ECMD5(String sourceStr) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(sourceStr.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString().substring(8, 24);

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	/**
	 * md5加密 注册使用此方法64位加密
	 * @param sourceStr
	 * @return
	 */
	public static String encryptionMD5(String sourceStr) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(sourceStr.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
