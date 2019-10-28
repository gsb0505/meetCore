/**
 * 
 */
package com.kd.core.entity;

import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @类名称：Roles.java
 * @类描述：用户角色

 * @创建时间：2015年1月13日-下午4:09:29
 * @修改备注:
 * @version
 */
@XmlRootElement(name = "userRoles")
public class UserRoles extends BaseEntity{


	private String userId;// 用户表userId
	private String roleCode;// 角色表role_code
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	





}
