package com.kd.core.util;

public class Constants {
	
	//通用
	public static final String SYSTEM_SUCCESS="000000"; 
	public static final String SYSTEM_FAILD="000001"; 
	public static final String TERMINAL_FAILD="000002";
	public static final String SUCCESS="SUCCESS"; 
	public static final int DEPOSIT=15;
	
	//4种交易类型  押金   退卡 4006 开卡4007
	public static final String RECHARGE="4002"; 
	public static final String MARGIN="4005"; 
	//2种支付类型
	public static final String TEMPORARY="3002"; 
	
	
	
	//内部使用错误码
	public static final String CARD_ERROR="CE00001";  //卡存在异常
	
	public static final String NULL_OBJECT="CE00002";  //空对象
	
	public static final String MONEY_ERROR="CE00003";  //金额异常
	
	public static final String DATA_ERROR="CE00004";  //数据交互异常
	
	public static final String ALREADY_OPERATE="CE00005";  //已做过此操作
	
	
	//一卡通错误码
	public static final String YKTSOCKETERROR = "YKTE0001";//SOCKET异常
	public static final String CARDCHECKERROR = "YKTE0002";//包文校验异常

	public static final String CARDSOCKETTIMEOUTERROR = "YKTE0003";//SOCKET超时异常
	public static final String CARDSOCKETREADERROR = "YKTE0004";//SOCKET读错误
	public static final String YKTPACKEGERROR = "YKTE0005";//组包异常
	
	
	
	
	
	
	//----------接口错误码--------------------//
	//请求成功
	public static final String SYSTEM_REQ_SUCCESS="XT00000"; 
	//商户异常
	public static final String AGENT_NOT_LEGAL="XT00001"; 
	//终端异常
	public static final String TERMINAL_NOT_LEGAL="XT00002"; 
	//签名错误
	public static final String SIGN_ERROR="XT00003"; 
	//终端流水号和批次号已存在
	public static final String TERMINAL_EXIST="XT00004";
	//订单不存在
	public static final String ORDER_NOT_EXIST="XT00005"; 
	//未知错误
	public static final String UNKNOWN_ERROR="XT00006"; 
	//卡异常（卡不存在或未激活）
	public static final String CARD_NOT_LEGAL="XT00007"; 
	//金额不足
	public static final String AMOUNT_DEFICIENCY="XT00008"; 
	//参数不合法
	public static final String PARAM_NOT_LEGAL="XT00009"; 
	//外部流水号、批次号不合法
	public static final String GLIDENO_NOT_LEGAL="XT00010"; 
	//未开卡
	public static final String NOT_OPEN_CARD="XT00011"; 
	//上送失败
	public static final String REQUEST_FAIL="XT00012"; 
	//卡异常
	public static final String CARD_NOT_LEGAL2="XT00013"; 
	//psam绑定错误
	public static final String PSAM_BIND_ERROR="XT00014"; 
	//离线上送TAC验证失败
	public static final String OFFLINE__REQUEST_TAC_CHECK_FAIL="XT00015"; 
	//离线上送交易金额校验出错
	public static final String OFFLINE__REQUEST_AMOUNT_CHECK_FAIL="XT00016"; 
	//离线上送失败
	public static final String OFFLINE__REQUEST_FAIL="XT00017"; 
	
	public static final String NOT_SETTLE="XT00018"; 
	//终端号不是web终端类型
	public static final String NOT_WEB_TERMINAL="XT00019"; 
	//交易成功
	public static final String DEAL_SUCCESS="JY10001"; 
	//交易失败
	public static final String DEAL_FAIL="JY10002"; 
	// 消费 
	public static final String CONSUME="LＸ40001"; 
	//充值
	public static final String RECHARGE_type="LＸ40002"; 
	//补卡
	public static final String PATCH_CARD="LＸ40003"; 
	//冲正
	public static final String RECHARGE_ROLL_BACK="LＸ40004"; 
	//正常卡片
	public static final String NORMAL_CARD="CP00000"; 
	//黑名单卡片
	public static final String BACKLIST_CARD="CP00001"; 
	
}
