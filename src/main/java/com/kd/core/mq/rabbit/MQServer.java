/**
 *
 */
package com.kd.core.mq.rabbit;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.core.util.PropertiesUtil;

/**
 * @类名称：MQClient.java
 * @类描述：
 * @创建时间：2015年3月27日-下午4:31:36
 * @修改备注:
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
     * @param topic 主题
     * @param tags
     * @param body  请求的参数2进制数组
     * @return
     * @描述 :收消息信息方法
     * @创建时间：2015年4月9日 下午4:36:28
     * @修改人：
     * @修改时间：
     * @修改描述：
     */
    public static String RecvMessage(final String queue_name) {
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
            String msg = "";
            // 配置好获取消息的方式
            final Channel finalChannel = channel;
            Consumer consumer = new DefaultConsumer(finalChannel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String msg = new String(body, "UTF-8");
                    System.out.println("Received message : '" + msg + "'");
                    log.info("core接受返回信息："
                            + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                            .format(new Date()));

                    log.debug("Mq Receiver get message");

                    // // 确认消息，已经收到
                    log.info("core接受返回信息：received message[" + msg + "] from "
                            + queue_name);
                    try {
                        finalChannel.basicAck(envelope.getDeliveryTag(), false);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            };
            // 开启了手工应答
            channel.basicConsume(queue_name, false, consumer);

            return msg;

        } catch (Exception e) {
            return "";
        } finally {
            try {
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                }
                conn.close();
            } catch (IOException e) {
                System.out.println("close channel error" + queue_name);
            }
        }
    }

}
