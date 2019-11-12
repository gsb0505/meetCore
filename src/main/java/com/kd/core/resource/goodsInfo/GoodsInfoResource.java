package com.kd.core.resource.goodsInfo;

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
import com.kd.core.entity.GoodsInfo;
import com.kd.core.entity.OrderDetail;
import com.kd.core.service.goodsInfo.GoodsInfoService;
import com.kd.core.service.impl.goodsInfo.GoodsInfoServiceImpl;

@Path("/goodsInfo")
public class GoodsInfoResource {
	
	@Autowired
	private GoodsInfoServiceImpl goodsInfoService;
	
	
	/**
	 * @return the goodsInfoService
	 */
	public GoodsInfoServiceImpl getGoodsInfoService() {
		return goodsInfoService;
	}

	/**
	 * @param goodsInfoService the goodsInfoService to set
	 */
	public void setGoodsInfoService(GoodsInfoServiceImpl goodsInfoService) {
		this.goodsInfoService = goodsInfoService;
	}

	@POST
	@Path("add")
	public boolean addGoodsInfo(GoodsInfo goodsInfo){
		return goodsInfoService.insert(goodsInfo);
	}
	
	@PUT
	@Path("modify")
	public boolean modifyGoodsInfo(GoodsInfo goodsInfo){
		return goodsInfoService.update(goodsInfo);
	}
	
	@DELETE
	@Path("delete/{gid}")
	public boolean deleteByTid(@PathParam("gid")String terId){
		return goodsInfoService.delete(terId);
	}
	
	@GET
	@Path("getModel")
	public GoodsInfo getModel(@QueryParam("goodsInfo") String goodsInfo){
		GoodsInfo ginfo = new Gson().fromJson(goodsInfo.replace("+", " "),GoodsInfo.class);
		GoodsInfo res = goodsInfoService.getModel(ginfo);
		return res;
	}
	
	
	@GET
	@Path("query")
	public List<GoodsInfo> queryPager (@QueryParam("goodsInfo") String goodsInfo) {
		GoodsInfo ginfo=new Gson().fromJson(goodsInfo, GoodsInfo.class);
		List<GoodsInfo> list = goodsInfoService.getPagedList(ginfo);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(ginfo.pageCount);
		}
		return list;
	} 
}
