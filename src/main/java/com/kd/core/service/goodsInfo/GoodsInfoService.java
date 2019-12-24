package com.kd.core.service.goodsInfo;

import com.kd.core.base.BaseService;
import com.kd.core.entity.GoodsDetail;
import com.kd.core.entity.GoodsInfo;

public interface GoodsInfoService extends BaseService<GoodsInfo>{


    /**
     * 更新商品购买数量和库存
     * @param goodsDetail
     */
    public void updateGoodsToNumber(GoodsDetail goodsDetail,Boolean flag);

}
