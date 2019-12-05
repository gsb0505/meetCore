package com.kd.core.resource.goodsDetail;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.entity.GoodsDetail;
import com.kd.core.service.goodsDetail.GoodsDetailService;
import com.kd.core.service.impl.goodsDetail.GoodsDetailServiceImpl;

@Path("/goodsDetail")
public class GoodsDetailResource {
	
	@Autowired
	private GoodsDetailServiceImpl goodsDetailService;
	
	/**
	 * @return the goodsDetailService
	 */
	public GoodsDetailServiceImpl getGoodsDetailService() {
		return goodsDetailService;
	}

	/**
	 * @param goodsDetailService the goodsDetailService to set
	 */
	public void setGoodsDetailService(GoodsDetailServiceImpl goodsDetailService) {
		this.goodsDetailService = goodsDetailService;
	}

	@POST
	@Path("add")
	public boolean addGoodsDetail(GoodsDetail goodsDetail){
		return goodsDetailService.insert(goodsDetail);
	}
	
	@PUT
	@Path("modify")
	public boolean modifyGoodsDetail(GoodsDetail goodsDetail){
		return goodsDetailService.update(goodsDetail);
	}
	
	@DELETE
	@Path("delete/{gid}")
	public boolean deleteByTid(@PathParam("gid")String terId){
		return goodsDetailService.delete(terId);
	}
	
	@POST
	@Path("getModel")
	public GoodsDetail getModel(GoodsDetail goodsDetail){
		GoodsDetail res = goodsDetailService.getModel(goodsDetail);
		return res;
	}

	@POST
	@Path("query")
	public List<GoodsDetail> queryPager (GoodsDetail goodsDetail) {
		List<GoodsDetail> list = goodsDetailService.getPagedList(goodsDetail);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(goodsDetail.pageCount);
		}
		return list;
	} 
	
	@POST
	@Path("getGoodsByGid")
	public int getGoodsByGid(GoodsDetail goodsDetail){
		GoodsDetail gd=new GoodsDetail();
		gd.setUserID("admin");
		return goodsDetailService.getGoodsByGid(gd);
	}

}
