package com.kd.core.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DepositSReport extends BaseEntity {
	
	//交易时间
	private String tradeDate;
	//园区
	private String parkType;
	//卡类型
	private String cardType;
	//交易类型
	private String payType;
	//机关
	private String organ;
	//操作类型
	private String operType;
	//交易笔数
	private String tradeCount;
	//押金金额
	private String tDeposit;
	/**
	 * @return the tradeDate
	 */
	public String getTradeDate() {
		return tradeDate;
	}
	/**
	 * @param tradeDate the tradeDate to set
	 */
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	/**
	 * @return the parkType
	 */
	public String getParkType() {
		return parkType;
	}
	/**
	 * @param parkType the parkType to set
	 */
	public void setParkType(String parkType) {
		this.parkType = parkType;
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
	 * @return the organ
	 */
	public String getOrgan() {
		return organ;
	}
	/**
	 * @param organ the organ to set
	 */
	public void setOrgan(String organ) {
		this.organ = organ;
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
	 * @return the tDeposit
	 */
	public String gettDeposit() {
		return tDeposit;
	}
	/**
	 * @param tDeposit the tDeposit to set
	 */
	public void settDeposit(String tDeposit) {
		this.tDeposit = tDeposit;
	}
	
	
}
