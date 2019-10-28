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

import com.kd.core.dto.ButtonDto;
import com.kd.core.service.impl.component.ButtonServiceImpl;

/**
 *
 *@类名称：ButtonResource.java
 *@类描述：

 *@创建时间：2015年1月29日-下午4:23:29
 *@修改备注:
 *@version 
 */
@Path("button")
public class ButtonResource {
	@Autowired
	private ButtonServiceImpl buttonServiceImpl;

	



	public ButtonServiceImpl getButtonServiceImpl() {
		return buttonServiceImpl;
	}





	public void setButtonServiceImpl(ButtonServiceImpl buttonServiceImpl) {
		this.buttonServiceImpl = buttonServiceImpl;
	}





	@GET
	@Path("query")
	public List<ButtonDto> getButtons(@Context UriInfo info){
		ButtonDto dto=new ButtonDto();
		dto.setRoleId(info.getQueryParameters().getFirst("roleId"));
		
		return buttonServiceImpl.getModelList(dto);
	}
	
}
