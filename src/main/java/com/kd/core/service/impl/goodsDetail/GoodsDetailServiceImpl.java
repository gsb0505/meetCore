package com.kd.core.service.impl.goodsDetail;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.goodsDetail.GoodsDetailDao;
import com.kd.core.entity.GoodsDetail;
import com.kd.core.service.goodsDetail.GoodsDetailService;

public class GoodsDetailServiceImpl extends BaseServiceImpl<GoodsDetail, GoodsDetailDao> implements GoodsDetailService{


	@Override
	public int getGoodsByGid(GoodsDetail goodsDetail) {
		return dao.getGoodsByGid(goodsDetail);
	}


}
