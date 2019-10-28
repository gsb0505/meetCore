package com.kd.core.service.meetNotice;


import com.kd.core.base.BaseService;
import com.kd.core.entity.MeetNotice;

public interface MeetNoticeService extends BaseService<MeetNotice>{
	
    //根据会议室信息查询会议室
	MeetNotice searchByParam(MeetNotice meetNotice);
    
    Boolean quantityByParam(MeetNotice meetNotice);

    /**
     * 根据会议室号查询会议室信息
     * 
     * @param meetRoomID	会议室号
     * @return 会议室信息
     */
    MeetNotice findByMeetNoticeNo(String meetRoomNo);
	
	
		
}
