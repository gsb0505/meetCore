/**
 * 
 */
package com.kd.core.resource.system;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kd.core.dto.UserLogDto;
import com.kd.core.entity.UserLog;
import com.kd.core.service.system.UserLogService;
/**
 *
 *@类名称：UserLogResource.java
 *@类描述：用户日志

 *@创建时间：2015年3月9日-下午4:41:30
 *@修改备注:
 *@version 
 */
@Path("userLog")
public class UserLogResource {
	@Autowired
	private UserLogService userLogService;

	public UserLogService getUserLogService() {
		return userLogService;
	}

	public void setUserLogService(UserLogService userLogService) {
		this.userLogService = userLogService;
	}
	/**
	 * 
	 *@描述	:用户日志表插入数据
	
	 *@创建时间：2015年3月9日 下午4:51:13
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param
	 *@return
	 *
	 * @param t
	 * @return
	 */
	@POST
	@Path("insert")
	public String add(UserLog t){
		return ""+userLogService.insert(t);
	}
	
	
	
	/**
	 *@描述
	
	 *@创建时间：2015年3月23日 下午2:19:26
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *
	 * @param userLog
	 * @return
	 */
	@GET
	@Path("queryLogByCondition")
	public List<UserLog> queryLogByCondition(@QueryParam("userLogDto") String userLogDto){
		UserLogDto uld =  new Gson().fromJson(userLogDto, UserLogDto.class);
				List<UserLog> list = userLogService.getPagedList(uld);
				if (list.size()>0) {
					list.get(0).setPageCount(uld.pageCount); //把分页参数值放入list
				}
				return list;
	}
	
}
