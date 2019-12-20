package com.kd.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsDetail extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -3468998946867996533L;

	//商品编号
	private String ginfoId;


	//商品名称
	private String goodsName;
	//订单号id
	private String tradeorderId;
	//商品总价
	private Double amount;
	//购买份数
	private Integer num;
	//单价
	private Double price;
	//商品类型
	private String typeCode;
	//商家
	private String storeCode;
	//创建时间
	private Date create_time;
	//更新时间
	private Date update_time;
	//所在用户
	private String userID;


	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * @return the ginfoId
	 */
	public String getGinfoId() {
		return ginfoId;
	}

	/**
	 * @param ginfoId the ginfoId to set
	 */
	public void setGinfoId(String ginfoId) {
		this.ginfoId = ginfoId;
	}

	/**
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * @param goodsName
	 *            the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * @return the tradeorderId
	 */
	public String getTradeorderId() {
		return tradeorderId;
	}

	/**
	 * @param tradeorderId
	 *            the tradeorderId to set
	 */
	public void setTradeorderId(String tradeorderId) {
		this.tradeorderId = tradeorderId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the typeCode
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * @param typeCode
	 *            the typeCode to set
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * @return the storeCode
	 */
	public String getStoreCode() {
		return storeCode;
	}

	/**
	 * @param storeCode
	 *            the storeCode to set
	 */
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	/**
	 * @return the create_time
	 */
	public Date getCreate_time() {
		return create_time;
	}

	/**
	 * @param create_time
	 *            the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the update_time
	 */
	public Date getUpdate_time() {
		return update_time;
	}

	/**
	 * @param update_time
	 *            the update_time to set
	 */
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

}
