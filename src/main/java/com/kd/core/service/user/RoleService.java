/**
 * 
 */
package com.kd.core.service.user;

import java.util.List;
import java.util.Map;

import com.kd.core.base.BaseService;
import com.kd.core.entity.Menu;
import com.kd.core.entity.Role;
import com.kd.core.entity.UserInfo;
import com.kd.core.entity.UserRoles;




/**
 * @author glt
 *
 */
public interface RoleService extends BaseService<Role> {
	/**
	 * 总数
	 * @return
	 */
	public int countRole() throws Exception;
	
	 /**
	  * 通过role_id查询所有分类信息-角色权限
	  * @return
	  */
public List<Menu> findAllMenu(String typeId,String role_id) throws Exception;

/**
 * 查询所有分类信息-角色权限
 * @return
 */
 public List<Menu> findAllMenuByRoleID(String role_id,String typeId) throws Exception;
 
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
  public int deleteMenu(String role_id,String typeId) throws Exception;
  
  /**
   * 删除角色
   * @param roleId
   * @return
   */
  public String deleteRole(String roleId) throws Exception;
  
}
