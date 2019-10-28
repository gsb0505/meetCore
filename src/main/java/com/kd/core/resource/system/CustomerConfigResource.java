package com.kd.core.resource.system;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kd.core.entity.CustomerConfig;
import com.kd.core.service.system.CustomerConfigService;

/**
*
*@类名称：CustomerConfigResource.java
*@类描述：
*@创建人：zlm
*@创建时间：2015年5月27日-上午10:45:20
*@修改备注:
*@version 
*/
@Path("/customerConfig")
public class CustomerConfigResource {
	
	@Autowired
    private CustomerConfigService customerConfigService;
	
	public CustomerConfigService getCustomerConfigService() {
		return customerConfigService;
	}

	public void setCustomerConfigService(CustomerConfigService customerConfigService) {
		this.customerConfigService = customerConfigService;
	}

	@POST
	@Path("/add")
	public String add(CustomerConfig customerConfig){
		return customerConfigService.insert(customerConfig)+"";
	}
	
	@DELETE
	@Path("/delete/{id}")
	public String delete(@PathParam("id") String cconfig){
		return customerConfigService.delete(cconfig)+"";
	} 
	
	@PUT
	@Path("/update")
	public String update(CustomerConfig customerConfig){
		return customerConfigService.update(customerConfig)+"";
	} 
	
	@GET
	@Path("/getPageList")
	public List<CustomerConfig> getPageList(@QueryParam("cconfig") String cconfig){
		CustomerConfig customerConfig = new Gson().fromJson(cconfig, CustomerConfig.class);
		List<CustomerConfig> list = customerConfigService.getPagedList(customerConfig);
		if(list != null && !list.isEmpty()){
			list.get(0).setPageCount(customerConfig.pageCount);
		}

		return list;
	} 
	
	@GET
	@Path("/findById")
	public CustomerConfig findById(@QueryParam("id") String id){
		return customerConfigService.getModel(id);
		
	}
}
