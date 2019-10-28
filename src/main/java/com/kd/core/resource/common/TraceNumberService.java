package com.kd.core.resource.common;

/**
 * 
 */

import java.util.HashMap;
import java.util.Map;

import com.kd.core.util.PropertiesUtil;
import com.kd.common.unit.util.DateUtil;
import com.kd.common.unit.util.JedisUtil;

/**
 * 
 * @类名称：TraceNumberService.java
 * @类描述：
 * @创建时间：2015年7月15日-上午9:29:44
 * @修改备注:
 * @version
 */
public class TraceNumberService {

	public static JedisUtil jedis = null;
	private static String branchTeller = "";
	private  static String code = "";
	static {
		String host =PropertiesUtil.readValue("redisIP");// 产品编号 ;
		int port = 6379;
		int db = 0;
		int timeout = 60000;
		// TODO 根据接口账户获取相关参数（从数据库当中）
		branchTeller = PropertiesUtil.readValue("NMbranchTeller");
		code =PropertiesUtil.readValue("NMCode");
		// String password = "89bbb657ed7b11e4:NScloud000";
		jedis = new JedisUtil(host, port, db, timeout, null);
	}

	private static volatile Map<String, Integer> GLIDEMAP = new HashMap<String, Integer>();
	private String GLIDEKEY = "ProductId:{productId}:GLIDENO";
	private String STEPKEY = "ProductId:{productId}:STEP";
	private String GLIDENO = "ProductId:{productId}:GLIDENO:CURR";

	public String getGlideNo(String productId, int len) {
		 String	seq = fillGlideNoZero(getSeq(productId, len), len);

		return fillGlideNo(seq);

	}

	public String getGlideNo_hsykt(String productId, int len) {

		return fillGlideNoZero(getSeq(productId, len), len);

	}
	// 8位序列数
	public synchronized String getSeq(String productId, int len) {
		// 获取Map中流水
		int currGlideNo = 0;
		int mapGlideNo = 0;
		try {
			currGlideNo = GLIDEMAP.get(GLIDEKEY.replace("{productId}",
					productId));
			mapGlideNo = GLIDEMAP
					.get(GLIDENO.replace("{productId}", productId));
		} catch (Exception e) {

		}

		if (currGlideNo <= 0) {
			currGlideNo = getRedisGlideNo(productId, len);
		}

		// 步长流水全部使用完，重新取流水
		if (currGlideNo >= mapGlideNo) {
			currGlideNo = getRedisGlideNo(productId, len);
			currGlideNo++;
		} else {
			currGlideNo++;
		}
		GLIDEMAP.put(GLIDEKEY.replace("{productId}", productId), currGlideNo);

		return String.valueOf(currGlideNo);

	}

	// 从内存数据库中获取流水号
	public int getRedisGlideNo(String productId, int len) {
		String key = GLIDEKEY.replace("{productId}", productId);
		String step = jedis.get(STEPKEY.replace("{productId}", productId));

		if (step == null || "".equals(step)) {
			step = "50";
		}

		int rStep = Integer.parseInt(step);
		int glideNo = jedis.incrby(key, rStep); // 不存的时候返回步长。
		int sumStep = 99990000;
		if (len == 7) {
			sumStep = 9999000;
		}
		if (glideNo + rStep >= sumStep) {// 序列超出范围
			glideNo = 1;
			jedis.set(key, String.valueOf(glideNo + rStep));
		}
		GLIDEMAP.put(key, glideNo);
		GLIDEMAP.put(GLIDENO.replace("{productId}", productId), glideNo + rStep);

		return glideNo;
	}

	// 时间（14）+服务器代码（2）+产品代码（4）+（预留2位）+8位随机数
	public String fillGlideNo(String seq) {
		String date = DateUtil.getIntervalDay(0, "yyyyMMdd");
		String ret =code+branchTeller +date + seq;
		return ret;
	}

	// seq为流水，len为填充的长度
	public static String fillGlideNoZero(String seq, int len) {
		// BigDecimal big = new BigDecimal(seq);
		StringBuilder strbu = new StringBuilder(10);
		strbu.append(seq);
		for (int i = 0, length = len - strbu.length(); i < length; i++) {
			strbu.insert(0, 0);
		}
		return strbu.toString();
	}

	public static void main(String[] args) {
		TraceNumberService b = new TraceNumberService();
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "-->" + b.getGlideNo("0009", 8));
		}
	}
}
