/**
*
 * @package:com.kd.core.service.impl.common
 * @projectName:cloud-core
 * @CreateTime:2015年1月22日-下午2:30:20
 *  2015杭州宽达信息技术有限公司-版权所有
 *
 */
package com.kd.core.service.impl.common;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.common.BaseDataDao;
import com.kd.core.entity.BaseData;
import com.kd.core.entity.ColumnDefine;
import com.kd.core.service.common.BaseDataService;
import com.kd.core.util.RedisUtil;
import com.kd.core.util.SerializationUtil;



public class BaseDataServiceImpl extends BaseServiceImpl<BaseData,BaseDataDao> implements BaseDataService {
	@Autowired
	private BaseDataDao baseDataDao;

	public BaseDataDao getBaseDataDao() {
		return baseDataDao;
	}

	public void setBaseDataDao(BaseDataDao baseDataDao) {
		this.baseDataDao = baseDataDao;
	}
	

	@Override
	public List<ColumnDefine> getColumns(ColumnDefine column) {
		
		return baseDataDao.getColumns(column);
	}


	@Override
	public String getMaxCode(String typeId) {
	
		return baseDataDao.getMaxCode(typeId);
	}

	@Override
	public BaseData isUnique_param(BaseData baseData) {
		// TODO Auto-generated method stub
		return baseDataDao.isUnique_param(baseData);
	}

	@Override
	public List<BaseData> searchInfo() {
		// TODO Auto-generated method stub
		return baseDataDao.findInfo();
	}
	
}
