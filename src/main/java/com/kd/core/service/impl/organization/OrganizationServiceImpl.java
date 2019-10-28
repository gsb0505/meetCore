package com.kd.core.service.impl.organization;

import java.util.List;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.organization.OrganizationDao;
import com.kd.core.dto.ODJDto;
import com.kd.core.entity.OrgDepartmentJob;
import com.kd.core.entity.Organization;
import com.kd.core.service.organization.OrganizationService;

public class OrganizationServiceImpl extends BaseServiceImpl<Organization,OrganizationDao> implements
		OrganizationService {

	@Override
	public List<OrgDepartmentJob> getDepartsJobsByCondition(OrgDepartmentJob orgJob) {
		return dao.getDepartsJobsByCondition(orgJob);
	}

	@Override
	public Boolean configOrgDepartmentJob(OrgDepartmentJob orgJob,String type) {
		if(type==null){
			return false;
		}else if(type.equals("addRow")){
			return dao.addRow(orgJob)>0;
		}else if(type.equals("delRow")){
			return dao.delRow(orgJob)>0;
		}
		return false;
	}

	@Override
	public List<Organization> getAllOrg() {
		return dao.getAllOrg();
	}

	@Override
	public boolean findRecord(OrgDepartmentJob orgJob) {
		return dao.findRecord(orgJob) != null ? true : false;
	}

	@Override
	public List<ODJDto> queryODJList(OrgDepartmentJob orgJob) {
		return dao.queryODJList(orgJob);
	}

}
