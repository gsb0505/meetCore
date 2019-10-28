/**
 * 
 */
package com.kd.core.entity;



import java.util.Date;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 *@类名称：BaseEntity.java
 *@类描述：基础实体，用来封装所有共有的属性

 *@创建时间：2015年1月14日-下午6:42:59
 *@修改备注:
 *@version 
 */
@XmlRootElement
public class BaseEntity {
	@Transient
	private String id;//主键id
	@Transient
	private String creator;//创建人
	@Transient
	private String auditor;//修改人
	@Transient
	private Date createTime;//创建时间
	@Transient
	private Date updateTime;//修改时间
	@Transient
	public PageCount pageCount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
 
	public void setPageCount(PageCount pageCount) {
		this.pageCount = pageCount;
	}
	/*public PageCount getPageCount() {
		return pageCount;
	}*/

	
}
