/**
 * 
 */
package com.kd.core.service.user;

import java.util.List;

import com.kd.core.base.BaseService;
import com.kd.core.entity.UserInfo;



/**
 * @author glt
 *
 */
public interface UserService extends BaseService<UserInfo>{
	public int countUser() throws Exception;
	public UserInfo validUser(UserInfo user);
	
	/**
	 * 更新密码错误次数
	 * @return
	 */
	public boolean updateErr(UserInfo user);
	
	/**
	 * 根据userId删除User与相关权限
	 * @param userId
	 * @return
	 */
	public boolean delByUserId(String userId);
}
