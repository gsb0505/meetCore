/**
 * 
 */
package com.kd.core.service.system;

import java.util.List;

import com.kd.core.base.BaseService;
import com.kd.core.dto.UserLogDto;
import com.kd.core.entity.UserLog;

/**
 *
 *@类名称：UserLogService.java
 *@类描述：

 *@创建时间：2015年3月9日-下午4:34:24
 *@修改备注:
 *@version 
 */
public interface UserLogService extends BaseService<UserLog>{
    public List<UserLog> getPagedList(UserLogDto dto);
}
