package com.kd.core.service.impl.orderDetail;


import java.util.List;

import com.kd.core.dao.goodsInfo.GoodsInfoDao;
import com.kd.core.entity.GoodsInfo;
import com.kd.core.service.goodsInfo.GoodsInfoService;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.goodsDetail.GoodsDetailDao;
import com.kd.core.dao.orderDetail.OrderDetailDao;
import com.kd.core.entity.GoodsDetail;
import com.kd.core.entity.OrderDetail;
import com.kd.core.resource.common.TraceNumberService;
import com.kd.core.service.orderDetail.OrderDetailService;
import com.kd.core.util.PropertiesUtil;

public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail, OrderDetailDao> implements OrderDetailService {

    @Autowired
    private GoodsDetailDao gdDetailDao;
    @Autowired
    private GoodsInfoDao goodsInfoDao;
    @Autowired
    private GoodsInfoService goodsInfoService;

    public void setGdDetailDao(GoodsDetailDao gdDetailDao) {
        this.gdDetailDao = gdDetailDao;
    }

    public void setGoodsInfoDao(GoodsInfoDao goodsInfoDao) {
        this.goodsInfoDao = goodsInfoDao;
    }

    /**
     * @return
     * @方法描述：生成流水号
     * @创建时间：20151211
     * @创建人：glt
     */
    public String getTraceNumber() {
        String BranchTeller = PropertiesUtil.readValue("BranchTeller");
        TraceNumberService tn = new TraceNumberService();
        String traceNumber = tn.getGlideNo(BranchTeller, 7);
        return traceNumber;
    }


    public String getTraceNumber_hsykt() {
        String BranchTeller = PropertiesUtil.readValue("BranchTeller_hsykt");
        TraceNumberService tn = new TraceNumberService();
        String traceNumber = tn.getGlideNo(BranchTeller, 8);
        return traceNumber;
    }

    public String getTraceNumber_settle() {
        String BranchTeller = PropertiesUtil.readValue("settleNumber");
        TraceNumberService tn = new TraceNumberService();
        String traceNumber = tn.getGlideNo(BranchTeller, 8);
        return traceNumber;
    }


    @Override
    public Boolean exitByParam(OrderDetail order) {
        return dao.exitByParam(order) > 0;
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
        return dao.updateErrCode(orderDetail) > 0;
    }


    @Override
    public boolean updateRequestFlag(OrderDetail orderDetail) {
        return dao.updateRequestFlag(orderDetail) > 0;
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


    @Transactional
    public boolean addOrder(OrderDetail orderDetail) {
        int gcount = 0;
        if (orderDetail.getErrCode() == null){
            orderDetail.setErrCode(1);
        }
        if (meetVerifi(orderDetail) == false){
        	return false;
        }
        int ocount = dao.insert(orderDetail);

        if (ocount > 0 && orderDetail.getGoodsDetailList() != null) {
            for (GoodsDetail goodsDetail :
                    orderDetail.getGoodsDetailList()) {
                goodsDetail.setTradeorderId(orderDetail.getId());
                //修改库存、购买次数
                goodsInfoService.updateGoodsToNumber(goodsDetail,true);

                gcount += gdDetailDao.insert(goodsDetail);
            }
        }

        if (ocount > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updateOrder(OrderDetail orderDetail) {
        int gcount = 0;
        if (orderDetail.getErrCode() == null){
            orderDetail.setErrCode(1);
        }
        if (meetVerifi(orderDetail) == false){
        	return false;
        }
        int ocount = dao.update(orderDetail);

        if (ocount > 0 && orderDetail.getGoodsDetailList() != null) {
        	GoodsDetail gd = new GoodsDetail();
        	gd.setTradeorderId(orderDetail.getId());
        	//获取原来订购商品
        	List<GoodsDetail> GoodsDetailList = gdDetailDao.getModelList(gd);
        	for (GoodsDetail goodsDetail :GoodsDetailList){
//        		原订购商品回归库存
        		 goodsInfoService.updateGoodsToNumber(goodsDetail,false);
        	}        	
        	//删除原有商品
        	gdDetailDao.deleteOrderDetail(orderDetail.getId());
        	//现有商品进行添加
            for (GoodsDetail goodsDetail :
                    orderDetail.getGoodsDetailList()) {
                goodsDetail.setTradeorderId(orderDetail.getId());
                //修改库存、购买次数
                goodsInfoService.updateGoodsToNumber(goodsDetail,true);

                gcount += gdDetailDao.insert(goodsDetail);
            }
        }

        if (ocount > 0) {
            return true;
        }
        return false;
    }

    /**
     * @param
     * @param info 实体对象
     * @return
     * @描述：获取待审核的数据
     * @创建时间：2015年1月19日 下午2:42:20
     * @修改人：
     * @修改时间：
     * @修改描述：
     */
    @Override
    public List<OrderDetail> getCheck(OrderDetail info) {

        return dao.getPagedCheck(info);
    }

    /**
     * @param
     * @param info 实体对象
     * @return
     * @throws Exception 这个异常用于以后的回滚
     * @描述：审核门店用户(门店账户添加一条数据+门店表更新状态)
     * @创建时间：2015年1月19日 下午2:42:20
     * @修改人：
     * @修改时间：
     * @修改描述：
     */
    @Override
    public boolean checkOrderDetail(String glideNo) {
        OrderDetail ai = new OrderDetail();
        ai.setGlideNo(glideNo);
        ai.setErrCode(2);
        int i = dao.update(ai);
        if (i < 0) {
            return false;
        }
        return true;
    }

	@Override
	public boolean cancelOrder(OrderDetail orderDetail) {
	        if (orderDetail.getErrCode() == null){
	            orderDetail.setErrCode(3);
	        }
	        int ocount = dao.update(orderDetail);
	        OrderDetail od = dao.getModel(orderDetail);

	        if (ocount > 0 && od.getGoodsDetailList() != null) {
	        	GoodsDetail gd = new GoodsDetail();
	        	gd.setTradeorderId(od.getId());
	        	//获取原来订购商品
	        	List<GoodsDetail> GoodsDetailList = gdDetailDao.getModelList(gd);
	        	for (GoodsDetail goodsDetail :GoodsDetailList){
//	        		原订购商品回归库存
	        		 goodsInfoService.updateGoodsToNumber(goodsDetail,false);
	        	}        	
	        }

	        if (ocount > 0) {
	            return true;
	        }
	        return false;
	}

	@Override
	public boolean meetVerifi(OrderDetail orderDetail) {
		String cStartTime = orderDetail.getMeetStartTime();
		String cEndTime = orderDetail.getMeetEndTime();
		String id = orderDetail.getId();
		OrderDetail od = new OrderDetail();
		od.setMeetDate(orderDetail.getMeetDate());
		od.setMeetRoomID(orderDetail.getMeetRoomID());
		List<OrderDetail> odList = dao.getModelList(od);
		boolean flag = true;
		
		for (OrderDetail orderDetail2 : odList) {
			String mStartTime = orderDetail2.getMeetStartTime();
			String mEndTime = orderDetail2.getMeetEndTime();
			if (orderDetail2.getErrCode()==3 || orderDetail2.getId().equals(id)){
				continue;
			}
			//若字符串等于参数字符串、则返回0，字符串小于参数字符串、则返回值小于0，字符串大于参数字符串、返回值大于0。
			Integer sCompare = mStartTime.compareTo(cStartTime);
			Integer eCompare = mEndTime.compareTo(cEndTime);
			Integer seCompare = mStartTime.compareTo(cEndTime);
			Integer esCompare = mEndTime.compareTo(cStartTime);
			
			if ((sCompare==0)){
				flag =false;
				break;
			}
			if (sCompare<0 && eCompare >=0){
				flag =false;
				break;
			}
			if (sCompare<0 && esCompare >0){
				flag =false;
				break;
			}
			if (sCompare>0 && eCompare <=0 ){
				flag =false;
				break;
			}
			if (seCompare<0 && eCompare >=0){
				flag =false;
				break;
			}
		}
	
		// TODO Auto-generated method stub
		return flag;
	}

}
