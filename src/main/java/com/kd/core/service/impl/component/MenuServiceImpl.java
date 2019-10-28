/**
 * 
 */
package com.kd.core.service.impl.component;

import java.util.List;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.component.MenuDao;
import com.kd.core.dto.MenuDto;
import com.kd.core.service.component.MenuService;

/**
 *
 *@类名称：ButtonServiceImpl.java
 *@类描述：

 *@创建时间：2015年1月29日-下午4:01:15
 *@修改备注:
 *@version 
 */
public class MenuServiceImpl extends BaseServiceImpl<MenuDto, MenuDao> implements MenuService{

	
public List<MenuDto> queryAllLevel(MenuDto menuDto){
		return dao.queryAllLevel(menuDto);
		
	}

	
}
