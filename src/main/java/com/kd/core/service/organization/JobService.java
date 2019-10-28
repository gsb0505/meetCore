package com.kd.core.service.organization;

import java.util.List;

import com.kd.core.base.BaseService;
import com.kd.core.entity.Job;
import com.kd.core.entity.OrgDepartmentJob;

/**
 * 职位--Service
 * @author zlm
 *
 */
public interface JobService extends BaseService<Job> {

	/**
     * 根据机构号与部门号查询职位
     * @return
     */
    List<Job> findJobsByOrgDeparts(OrgDepartmentJob odj);
    
    Integer countByJobId(String jobIds);
}
