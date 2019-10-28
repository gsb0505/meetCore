package com.kd.core.resource.common;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kd.core.entity.Config;
import com.kd.core.service.common.ConfigService;
import com.kd.core.util.RedisUtil;
import com.kd.core.util.SerializationUtil;

@Path("/config")
public class ConfigResource{
	@Autowired
	private ConfigService cs;
	
	public ConfigService getCs() {
		return cs;
	}

	public void setCs(ConfigService cs) {
		this.cs = cs;
	}
	
	@GET
	@Path("/quertBaseDate")
	public String quertBaseDate(){
		 
		return cs.quertBaseDate();
	} 
	
	
	
	@GET
	@Path("/queryByCode")
	public Config queryByCode(@QueryParam("code") String code){
		return cs.getModelByCode(code);
	}
	
	@GET
	@Path("/queryById")
	public Config queryById(@QueryParam("id") String id){
		return cs.getModel(id);
	} 
	@GET
	@Path("/query")
	public List<Config> query(@QueryParam("str") String str){
		Config config=new Gson().fromJson(str,Config.class);
		List<Config> lists=cs.getPagedList(config);
		if(lists!=null&&lists.size()>0){
			lists.get(0).setPageCount(config.pageCount);
		}
		return lists;
	}
	@POST
	@Path("/add")
	public String add(Config config){
		return ""+cs.insert(config);
	}
	@PUT
	@Path("/modify")
	public String modify(Config str){
		String name="deposit";
		String result=""+cs.update(str);
		if(result.equals("true")){
			List<Config> configs=cs.getPagedList(null);
			RedisUtil.set(name.getBytes(), SerializationUtil.serialize(configs));
		}
		return result;
	}
	@DELETE
	@Path("/delete")
	public String delete(@QueryParam("id") String id){
		return ""+cs.delete(id);
	}
	
	@GET
	@Path("queryMaxcode")
	public String queryMaxcode(){
		return cs.searchMaxCode();
	}
}
