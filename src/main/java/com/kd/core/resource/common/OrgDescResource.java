/**
*
 * @package:com.kd.core.resource
 * @projectName:cloud-core
 * @CreateTime:2015年1月22日-下午2:28:25
 *  2015杭州宽达信息技术有限公司-版权所有
 *
 */
package com.kd.core.resource.common;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.service.impl.common.OrgDescServiceImpl;

/**
 *
 * @Class:OrgDescResource
 * @Autor:glt
 * @CreateTime:2015年1月22日 下午2:28:25
 * @version 1.0.0
 *
 */
@Path("orgDesc")
public class OrgDescResource {
	@Autowired
	private OrgDescServiceImpl orgDescServiceImpl;

	/**
	 * orgDescServiceImpl
	 *
	 * @return  the orgDescServiceImpl
	 * @since   1.0.0
	 */
	
	public OrgDescServiceImpl getOrgDescServiceImpl() {
		return orgDescServiceImpl;
	}

	/**
	 * @param orgDescServiceImpl the orgDescServiceImpl to set
	 */
	public void setOrgDescServiceImpl(OrgDescServiceImpl orgDescServiceImpl) {
		this.orgDescServiceImpl = orgDescServiceImpl;
	}

}