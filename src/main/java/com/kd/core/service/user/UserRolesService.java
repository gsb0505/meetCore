
package com.kd.core.service.user;
import java.util.List;

import com.kd.core.base.BaseService;
import com.kd.core.dto.UserRolesDto;
import com.kd.core.entity.UserRoles;

/**
 * 
 *
 *@类名称：UserRolesService.java
 *@类描述：用户角色关系Service

 *@创建时间：2015年1月15日-下午1:20:31
 *@修改备注:
 *@version
 */
public interface UserRolesService extends BaseService<UserRolesDto>{
	/**
	 * 
	 *@描述 :根据id和选择的权限集合进行数据更新
	
	 *@创建时间：2015年1月15日 下午3:54:51
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param
	 *@return
	 *
	 * @param userId
	 * @param userRoles
	 * @return
	 */
	
	public boolean updateUserRoles(String userId,UserRoles[] userRoles);
	/**
	 * glt 
	 * TODO 获取一个用户的多个角色 用于角色切换
	 * @param dto
	 * @return
	 * @return List<UserRolesDto>
	 * @auditor
	 * @exception
	 * @since  1.0.0
	 */
	public List<UserRolesDto> getUserRolesList(UserRolesDto dto);
	
	
}
