package com.kd.core.util;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class StringUtil {
	
	/**
     * 只判断单个String.trim()是否为空
     * 若非空则返回true,否则返回false
     * @param str
     * @return boolean
     */
    public static boolean iStrTrim(String str) {
        if (!"".equals(str) && null != str) {
            if (!"".equals(str.trim()) && null != str.trim()) return true;
        } 
        return false;
    }
    
    /**
     * 只判断单个String是否为空(无论有没全角或半角的空格)
     * 若非空则返回true,否则返回false
     * @param str
     * @return boolean
     */
    public static boolean iStr(String str) {
        if (!"".equals(str) && null != str) return true;
        return false; 
    }
    
    /**
     * 只判断多个String是否为空(无论有没全角或半角的空格)
     * 若非空则返回true,否则返回false
     * @param str
     * @return boolean
     */
    public static boolean iAryStr(String ...str) {
        if(null == str) return false;
        for (String s : str) {
            if(!iStr(s)) return false;
        }
        return true;
    }
    
   /**
    * 只判断多个String.trim()是否为空
    * 若非空则返回true,否则返回false
    * @param str
    * @return boolean
    */
   public static boolean iAryStrTrim(String ...str){
       if(null == str) return false;
       for (String s : str) {
           if(!iStrTrim(s)) return false;
       }
       return true;
   }
      
    /** 
     * 截取字符串，字母、汉字都可以，汉字不会截取半 
     * @param str 字符串 
     * @param n 截取的长度，字母数，如果为汉字，一个汉字等于两个字母数 
     * @return 
     */  
    public static String subStringByByte(String str, int n){  
        int num = 0;  
        try {  
            byte[] buf = str.getBytes("GBK");  
            if(n>=buf.length){  
                return str;  
            }  
            boolean bChineseFirstHalf = false;  
            for(int i=0;i<n;i++)  
            {  
                if(buf[i]<0 && !bChineseFirstHalf){  
                    bChineseFirstHalf = true;  
                }else{  
                    num++;  
                    bChineseFirstHalf = false;                
                }  
            }  
        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return str.substring(0,num);  
    }  
}
