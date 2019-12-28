
package com.kd.core.dao.goodsInfo;

import com.kd.core.base.BaseDao;
import com.kd.core.entity.GoodsInfo;

public interface GoodsInfoDao extends BaseDao<GoodsInfo>{

    /**
     * 更新库存数量
     * @param goodsInfo
     * @return
     */
    public int updateNumber(GoodsInfo goodsInfo);

    /**
     * 获得商品信息--加排他锁
     * @param id
     * @return
     */
    public GoodsInfo getModelLock(String id);

    /**
     * 查询数量
     * @param goodsInfo
     * @return
     */
    public int getSelectedCount(GoodsInfo goodsInfo);


}
