package com.kd.core.service.impl.meetNotice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.meetNotice.MeetNoticeDao;
import com.kd.core.entity.MeetNotice;
import com.kd.core.service.meetNotice.MeetNoticeService;


public class MeetNoticeServiceImpl extends BaseServiceImpl<MeetNotice, MeetNoticeDao> implements MeetNoticeService {
	
	private static final Logger log=LoggerFactory.getLogger(MeetNotice.class);
	
	@Autowired
	public MeetNoticeDao dao;

	@Override
	public MeetNotice searchByParam(MeetNotice MeetNotice) {
		MeetNotice ter=null;
		try {
			ter=dao.selectByParam(MeetNotice);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询实体信息失败！空对象或者有多条记录");
		}
		return ter;
	}

	@Override
	public MeetNotice findByMeetNoticeNo(String MeetNoticeNo) {
		// TODO Auto-generated method stub
		return dao.findByMeetNoticeNo(MeetNoticeNo);
	}

	
	
	@Override
	public Boolean quantityByParam(MeetNotice MeetNotice){
		Integer ter=null;
		try {
			ter=dao.quantityByParam(MeetNotice);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询实体信息失败！空对象或者有多条记录");
		}
		return ter>0;
	}
	
}
