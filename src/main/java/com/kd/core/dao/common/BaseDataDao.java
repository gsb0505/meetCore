/**
 * 
 */
package com.kd.core.dao.common;


import java.util.List;

import com.kd.core.base.BaseDao;
import com.kd.core.entity.BaseData;
import com.kd.core.entity.ColumnDefine;

/**
 *
 *@类名称：CommonDao.java
 *@类描述：基础表数据DAO

 *@创建时间：2015年1月23日-上午9:39:33
 *@修改备注:
 *@version 
 */
public interface BaseDataDao extends BaseDao<BaseData>{
	public List<ColumnDefine> getColumns(ColumnDefine column);
	/**
	 * 
	 *@描述  ：自动生成业务码
	
	 *@创建时间：2015年3月16日 上午9:43:38
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param typeId
	 *@return
	 */
	public String getMaxCode(String typeId);
	
	/**
	 * @方法描述：判断参数是否唯一
	 * @创建人：glt
	 * @创建时间：20151019
	 * @param baseData
	 * @return
	 */
	public BaseData isUnique_param(BaseData baseData);
	
	//查询所有基础信息
	public List<BaseData> findInfo();
}
