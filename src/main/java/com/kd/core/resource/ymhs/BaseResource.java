package com.kd.core.resource.ymhs;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kd.core.util.Md5Encrypt;

public class BaseResource {
	private static Logger log = LoggerFactory.getLogger(BaseResource.class);
	/**
	 * 请求错误编码
	 * @author sunc
	 */
	protected static enum ErrorCode{
		/** 请求成功*/
		XT00000,
		/** 商户异常（商户不存在或未激活）*/
		XT00001,		
		/** 终端异常（终端不存在或未激活）*/
		XT00002,		
		/** 签名错误*/
		XT00003,		
		/** 终端流水号和批次号已存在*/
		XT00004,		
		/** 订单不存在*/
		XT00005,		
		/** 未知错误*/
		XT00006,		
		/** 卡片不存在*/
		XT00007,
		/** 余额不足*/
		XT00008,
		/** 参数不合法*/
		XT00009,		
		/**外部流水号、批次号不合法*/
		XT00010,
		/**未开卡*/
		XT00011,
		/**上送失败*/
		XT00012,
		/**卡异常*/
		XT00013,
		/**psam绑定错误*/
		XT00014,
		/**未找到相应的交易*/
		XT00015,
		/**数据更新异常*/
		XT00016
	}
	
	/**交易状态*/
	protected enum TradeStatus{
		/**交易成功*/
		JY10001,
		/**交易失败*/
		JY10002,
	}
	
	/**
	 * 卡状态
	 * @author sunc
	 */
	protected enum CardStatus{
		/** 正常卡*/
		CP00000,
		/** 黑名单卡*/
		CP00001,
	}
	protected final static String terminal_type_pos = "7001";
	protected final static String terminal_type_pos1 = "7002";
	protected static Map<ErrorCode,String> ERROR_MESSAGE = new HashMap<ErrorCode,String>();
	protected static Map<String,String> TradeType = new HashMap<String,String>();
	
	protected static Long[] TIME_NODE = new Long[3];
	protected static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HHmmss");
	
