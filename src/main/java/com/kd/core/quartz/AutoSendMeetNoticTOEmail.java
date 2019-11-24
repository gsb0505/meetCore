package com.kd.core.quartz;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.kd.core.dao.orderDetail.OrderDetailDao;
import com.kd.core.entity.OrderDetail;
import com.kd.core.service.orderDetail.OrderDetailService;
import com.kd.core.util.PropertiesUtil;


public class AutoSendMeetNoticTOEmail {
	
	private Logger logger=LoggerFactory.getLogger(AutoSendMeetNoticTOEmail.class);
	
	private static String serverUri = "http://localhost:8082/meetCore/goodsInfo";
	
	private final static String EMAILLOGGERNAME="【邮件通知】";
	
	private static String[] mina=null;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	
	/**
	 * @方法描述：自动导入汇款银行
	 * @创建人：glt
	 * @创建时间：20151207
	 */
	public void autoSendEmail(){
		
		logger.info(EMAILLOGGERNAME+" 定时器准备执行下发邮件通知。。。。。。");
		
		mina=PropertiesUtil.readValue("min").split(",");
		
		List<OrderDetail> orders=orderDetailDao.getSendEmailInfo();
		
		logger.info(EMAILLOGGERNAME+" 需要下发邮件的email用户数："+orders.size());
		
		for (OrderDetail orderDetail : orders) {
			for (int i = 0; i < mina.length; i++) {
				if(orderDetail.getRemark().equals(mina[i])){
					
					logger.info(EMAILLOGGERNAME+" 需要下发的邮箱账号是："+orderDetail.getEmail());
					
					//此处加请求manage代码 下发邮箱
					Client client = ClientBuilder.newClient();
					WebTarget target = client.target(serverUri + "/sendEmail");
					Response res = target.request().post(
							Entity.entity(orderDetail, MediaType.APPLICATION_XML));
					
					logger.info(EMAILLOGGERNAME+" 下发"+orderDetail.getEmail()+"成功。。。。。。");
					
				}
			}
		}
		
		
	}
}
