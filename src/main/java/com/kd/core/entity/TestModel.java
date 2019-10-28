package com.kd.core.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name = "agent_info")
@XmlRootElement()
public class TestModel extends BaseEntity {
	@Id
	@Column(name = "agent_id")
	private String agentId;//用户名
	
	@Column(name = "agent_desc")
	private String agentDesc;
	
	@Id
	@Column(name = "id1")
	private String id;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
