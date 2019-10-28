package com.kd.core.resource.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kd.core.entity.Menu;
import com.kd.core.entity.PageCount;
import com.kd.core.entity.Role;
import com.kd.core.entity.UserInfo;
import com.kd.core.service.user.RoleService;
import com.kd.core.util.CoreUtil;

/**
 *
 * @类名称：RoleResource.java
 * @类描述：
 * 
 * @创建时间：2015年2月3日-下午12:57:03
 * @修改备注:
 * @version
 */
@Path("/role")
public class RoleResource {
	@Autowired
	private RoleService roleService;

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * 新增
	 * 
	 * @param userInfo
	 * @throws Exception
	 */
	@POST
	@Path("add")
	public boolean addClientUser(Role role) throws Exception {
		return roleService.insert(role);
	}

	/**
	 * @描述:根据条件查询数据！
	 * 
	 * @创建时间：2015年2月9日 下午5:19:17
	 * @修改人：
	 * @修改时间：
	 * @修改描述：
	 *
	 * @param info
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("query")
	public List<Role> query(@QueryParam("role") String role) throws Exception {
		Role r = new Gson().fromJson(role, Role.class);
		List<Role> roleList = roleService.getPagedList(r);
		if (roleList.size() > 0) {
			roleList.get(0).setPageCount(r.pageCount);
		}
		return roleList;
	}

	/**
	 * 修改
	 * 
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@PUT
	@Path("modify")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public boolean modifyClientRole(Role role) throws Exception {
		return roleService.update(role);
	}

	/**
	 * @描述:配置用户角色关系时查询所有角色
	 * 
	 * @创建时间：2015年2月9日 下午5:25:13
	 * @修改人：
	 * @修改时间：
	 * @修改描述：
	 *
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("queryList")
	public List<Role> queryList() throws Exception {
		Role r = new Role();
		List<Role> roleList = roleService.getModelList(r);
		return roleList;
	}

	/**
	 * @描述：添加前查询数据看是否该角色已经存在
	 * 
	 * @创建时间：2015年2月9日 下午5:25:56
	 * @修改人：
	 * @修改时间：
	 * @修改描述：
	 *
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("queryModel")
	public Role queryModel(@QueryParam("role") String role) throws Exception {
		Role r = new Gson().fromJson(role, Role.class);
		return roleService.getModel(r);
	}

	/**
	 * 根据roleid查询所有分类信息-角色权限
	 * 
	 * @return
	 */
	@GET
	@Path("listByRoleId/{roleId}/{typeId}")
	public List<Menu> findAllLibraryByRoleID(
			@PathParam("roleId") String roleId,
			@PathParam("typeId") String typeId,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception {
		return roleService.findAllMenuByRoleID(roleId, typeId);
	}

	/**
	 * 查询所有分类信息-角色权限
	 * 
	 * @return
	 */
	@GET
	@Path("list/{typeId}/{roleId}")
	public List<Menu> findAllLibrary(@PathParam("typeId") String typeId,
			@PathParam("roleId") String roleId,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception {
		List<Menu> list = roleService.findAllMenu(typeId, roleId);
		return list;
	}

	/**
	 * 更新分类名称-角色权限
	 * 
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path("addAndUpdate")
	public int updateLibraryName(@Context HttpServletRequest request,
			@Context HttpServletResponse response, Menu library)
			throws Exception {
		return roleService.addOrUpdateMenu(library);
	}

	/**
	 * 删除分类-角色权限
	 * 
	 * @return
	 * @throws Exception
	 */
	@DELETE
	@Path("deleteLibrary/{role_id}/{typeId}")
	public int deleteLibrary(@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@PathParam("role_id") String role_id,
			@PathParam("typeId") String typeId) throws Exception {
		return roleService.deleteMenu(role_id, typeId);
	}
	
	/**
	 * 刪除角色
	 * @throws Exception
	 */
	@GET
	@Path("deleteByRoleID/{roleId}")
	public String deleteByRoleID(
			@PathParam("roleId") String roleId,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception {
		return roleService.deleteRole(roleId);
	}
}
