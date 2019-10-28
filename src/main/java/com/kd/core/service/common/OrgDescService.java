/**
*
 * @package:com.kd.core.service.common
 * @projectName:cloud-core
 * @CreateTime:2015年1月22日-下午2:19:29
 *  2015杭州宽达信息技术有限公司-版权所有
 *
 */
package com.kd.core.service.common;

import com.kd.core.base.BaseService;
import com.kd.core.entity.OrgDescInfo;

/**
 *
 * @interface:OrgDescService
 * @Autor:glt
 * @CreateTime:2015年1月22日 下午2:19:29
 * @version 1.0.0
 *
 */
public interface OrgDescService extends BaseService<OrgDescInfo>{

	public String getIDList(String orgDesc);
}
