package com.kd.core.dao.meetRoom;

import com.kd.core.base.BaseDao;
import com.kd.core.entity.MeetRoom;

public interface MeetRoomDao extends BaseDao<MeetRoom>{
    //根据终端信息查询终端
    MeetRoom selectByParam(MeetRoom meetRoom);
    
    Integer quantityByParam(MeetRoom meetRoom);
    
    /**
     * 根据终端号查询终端信息
     * 
     * @param meetRoomNo	终端号
     * @return 终端信息
     */
	MeetRoom findBymeetRoomNo(String meetRoomNo);
	MeetRoom getModelTerminalNo(String terminalNo);
	
}
