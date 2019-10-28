package com.kd.core.dao.organization;

import java.util.List;

import com.kd.core.base.BaseDao;
import com.kd.core.dto.ODJDto;
import com.kd.core.entity.OrgDepartmentJob;
import com.kd.core.entity.Organization;


public interface OrganizationDao extends BaseDao<Organization>{

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Organization record);

    List<Organization> getAllOrg();
    
    /**
     * 根据条件查询相关配置信息
     * @param orgId
     * @return
     */
    List<OrgDepartmentJob> getDepartsJobsByCondition(OrgDepartmentJob orgJob);
    /**
     * 添加一行配置
     * @param orgJob
     * @return
     */
    Integer addRow(OrgDepartmentJob orgJob);
    /**
     * 删除一行配置
     * @param orgId
     * @return
     */
    Integer delRow(OrgDepartmentJob orgJob);
    /**
     * 删除职位
     * @param jobId
     * @return
     */
    Integer delJob(OrgDepartmentJob orgJob);
    /**
     * 添加职位
     * @param jobId
     * @return
     */
    Integer addJob(OrgDepartmentJob orgJob);
    
    /**
     * 记录查询
     * @param orgJob
     * @return
     */
    OrgDepartmentJob findRecord(OrgDepartmentJob orgJob);
    
    /**
     * 查询所有配置列表
     * @param orgJob
     * @return
     */
    List<ODJDto> queryODJList(OrgDepartmentJob orgJob);
}