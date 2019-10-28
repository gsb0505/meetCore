package com.kd.core.dao.user;


import com.kd.core.base.BaseDao;
import com.kd.core.entity.UserInfo;
/**
 * 
 *
 *@类名称：UserDao.java
 *@类描述：后台用户

 *@创建时间：2015年1月14日-下午1:12:57
 *@修改备注:
 *@version
 */
public interface UserDao extends BaseDao<UserInfo> {

	public int countUser();
	public UserInfo validUser(UserInfo user);
	public int updateErr(UserInfo user);
	public int updatePSW(UserInfo user);
	
	public int delByUserId(String userId);
	public UserInfo getByUserid(String username);
}
