/**
 * 
 */
package com.kd.core.mq.rabbit;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.core.util.PropertiesUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * 
 * @类名称：MQClient.java
 * @类描述：
 * @创建时间：2015年3月27日-下午4:31:36
 * @修改备注:
 * @version
 */
public class MQClient {
	private static ConnectionFactory connFac = new ConnectionFactory();
	private static Connection conn = null;
	private static String connFacUri = "";
	private static Logger log = LoggerFactory.getLogger(MQClient.class);

	public static final boolean durable = true; // 消息队列持久化

	private static String connUser = "";
	private static String connPwd = "";
	static {
		connFacUri = PropertiesUtil.readValue("mqConnUri");
		connUser = PropertiesUtil.readValue("mqUser");
		connPwd = PropertiesUtil.readValue("mqUser");
		// RabbitMQ-Server安装在本机，所以直接用127.0.0.1
		connFac.setHost(connFacUri);
		connFac.setUsername(connUser);
		connFac.setPassword(connPwd);
		try {
			log.info("获取连接属性：ip:"+connFac.getHost()+" 用户名："+connFac.getUsername()+" 密码："+connFac.getPassword());
			// 创建一个连接
			conn = connFac.newConnection();
			log.info("MQClient创建连接成功");
			System.out.println("conn create !");

		} catch (Exception e) {
			e.printStackTrace();
			conn = null;
			log.info("创建连接失败："+e.getMessage());
			System.out.println("conn create error!"+e.getMessage());
		}
	}

	/**
	 * 
	 * @描述 ：发送信息方法
	
	 * @创建时间：2015年4月9日 下午4:36:28
	 * @修改人：
	 * @修改时间：
	 * @修改描述：
	 * @param topic
	 *            主题
	 * @param tags
	 * @param body
	 *            请求的参数2进制数组
	 * @return
	 */
	public static boolean sendMessage(String body,
			String queue_name) {
		log.info("开始发送mq消息");
		if (conn == null) {
			return false;
		}
		Channel channel = null;
		try {

			// 创建一个渠道
			channel = conn.createChannel();

			// 为channel定义queue的属性，queueName为Queue名称
			// 声明消息队列，且为可持久化的
			channel.queueDeclare(queue_name, durable, false, false, null);
			log.info("core发送信息："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));


			channel.basicPublish("", queue_name,
					MessageProperties.PERSISTENT_TEXT_PLAIN, body.getBytes());

			log.info("core发送信息[" + body + "] to " + queue_name
					+ " success!");

			return true;

		} catch (Exception e) {
			return false;
		}
		finally{
			try {
				channel.close();
			} catch (IOException e) {
				System.out.println("close channel error" + queue_name);
			}
		}
	}
}
