package com.kd.core.service.meetRoom;


import com.kd.core.base.BaseService;
import com.kd.core.entity.MeetRoom;

public interface MeetRoomService extends BaseService<MeetRoom>{
	
    //根据会议室信息查询会议室
    MeetRoom searchByParam(MeetRoom meetRoom);
    
    Boolean quantityByParam(MeetRoom meetRoom);

    /**
     * 根据会议室号查询会议室信息
     * 
     * @param meetRoomID	会议室号
     * @return 会议室信息
     */
	MeetRoom findBymeetRoomNo(String meetRoomNo);
	MeetRoom getModelTerminalNo(String terminalNo);
	
	
		
}
