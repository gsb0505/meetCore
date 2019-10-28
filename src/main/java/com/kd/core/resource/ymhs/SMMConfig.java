package com.kd.core.resource.ymhs;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kd.core.dto.ExternalDto;
import com.kd.core.dto.MessageDto;
import com.kd.core.entity.BaseData;
import com.kd.core.entity.Config;
import com.kd.core.entity.MeetRoom;
import com.kd.core.entity.OrderDetail;
import com.kd.core.service.common.ConfigService;
import com.kd.core.service.external.ExternalService;
import com.kd.core.service.meetRoom.MeetRoomService;
import com.kd.core.service.orderDetail.OrderDetailService;
import com.kd.core.util.BaseDataUtil;
import com.kd.core.util.Constants;
import com.kd.core.util.StringUtil;
import com.sun.mail.iap.Response;
import com.sun.tools.corba.se.idl.constExpr.Terminal;

@Path("/SMMConfig")
public class SMMConfig extends BaseResource {

	private static Logger log = LoggerFactory.getLogger(SMMConfig.class);

	@Autowired
	private MeetRoomService meetRoomService;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private ConfigService configService;

	/** 卡状态（正常） */
	private final static String cardStatus = "2001";

	/** 卡状态（未开卡） */
	private final static String CARD_STATUS_ONTOPEN = "2005";
	/** 账户状态（正常） */
	private final static String accountStatus = "1501";
	/** 金额类型（固定套餐） */
	private final static Integer amountType = 1001;

	/** 自助终端 */
	private final static String terminalType = "7002";

	/** 消费类型（在线钱包） */
	private final static String pursetype_online = "5001";
	/** 消费类型（离线钱包） */
	private final static String pursetype_offline = "5002";

	/** 卡类型（园区卡） */
	private final static String CARD_TYPE_PARK = "3001";

	/** 卡类型（临时卡） */
	private final static String CARD_TYPE_TEMP = "3002";

	/** 卡类型（红山卡） */
	private final static String CARD_TYPE_HS = "3003";

	/*** 红山一卡通成功返回码 */
	protected final String HSYKT_CODE_SUCCESS = "00000";

	private final static String KEY = "key123";

	/**
	 * 验证终端
	 * 
	 * @param checkMeetRoom
	 * @return
	 */
	private MeetRoom checkMeetRoom(String terminalNo) {
		MeetRoom meetRoom = meetRoomService.getModelTerminalNo(terminalNo);

		if (meetRoom == null) {
			return null;
		}
		return meetRoom;
	}

	/**
	 * 参数配置接口
	 * 
	 * @param terminalNo
	 * @param signMsg
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	/*
	 * http://localhost:8080/canteen-core/SMMConfig/query?terminalNo=11&signMsg=
	 * 0a41f1f29358e6bb20e54518293573fa
	 */

	@GET
	@Path("/queryMeetRoom")
	public byte[] queryTerminal(@QueryParam("terminalNo") String terminalNo,
			HttpServletResponse response) {

		log.info("----------终端签到开始-------------");
		log.info("?terminalNo=" + terminalNo);

		if (!StringUtil.iStr(terminalNo)) {
			return resultMessage(ErrorCode.XT00009);
		}
		log.info("?terminalNo=" + terminalNo);

		MeetRoom meetRoom = checkMeetRoom(terminalNo);
		if (meetRoom == null) {
			return resultMessage(ErrorCode.XT00002);
		}
		log.info("获取终端成功。。。。。。");

		log.info("。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		JSONObject json = new JSONObject();
		json.put("meetRoomName", meetRoom.getMeetRoomName());
		json.put("meetRoomID", meetRoom.getMeetRoomID());
		json.put("person", meetRoom.getPerson()==null?"":meetRoom.getPerson());
		json.put("meetNoticeContent", meetRoom.getMeetNoticeContent()==null?"":meetRoom.getMeetNoticeContent());		
		String toJsonString = JSON.toJSONString(meetRoom.getOrderDetailList());
		JSONArray array1 = new JSONArray().parseArray(toJsonString);
		json.put("orderDetailList", array1);
		return resultMessage(json);
	}

}
