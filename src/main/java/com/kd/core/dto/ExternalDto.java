package com.kd.core.dto;

import com.kd.core.entity.MeetRoom;

/**
 * 
* @ClassName: ExternalDto 
* @Description: 外放接口辅助类
* @author Giles 
* @date 2016年10月12日 下午1:34:40 
*
 */
public class ExternalDto {
	
	private String glideNo;
	
	private String terminalNo;
	
	private String outorderNo;
	
	private String outbatchNo;
	
	private String cardNo;
	
	private String cardType;
	
	private String purseType;
	
	private String amount;
	
	private String dateTime;
	
	private String writeStatus;
	
	private String startTime;
	
	private String endTime;
	
	private String signMsg;
	
	private String jsonStr;
	
	private String operType;
	
	private String oldCardNo;
	
	private String payType;
	
	private String IDNumber;
	
	private String deposit;
	
	private int status;
	
	private String tradeType;
	
	private String agentId;
	
	//消费模式（固定套餐等）
	private String amountType;
	
	private String cardMold;
	
	private String depositType;
	//终端号
	private MeetRoom terminal;
	/**
	 * @return 终端号
	 */
	public String getTerminalNo() {
		return terminalNo;
	}

	/**
	 * @param 终端号
	 */
	public void setTerminalNo(String terminalNo) {
		this.terminalNo = terminalNo;
	}

	/**
	 * @return 外部流水号
	 */
	public String getOutorderNo() {
		return outorderNo;
	}

	/**
	 * @param 外部流水号
	 */
	public void setOutorderNo(String outorderNo) {
		this.outorderNo = outorderNo;
	}

	/**
	 * @return 外部批次号
	 */
	public String getOutbatchNo() {
		return outbatchNo;
	}

	/**
	 * @param 外部批次号
	 */
	public void setOutbatchNo(String outbatchNo) {
		this.outbatchNo = outbatchNo;
	}

	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return 钱包类型（5002离线钱包）
	 */
	public String getPurseType() {
		return purseType;
	}

	/**
	 * @param 钱包类型（5002离线钱包）
	 */
	public void setPurseType(String purseType) {
		this.purseType = purseType;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return 交易时间
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * @param 交易时间
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return 写卡状态
	 */
	public String getWriteStatus() {
		return writeStatus;
	}

	/**
	 * @param 写卡状态
	 */
	public void setWriteStatus(String writeStatus) {
		this.writeStatus = writeStatus;
	}

	/**
	 * @return 查询开始时间
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param 查询开始时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return 查询结束时间
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param 查询结束时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the signMsg
	 */
	public String getSignMsg() {
		return signMsg;
	}

	/**
	 * @param signMsg the signMsg to set
	 */
	public void setSignMsg(String signMsg) {
		this.signMsg = signMsg;
	}

	/**
	 * @return the jsonStr
	 */
	public String getJsonStr() {
		return jsonStr;
	}

	/**
	 * @param jsonStr the jsonStr to set
	 */
	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	/**
	 * @return the operType
	 */
	public String getOperType() {
		return operType;
	}

	/**
	 * @param operType the operType to set
	 */
	public void setOperType(String operType) {
		this.operType = operType;
	}

	/**
	 * @return the oldCardNo
	 */
	public String getOldCardNo() {
		return oldCardNo;
	}

	/**
	 * @param oldCardNo the oldCardNo to set
	 */
	public void setOldCardNo(String oldCardNo) {
		this.oldCardNo = oldCardNo;
	}

	/**
	 * @return the payType
	 */
	public String getPayType() {
		return payType;
	}

	/**
	 * @param payType the payType to set
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}

	/**
	 * @return the iDNumber
	 */
	public String getIDNumber() {
		return IDNumber;
	}

	/**
	 * @param iDNumber the iDNumber to set
	 */
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	/**
	 * @return the deposit
	 */
	public String getDeposit() {
		return deposit;
	}

	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the tradeType
	 */
	public String getTradeType() {
		return tradeType;
	}

	/**
	 * @param tradeType the tradeType to set
	 */
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	/**
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the amountType
	 */
	public String getAmountType() {
		return amountType;
	}

	/**
	 * @param amountType the amountType to set
	 */
	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}

	/**
	 * @return the cardMold
	 */
	public String getCardMold() {
		return cardMold;
	}

	/**
	 * @param cardMold the cardMold to set
	 */
	public void setCardMold(String cardMold) {
		this.cardMold = cardMold;
	}

	/**
	 * @return the depositType
	 */
	public String getDepositType() {
		return depositType;
	}

	/**
	 * @param depositType the depositType to set
	 */
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	/**
	 * @return the glideNo
	 */
	public String getGlideNo() {
		return glideNo;
	}

	/**
	 * @param glideNo the glideNo to set
	 */
	public void setGlideNo(String glideNo) {
		this.glideNo = glideNo;
	}

	public ExternalDto(String terminalNo, String outorderNo, String outbatchNo, String cardNo, String cardType,
			String purseType, String amount, String dateTime, String writeStatus, String startTime, String endTime,String signMsg) {
		super();
		this.terminalNo = terminalNo;
		this.outorderNo = outorderNo;
		this.outbatchNo = outbatchNo;
		this.cardNo = cardNo;
		this.cardType = cardType;
		this.purseType = purseType;
		this.amount = amount;
		this.dateTime = dateTime;
		this.writeStatus = writeStatus;
		this.startTime = startTime;
		this.endTime = endTime;
		this.signMsg=signMsg;
	}

	public ExternalDto(String terminalNo, String outorderNo, String outbatchNo, String cardNo, String cardType,
			String purseType, String amount, String dateTime, String writeStatus, String startTime, String endTime,
			String signMsg, String jsonStr) {
		super();
		this.terminalNo = terminalNo;
		this.outorderNo = outorderNo;
		this.outbatchNo = outbatchNo;
		this.cardNo = cardNo;
		this.cardType = cardType;
		this.purseType = purseType;
		this.amount = amount;
		this.dateTime = dateTime;
		this.writeStatus = writeStatus;
		this.startTime = startTime;
		this.endTime = endTime;
		this.signMsg = signMsg;
		this.jsonStr = jsonStr;
	}

	public ExternalDto(String terminalNo, String outorderNo, String outbatchNo, String cardNo, String cardType,
			String purseType, String amount, String dateTime, String writeStatus, String startTime, String endTime,
			String signMsg, String jsonStr, String operType, String oldCardNo, String payType, String iDNumber,
			String deposit) {
		super();
		this.terminalNo = terminalNo;
		this.outorderNo = outorderNo;
		this.outbatchNo = outbatchNo;
		this.cardNo = cardNo;
		this.cardType = cardType;
		this.purseType = purseType;
		this.amount = amount;
		this.dateTime = dateTime;
		this.writeStatus = writeStatus;
		this.startTime = startTime;
		this.endTime = endTime;
		this.signMsg = signMsg;
		this.jsonStr = jsonStr;
		this.operType = operType;
		this.oldCardNo = oldCardNo;
		this.payType = payType;
		IDNumber = iDNumber;
		this.deposit = deposit;
	}

	/**
	 * @return the terminal
	 */
	public MeetRoom getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal the terminal to set
	 */
	public void setTerminal(MeetRoom terminal) {
		this.terminal = terminal;
	}
	
	
	
}
