package com.kd.core.dao.common;

import com.kd.core.base.BaseDao;
import com.kd.core.entity.Config;

public interface ConfigDao extends BaseDao<Config> {

	String quertBaseDate();
	
	String findMaxCode();

	public Config getModelByCode(String code);
}
