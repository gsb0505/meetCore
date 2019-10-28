package com.kd.core.service.impl.account;


import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.account.AccountLogDao;
import com.kd.core.dto.AgentAccountLogDto;
import com.kd.core.service.account.AccountLogService;

public class AccountLogServiceImpl extends BaseServiceImpl<AgentAccountLogDto, AccountLogDao> implements AccountLogService {
	
	@Autowired
	private AccountLogDao dao;
	
	@Override
	public Double searchTotalMoney() {
		// TODO Auto-generated method stub
		return dao.findTotalMoney();
	}
	
	
}
