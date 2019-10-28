package com.kd.core.service.impl.orderDetail;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.orderDetail.OrderDetailDao;
import com.kd.core.entity.OrderDetail;
import com.kd.core.resource.common.TraceNumberService;
import com.kd.core.service.orderDetail.OrderDetailService;
import com.kd.core.util.PropertiesUtil;

public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail, OrderDetailDao> implements OrderDetailService {
	
	@Autowired
	private OrderDetailDao dao;
	
	/**
	 * @方法描述：生成流水号
	 * @创建时间：20151211
	 * @创建人：glt
	 * @return
	 */
	public String getTraceNumber() {
		String BranchTeller = PropertiesUtil.readValue("BranchTeller");
		TraceNumberService tn = new TraceNumberService();		
		String traceNumber =tn.getGlideNo(BranchTeller, 7);
		return traceNumber;
	}

	
	public String getTraceNumber_hsykt() {
		String BranchTeller = PropertiesUtil.readValue("BranchTeller_hsykt");
		TraceNumberService tn = new TraceNumberService();		
		String traceNumber =tn.getGlideNo(BranchTeller, 8);
		return traceNumber;
	}
	
	public String getTraceNumber_settle() {
		String BranchTeller = PropertiesUtil.readValue("settleNumber");
		TraceNumberService tn = new TraceNumberService();		
		String traceNumber =tn.getGlideNo(BranchTeller, 8);
		return traceNumber;
	}
	

	@Override
	public Boolean exitByParam(OrderDetail order){
		return dao.exitByParam(order)>0;
	}


	@Override
	public List<OrderDetail> getNotUploadInfo(OrderDetail orderDetail) {
		return dao.findNotUploadInfo(orderDetail);
	}


	@Override
	public List<OrderDetail> getIsRequestInfo(OrderDetail orderDetail) {
		return dao.findIsRequestInfo(orderDetail);
	}


	@Override
	public boolean updateErrCode(OrderDetail orderDetail) {
		return dao.updateErrCode(orderDetail)>0;
	}


	@Override
	public boolean updateRequestFlag(OrderDetail orderDetail) {
		return dao.updateRequestFlag(orderDetail)>0;
	}



//	@Override
//	public List<OrderDetail> getModelLists(OrderDetail orderDetail) {
//		return dao.getModelLists(orderDetail);
//	}
	@Override
	public List<OrderDetail> getPagedListOld(OrderDetail orderDetail) {
		return dao.getPagedListOld(orderDetail);
	}
	@Override
	public OrderDetail getTCMoney(OrderDetail orderDetail) {
		return dao.findTCMoney(orderDetail);
	}


	@Override
	public boolean addOrder(OrderDetail orderDetail) {
		//首先要验证一下这个手机号码在正式的用户当中是否已经存在
			return dao.insert(orderDetail)==1?true:false;
	}

	/**
	 * 
	 *@描述：获取待审核的数据
	
	 *@创建时间：2015年1月19日 下午2:42:20
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param
	 *@return
	 *
	 * @param info 实体对象
	 * @return
	 */
	@Override
	public List<OrderDetail> getCheck(OrderDetail info) {
	
		return dao.getPagedCheck(info);
	}
	
	/**
	 * 
	 *@描述：审核门店用户(门店账户添加一条数据+门店表更新状态)
	
	 *@创建时间：2015年1月19日 下午2:42:20
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param
	 *@return
	 *
	 * @param info 实体对象
	 * @return
	 * @throws Exception 这个异常用于以后的回滚
	 */
	@Override
	public boolean checkOrderDetail(String glideNo)  {
		OrderDetail ai=new OrderDetail();
		ai.setGlideNo(glideNo);
		ai.setErrCode(2);
		int i=dao.update(ai);
		if(i<0){
			return false; 
		}
		return true;
	}
}
