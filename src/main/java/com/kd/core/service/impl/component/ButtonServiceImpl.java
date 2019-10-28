/**
 * 
 */
package com.kd.core.service.impl.component;

import java.util.List;


import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.component.ButtonDao;
import com.kd.core.dto.ButtonDto;
import com.kd.core.dto.MenuDto;
import com.kd.core.service.component.ButtonService;

/**
 *
 *@类名称：ButtonServiceImpl.java
 *@类描述：

 *@创建时间：2015年1月29日-下午4:01:15
 *@修改备注:
 */
public class ButtonServiceImpl extends BaseServiceImpl<ButtonDto, ButtonDao> implements ButtonService{

	
	public List<ButtonDto> qeuryAllButton(){
		return dao.qeuryAllButton();
	}
	
	public String getModel(MenuDto m){
		return dao.getModel(m);
	}
	
}
