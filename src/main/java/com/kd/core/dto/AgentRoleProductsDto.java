package com.kd.core.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AgentRoleProductsDto {
	private String code;
	private String name;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
