package com.kd.core.service.impl.organization;

import java.util.List;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.organization.DepartmentDao;
import com.kd.core.entity.Department;
import com.kd.core.service.organization.DepartmentService;

public class DepartmentServiceImpl extends BaseServiceImpl<Department,DepartmentDao> implements
		DepartmentService {

	@Override
	public List<Department> findDepartsByOrg(String orgId) {
		return dao.findDepartsByOrg(orgId);
	}

}
