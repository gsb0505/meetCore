package com.kd.core.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.kd.core.dto.MessageDto;
import com.kd.core.entity.BaseData;
import com.kd.core.entity.Config;

import net.sf.json.JSONObject;

public class BaseUtil {
	
	private static Logger log = LoggerFactory.getLogger(BaseUtil.class);
	
	/**
	 * 函数名称：checkSign
	 * 
	 * @author 屠红青 创建时间：2014-12-29 函数功能：md5 签名验证(主密钥)
	 * @param md5Params
	 * @param requestSign
	 * @return 验证成功返回 true，失败返回false
	 */
	public static boolean checkSign(String md5Params, String requestSign) {
		System.out.println("=========md5Params.toLowerCase()========"
				+ md5Params);

		String makeSign = Md5Encrypt.md5(md5Params);

		System.out.println("===========makeSign========" + makeSign);

		System.out.println("===========requestSign========" + requestSign);

		if (makeSign.equals(requestSign)) {
			return true;
		} else {
			return false;
		}

	}
	
	public static String writeOutObjectJson(String result,
			Object value) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
//		Map<String, Object> head = new HashMap<String, Object>();
//		Map<String, Object> message = new HashMap<String, Object>();
//		head.put("result", result);
//		message.put("retcode", value);
		dataMap.put("result", result);
		dataMap.put("message", value);
		JSONObject josn = JSONObject.fromObject(dataMap);
		return josn.toString();
	}
	
	
	public static boolean isMobileNO(String mobiles){
		Pattern p=Pattern.compile("^1[3|4|5|7|8][0-9]\\d{8}$");
		Matcher m=p.matcher(mobiles);
		return m.matches();
	}
	
	
	public static String changeCase(Long cash){
		String fraction[] = {"角", "分"};
        String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String unit[][] = {{"元", "万", "亿"},
                     {"", "拾", "佰", "仟"}};
 
        String head = cash < 0? "负": "";
        cash = Math.abs(cash);
         
        String s = "";
        for (int i = 0; i < fraction.length; i++) {
            s += (digit[(int)(Math.floor(cash * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
        }
        if(s.length()<1){
            s = "整";    
        }
        int integerPart = (int)Math.floor(cash);
 
        for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
            String p ="";
            for (int j = 0; j < unit[1].length && cash > 0; j++) {
                p = digit[integerPart%10]+unit[1][j] + p;
                integerPart = integerPart/10;
            }
            s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
        }
        return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
    }
	

	/**
	 * 返回信息
	 * 
	 * @param code
	 *            返回码
	 * @param message
	 *            返回信息
	 * @return
	 */
	public final static String message(String code, String message) {
		return new Gson().toJson(new MessageDto(code, message));
	}
	
	
	//自动生成外部流水批次号
	public static String autoCreateBatchNo() {
		String name="OutBatchNo";
		String terId = PropertiesUtil.readValue("batchNo");
		DecimalFormat myformat = new DecimalFormat();
		myformat.applyPattern("000000");
		Boolean exists=RedisUtil.exists(name);
		if(!exists){
			RedisUtil.set(name, "0");
		}
		int num=Integer.parseInt(RedisUtil.get(name))+1;
		RedisUtil.set(name, num+"");
		String OutBatchNo =terId+myformat.format(num); 
		return OutBatchNo;
	}
	
	//获取时间段
	public static String getTFrame(){
		//时间段
		String TFrame_name=""; 
		
		//从redis中获取基础数据信息
		byte[] ar=RedisUtil.get("BaseData".getBytes());
		List<BaseData> baseDatas=(List<BaseData>) SerializationUtil.deserialize(ar);
		
		List<BaseData> bases=new ArrayList<>();
		//获取时间段基础信息
		for (BaseData baseData : baseDatas) {
			if(baseData.getTypeId().equals("6")){
				bases.add(baseData);
			}
		}
		
		//比较时间  获取当前时间处于什么时间段
		DateFormat df = new SimpleDateFormat("HH:mm");
		for (BaseData baseData : bases) {
			String[] timeStr=baseData.getRemark().split("-");
			 try {
				long now = df.parse(df.format(new Date())).getTime();
				long start = df.parse(timeStr[0]).getTime();
				long end = df.parse(timeStr[1]).getTime();
				if(now>=start && now<end){
					log.debug("得到最终时间段："+baseData.getName());
					TFrame_name=baseData.getCode();
				}
			} catch (ParseException e) {
				log.debug("格式化时间出现异常："+e);
			}
		}
		return TFrame_name;
	}
	
	
	public static String getDeposit(){
		String deposit="";
		try {
			byte[] ar = RedisUtil.get("deposit".getBytes());
			List<Config> configs = (List<Config>) SerializationUtil.deserialize(ar);
			for (Config config : configs) {
				if (config.getCode().equals("7001")) {
					deposit = config.getNum();
				}
			} 
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("获取押金金额："+deposit);
		log.debug("获取押金金额："+deposit);
		return deposit;
	}
	
	/**
	 * 
	* @Title: getPsamGlideNo 
	* @Description: 获取psam流水号
	* @author A18ccms A18ccms_gmail_com  
	* @date 2016年8月22日 上午10:35:46 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getPsamGlideNo(){
		String psamName="psamGlideNo";
		String value="1";
		String gildeNo=RedisUtil.get(psamName);
		if(RedisUtil.exists(psamName)){
			RedisUtil.set(psamName, (Integer.parseInt(gildeNo)+1)+"");
		}else{
			RedisUtil.set(psamName, value);
		}
		return RedisUtil.get(psamName);
	}
	
	 public static String addZeroForNum(String str, int strLength) {
	     int strLen = str.length();
	     StringBuffer sb = null;
	     while (strLen < strLength) {
	           sb = new StringBuffer();
//	           sb.append("0").append(str);// 左(前)补0
	           sb.append(str).append("0");//右(后)补0
	           str = sb.toString();
	           strLen = str.length();
	     }
	     return str;
	 }
	 public static String addLeftZeroForNum(String str, int strLength) {
	     int strLen = str.length();
	     StringBuffer sb = null;
	     while (strLen < strLength) {
	           sb = new StringBuffer();
	           sb.append("0").append(str);// 左(前)补0
	           str = sb.toString();
	           strLen = str.length();
	     }
	     return str;
	 }
}