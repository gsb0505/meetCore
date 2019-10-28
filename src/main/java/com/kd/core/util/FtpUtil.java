package com.kd.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUtil {
	/**
	 * Description: 从FTP服务器下载文件
	 * 
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 * @throws IOException
	 */

	public static boolean downFile(String url, int port, String username,
			String password, String fileName, String localPath)
			throws IOException {
		// 初始表示下载失败
		boolean success = false;
		// 创建FTPClient对
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.setConnectTimeout(6000);
			ftp.connect(url, port);
			
			
			// 登录ftp
			ftp.login(username, password);
		
			ftp.enterLocalPassiveMode();
			reply = ftp.getReplyCode();
			ftp.setDataTimeout(60000);

			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			// 转到指定下载目录
			ftp.changeWorkingDirectory(url);
			// 列出该目录下所有文件
			FTPFile[] fs = ftp.listFiles();
			// 遍历所有文件，找到指定的文件
			for (FTPFile ff : fs) {

				String ftpFileName = new String(ff.getName().getBytes(
						"ISO-8859-1"), "gbk");
				if (ftpFileName.equals(fileName)) {
					// 根据绝对路径初始化文件
					File localFile = new File(localPath);
					// 输出流
					OutputStream is = new FileOutputStream(localFile);
					// 下载文件
					ftp.retrieveFile(ff.getName(), is);
					is.close();

					success = true;
					break;
				}
			}

			ftp.logout();
			// 下载成功

		} catch (IOException e) {
			if (ftp.isConnected()) {
				ftp.disconnect();

			}
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				ftp.disconnect();
			}
		}
		if (ftp.isConnected()) {
			ftp.disconnect();
		}
		return success;

	}

//	public static void main(String[] args) {
//		String path = System.getProperty("user.dir").replace("bin",
//				"logs/tradelogs/");
//		// downFile("211.138.112.133",21,"13738195188","33010014","ZH_13738195188_20130522.Result_1",path+"\\test.log");
//		String recv = "9PAY0001|AAA|2011-4-11 00:00:00|2011-4-11 00:00:00|1|1|0|13333333333|50.00|49.24|50.00|2";
//		String[] tmp = null;
//		tmp = recv.split("\\|");
//		for (int i = 0; i < tmp.length; i++) {
//			System.out.println(i + "  " + tmp[i]);
//		}
//	}
}
