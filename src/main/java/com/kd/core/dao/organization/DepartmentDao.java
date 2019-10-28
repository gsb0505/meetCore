package com.kd.core.dao.organization;

import java.util.List;

import com.kd.core.base.BaseDao;
import com.kd.core.entity.Department;

/**
 * 部门 
 * @author zlm
 *
 */
public interface DepartmentDao extends BaseDao<Department>{

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);
    
    /**
     * 根据机构id查询部门
     * @param orgId
     * @return
     */
    List<Department> findDepartsByOrg(String orgId);

}