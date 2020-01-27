package com.kd.core.resource.user;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;




import com.google.gson.Gson;
import com.kd.common.unit.util.EncryptUtils;
import com.kd.core.entity.PageCount;
import com.kd.core.entity.Role;
import com.kd.core.entity.UserInfo;
import com.kd.core.service.user.UserService;
import com.kd.core.util.CoreUtil;



/**
 *
 *@类名称：UserResource.java
 *@类描述：用户管理core项目资源类

 *@创建时间：2015年1月28日-下午12:50:52
 *@修改备注:集成所有base类
 *@version 
 */
@Path("/user")
public class UserResource {
	private static Logger log = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UserService userService;

	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	/**
	 *@描述
	
	 *@创建时间：2015年1月28日 下午12:52:31
	 *@修改描述：集成base类  根据用户名，状态和用户ID进行查询  
	 * @param info
	 * @return List<UserInfo>
	 * @throws Exception
	 */
	@GET
	@Path("query")
	public List<UserInfo> query (@QueryParam("user") String user ) throws Exception {
		UserInfo u = new Gson().fromJson(user, UserInfo.class);
		List<UserInfo> list  = userService.getPagedList(u);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(u.pageCount);
		}
		return list;
	}
	
	
	/**
	 * 新增
	 * @param userInfo
	 * @throws Exception
	 */
	@POST
	@Path("add")
	public void addClientUser(UserInfo userInfo) throws Exception {
		userService.insert(userInfo);
	}
	

	/**
	 * 指向修改
	 * @param id
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@GET
	@Path("queryModel")
	public UserInfo queryModel(@QueryParam("user") String user) throws Exception {
		UserInfo u = new Gson().fromJson(user, UserInfo.class);
		return 	userService.getModel(u);
	}
	/**
	 * 修改
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("modify")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public boolean modifyClientUser(UserInfo userInfo) throws Exception {
		return userService.update(userInfo);
	}
	/**
	 * 非空修改
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("modifyByCondition")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public boolean modifyByCondition(UserInfo userInfo) {
		return userService.updateByCondition(userInfo);
	}
	
	/**
	 * 指向修改
	 * @param user
	 * @throws Exception
	 */
	@GET
	@Path("validUser")
	public UserInfo validUser(@QueryParam("user") String user) throws Exception {
		UserInfo u = new Gson().fromJson(user, UserInfo.class);
		return 	userService.validUser(u);
	}

	
	@GET
	@Path("queryAll")
	public List<UserInfo> getAllUserInfo(){
		return userService.getModelList(new UserInfo());
	}
	
	/**
	 * 更新密码错误次数
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@PUT
	@Path("modifyError")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
	public boolean modifyError(UserInfo userInfo) throws Exception {
		return userService.updateErr(userInfo);
	}

	@GET
	@Path("wxLogin")
	public String wxLogin(@QueryParam("user") String user){
		UserInfo u = new Gson().fromJson(user, UserInfo.class);

		EncryptUtils loginE = new EncryptUtils(u.getUserId(), "MD5");
		String inPws = loginE.encode(u.getLoginPSW());
		u.setLoginPSW(inPws);
		log.debug(new Gson().toJson(userService.validUser(u)));
		return 	new Gson().toJson(userService.validUser(u));
	}
	


	
}
