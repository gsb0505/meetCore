package com.kd.core.service.common;

import com.kd.core.base.BaseService;
import com.kd.core.entity.Config;

public interface ConfigService  extends BaseService<Config>{

	String quertBaseDate();
	
	String searchMaxCode();

	public Config getModelByCode(String code);
}
