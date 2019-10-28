package com.kd.core.resource.user;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kd.core.dto.UserRolesDto;
import com.kd.core.entity.UserRoles;
import com.kd.core.service.user.UserRolesService;
@Path("/userRoles")
public class UserRolesResource {
	@Autowired
	private UserRolesService userRolesService;
	
	public UserRolesService getUserRolesService() {
		return userRolesService;
	}

	public void setUserRolesService(UserRolesService userRolesService) {
		this.userRolesService = userRolesService;
	}

	
	/**
	 *@描述：根据条件查询用户和相对于的角色，获得的分页好的数据
	
	 *@创建时间：2015年2月6日 下午1:09:53
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *
	 * @param info
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("query")
	public List<UserRolesDto> getRolesByCondition (@QueryParam("dto") String dto) throws Exception {
		
		UserRolesDto udto = new Gson().fromJson(dto, UserRolesDto.class);
	
		List<UserRolesDto> list = userRolesService.getPagedList(udto);
		if(list.size()>0){
			list.get(0).setPageCount(udto.pageCount);
		}
		return list;
	}
	
	
	
	@GET
	@Path("queryModel")
	public UserRolesDto queryModel (@QueryParam("dto") String dto) throws Exception {
		UserRolesDto udto = new Gson().fromJson(dto, UserRolesDto.class);
		UserRolesDto dtoRec = userRolesService.getModel(udto);
		return dtoRec;
	}
	
	/**
	 *@描述：编辑该用户的角色
	
	 *@创建时间：2015年2月6日 下午1:10:08
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *
	 * @param userId
	 * @param userRoles
	 * @return
	 * @throws Exception
	 */
	@PUT
	@Path("modify/{userId}")
	public boolean modifyUserRoles (@PathParam("userId") String userId,UserRoles[] userRoles) throws Exception {
		
		return userRolesService.updateUserRoles(userId, userRoles);
	}
	/**
	 * glt
	 * TODO 获取一个用户的多个角色 用于角色切换
	 * @param userId
	 * @return
	 * @throws Exception
	 * @return List<UserRolesDto>
	 * @auditor
	 * @exception
	 * @since  1.0.0
	 */
	@GET
	@Path("getUserRolesList/{userId}")
	public List<UserRolesDto> getDto (@PathParam("userId") String userId) throws Exception {
		System.out.println(userId);
		UserRolesDto udto = new UserRolesDto();
		udto.setUserId(userId);
		List<UserRolesDto> list = userRolesService.getUserRolesList(udto);
		return list;
	}

}
