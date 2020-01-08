package com.kd.core.quartz;

import java.util.List;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.dao.orderDetail.OrderDetailDao;
import com.kd.core.entity.OrderDetail;
import com.kd.core.util.PropertiesUtil;


public class AutoSendMeetNoticTOEmail {
	
	private Logger logger=LoggerFactory.getLogger(AutoSendMeetNoticTOEmail.class);
	
	private static String serverUri = PropertiesUtil.readValue("manage.emil.url");//"http://localhost:8082/meetCore/goodsInfo";
	
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
					Invocation.Builder request = client.target(serverUri + "semail/sendEmail.do").queryParam("meetName",orderDetail.getMeetName())
							.queryParam("meetRoomName",orderDetail.getMeetRoomName())
							.queryParam("meetStartTime",orderDetail.getMeetStartTime())
							.queryParam("e_mail",orderDetail.getEmail()).request();
					request.header("Content-type", MediaType.APPLICATION_JSON);
					request.buildGet().submit();
//							.queryParam("meetName",orderDetail.getMeetName())
//							.queryParam("meetRoomName",orderDetail.getMeetRoomName())
//							.queryParam("meetStartTime",orderDetail.getMeetStartTime())
//							.queryParam("e_mail",orderDetail.getEmail());
					//Response res = target.request().get();
					
					logger.info(EMAILLOGGERNAME+" 下发"+orderDetail.getEmail()+"成功。。。。。。");
					
				}
			}
		}
		
		
	}
}
