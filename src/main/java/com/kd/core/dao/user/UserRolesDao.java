package com.kd.core.dao.user;


import java.util.List;

import com.kd.core.base.BaseDao;
import com.kd.core.dto.UserRolesDto;
import com.kd.core.entity.UserRoles;

/**
 * 
 *
 *@类名称：UserRolesDao.java
 *@类描述：用户角色关系

 *@创建时间：2015年1月15日-上午11:28:03
 *@修改备注:
 *@version
 */
public interface UserRolesDao extends BaseDao<UserRolesDto>{
	
	/**
	 * 
	 *@描述 添加角色用户关系
	
	 *@创建时间：2015年1月15日 下午1:37:05
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param
	 *@return
	 *
	 * @param userRoles
	 * @return
	 */
	public boolean addUserRoles(UserRoles userRoles);
	
	/**
	 * glt TODO 获取一个用户的多个角色 用于角色切换
	 * 
	 * @param dto
	 * @return
	 * @return List<UserRolesDto>
	 * @auditor
	 * @exception
	 * @since 1.0.0
	 */
	public List<UserRolesDto> getUserRolesList(UserRolesDto dto);
	
}
