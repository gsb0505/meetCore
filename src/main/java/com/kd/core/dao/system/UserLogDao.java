/**
 * 
 */
package com.kd.core.dao.system;

import java.util.List;

import com.kd.core.base.BaseDao;
import com.kd.core.dto.UserLogDto;
import com.kd.core.entity.UserLog;

/**
 *
 *@类名称：UserLogDao.java
 *@类描述：用户日志

 *@创建时间：2015年3月9日-下午4:32:42
 *@修改备注:
 *@version 
 */
public interface UserLogDao extends BaseDao<UserLog>{
	public List<UserLog> getPagedList(UserLogDto dto);
}
