/**
 *
 * @package:com.kd.core.entity
 * @projectName:cloud-core
 * @CreateTime:2015年1月15日-下午3:45:11
 *  2015杭州宽达信息技术有限公司-版权所有
 *
 */
package com.kd.core.entity;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *角色菜单
 * @Class:Menu
 * @Autor:glt
 * @CreateTime:2015年1月15日 下午3:45:11
 * @version 1.0.0
 *
 */
@XmlRootElement()
public class Menu {
	@FormParam("id")
	private String id;
	@FormParam("targetId")
	private String targetId;
	@FormParam("pId")
	private String pId;
	@FormParam("targetPId")
	private String targetPId;
	@FormParam("name")
	private String name;
	@FormParam("roleId")
	private String roleId;     
	@FormParam("typeId")
	private String typeId;
	private String btnId;
	private String open;  //ztree使用
	private String checked; //ztree使用
	private String isbtn;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getTargetPId() {
		return targetPId;
	}
	public void setTargetPId(String targetPId) {
		this.targetPId = targetPId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getBtnId() {
		return btnId;
	}
	public void setBtnId(String btnId) {
		this.btnId = btnId;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getIsbtn() {
		return isbtn;
	}
	public void setIsbtn(String isbtn) {
		this.isbtn = isbtn;
	}
	

}
