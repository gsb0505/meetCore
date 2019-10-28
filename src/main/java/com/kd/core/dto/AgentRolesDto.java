/**
 * 
 */
package com.kd.core.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.kd.core.entity.BaseEntity;

/**
 *
 *@类名称：UserRolesDto.java
 *@类描述：用户角色关系传输对象

 *@创建时间：2015年1月15日-下午2:50:32
 *@修改备注:
 *@version 
 */
@XmlRootElement(name="agentRolesDto")
public class AgentRolesDto extends BaseEntity{
	
	private String userId;
	private String userName;
	private String agentId;
	private String agentDesc;
	private String agentName;
	private String agentRoleDesc;
	private String agentRoleCode;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getAgentDesc() {
		return agentDesc;
	}
	public void setAgentDesc(String agentDesc) {
		this.agentDesc = agentDesc;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentRoleDesc() {
		return agentRoleDesc;
	}
	public void setAgentRoleDesc(String agentRoleDesc) {
		this.agentRoleDesc = agentRoleDesc;
	}
	public String getAgentRoleCode() {
		return agentRoleCode;
	}
	public void setAgentRoleCode(String agentRoleCode) {
		this.agentRoleCode = agentRoleCode;
	}
	
	
	 
	
	
	
}
