/**
 * 
 */
package com.kd.core.resource.component;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.dto.MenuDto;
import com.kd.core.service.component.MenuService;

/**
 *
 *@类名称：ButtonResource.java
 *@类描述：

 *@创建时间：2015年1月29日-下午4:23:29
 *@修改备注:
 *@version 
 */
@Path("menu")
public class MenuResource {
	@Autowired
	private MenuService menuService ;

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	@GET
	@Path("query")
	public List<MenuDto> getButtons(@Context UriInfo info){
		MenuDto dto=new MenuDto();
		dto.setRoleId(info.getQueryParameters().getFirst("roleId"));
		
		return menuService.getModelList(dto);
	}
	
}
