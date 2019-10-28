package com.kd.core.service.impl.common;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.common.ConfigDao;
import com.kd.core.entity.Config;
import com.kd.core.service.common.ConfigService;

public class ConfigServiceImpl extends BaseServiceImpl<Config, ConfigDao> implements ConfigService {

	@Override
	public String quertBaseDate() {
		// TODO Auto-generated method stub
		return dao.quertBaseDate();
	}

	@Override
	public String searchMaxCode() {
		return dao.findMaxCode();
	}

	@Override
	public Config getModelByCode(String code) {
		return dao.getModelByCode(code);
	}

}
