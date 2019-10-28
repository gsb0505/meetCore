package com.kd.core.dao.orderDetail;


import java.util.List;

import com.kd.core.base.BaseDao;
import com.kd.core.entity.OrderDetail;

public interface OrderDetailDao  extends BaseDao<OrderDetail>{

		Integer exitByParam(OrderDetail order);
	
	/**
	* @Title: findNotUploadInfo 
	* @Description: 查询出未售卡提交的数据 
	* @author A18ccms A18ccms_gmail_com  
	* @date 2016年8月29日 下午2:08:33 
	* @param @param orderDetail
	* @param @return    设定文件 
	* @return List<OrderDetail>    返回类型 
	* @throws
	 */
	List<OrderDetail> findNotUploadInfo(OrderDetail orderDetail);
	
	/**
	 *  根据条件查询是否存在处理中的数据
	 * @param orderDetail
	 * @return
	 */
	List<OrderDetail> findIsRequestInfo(OrderDetail orderDetail);

	/**
	 * 更新交易状态
	 * ps：难到不值得你写一个service吗
	 * @param orderDetail
	 * @return
	 */
	int updateErrCode(OrderDetail orderDetail);

	/**
	 * 更新上送状态
	 * ps：难到不值得你写一个service吗
	 * @param orderDetail
	 * @return
	 */
	int updateRequestFlag(OrderDetail orderDetail);
	

	List<OrderDetail> getPagedListOld(OrderDetail orderDetail);
	/**
	 * 
	* @Title: findTCMoney 
	* @Description: 查询消费总金额
	* @author A18ccms A18ccms_gmail_com  
	* @date 2017年3月29日 上午11:11:09 
	* @param @param orderDetail
	* @param @return    设定文件 
	* @return OrderDetail    返回类型 
	* @throws
	 */
	OrderDetail findTCMoney(OrderDetail orderDetail);

	/**
	 * 业务订单明细分表复制
	 * @param orderDetail
	 */
	void copyOrderDetail(OrderDetail orderDetail);
	
	public List<OrderDetail> getPagedCheck(OrderDetail info);
	
	public List<OrderDetail> getMeetRoomList(String meetRoomID);
	
}