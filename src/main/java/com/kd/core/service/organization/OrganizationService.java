package com.kd.core.service.organization;

import java.util.List;

import com.kd.core.base.BaseService;
import com.kd.core.dto.ODJDto;
import com.kd.core.entity.OrgDepartmentJob;
import com.kd.core.entity.Organization;

/**
 * 机关--Service
 * @author zlm
 *
 */
public interface OrganizationService extends BaseService<Organization>  {
	
	 /**
     * 根据条件查询相关配置信息
     * @param orgId
     * @return
     */
	List<OrgDepartmentJob> getDepartsJobsByCondition(OrgDepartmentJob orgJob);
	
	/**
	 * 配置
	 * @param orgJob
	 * @return
	 */
	Boolean configOrgDepartmentJob(OrgDepartmentJob orgJob,String type);
	
	List<Organization> getAllOrg();
	
	/**
     * 记录查询
     * @param orgJob
     * @return
     */
	boolean findRecord(OrgDepartmentJob orgJob);
	
	/**
     * 查询所有配置列表
     * @param orgJob
     * @return
     */
	List<ODJDto> queryODJList(OrgDepartmentJob orgJob);
}
