package com.kd.core.quartz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.dao.orderDetail.OrderDetailDao;
import com.kd.core.entity.OrderDetail;

public class AutoUpdateOrderStatus{

	@Autowired
	private OrderDetailDao orderDetailDao;
	
	private final static String ORDERSTATUS="【实时更新订单状态】";
	
	private Logger logger=LoggerFactory.getLogger(AutoUpdateOrderStatus.class);
	
	public void updateOrderStatus(){
		logger.info(ORDERSTATUS+" 准备获取已结束的会议记录进行订单更新。。。。。。");
		
		List<OrderDetail> orders=orderDetailDao.getIsOverOrder();
		
		logger.info(ORDERSTATUS+" 获取到的已结束的会议记录数是："+orders.size());
		
		if(orders.size()<=0){
			logger.info("未找到需要更新狀態的訂單！");
			return;
		}
		
		logger.info(ORDERSTATUS+" 获取到记录 准备进行状态更新。。。。。。");
		
		for (OrderDetail orderDetail : orders) {
			if(orderDetail.getErrCode().equals("2")){
				orderDetail.setErrCode(5); //使用中
			}else{
				orderDetail.setErrCode(4);
			}
			orderDetailDao.update(orderDetail);
		}
		
		logger.info(ORDERSTATUS+"此次数据，更新完成。。。。");
	}

}
