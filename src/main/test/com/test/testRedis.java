package com.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.kd.core.entity.Config;
import com.kd.core.util.BaseUtil;
import com.kd.core.util.PropertiesUtil;
import com.kd.core.util.RedisUtil;
import com.kd.core.util.SerializationUtil;

public class testRedis {
	
	public static void main(String[] args) {
//		testTerminalId();
//		testSetList();
		testDeposit();
//		testZERO();
	}
	
	public static void testTerminalId(){
		String name="terminalId";
		String terId = PropertiesUtil.readValue("terId");
		DecimalFormat myformat = new DecimalFormat();
		myformat.applyPattern("0000");
		Boolean exists=RedisUtil.exists(name);
		if(!exists){
			RedisUtil.set(name, "0");
		}
		int num=Integer.parseInt(RedisUtil.get(name))+1;
		RedisUtil.set(name, num+"");
		String terminalId =myformat.format(num); 
		System.out.println("terminalId:"+(terId+terminalId));
		RedisUtil.del(name);
	}
	
	public static void testSetList(){
		String name="alist";
		List<String> lists=new ArrayList<>();
		lists.add("1");
		lists.add("2");
		lists.add("3");
		lists.add("4");
		lists.add("5");
		lists.add("6");
		if(!RedisUtil.exists(name.getBytes())){
			RedisUtil.set(name.getBytes(),SerializationUtil.serialize(lists));
		}
		byte[] ar=RedisUtil.get(name.getBytes());
		lists=(List<String>) SerializationUtil.deserialize(ar);
		for (String b : lists) {
			System.out.println("b："+b);
		}
	}
	
	public static void testDeposit(){
//		String name="deposit";
		String name="card_sub_Name";
//		byte[] ar=RedisUtil.get(name.getBytes());
//		List<Config> configs=(List<Config>) SerializationUtil.deserialize(ar);
//		for (Config config : configs) {
//			System.out.println(config.getCode()+" "+config.getRemark());
//		}
		RedisUtil.del(name.getBytes());
	}
	
	public static void testZERO(){
//		System.out.println(BaseUtil.addZeroForNum("aaa", 16));
		System.out.println("aaaa"+RedisUtil.get("open210905197807210546"));
	}
	
}
