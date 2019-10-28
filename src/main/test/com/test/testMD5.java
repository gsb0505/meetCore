package com.test;

import com.kd.core.util.BaseUtil;
import com.kd.core.util.Md5Encrypt;

public class testMD5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//签名验证
		//订单明细md5
		StringBuilder sb=new StringBuilder();
//		sb.append("10991028").append("0300000090001816")
//		.append("20161009160937").append("20161010160937").append("test96");
//		System.out.println("订单明细加密之后："+Md5Encrypt.md5(sb.toString()));
		//余额查询
//		sb.append("10991028").append("0300000090001939").append("test96");
//		System.out.println("余额查询加密之后："+Md5Encrypt.md5(sb.toString()));
//		sb.append("10991028").append("key123");
		sb.append("10991318").append("100002").append("100002").append("0300000090000345").append("EF9499B800000000").append("11").append("830000E00096").append("123456");
		System.out.println("终端加密："+Md5Encrypt.md5(sb.toString()).toUpperCase());
	}
	
}
