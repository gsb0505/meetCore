package com.kd.core.resource.meetNotice;


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
import com.kd.core.entity.MeetNotice;
import com.kd.core.service.meetNotice.MeetNoticeService;

@Path("/meetNotice")
public class MeetNoticeResource {
	@Autowired
	private MeetNoticeService meetNoticeService;
	
	@POST
	@Path("add")
	public boolean addmeetNotice(MeetNotice meetNotice){
		return meetNoticeService.insert(meetNotice);
	}
	
	@PUT
	@Path("modify")
	public boolean modifymeetNotice(MeetNotice meetNotice){
		return meetNoticeService.update(meetNotice);
	}
	
	@GET
	@Path("queryModel/{terId}")
	public MeetNotice queryModel(@PathParam("terId") String terId) {
		return meetNoticeService.getModel(terId);
	} 
	
	@DELETE
	@Path("delete/{terId}")
	public boolean deleteByTid(@PathParam("terId")String terId){
		return meetNoticeService.delete(terId);
	}
	
	@GET
	@Path("query")
	public List<MeetNotice> queryPager (@QueryParam("meetNotice") String meetNotice) {
		MeetNotice ter=new Gson().fromJson(meetNotice, MeetNotice.class);
		List<MeetNotice> list = meetNoticeService.getPagedList(ter);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(ter.pageCount);
		}
		return list;
	} 
	
	@GET
	@Path("queryList")
	public List<MeetNotice> queryAll (@QueryParam("meetNotice") String meetNotice) {
		MeetNotice ter=new Gson().fromJson(meetNotice, MeetNotice.class);
		List<MeetNotice> list = meetNoticeService.getModelList(ter);
		return list;
	} 
	
	@GET
	@Path("queryByParam")
	public MeetNotice queryByParam(@QueryParam("meetNotice") String meetNotice){
		MeetNotice ter=new Gson().fromJson(meetNotice, MeetNotice.class);
		ter=meetNoticeService.searchByParam(ter);
		return ter;
	}
	
	@GET
	@Path("existByParam")
	public Boolean existByParam(@QueryParam("meetNotice") String meetNotice){
		MeetNotice ter=new Gson().fromJson(meetNotice, MeetNotice.class);
		return meetNoticeService.quantityByParam(ter);
	}

	
}
