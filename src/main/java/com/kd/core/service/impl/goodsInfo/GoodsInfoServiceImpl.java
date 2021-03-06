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
    public Boolean updateGoodsToNumber(GoodsDetail goodsDetail,Boolean flag){
        //修改库存、购买次数
        GoodsInfo qgoodsInfo = dao.getModelLock(goodsDetail.getGinfoId());
        GoodsInfo ugoodsInfo = new GoodsInfo();
        ugoodsInfo.setId(goodsDetail.getGinfoId());
        if (flag){
        	//购买商品
        	//购买数量+
        	ugoodsInfo.setOrderNum(qgoodsInfo.getOrderNum()+goodsDetail.getNum());
        	if (qgoodsInfo.getCount()-goodsDetail.getNum() <0){
        		return false;
        	}
        	//剩余数量-
        	ugoodsInfo.setCount(qgoodsInfo.getCount()-goodsDetail.getNum());
        }else{
        	//退购商品
        	//购买数量+
            ugoodsInfo.setOrderNum(qgoodsInfo.getOrderNum()-goodsDetail.getNum());
            //剩余数量-
            ugoodsInfo.setCount(qgoodsInfo.getCount()+goodsDetail.getNum());
        }
        Integer count = dao.updateNumber(ugoodsInfo);
        if (count>0){
        	return true;
        }else{
        	return false;
        }
    }

    @Override
    public int getSelectedCount(GoodsInfo goodsInfo) {
        return dao.getSelectedCount(goodsInfo);
    }


}
