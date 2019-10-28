package com.kd.core.util;
import java.security.PublicKey;
import java.security.SecureRandom;

import javax.crypto.Cipher;  
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;  
import javax.crypto.spec.DESKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
  
public class DesUtil {   
	private static Logger log = LoggerFactory.getLogger(DesUtil.class);
	/* 
    * DES算法密钥 
    */  
   private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128, -65 };  
   /** 
    * 数据加密，算法（DES） 
    * 
    * @param data 
    *            要进行加密的数据 
    * @return 加密后的数据 
    */  
   public static String encryptBasedDes(String data,String des_key) {  
       String encryptedData = null;  
       try {  
           // DES算法要求有一个可信任的随机数源  
           SecureRandom sr = new SecureRandom();  
           DESKeySpec deskey = new DESKeySpec(des_key.getBytes());  
           // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象  
           SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
           SecretKey key = keyFactory.generateSecret(deskey);  
           // 加密对象  
           Cipher cipher = Cipher.getInstance("DES");  
           cipher.init(Cipher.ENCRYPT_MODE, key, sr);  
           // 加密，并把字节数组编码成字符串  
           byte[] bt = data.getBytes("UTF-8");
           encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(bt));  
       } catch (Exception e) {  
//           log.error("加密错误，错误信息：", e);  
           throw new RuntimeException("加密错误，错误信息：", e);  
       }  
       log.debug("加密串："+encryptedData);
       return encryptedData.replaceAll("\r\n",""); 
   } 
   
   /** 
    * 数据解密，算法（DES） 
    * 
    * @param cryptData 
    *            加密数据 
    * @return 解密后的数据 
    */  
   public static String decryptBasedDes(String cryptData,String des_key) {  
       String decryptedData = null;  
       try {  
           // DES算法要求有一个可信任的随机数源  
           SecureRandom sr = new SecureRandom();  
           DESKeySpec deskey = new DESKeySpec(des_key.getBytes());  
           // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象  
           SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
           SecretKey key = keyFactory.generateSecret(deskey);  
           // 解密对象  
           Cipher cipher = Cipher.getInstance("DES");  
           cipher.init(Cipher.DECRYPT_MODE, key, sr);  
           // 把字符串解码为字节数组，并解密  
           decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)),"UTF-8");  
       } catch (Exception e) {  
//           log.error("解密错误，错误信息：", e);  
           throw new RuntimeException("解密错误，错误信息：", e);  
       }  
       return decryptedData;  
   }  
   
}