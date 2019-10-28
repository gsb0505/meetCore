package com.kd.core.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;

public class HttpUtil {
	
	public static void download(String downUrl,String localUrl){
		File file = new File(localUrl);
		
		try {
			if (file.exists()) {
				throw new Exception("创建单个文件" + localUrl + "失败，目标文件已存在！");
			}
			if (localUrl.endsWith(File.separator)) {
				throw new Exception("创建单个文件" + localUrl + "失败，目标不能是目录！");
			}
			if (!file.getParentFile().exists()) {
				System.out.println("目标文件所在路径不存在，准备创建。。。");
				if (!file.getParentFile().mkdirs()) {
					throw new Exception("创建目录文件所在的目录失败！");
				}
			}
			// 创建目标文件
			if (file.createNewFile()) {
				System.out.println("创建单个文件" + localUrl + "成功！");
			} else {
				throw new Exception("创建单个文件" + localUrl + "失败！");
			}

			URL url=new URL(downUrl);
			InputStream is=url.openStream();
			
			InputStreamReader isr = new InputStreamReader(is, "GBK");
			BufferedReader reader = new BufferedReader(isr);
			BufferedWriter writer  = new BufferedWriter(new FileWriter(file));
			String line = reader.readLine();
			while(line != null){
				writer.write(line);
				line = reader.readLine();
			}
			reader.close();
			writer.close();
			isr.close();
			is.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
