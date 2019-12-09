package com.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kd.common.unit.util.EncryptUtils;
import com.kd.core.entity.BaseData;
import com.kd.core.util.DesUtil;
import com.kd.core.util.RedisUtil;
import com.kd.core.util.SerializationUtil;
import com.kd.core.util.TimeUtil;

public class testTime {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
//		testTFrame();
		testDesc();
//		testTime();
	}
	
	public static void testTFrame(){
		byte[] ar=RedisUtil.get("BaseData".getBytes());
		List<BaseData> baseDatas=(List<BaseData>) SerializationUtil.deserialize(ar);
		List<BaseData> bases=new ArrayList<>();
		for (BaseData baseData : baseDatas) {
			if(baseData.getTypeId().equals("6")){
				bases.add(baseData);
			}
		}
		DateFormat df = new SimpleDateFormat("HH:mm");
		for (BaseData baseData : bases) {
			System.out.println("code："+baseData.getName());
			String[] timeStr=baseData.getRemark().split("-");
			 try {
				long now = df.parse(df.format(new Date())).getTime();
				long start = df.parse(timeStr[0]).getTime();
				long end = df.parse(timeStr[1]).getTime();
				if(now>=start && now<end){
					System.out.println("时间段："+baseData.getName());
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void testDesc(){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str=DesUtil.encryptBasedDes("2017-06-30 00:00:00", "12345678");
		System.out.println(str);
		System.out.println(DesUtil.decryptBasedDes(str, "12345678"));
		
		 Date dt1 = null;
         Date dt2 = null;
		try {
			dt1 = df.parse("2016-10-10 15:06:38");
			dt2 = df.parse("2016-10-11 15:06:38");
		} catch (Exception e) {
			// TODO: handle exception
		}
         if (dt1.getTime() > dt2.getTime()) {
        	 System.out.println("hello");
         }else{
        	 System.out.println("fuck you");
         }
           
	}
	
	public static void testTime() throws ParseException{
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String d1 = sdf.format(new Date());//第一个时间
//			String d2 =sdf.format(sdf.parse("2016-12-22"));
//			
//			if(d1.equals(d2)){
//				System.out.println("aaaaaaaaaaaaaaaaaaa");
//			}else{
//				System.out.println("bbbbbbbbbbbbbbbbbbb");
//			}
////			20161017133655
////			20161009160937
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String d2 =sdf.format(sdf.parse("2016-12-21"));
		System.out.println(d2);
		String d3=TimeUtil.getNextDay(new Date());
		System.out.println(d2+" "+d3);
		if(d2.equals(d3)){
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
		}else{
			System.out.println("bbbbbbbbbbbbbbbbbbbbbbbb");
		}
	}

}
