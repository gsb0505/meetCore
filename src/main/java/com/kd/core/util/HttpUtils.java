package com.kd.core.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HttpUtils {
	
	
	public static String  send(String url,String data) {
		
		String receive = "";
		try {
			URL urlConn = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlConn.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setConnectTimeout(30000);
			connection.setReadTimeout(30000);
			
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			
			out.write(data);
			out.flush();
			out.close();
			

			
			StringBuffer recvData = new StringBuffer();
			String line;

			BufferedReader urlReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			Thread.sleep(1000);
			while ((line = urlReader.readLine()) != null) {
				recvData.append(line + "\r\n");
			}
			urlReader.close();
			receive = recvData.toString().trim();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		return receive;
	}
	
	public static void main(String[] args) {
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String url = "http://116.236.192.117:8080/aop/rest";
		StringBuffer data =  new StringBuffer() ;
		data.append("").append("app_key=xxsms");
		data.append("&").append("method=allinpay.card.msg.add");
		data.append("&").append("timestamp=").append(sdf.format(now));
		data.append("&").append("sign_v=1.0");
		data.append("&").append("v=1.0");
		data.append("&").append("sign=sdfsd");
		data.append("&").append("sign_method=md5");
		data.append("&").append("session=");
		data.append("&").append("format=xml");
//		data.append("&").append("app_secret=xxsms1aopreq20150210173004frC5PSoa");
		data.append("&").append("order_id=123456789");
		data.append("&").append("phone_num_array=18158194627");
		data.append("&").append("msg_text=你的验证码是：6789");
		data.append("&").append("msg_sign=123456789");
		data.append("&").append("send_time=").append(sdf.format(now));
		
		
		System.out.println(send(url, data.toString()));
		
		
	}
}
