package com.kd.core.resource.goodsInfo;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.entity.GoodsInfo;
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
	
	@POST
	@Path("getModel")
	public GoodsInfo getModel(GoodsInfo ginfo){
		//GoodsInfo ginfo = new Gson().fromJson(goodsInfo.replace("+", " "),GoodsInfo.class);
		GoodsInfo res = goodsInfoService.getModel(ginfo);
		return res;
	}

	@GET
	@Path("getGinfo/{id}")
	public GoodsInfo getGinfo(@PathParam("id") String id){
		//GoodsInfo ginfo = new Gson().fromJson(goodsInfo.replace("+", " "),GoodsInfo.class);
		GoodsInfo res = goodsInfoService.getModel(id);
		return res;
	}
	
	
	@POST
	@Path("query")
	//@Consumes(MediaType.APPLICATION_JSON)
	public List<GoodsInfo> queryPager(GoodsInfo goodsInfo) {//@QueryParam("goodsInfo") String goodsInfo
		//GoodsInfo ginfo=new Gson().fromJson(goodsInfo, GoodsInfo.class);
		List<GoodsInfo> list = goodsInfoService.getPagedList(goodsInfo);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(goodsInfo.pageCount);
		}
		return list;
	}

	@POST
	@Path("getStoreProductCount")
	public Response getStoreProductCount(GoodsInfo goodsInfo){
		Boolean bool = goodsInfoService.getSelectedCount(goodsInfo) > 0 ? Boolean.TRUE: Boolean.FALSE;
		return Response.ok(bool).build();
	}
}
