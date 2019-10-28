/**
*
 * @package:com.kd.core.resource
 * @projectName:cloud-core
 * @CreateTime:2015年1月22日-下午2:28:25
 *  2015杭州宽达信息技术有限公司-版权所有
 *
 */
package com.kd.core.resource.common;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kd.core.entity.BaseData;
import com.kd.core.service.impl.common.BaseDataServiceImpl;
import com.kd.core.util.RedisUtil;
import com.kd.core.util.SerializationUtil;

/**
 * 
 *
 *@类名称：CommonResource.java
 *@类描述：基础数据Resource

 *@创建时间：2015年1月23日-上午10:03:15
 *@修改备注:
 *@version
 */
@Path("/common")
public class CommonResource {
	@Autowired
	private BaseDataServiceImpl baseDataServiceImpl;

	public BaseDataServiceImpl getBaseDataServiceImpl() {
		return baseDataServiceImpl;
	}

	public void setBaseDataServiceImpl(BaseDataServiceImpl baseDataServiceImpl) {
		this.baseDataServiceImpl = baseDataServiceImpl;
	}
	/**
	 * 
	 *@描述:单条件查询 用于下拉菜单的显示
	
	 *@创建时间：2015年1月23日 上午11:27:19
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param
	 *@return
	 *
	 * @param typeId
	 * @return
	 */
	@GET
	@Path("query/{typeId}")
	public List<BaseData> queryByType(@PathParam("typeId") String  typeId){
		BaseData base=new BaseData();
		base.setTypeId(typeId);
		return baseDataServiceImpl.getModelList(base);
	
	}
	/**
	 * 
	 *@描述 ：多条件查询，用于基础数据的维护的显示
	
	 *@创建时间：2015年1月23日 上午11:27:47
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param
	 *@return
	 *
	 * @param info
	 * @return
	 */
	
	
	@GET
	@Path("queryData")
	public List<BaseData> queryBase( @QueryParam("baseData") String baseData) throws Exception{
		
		BaseData base=new Gson().fromJson(baseData, BaseData.class);
		List<BaseData> list= baseDataServiceImpl.getPagedList(base);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(base.pageCount);
		}
		
		return list;	
	}
	
	@POST
	@Path("add")
	public String addBaseData(BaseData t){
		String result=""+baseDataServiceImpl.insert(t);
		common(result);
		return result;
	}
	@DELETE
	@Path("delete/{id}")
	public String deleteById(@PathParam("id") String id){	
		String result=""+baseDataServiceImpl.delete(id);
		common(result);
		return result;
	}
	@PUT
	@Path("modify")
	public String update(BaseData t){
		String result=""+baseDataServiceImpl.update(t);
		common(result);
		return result;
		
	}
	
	@GET
	@Path("toModify/{id}")
	public BaseData queryById(@PathParam("id") String id){
		return baseDataServiceImpl.getModel(id);
	}

	@GET
	@Path("getCode/{typeId}")
	public String getCode(@PathParam("typeId") String typeId){
		return baseDataServiceImpl.getMaxCode(typeId);
	}
	
	@GET
	@Path("isUnique_param")
	public BaseData isUnique_param(@QueryParam("baseData") String baseData){
		BaseData base=new Gson().fromJson(baseData, BaseData.class);
		return baseDataServiceImpl.isUnique_param(base);
	}
	
	
	@GET
	@Path("getBaseDataById/{typeId}")
	public List<BaseData> getBaseDataById(@PathParam("typeId") String typeId){
		byte[] ar=RedisUtil.get("BaseData".getBytes());
		List<BaseData> baseDatas=(List<BaseData>) SerializationUtil.deserialize(ar);
		
		List<BaseData> bases=new ArrayList<>();
		//获取时间段基础信息
		for (BaseData baseData : baseDatas) {
			if(baseData.getTypeId().equals(typeId)){
				bases.add(baseData);
			}
		}
		return bases;
	}
	
	public void common(String result){
		if(result.equals("true")){
			String name="BaseData";
			List<BaseData> baseDatas=baseDataServiceImpl.searchInfo();
			RedisUtil.set(name.getBytes(), SerializationUtil.serialize(baseDatas));
		}
	}
}
