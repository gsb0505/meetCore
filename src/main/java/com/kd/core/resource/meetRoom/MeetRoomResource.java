package com.kd.core.resource.meetRoom;


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
import com.kd.core.entity.MeetRoom;
import com.kd.core.service.meetRoom.MeetRoomService;
import com.kd.core.service.orderDetail.OrderDetailService;

@Path("/meetRoom")
public class MeetRoomResource {
	@Autowired
	private MeetRoomService meetRoomService;
	@Autowired
	private OrderDetailService orderDetailService;
	
	@POST
	@Path("add")
	public boolean addmeetRoom(MeetRoom meetRoom){
		return meetRoomService.insert(meetRoom);
	}
	
	@PUT
	@Path("modify")
	public boolean modifymeetRoom(MeetRoom meetRoom){
		return meetRoomService.update(meetRoom);
	}
	
	@GET
	@Path("queryModel/{terId}")
	public MeetRoom queryModel(@PathParam("terId") String terId) {
		return meetRoomService.getModel(terId);
	} 
	
	@GET
	@Path("queryModelTerminalNo/{terId}")
	public MeetRoom queryModelTerminalNo(@PathParam("terId") String terId) {
		return meetRoomService.getModelTerminalNo(terId);
	} 
	
	@DELETE
	@Path("delete/{terId}")
	public boolean deleteByTid(@PathParam("terId")String terId){
		return meetRoomService.delete(terId);
	}
	
	@GET
	@Path("query")
	public List<MeetRoom> queryPager (@QueryParam("meetRoom") String meetRoom) {
		MeetRoom ter=new Gson().fromJson(meetRoom, MeetRoom.class);
		List<MeetRoom> list = meetRoomService.getPagedList(ter);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(ter.pageCount);
		}
		return list;
	} 
	
	@GET
	@Path("queryList")
	public List<MeetRoom> queryAll (@QueryParam("meetRoom") String meetRoom) {
		MeetRoom ter=new Gson().fromJson(meetRoom, MeetRoom.class);
		List<MeetRoom> list = meetRoomService.getModelList(ter);
		return list;
	} 
	
	@GET
	@Path("queryByParam")
	public MeetRoom queryByParam(@QueryParam("meetRoom") String meetRoom){
		MeetRoom ter=new Gson().fromJson(meetRoom, MeetRoom.class);
		ter=meetRoomService.searchByParam(ter);
		return ter;
	}
	
	@GET
	@Path("existByParam")
	public Boolean existByParam(@QueryParam("meetRoom") String meetRoom){
		MeetRoom ter=new Gson().fromJson(meetRoom, MeetRoom.class);
		return meetRoomService.quantityByParam(ter);
	}

	
}
