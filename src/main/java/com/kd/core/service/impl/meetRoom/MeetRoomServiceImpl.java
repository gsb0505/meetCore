package com.kd.core.service.impl.meetRoom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.meetRoom.MeetRoomDao;
import com.kd.core.entity.MeetRoom;
import com.kd.core.service.meetRoom.MeetRoomService;


public class MeetRoomServiceImpl extends BaseServiceImpl<MeetRoom, MeetRoomDao> implements MeetRoomService {
	
	private static final Logger log=LoggerFactory.getLogger(MeetRoom.class);
	
	@Autowired
	public MeetRoomDao dao;

	@Override
	public MeetRoom searchByParam(MeetRoom meetRoom) {
		MeetRoom ter=null;
		try {
			ter=dao.selectByParam(meetRoom);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询实体信息失败！空对象或者有多条记录");
		}
		return ter;
	}

	@Override
	public MeetRoom findBymeetRoomNo(String meetRoomNo) {
		// TODO Auto-generated method stub
		return dao.findBymeetRoomNo(meetRoomNo);
	}

	
	
	@Override
	public Boolean quantityByParam(MeetRoom meetRoom){
		Integer ter=null;
		try {
			ter=dao.quantityByParam(meetRoom);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询实体信息失败！空对象或者有多条记录");
		}
		return ter>0;
	}

	@Override
	public MeetRoom getModelTerminalNo(String terminalNo) {
		// TODO Auto-generated method stub
		return dao.getModelTerminalNo(terminalNo);
	}
	
}
