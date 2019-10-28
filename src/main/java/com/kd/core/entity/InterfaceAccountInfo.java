/**
 *
 * @package:com.kd.core.entity
 * @projectName:cloud-core
 * @CreateTime:2015年1月20日-下午2:49:21
 *  2015杭州宽达信息技术有限公司-版权所有
 *
 */
package com.kd.core.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 
 * @类名称：InterfaceAccountInfo.java
 * @类描述：接口账户信息

 * @创建时间：2015年3月16日-上午10:49:20
 * @修改备注:字段重新定义
 * @version
 */
@XmlRootElement(name = "interfaceAccountInfo")
public class InterfaceAccountInfo extends BaseEntity {
	private String interfaceId;// 接口编号
	private String interfaceName;// 接口名
	private String rechargeURL;// 充值地址
	private String balanceURL;// 余额查询地址
	private String queryURL;// 状态查询地址
	private String loginPSW;// 登陆密码
	private String payPSW;// 支付密码
	private String thirdKey;// 第三方密匙
	private String cash;// 金额
	private String typeId;// 接口类型表ID
	private String accountId;// 接口账户ID
	private String accountName;// 接口用户name
	private String onOff;// 开关 0 关 1 开 默认关
	private String interfaceOnOff;// 开关 0 关 1 开 默认关
	private String ip;// ip
	private String remark;// 备注
	private String tacticsConfigs;// 接口账户策略数据 格式是json
									// key=策略code（基础数据表中--接口优先策略表）
	private String dailyLimit;// 每日限额 默认值0 不限
	private String otherConfig;// 这个字段预留
	private String commissionType; // 接口佣金方式
	private String speed_ratio;  //充值速度比例
	private String quality_ratio; //质量比例
	
	public String getInterfaceOnOff() {
		return interfaceOnOff;
	}

	public void setInterfaceOnOff(String interfaceOnOff) {
		this.interfaceOnOff = interfaceOnOff;
	}

	public String getThirdKey() {
		return thirdKey;
	}

	public void setThirdKey(String thirdKey) {
		this.thirdKey = thirdKey;
	}

	public String getDailyLimit() {
		return dailyLimit;
	}

	public void setDailyLimit(String dailyLimit) {
		this.dailyLimit = dailyLimit;
	}

	public String getOtherConfig() {
		return otherConfig;
	}

	public void setOtherConfig(String otherConfig) {
		this.otherConfig = otherConfig;
	}

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getRechargeURL() {
		return rechargeURL;
	}

	public void setRechargeURL(String rechargeURL) {
		this.rechargeURL = rechargeURL;
	}

	public String getBalanceURL() {
		return balanceURL;
	}

	public void setBalanceURL(String balanceURL) {
		this.balanceURL = balanceURL;
	}

	public String getQueryURL() {
		return queryURL;
	}

	public void setQueryURL(String queryURL) {
		this.queryURL = queryURL;
	}

	public String getLoginPSW() {
		return loginPSW;
	}

	public void setLoginPSW(String loginPSW) {
		this.loginPSW = loginPSW;
	}

	public String getPayPSW() {
		return payPSW;
	}

	public void setPayPSW(String payPSW) {
		this.payPSW = payPSW;
	}

	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getOnOff() {
		return onOff;
	}

	public void setOnOff(String onOff) {
		this.onOff = onOff;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTacticsConfigs() {
		return tacticsConfigs;
	}

	public void setTacticsConfigs(String tacticsConfigs) {
		this.tacticsConfigs = tacticsConfigs;
	}

	public String getCommissionType() {
		return commissionType;
	}

	public void setCommissionType(String commissionType) {
		this.commissionType = commissionType;
	}

	public String getSpeed_ratio() {
		return speed_ratio;
	}

	public void setSpeed_ratio(String speed_ratio) {
		this.speed_ratio = speed_ratio;
	}

	public String getQuality_ratio() {
		return quality_ratio;
	}

	public void setQuality_ratio(String quality_ratio) {
		this.quality_ratio = quality_ratio;
	}

}
