/**
*
 * @package:com.kd.core.dao.common
 * @projectName:cloud-core
 * @CreateTime:2015年1月22日-下午2:24:57
 *  2015杭州宽达信息技术有限公司-版权所有
 *
 */
package com.kd.core.dao.common;

import com.kd.core.base.BaseDao;
import com.kd.core.entity.OrgDescInfo;

/**
 *
 * @Class:OrgDescDao
 * @Autor:glt
 * @CreateTime:2015年1月22日 下午2:24:57
 * @version 1.0.0
 *
 */
public interface OrgDescDao extends BaseDao<OrgDescInfo>{
	
	public String getIDList(String orgDesc);
}
