/**
*
 * @package:com.kd.core.service.impl.common
 * @projectName:cloud-core
 * @CreateTime:2015年1月22日-下午2:30:20
 *  2015杭州宽达信息技术有限公司-版权所有
 *
 */
package com.kd.core.service.impl.common;
import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.common.OrgDescDao;
import com.kd.core.entity.OrgDescInfo;
import com.kd.core.service.common.OrgDescService;

/**
 *
 * @Class:OrgDescServiceImpl
 * @Autor:glt
 * @CreateTime:2015年1月22日 下午2:30:20
 * @version 1.0.0
 *
 */
public class OrgDescServiceImpl extends BaseServiceImpl<OrgDescInfo,OrgDescDao> implements OrgDescService {
	private OrgDescDao orgDescDao;
	
	/**
	 * orgDescDao
	 *
	 * @return  the orgDescDao
	 * @since   1.0.0
	 */
	
	public OrgDescDao getOrgDescDao() {
		return orgDescDao;
	}

	/**
	 * @param orgDescDao the orgDescDao to set
	 */
	public void setOrgDescDao(OrgDescDao orgDescDao) {
		this.orgDescDao = orgDescDao;
	}

	@Override
	public String getIDList(String orgDesc) {
		
		return dao.getIDList(orgDesc);
	}

	
	
}
