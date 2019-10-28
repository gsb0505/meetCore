package com.kd.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	
	 public static long[] getDistanceTimes(String str1, String str2) {  
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        Date one;  
	        Date two;  
	        long day = 0;  
	        long hour = 0;  
	        long min = 0;  
	        long sec = 0;  
	        try {  
	            one = df.parse(str1);  
	            two = df.parse(str2);  
	            long time1 = one.getTime();  
	            long time2 = two.getTime();  
	            long diff ;  
	            if(time1<time2) {  
	                diff = time2 - time1;  
	            } else {  
	                diff = time1 - time2;  
	            }  
	            day = diff / (24 * 60 * 60 * 1000);  
	            hour = (diff / (60 * 60 * 1000) - day * 24);  
	            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
	            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        long[] times = {day, hour, min, sec};  
	        return times;  
	    }
	 
	 public static String getNextDay(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, -1);  
        date = calendar.getTime();  
        return new SimpleDateFormat("yyyy-MM-dd").format(date);  
	 }  
}
