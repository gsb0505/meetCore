package com.kd.core.service.organization;

import java.util.List;

import com.kd.core.base.BaseService;
import com.kd.core.entity.Department;

public interface DepartmentService extends BaseService<Department> {
	
	/**
     * 根据机构id查询部门
     * @param orgId
     * @return
     */
    List<Department> findDepartsByOrg(String orgId);
    
}
