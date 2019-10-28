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
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

/**
 * 
 * @类名称：MQClient.java
 * @类描述：

 * @创建时间：2015年3月27日-下午4:31:36
 * @修改备注:
 * @version
 */
public class MQServer {
	private static ConnectionFactory connFac = new ConnectionFactory();
	private static Logger log = LoggerFactory.getLogger(MQServer.class);
	// private static Connection conn = null;
	private static String connFacUri = "";

	public static final boolean durable = true; // 消息队列持久化

	private static String connUser = "";
	private static String connPwd = "";
	static {
		connFacUri = PropertiesUtil.readValue("mqConnUri");
		connUser = PropertiesUtil.readValue("mqUser");
		connPwd = PropertiesUtil.readValue("mqUser");
		connFac = new ConnectionFactory();
		connFac.setConnectionTimeout(20000);
		// RabbitMQ-Server安装在本机，所以直接用127.0.0.1
		connFac.setHost(connFacUri);
		connFac.setUsername(connUser);
		connFac.setPassword(connPwd);

	}

	/**
	 * 
	 * @描述 :收消息信息方法
	
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
	public static String RecvMessage(String queue_name) {
		Connection conn = null;

		try {

			// 创建一个连接
			conn = connFac.newConnection();
			System.out.println("conn create !");

		} catch (Exception e) {
			conn = null;
		}

		if (conn == null) {
			return "";
		}
		Channel channel = null;
		try {
			// 创建一个渠道
			channel = conn.createChannel();

			// 为channel定义queue的属性，queueName为Queue名称
			// 声明消息队列，且为可持久化的
			channel.queueDeclare(queue_name, durable, false, false, null);
			channel.basicQos(1);// 消息分发处理
			String msg1 ="";
			// 配置好获取消息的方式
			QueueingConsumer consumer = new QueueingConsumer(channel);
			// 取消autoAck 非阻塞模式
			channel.basicConsume(queue_name, false, consumer);
//			while (true) {
//				try {

					// 获取消息，如果没有消息，这一步将会一直阻塞
					Delivery delivery = consumer.nextDelivery();
					log.info("core接受返回信息："
							+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
									.format(new Date()));

					msg1 = new String(delivery.getBody());
					log.debug("Mq Receiver get message");

					// // 确认消息，已经收到
					try {
						channel.basicAck(delivery.getEnvelope()
								.getDeliveryTag(), false);
					} catch (IOException e) {
						e.printStackTrace();
					}
//					break;
//				} finally {
//
//					Thread.sleep(100);
//				}

//			}
			log.info("core接受返回信息：received message[" + msg1 + "] from "
					+ queue_name);

			return msg1;

		} catch (Exception e) {
			return "";
		} finally {
			try {
				channel.close();
				conn.close();
			} catch (IOException e) {
				System.out.println("close channel error" + queue_name);
			}
		}
	}

}
