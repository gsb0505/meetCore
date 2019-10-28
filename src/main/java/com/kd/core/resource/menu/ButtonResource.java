package com.kd.core.resource.menu;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.kd.core.dto.ButtonDto;
import com.kd.core.dto.MenuDto;
import com.kd.core.service.component.ButtonService;

/**
 *
 *@类名称：ButtonResource.java
 *@类描述：

 *@创建时间：2015年2月3日-下午3:52:39
 *@修改备注:
 *@version 
 */
@Path("userButton")
public class ButtonResource {
	@Autowired
	private ButtonService buttonService;

	public ButtonService getButtonService() {
		return buttonService;
	}

	public void setButtonService(ButtonService buttonService) {
		this.buttonService = buttonService;
	}
	
	@GET
	@Path("queryAllButton")
	public List<ButtonDto> qeuryAllButton(){
		return buttonService.qeuryAllButton();
	}
	
	@GET
	@Path("queryButton")
	public String qeuryButtonByCondition(@QueryParam("menuId") String menuId,@QueryParam("roleId") String roleId){
		MenuDto dto = new MenuDto();
		dto.setMenuId(menuId);
		dto.setRoleId(roleId);
		return buttonService.getModel(dto);
	}
}
