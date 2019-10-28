package com.kd.core.service.orderDetail;


import java.util.List;

import com.kd.core.base.BaseService;
import com.kd.core.entity.OrderDetail;

public interface OrderDetailService extends BaseService<OrderDetail> {
	public String getTraceNumber();

	public String getTraceNumber_hsykt();
	
	public String getTraceNumber_settle();
	
	Boolean exitByParam(OrderDetail order);
	
	List<OrderDetail> getNotUploadInfo(OrderDetail orderDetail);
	
	/**
	 *  根据条件查询是否存在处理中的数据
	 * @param orderDetail
	 * @return
	 */
	List<OrderDetail> getIsRequestInfo(OrderDetail orderDetail);
	
	/**
	 * 更新交易状态
	 * ps：难到不值得你写一个service吗
	 * @param orderDetail
	 * @return
	 */
	public boolean updateErrCode(OrderDetail orderDetail);
	
	/**
	 * 更新上送状态
	 * ps：难到不值得你写一个service吗
	 * @param orderDetail
	 * @return
	 */
	public boolean updateRequestFlag(OrderDetail orderDetail);
	
	

	/**
	 * 无分页查询
	 * @param orderDetail
	 * @return
	 */
//	List<OrderDetail> getModelLists(OrderDetail orderDetail);

	List<OrderDetail> getPagedListOld(OrderDetail orderDetail);


	/**
	 * 
	* @Title: findTCMoney 
	* @Description: 根据条件查询消费总金额
	* @author A18ccms A18ccms_gmail_com  
	* @date 2017年3月29日 上午11:12:54 
	* @param @param orderDetail
	* @param @return    设定文件 
	* @return OrderDetail    返回类型 
	* @throws
	 */
	OrderDetail getTCMoney(OrderDetail orderDetail);
	
	
	public boolean addOrder(OrderDetail orderDetail) ;
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
	public List<OrderDetail> getCheck(OrderDetail info);
	
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
	public boolean checkOrderDetail(String glideNo);
}
