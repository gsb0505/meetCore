package com.kd.core.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
* @ClassName: StatementReport 
* @Description: 结算报表实体类
* @author Giles 
* @date 2016年11月14日 下午2:26:51 
*
 */
@XmlRootElement(name="userSReport")
public class UserSReport extends BaseEntity{
	
	//交易类型
	private String tradeType;
	//交易笔数
	private String tradeCount;
	//交易金额
	private String tradeAmount;
	//交易押金
	private String tradeDeposit;
	//交易模式
	private String tradePattern;
	//终端
	private MeetRoom terminal;
	//园区卡售卡
	private String campusSCard;
	//临时卡售卡
	private String temporarySCard;
	//临时卡充值/取款
	private String temporaryRecharge;
	//园区卡退卡
	private String campusECard;
	//临时卡退卡
	private String temporaryECard;
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
	 * @return the tradeCount
	 */
	public String getTradeCount() {
		return tradeCount;
	}
	/**
	 * @param tradeCount the tradeCount to set
	 */
	public void setTradeCount(String tradeCount) {
		this.tradeCount = tradeCount;
	}
	/**
	 * @return the tradeAmount
	 */
	public String getTradeAmount() {
		return tradeAmount;
	}
	/**
	 * @param tradeAmount the tradeAmount to set
	 */
	public void setTradeAmount(String tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	/**
	 * @return the tradeDeposit
	 */
	public String getTradeDeposit() {
		return tradeDeposit;
	}
	/**
	 * @param tradeDeposit the tradeDeposit to set
	 */
	public void setTradeDeposit(String tradeDeposit) {
		this.tradeDeposit = tradeDeposit;
	}
	/**
	 * @return the tradePattern
	 */
	public String getTradePattern() {
		return tradePattern;
	}
	/**
	 * @param tradePattern the tradePattern to set
	 */
	public void setTradePattern(String tradePattern) {
		this.tradePattern = tradePattern;
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
	/**
	 * @return the campusSCard
	 */
	public String getCampusSCard() {
		return campusSCard;
	}
	/**
	 * @param campusSCard the campusSCard to set
	 */
	public void setCampusSCard(String campusSCard) {
		this.campusSCard = campusSCard;
	}
	/**
	 * @return the temporarySCard
	 */
	public String getTemporarySCard() {
		return temporarySCard;
	}
	/**
	 * @param temporarySCard the temporarySCard to set
	 */
	public void setTemporarySCard(String temporarySCard) {
		this.temporarySCard = temporarySCard;
	}
	/**
	 * @return the temporaryRecharge
	 */
	public String getTemporaryRecharge() {
		return temporaryRecharge;
	}
	/**
	 * @param temporaryRecharge the temporaryRecharge to set
	 */
	public void setTemporaryRecharge(String temporaryRecharge) {
		this.temporaryRecharge = temporaryRecharge;
	}
	/**
	 * @return the campusECard
	 */
	public String getCampusECard() {
		return campusECard;
	}
	/**
	 * @param campusECard the campusECard to set
	 */
	public void setCampusECard(String campusECard) {
		this.campusECard = campusECard;
	}
	/**
	 * @return the temporaryECard
	 */
	public String getTemporaryECard() {
		return temporaryECard;
	}
	/**
	 * @param temporaryECard the temporaryECard to set
	 */
	public void setTemporaryECard(String temporaryECard) {
		this.temporaryECard = temporaryECard;
	} 
	
	
}
