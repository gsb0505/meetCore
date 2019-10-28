/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test;

/**
 *
 * @author Administrator
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

	public static void main(String[] args) throws UnsupportedEncodingException {
	int times = 1;
        String ip = "220.171.31.78";
        int port = 7778;
        times = 1;

		byte[] dt1=null;
        try {
            dt1 = Client.sender(times, ip, port, init1047());
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("返回包 : " + dt1);
        String str =new String(dt1, 7, dt1.length - 7);
        
		System.out.println("End : " + new String(str.getBytes("GBK"),"UTF-8"));

        
	}

    public static byte[] init1058() {
		byte[] head = { (byte)0X10, (byte)0X58, 0, 0, 0, 0, 0 };
      
        String dataS1="";
             
                dataS1+=FormatString(0,"1058",4," ");
                dataS1+=FormatString(0,"830000A00388",16," ");
                dataS1+=FormatString(0,"1	",1," ");
                dataS1+=FormatString(0,"20140623082700",14," ");
                dataS1+=FormatString(0,"3",8," ");
                dataS1+=FormatString(0,"0300000000056134",16," ");
                dataS1+=FormatString(0,"2F82843200000000",16," ");
                dataS1+=FormatString(0,"11",4," ");
                dataS1+=FormatString(0,"02",4," ");
                dataS1+=FormatString(0,"830000A00388",16," ");
                dataS1+=FormatString(0,"20140623081100",14," ");
                dataS1+=FormatString(0,"1000",8," ");
                dataS1+=FormatString(0,"76389",8," ");
                dataS1+=FormatString(0,"17",2," ");
                dataS1+=FormatString(0,"830000A00388",16," ");
                dataS1+=FormatString(0,"20140623082700",14," ");
                dataS1+=FormatString(0,"1",6," ");
                dataS1+=FormatString(0,"205",6," ");
                dataS1+=FormatString(0,"CA758B90",8," ");
                dataS1+=FormatString(0,"8300",4," ");
                dataS1+=FormatString(0,"0021",4," ");
                dataS1+=FormatString(0,"0100",4," ");
                dataS1+=FormatString(0,"20131130113447",14," ");
                dataS1+=FormatString(0,"VN00000000000016",16," ");
                dataS1+=FormatString(0,"admin",8," ");

                System.out.println("发送包："+dataS1);
		try{
                byte[] body = dataS1.getBytes("GBK");

		byte[] tempLen = intToWord(7 + body.length);

		
		head[5] = tempLen[0];
		head[6] = tempLen[1];

		byte[] sendData = new byte[head.length + body.length];
		System.arraycopy(head, 0, sendData, 0, head.length);
		System.arraycopy(body, 0, sendData, head.length, body.length);

		return sendData;
                 }
                catch(Exception e){
                }
                return null;
	}
    
    
    public static byte[] init5088() {
		byte[] head = { (byte)0X50, (byte)0X88, 0, 0, 0, 0, 0 };

        String dataS1="";
             
                dataS1+=FormatString(0,"5088",4," ");
                dataS1+=FormatString(0,"830000E00080",16," ");
                dataS1+=FormatString(0,"1",16," ");
                dataS1+=FormatString(0,"10901011",16," ");
                dataS1+=FormatString(0,"160811",16," ");
                dataS1+=FormatString(0,"1",1," ");
                dataS1+=FormatString(0,"0300000090001832",16," ");
                dataS1+=FormatString(0,"2F82843200000000",16," ");
                dataS1+=FormatString(0,"11",2," ");
                dataS1+=FormatString(0,"24",2," ");
                dataS1+=FormatString(0,"0",8," ");
                dataS1+=FormatString(0,"0",8," ");
                dataS1+=FormatString(0,"0",8," ");
                dataS1+=FormatString(0,"0991",4," ");
                dataS1+=FormatString(0,"8300",4," ");
                dataS1+=FormatString(0,"0000",4," ");
                dataS1+=FormatString(0,"9C0AD977",8," ");
                dataS1+=FormatString(0,"1",1," ");
                dataS1+=FormatString(0,"",16," ");
                dataS1+=FormatString(0,"01",2," ");
                dataS1+=FormatString(0,"330282198410078248",36," ");
                dataS1+=FormatString(0,"20160811",8," ");
                dataS1+=FormatString(0,"03",2," ");
                dataS1+=FormatString(0,"10000001",8," ");
                dataS1+=FormatString(0,"0",8," ");
                dataS1+=FormatString(0,"0",32," ");

                System.out.println("发送包："+dataS1);
		try{
                byte[] body = dataS1.getBytes("GBK");

		byte[] tempLen = intToWord(7 + body.length);
		System.out.println(body.length);

		
		head[5] = tempLen[0];
		head[6] = tempLen[1];

		byte[] sendData = new byte[head.length + body.length];
		System.arraycopy(head, 0, sendData, 0, head.length);
		System.arraycopy(body, 0, sendData, head.length, body.length);

		return sendData;
                 }
                catch(Exception e){
                }
                return null;
	}
    public static byte[] init1047() {
  		byte[] head = { (byte)0X10, (byte)0X47, 0, 0, 0, 0, 0 };
        
          String dataS1="";
               
                  dataS1+=FormatString(0,"1047",4," ");
                  dataS1+=FormatString(0,"830000E00080",16," ");
                  dataS1+=FormatString(0,"160811",16," ");
                  dataS1+=FormatString(0,"0300000090001831",16," ");
                  dataS1+=FormatString(0,"2F82843200000000",16," ");
                  dataS1+=FormatString(0,"11",4," ");
                  dataS1+=FormatString(0,"23",4," ");
                  dataS1+=FormatString(0,"1000",8," ");
                 

                  System.out.println("发送包："+dataS1);
  		try{
                  byte[] body = dataS1.getBytes("GBK");

  		byte[] tempLen = intToWord(7 + body.length);

  		
  		head[5] = tempLen[0];
  		head[6] = tempLen[1];

  		byte[] sendData = new byte[head.length + body.length];
  		System.arraycopy(head, 0, sendData, 0, head.length);
  		System.arraycopy(body, 0, sendData, head.length, body.length);

  		return sendData;
                   }
                  catch(Exception e){
                  }
                  return null;
  	}

	private static final byte[] intToWord(int i) {
		byte[] word = new byte[2];
		word[0] = (byte) (i >>> 8 & 0xFF);
		word[1] = (byte) (i & 0xFF);
		return word;
	}

	public static byte[] sender(int times, String hostIP, int port, byte[] content){
		System.gc();
		if (times <= 0 || content == null) {
			System.out.println("times <= 0 || content == null");
			return null;
		}
		byte[] retData = null;
		byte[] returnData = null;
		int bodyCounter = 0;
		int bodyLength = 0;

		Socket client = null;
		InputStream input = null;
		OutputStream output = null;

		try {
			client = new Socket(hostIP, port);
			input = client.getInputStream();
			output = client.getOutputStream();


			for(int a = 0; a < times; a++){//loop test
				bodyCounter = 0;
				output.write(content);
				output.flush();

				byte[] head = new byte[7];
				for(int i = 0; i < 7; i++){
					head[i] = (byte)input.read();
				}
		        bodyLength = ((head[5] & 0X000000FF) << 8 | (head[6] & 0X000000FF)) - 7;
		        retData = new byte[bodyLength];

		        for (int tt = 0; tt < bodyLength; tt++) {
		        	++bodyCounter;
		        	retData[tt] = (byte)input.read();
		        }

		        if (bodyCounter != bodyLength) {
		        	System.out.println(a + " :: " + new String(retData));
		        	break;
		        } else {
		        	returnData = new byte[bodyLength + 7];
		        	System.arraycopy(head, 0, returnData, 0, 7);
		        	System.arraycopy(retData, 0, returnData, 7, bodyLength);
		        	System.out.println(a + " - " + new String(retData));
		        }
			}
		} catch (Exception e) {
		} finally {
			try {
				if (client != null){
					client.close();
				}
				input = null;
				output = null;
				client = null;
			} catch (IOException e) {
			}
			System.gc();
		}
		return returnData;
	}
    //type 0 为锟斤拷 1 为锟揭诧拷 锟斤拷formatString 要锟斤拷式锟斤拷锟斤拷锟街凤拷 len 锟斤拷式锟斤拷锟斤拷某锟斤拷锟�锟斤拷flag 锟斤拷锟斤拷锟斤拷锟�
    public static String FormatString(int type, String formatString, int len, String flag) {
        StringBuffer result = new StringBuffer();
        int srcLen = formatString.length();
        int formatLen = len - srcLen;
        if (type == 1) {//锟揭诧拷
            result.append(formatString.trim());
        }
        for (int i = 0; i < formatLen; i++) {
            result.append(flag);
        }
        if (type == 0) {//锟斤拷
            result.append(formatString.trim());
        }
        return result.toString();
    }
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }
}
