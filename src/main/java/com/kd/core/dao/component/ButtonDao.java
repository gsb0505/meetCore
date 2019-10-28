package com.kd.core.dao.component;

import java.util.List;

import com.kd.core.base.BaseDao;
import com.kd.core.dto.ButtonDto;
import com.kd.core.dto.MenuDto;

/**
 *
 *@类名称：ButtonDao.java
 *@类描述：

 *@创建时间：2015年1月29日-下午3:52:43
 *@修改备注:
 *@version 
 */
public interface ButtonDao extends BaseDao<ButtonDto> {
	public List<ButtonDto> qeuryAllButton();
	public String getModel(MenuDto t);
}
