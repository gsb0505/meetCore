/**
 * 
 */
package com.kd.core.service.impl.system;

import java.util.List;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.system.UserLogDao;
import com.kd.core.dto.UserLogDto;
import com.kd.core.entity.UserLog;
import com.kd.core.service.system.UserLogService;

/**
 *
 *@类名称：UserLogServiceImpl.java
 *@类描述：用户日志serviceImpl

 *@创建时间：2015年3月9日-下午4:37:34
 *@修改备注:
 *@version 
 */
public class UserLogServiceImpl extends BaseServiceImpl<UserLog, UserLogDao> implements UserLogService{
	 public List<UserLog> getPagedList(UserLogDto dto){
		 return dao.getPagedList(dto);
	 }
}
