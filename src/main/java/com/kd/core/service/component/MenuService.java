/**
 * 
 */
package com.kd.core.service.component;

import java.util.List;

import com.kd.core.base.BaseService;
import com.kd.core.dto.ButtonDto;
import com.kd.core.dto.MenuDto;

/**
 *
 *@类名称：ButtonService.java
 *@类描述：

 *@创建时间：2015年1月29日-下午3:59:28
 *@修改备注:
 *@version 
 */
public interface MenuService extends BaseService<MenuDto>{
public List<MenuDto> queryAllLevel(MenuDto menuDto);

}
