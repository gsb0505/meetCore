package com.kd.core.service.impl.goodsInfo;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.goodsInfo.GoodsInfoDao;
import com.kd.core.entity.GoodsDetail;
import com.kd.core.entity.GoodsInfo;
import com.kd.core.service.goodsInfo.GoodsInfoService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class GoodsInfoServiceImpl extends BaseServiceImpl<GoodsInfo, GoodsInfoDao> implements GoodsInfoService {


    @Override
    @Transactional
    public void updateGoodsToNumber(GoodsDetail goodsDetail){
        //修改库存、购买次数
        GoodsInfo qgoodsInfo = dao.getModelLock(goodsDetail.getGinfoId());
        GoodsInfo ugoodsInfo = new GoodsInfo();
        ugoodsInfo.setId(goodsDetail.getGinfoId());
        //购买数量+
        ugoodsInfo.setOrderNum(qgoodsInfo.getOrderNum()+goodsDetail.getNum());
        //剩余数量-
        ugoodsInfo.setCount(qgoodsInfo.getCount()-goodsDetail.getNum());
        dao.updateNumber(ugoodsInfo);
    }

}
