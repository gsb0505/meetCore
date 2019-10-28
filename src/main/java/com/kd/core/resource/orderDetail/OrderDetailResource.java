package com.kd.core.resource.orderDetail;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kd.core.entity.OrderDetail;
import com.kd.core.entity.UserLog;
import com.kd.core.service.orderDetail.OrderDetailService;
import com.kd.core.service.system.UserLogService;

/**
 * 订单明细
 * @author thq
 *
 */
@Path("/orderDetail")
public class OrderDetailResource {
	
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private UserLogService userLogService;
	
	@GET
	@Path("query")
	public List<OrderDetail> query(@QueryParam("orderDetail") String orderDetail){
		List<OrderDetail> list=null;
		try {
			OrderDetail order = new Gson().fromJson(orderDetail.replace("+", " "), OrderDetail.class);
			list = orderDetailService.getPagedList(order);
			if (list != null && list.size() > 0) {
				list.get(0).setPageCount(order.pageCount);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@GET
	@Path("queryOld")
	public List<OrderDetail> queryOld(@QueryParam("orderDetail") String orderDetail){
		OrderDetail order = new Gson().fromJson(orderDetail.replace("+", " "),OrderDetail.class);
		List<OrderDetail> list = orderDetailService.getPagedListOld(order);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(order.pageCount);
		}
		return list;
}

	@GET
	@Path("exitByParam")
	public Boolean exitByParam(@QueryParam("orderDetail") String orderDetail){
		OrderDetail order = new Gson().fromJson(orderDetail.replace("+", " "),OrderDetail.class);
		Boolean res = orderDetailService.exitByParam(order);
		return res;
	}
	@GET
	@Path("getModel")
	public OrderDetail getModel(@QueryParam("orderDetail") String orderDetail){
		OrderDetail order = new Gson().fromJson(orderDetail.replace("+", " "),OrderDetail.class);
		OrderDetail res = orderDetailService.getModel(order);
		return res;
	}
	
	/**
	 * 退款 
	 * @return
	 */
	@GET
	@Path("handle")
	public boolean handle(@QueryParam("orderDetail") String orderDetail){
		OrderDetail order = new Gson().fromJson(orderDetail.replace("+", " "),OrderDetail.class);
		boolean res = orderDetailService.updateErrCode(order);
		UserLog us = new UserLog();
		us.setAction("handle");
		us.setUserId(order.getCreator());
		us.setCreateTime(new Date());
		us.setRemark("修改交易状态为失败");
		us.setType("0");
		
		if(res){
			us.setResult("操作成功");
		}else{
			us.setResult("操作失败");
		}
		userLogService.insert(us);
		return res;
	}
	
	/**
	 * 
	 *@描述:订单添加
	
	 *@创建时间：2017年6月20日 下午4:29:51
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param
	 *@return
	 *
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("add")
	@Produces(MediaType.TEXT_HTML)
	public String addOrder(OrderDetail orderDetail) throws Exception{
		orderDetail.setGlideNo(orderDetailService.getTraceNumber());
		return String.valueOf(orderDetailService.insert(orderDetail));
	}
	
	/**
	 * 
	 *@描述	:待审核数据查询
	
	 *@创建时间：2017年6月23日 下午5:38:18
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param
	 *@return
	 *

	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("queryCheck")
	public List<OrderDetail> queryCheck (@QueryParam("orderDetail") String orderDetail
			) throws Exception {
		OrderDetail a= new Gson().fromJson(orderDetail, OrderDetail.class);
		List<OrderDetail> list = orderDetailService.getCheck(a);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(a.pageCount);
		}
		return list;
	}
	
	/**
	 * 
	 *@描述	:获取待审核的单条数据对象
	
	 *@创建时间：2017年6月23日 下午5:38:18
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param
	 *@return
	 *
	 * @param agentId
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("toCheck/{glideNo}")
	public OrderDetail findOrderCheckById(@PathParam("glideNo") String glideNo) throws Exception {
		OrderDetail ord = new OrderDetail(); 
		ord.setGlideNo(glideNo);
		OrderDetail orderDetail = orderDetailService.getModel(ord);
		return orderDetail;
	}
	
	/**
	 * 
	 *@描述:会议审核
	
	*@创建时间：2017年6月23日 下午5:38:18
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param
	 *@return
	 *
	 * @return
	 * @throws Exception 
	 */
	@GET
	@Path("check")
	public String checkAgent(@QueryParam("glideNo") String glideNo) throws Exception{
		return ""+orderDetailService.checkOrderDetail(glideNo);
	}
	
	@POST
	@Path("modify")
	@Produces(MediaType.TEXT_HTML)
	public String update(OrderDetail orderDetail){
		return ""+orderDetailService.update(orderDetail);
	}
}
