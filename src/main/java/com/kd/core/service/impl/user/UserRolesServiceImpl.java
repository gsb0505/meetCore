/**
 * 
 */
package com.kd.core.service.impl.user;

import java.util.List;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.user.UserRolesDao;
import com.kd.core.dto.UserRolesDto;
import com.kd.core.entity.UserRoles;
import com.kd.core.service.user.UserRolesService;

/**
 *
 * @类名称：UserRolesServiceImpl.java
 * @类描述：

 * @创建时间：2015年1月15日-下午1:24:06
 * @修改备注:
 * @version
 */
public class UserRolesServiceImpl extends
		BaseServiceImpl<UserRolesDto, UserRolesDao> implements UserRolesService {

	private UserRolesDao userRolesDao;

	/**
	 * userRolesDao
	 *
	 * @return the userRolesDao
	 * @since 1.0.0
	 */

	public UserRolesDao getUserRolesDao() {
		return userRolesDao;
	}

	/**
	 * @param userRolesDao
	 *            the userRolesDao to set
	 */
	public void setUserRolesDao(UserRolesDao userRolesDao) {
		this.userRolesDao = userRolesDao;
	}

	// TODO 这边需要事物的封装
	public boolean updateUserRoles(String userId, UserRoles[] userRoles) {
		dao.delete(userId);
		for (UserRoles ur : userRoles) {
			dao.addUserRoles(ur);
		}
		return true;
	}

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
	public List<UserRolesDto> getUserRolesList(UserRolesDto dto) {
		return userRolesDao.getUserRolesList(dto);
	}
}
