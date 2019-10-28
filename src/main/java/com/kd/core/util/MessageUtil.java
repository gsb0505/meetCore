package com.kd.core.util;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * @类描述：解析json
 * @创建者：glt
 * @创建时间：20150921
 * @author kd003
 *
 */
public class MessageUtil {
	
	private static Logger log = LoggerFactory.getLogger(MessageUtil.class);
	/**
	 * 获取json值
	 * 
	 * @param jsonStr
	 *            json串
	 * @param keyName
	 *            json key
	 * @return 调用decodeJSONObjects返回key值
	 */
	public static String decodeJSONObjects(String jsonStr, String keyName) {
		JSONObject json =  JSONObject.fromObject(jsonStr);
		String keyValues = "";
		Iterator<String> keys = json.keys();
		JSONObject jo = null;
		Object o;
		String key;
		while (keys.hasNext()) {
			key = keys.next();
			o = json.get(key);
			if (o instanceof JSONObject) {
				jo = (JSONObject) o;
				if (jo.keySet().size() > 0) {
					keyValues = decodeJSONObjects(jo.toString(), keyName);
					if (!keyValues.isEmpty()) {
						break;
					}
				} else {
					System.out.println(key + "--" + o);
					keyValues =o.toString();
					break;
				}
			} else {
				if (keyName.toLowerCase().equals(key.toLowerCase())) {
					keyValues =  o.toString();
					break;
				}
			}
		}
		return keyValues;
	}

	public static JSONArray decodeJSONObjectList(String jsonStr, String keyName) {
		JSONObject json = JSONObject.fromObject(jsonStr);
		JSONArray keyValues = null;
		Iterator<String> keys = json.keys();
		JSONObject jo = null;
		Object o;
		String key;
		while (keys.hasNext()) {
			key = keys.next();
			o = json.get(key);
			if (keyName.toLowerCase().equals(key.toLowerCase())) {
				keyValues = JSONArray.fromObject(o);
			} else {
				if (o instanceof JSONObject) {
					jo = (JSONObject) o;
					if (jo.keySet().size() > 0) {
						keyValues = decodeJSONObjectList(jo.toString(), keyName);
						if (keyValues != null) {

							break;
						}
					}
				} else {
					if (keyName.toLowerCase().equals(key.toLowerCase())) {
						keyValues = JSONArray.fromObject(o);
						break;
					}
				}
			}
		}
		return keyValues;
	}
}
