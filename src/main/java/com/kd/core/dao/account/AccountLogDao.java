package com.kd.core.dao.account;



import com.kd.core.base.BaseDao;
import com.kd.core.dto.AgentAccountLogDto;



public interface AccountLogDao extends BaseDao<AgentAccountLogDto> {
	
	/**
	 * 查询总日志金额
	 * @return
	 */
	public Double findTotalMoney();
}
