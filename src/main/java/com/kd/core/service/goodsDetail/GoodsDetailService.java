package com.kd.core.service.goodsDetail;

import com.kd.core.base.BaseService;
import com.kd.core.entity.GoodsDetail;

public interface GoodsDetailService extends BaseService<GoodsDetail>{
	
	//根据商品id查询在商品是否被会议预约有则返回1 否则返回-1
	public int getGoodsByGid(GoodsDetail goodsDetail);

}
