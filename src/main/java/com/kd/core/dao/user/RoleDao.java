package com.kd.core.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kd.core.base.BaseDao;
import com.kd.core.entity.Menu;
import com.kd.core.entity.Role;

/**
 * 
 *
 *@类名称：RoleDao.java
 *@类描述：角色

 *@创建时间：2015年1月14日-下午6:54:12
 *@修改备注:
 *@version
 */
public interface RoleDao extends BaseDao<Role> {
	public int countUser();
	
	/**
	  * 查询所有分类信息-角色权限
	  * @return
	  */
	  public List<Menu> findAllMenuByRoleID(Map<String, String> map/*@Param(value="roleId") String roleId,@Param(value="typeId") String typeId*/);
	  /** 
		  * 查询所有分类信息-角色权限
		  * @return
		  */
	  public List<Menu> findAllMenu(Map<String, String> map);
	
	/**
	   * 保存或更新分类信息-角色权限
	   * @param library
	   * @return
	   */
	   public int addOrUpdateMenu(Menu library) throws Exception;
	     
	   /**
	   * 删除分类-角色权限
	   * @param role_id
	   * @return
	   */
	   public int deleteMenu(@Param(value="roleId") String roleId,@Param(value="typeId") String typeId) throws Exception;
	   
	   /**
	    * 查询权限数量
	    * @param roleId
	    * @param typeId
	    * @return
	    */
	   public int countByRoleCode(String code);
}
