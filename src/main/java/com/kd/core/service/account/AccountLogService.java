package com.kd.core.service.account;


import com.kd.core.base.BaseService;
import com.kd.core.dto.AgentAccountLogDto;


public interface AccountLogService extends BaseService<AgentAccountLogDto>{
	/**
	 * 查询总日志金额
	 * @return
	 */
	public Double searchTotalMoney();
}
