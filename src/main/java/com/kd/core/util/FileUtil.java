package com.kd.core.util;


import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


/**
 * User: thq Date: 15-5-29
 */
public class FileUtil {
	private static String url = "http://188.220.190.15:9060/";
	private static String http = "127.0.0.1";
	private static Integer port = 8118;
	private static Logger log = LoggerFactory.getLogger(FileUtil.class);
	private static String TradeInterfaceId;

	static {
//		url = PropertiesUtil.readValue("neimengpowerurl");
//		http = PropertiesUtil.readValue("neimengpowerhttp");
//		port = Integer.valueOf(PropertiesUtil.readValue("neimengpowerport"));
		// TradeInterfaceId =
		// PropertiesUtil.readValue("neimengpowerTradeInterfaceId");
		// InterfaceAccountInfo interfaceAccount = CloudService
		// .getInterfaceMessage(TradeInterfaceId);
		//
		// url = interfaceAccount.getRechargeURL();
	}

	public static  boolean DownFile(String fileName) {

		HttpClient client = new HttpClient();
		// 设置代理 J_20150603_pldk_01.txt
		client.getHostConfiguration().setProxy(http, port);
		PostMethod post = new PostMethod(url + "PldkFileDownload.do");
		NameValuePair p1 = new NameValuePair("fileName", fileName);
		post.setRequestBody(new NameValuePair[] { p1 });
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			client.executeMethod(post);
			Header[] hs = post.getResponseHeaders();
			for (Header header : hs) {
				System.out.println(header.getName() + ":" + header.getValue());
			}
			Header file_header = post.getResponseHeader("Content-Disposition");
			if (file_header == null) {
				System.out.println("@@"
						+ new String(post.getResponseBodyAsString().getBytes(
								"ISO8859-1"), "GBK"));
			} else {
				is = post.getResponseBodyAsStream();
				System.out.println(is.available());
				fos = new FileOutputStream(new File("d:\\J_20150603_pldk_01.txt"));
				byte[] b = new byte[1024];
				while (is.read(b) != -1) {
					fos.write(b);
				}
			}

		} catch (Exception e) {
			return false;
		} finally {
			try {
				is.close();
				fos.close();
				post.releaseConnection();
			} catch (Exception e) {
			}

		}
		return true;
	}

	public static String UploadFile(String filePath) {

		HttpClient client = new HttpClient();
		// 设置代理
		client.getHostConfiguration().setProxy(http, port);

		PostMethod post = new PostMethod(url + "DkfhFileUpload.do");
		try {
			File file = new File(filePath);// 需上传文件
			Part[] parts = { new FilePart(file.getName(), file) };
			post.setRequestEntity(new MultipartRequestEntity(parts, post
					.getParams()));
			int status;

			status = client.executeMethod(post);
			if (status == HttpStatus.SC_OK) {
				System.out.println("upload success!!!");
				String result = post.getResponseBodyAsString();// 返回结果
				result = new String(result.getBytes("ISO8859-1"), "GBK");
				System.out.println(result);
				return result;
			} else {
				return "-2!@!发送文件异常";
			}
		} catch (Exception e) {
			return "-2!@!发送文件异常";
		} finally {
			post.releaseConnection();
		}
	}

}
