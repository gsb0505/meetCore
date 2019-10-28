package com.kd.core.resource.account;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kd.core.dto.AgentAccountLogDto;
import com.kd.core.service.account.AccountLogService;

@Path("accountLog")
public class AccountLogResource {
	@Autowired
	private  AccountLogService accountLogService;
	
	public AccountLogService getAccountLogService() {
		return accountLogService;
	}


	public void setAccountLogService(AccountLogService accountLogService) {
		this.accountLogService = accountLogService;
	}


	@GET
	@Path("queryListByCon")
	public List<AgentAccountLogDto> getList(@QueryParam("dto") String dto){
		AgentAccountLogDto recDto = new Gson().fromJson(dto, AgentAccountLogDto.class);
		List<AgentAccountLogDto> list = accountLogService.getPagedList(recDto);

		if (list.size()>0) {
			list.get(0).setPageCount(recDto.pageCount); //把分页参数值放入list
		}
		return list;
	}
	
	@GET
	@Path("searchTotalMoney")
	public Double searchTotalMoney(){
		return accountLogService.searchTotalMoney();
	}
}