	protected static Map<String, String> ERROR_MESSAGE_HSYKT = new HashMap<String, String>();
	
	
	static{
		try{
			TIME_NODE[0] = TIME_FORMAT.parse("125959").getTime();
			TIME_NODE[1] = TIME_FORMAT.parse("185959").getTime();
			TIME_NODE[2] = TIME_FORMAT.parse("235959").getTime();
		}catch(Exception e){
			log.error(e.getMessage());
		}
		ERROR_MESSAGE.put(ErrorCode.XT00000, "请求成功");
		ERROR_MESSAGE.put(ErrorCode.XT00001, "商户异常（商户不存在或未激活）");
		ERROR_MESSAGE.put(ErrorCode.XT00002, "终端异常（终端不存在或未激活）");
		ERROR_MESSAGE.put(ErrorCode.XT00003, "签名错误");
		ERROR_MESSAGE.put(ErrorCode.XT00004, "终端流水号和批次号已存在");
		ERROR_MESSAGE.put(ErrorCode.XT00005, "订单不存在");
		ERROR_MESSAGE.put(ErrorCode.XT00006, "未知错误");
		ERROR_MESSAGE.put(ErrorCode.XT00007, "卡不存在");
		ERROR_MESSAGE.put(ErrorCode.XT00008, "余额不足");
		ERROR_MESSAGE.put(ErrorCode.XT00009, "参数不合法");
		ERROR_MESSAGE.put(ErrorCode.XT00010, "外部流水号、批次号不合法");
		ERROR_MESSAGE.put(ErrorCode.XT00011, "此卡片未开卡");
		ERROR_MESSAGE.put(ErrorCode.XT00012, "上送失败");
		ERROR_MESSAGE.put(ErrorCode.XT00013, "卡异常");
		ERROR_MESSAGE.put(ErrorCode.XT00014, "psam绑定错误");
		ERROR_MESSAGE.put(ErrorCode.XT00015, "未找到相应的记录");
		ERROR_MESSAGE.put(ErrorCode.XT00016, "数据更新异常");
		
		
		TradeType.put("4001", "LX40001");//消费
		TradeType.put("4002", "LX40002");//充值
		TradeType.put("4003", "LX40003");//补卡
		TradeType.put("4004", "LX40004");//冲正
		TradeType.put("4005", "LX40005");//退款
		
		ERROR_MESSAGE_HSYKT.put("CE00001", "卡存在异常");
		ERROR_MESSAGE_HSYKT.put("CE00002", "空对象");
		ERROR_MESSAGE_HSYKT.put("CE00003", "金额异常");
		ERROR_MESSAGE_HSYKT.put("CE00004", "数据交互异常");
		ERROR_MESSAGE_HSYKT.put("CE00005", "卡存在异常");
		ERROR_MESSAGE_HSYKT.put("YKTE0001", "SOCKET异常");
		ERROR_MESSAGE_HSYKT.put("YKTE0002", "包文校验异常");
		ERROR_MESSAGE_HSYKT.put("YKTE0003", "SOCKET超时异常");
		ERROR_MESSAGE_HSYKT.put("YKTE0004", "SOCKET读错误");
		ERROR_MESSAGE_HSYKT.put("YKTE0005", "组包异常");
		
	}
	

	
	protected final SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * 获取时间段编码
	 * @param tradeTime
	 * @return
	 */
	protected static String getTFrame(String tradeTime){
		
		tradeTime = tradeTime.substring(8, tradeTime.length());
		try {
			Long data = TIME_FORMAT.parse(tradeTime).getTime();
			int code = 6000;
			for (int i = 0; i < TIME_NODE.length; i++) {
				if(data<=TIME_NODE[i]){
					return (code+i+1)+"";
				}
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return null;
	}

	
	protected byte[] errorMessage_hsykt(String code,String message){
		
		JSONObject json = new JSONObject();
		json.put("code", code);
		if(message == null || "".equals(message)){
			json.put("message", ERROR_MESSAGE_HSYKT.get(code));
		}else{
			json.put("message", message);
		}
		JSONObject retMessage = new JSONObject();
		JSONArray array = new JSONArray();
		array.add(json);
		retMessage.put("retMessage", array);
		System.out.println(retMessage.toString());
		log.debug(retMessage.toString());
		try {
			return retMessage.toJSONString().getBytes("gbk");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	
	
	/**
	 * 失败返回信息
	 * @param code 错误码
	 * @return
	 */
	protected byte[] resultMessage(ErrorCode code){
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("message", ERROR_MESSAGE.get(code));
		JSONObject retMessage = new JSONObject();
		JSONArray array = new JSONArray();
		array.add(json);
		retMessage.put("retMessage", array);
		System.out.println(retMessage.toString());
		log.debug(retMessage.toJSONString());
		try {
			return retMessage.toJSONString().getBytes("gbk");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	/**
	 * 成功返回信息
	 * @param json 数据
	 * @return
	 */
	protected byte[] resultMessage(JSONObject json){
		JSONObject json1 = new JSONObject();
		json1.put("code", "XT00000");
		json1.put("message", "");
		JSONArray array1 = new JSONArray();
		JSONArray array2 = new JSONArray();
		array1.add(json1);
		array2.add(json);
		JSONObject retInfo = new JSONObject();
		retInfo.put("retMessage",array1);
		retInfo.put("retInfo", array2);
		System.out.println(retInfo.toString());
		log.info(retInfo.toJSONString());
		try {
			return retInfo.toJSONString().getBytes("gbk");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
			return null;
		}
	}
	
	/**
	 * 成功返回信息
	 * @param json 数据
	 * @return
	 */
	protected byte[] resultMessage(String toJsonString){
		JSONObject json1 = new JSONObject();
		json1.put("code", "XT00000");
		json1.put("message", "");
		JSONArray array1 = new JSONArray();
		JSONArray array2 = new JSONArray().parseArray(toJsonString);
		array1.add(json1);
		JSONObject retInfo = new JSONObject();
		retInfo.put("retMessage",array1);
		retInfo.put("retInfo", array2);
		System.out.println(retInfo.toString());
		log.info(retInfo.toJSONString());
		try {
			return retInfo.toJSONString().getBytes("gbk");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
			return null;
		}
	}

	protected boolean checkSign(String parmValue,String sign){
		System.out.println(parmValue);
		String md5 = Md5Encrypt.md5(parmValue).toUpperCase();
		System.out.println("md5:"+"\t"+md5);
		System.out.println("sign:"+"\t"+sign);
		if(md5.equals(sign)){
			return true;
		}else{
			log.debug("签名字符串："+parmValue);
			log.debug("md5 :"+md5);
			log.debug("sign:"+sign);			
			return false;			
		}
	}
	

}
