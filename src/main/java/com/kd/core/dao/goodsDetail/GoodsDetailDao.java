package com.kd.core.dao.goodsDetail;

import com.kd.core.base.BaseDao;
import com.kd.core.entity.GoodsDetail;


public interface GoodsDetailDao extends BaseDao<GoodsDetail>{
	
	//根据商品id查询在商品是否被会议预约有则返回1 否则返回-1
	public int getGoodsByGid(GoodsDetail goodsDetail);
	
	public Integer deleteOrderDetail(String tradeorderId);
	

}
