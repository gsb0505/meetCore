package com.kd.core.dao.meetNotice;

import com.kd.core.base.BaseDao;
import com.kd.core.entity.MeetNotice;

public interface MeetNoticeDao extends BaseDao<MeetNotice>{
    //根据终端信息查询终端
    MeetNotice selectByParam(MeetNotice meetNotice);
    
    Integer quantityByParam(MeetNotice meetNotice);
    
    /**
     * 根据终端号查询终端信息
     * 
     * @param MeetNoticeNo	终端号
     * @return 终端信息
     */
	MeetNotice findByMeetNoticeNo(String meetNoticeNo);
    
}
