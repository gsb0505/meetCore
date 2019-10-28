/**
*
 * @package:com.kd.core.entity
 * @projectName:cloud-core
 * @CreateTime:2015年1月22日-下午2:20:47
 *  2015杭州宽达信息技术有限公司-版权所有
 *
 */
package com.kd.core.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @Class:OrgDescInfo
 * @Autor:glt
 * @CreateTime:2015年1月22日 下午2:20:47
 * @version 1.0.0
 *
 */
@XmlRootElement
public class OrgDescInfo {
	//地域 Id 子
	private  String orgId;
	//地域 Id 父
	private  String parentOrgId;
	//地域描述
	private String orgDesc;
	//状态
	private String status;
	//备注
	private String remark;
	/**
	 * orgId
	 *
	 * @return  the orgId
	 * @since   1.0.0
	 */
	
	public String getOrgId() {
		return orgId;
	}
	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * parentOrgId
	 *
	 * @return  the parentOrgId
	 * @since   1.0.0
	 */
	
	public String getParentOrgId() {
		return parentOrgId;
	}
	/**
	 * @param parentOrgId the parentOrgId to set
	 */
	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}
	/**
	 * orgDesc
	 *
	 * @return  the orgDesc
	 * @since   1.0.0
	 */
	
	public String getOrgDesc() {
		return orgDesc;
	}
	/**
	 * @param orgDesc the orgDesc to set
	 */
	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}
	/**
	 * status
	 *
	 * @return  the status
	 * @since   1.0.0
	 */
	
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * remark
	 *
	 * @return  the remark
	 * @since   1.0.0
	 */
	
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
