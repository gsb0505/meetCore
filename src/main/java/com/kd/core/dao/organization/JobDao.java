package com.kd.core.dao.organization;

import java.util.List;

import com.kd.core.base.BaseDao;
import com.kd.core.entity.Job;
import com.kd.core.entity.OrgDepartmentJob;


public interface JobDao extends BaseDao<Job>{

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Job record);
    
    /**
     * 根据机构号与部门号查询职位
     * @return
     */
    List<Job> findJobsByOrgDeparts(OrgDepartmentJob odj);
    
    Integer countByJobId(String jobIds);

}