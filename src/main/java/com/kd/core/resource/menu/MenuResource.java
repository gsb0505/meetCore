package com.kd.core.resource.menu;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.dto.MenuDto;
import com.kd.core.service.component.MenuService;

/**
 *
 *@类名称：MenuResource.java
 *@类描述：用户菜单管理

 *@创建时间：2015年1月30日-下午1:48:21
 *@修改备注:
 *@version 
 */
@Path("userMenu")
public class MenuResource {
	@Autowired
	private MenuService menuService ;
	
	
	public MenuService getMenuService() {
		return menuService;
	}


	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	
	/**
	 *@描述：根据角色ID获得该角色所拥有的所有菜单
	
	 *@创建时间：2015年2月6日 下午1:07:55
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *
	 * @param roleId
	 * @return
	 */
	@Path("queryAllLevel")
	@GET
	public List<MenuDto> queryAllLevel(@QueryParam(value="roleId") String roleId,@QueryParam(value="userId") String userId){
		MenuDto menuDto = new MenuDto();
		menuDto.setRoleId(roleId);
		menuDto.setUserId(userId);
		List<MenuDto> list = menuService.queryAllLevel(menuDto);
		return list;
	}
	
	/**
	 *@描述：增加常用功能
	
	 *@创建时间：2015年3月16日 下午6:42:38
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 */
	@Path("addFavorite")
	@POST	
	public boolean addFavorite(MenuDto menuDto){
		
		return menuService.insert(menuDto);
	}
	
	/**
	 *@描述：删除常用功能
	
	 *@创建时间：2015年3月18日 下午8:29:52
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 */
	@Path("delFavorite")
	@DELETE
	public boolean delFavorite(@QueryParam(value="menuId") String menuId,@QueryParam(value="userId") String userId) {
		MenuDto menuDto = new MenuDto();
		menuDto.setMenuId(menuId);
		menuDto.setUserId(userId);
		return menuService.delete(menuDto);
	}
	

}
