package com.kd.core.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *@类名称：SystemConfig.java
 *@类描述：系统配置表

 *@创建时间：2015年3月21日-下午4:32:51
 *@修改备注:
 *@version 
 */
@XmlRootElement
public class Config extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2497477998795980727L;
	private String num;
	private String mark;	//配置备注（标记）
	private String code;
	private String remark;	//对配置的描述
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


}
