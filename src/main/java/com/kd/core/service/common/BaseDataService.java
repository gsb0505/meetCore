/**
 * 
 */
package com.kd.core.service.common;

import java.util.List;

import com.kd.core.base.BaseService;
import com.kd.core.dao.common.BaseDataDao;
import com.kd.core.entity.BaseData;
import com.kd.core.entity.ColumnDefine;
import com.kd.core.entity.OrgDescInfo;

/**
 *
 *@类名称：BaseDataService.java
 *@类描述：

 *@创建时间：2015年1月23日-上午9:55:49
 *@修改备注:
 *@version 
 */
public interface BaseDataService extends BaseService<BaseData>{
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
	public List<BaseData> searchInfo();
}
