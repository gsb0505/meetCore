package com.kd.core.service.impl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.user.RoleDao;
import com.kd.core.dao.user.UserDao;
import com.kd.core.entity.Menu;
import com.kd.core.entity.Role;
import com.kd.core.entity.UserInfo;
import com.kd.core.entity.UserRoles;
import com.kd.core.service.user.RoleService;
import com.kd.core.service.user.UserService;


/**
 * @author glt service 实现
 */

public  class RoleServiceImpl extends BaseServiceImpl<Role,RoleDao> implements  RoleService {
	




	
	public int countRole() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	
	/**
	  * 通过role_id查询所有分类信息
	  * @return
	  */
	  public List<Menu> findAllMenuByRoleID(String roleId,String typeId){
		  Map<String, String> map = new HashMap<String,String>();
		  map.put("roleId", roleId);
		  map.put("typeId", typeId);
	    List<Menu> listLibrary  = dao.findAllMenuByRoleID(map);
	    return listLibrary;
	  }
	  
	  /**
		  * 查询所有分类信息-角色权限
		  * @return
		  */
	public List<Menu> findAllMenu(String typeId,String roleId) throws Exception{
		Map<String, String> map = new HashMap<String,String>();
		  map.put("roleId", roleId);
		  map.put("typeId", typeId);
		 List<Menu> listLibrary  = dao.findAllMenu(map);
		 return listLibrary;
	}
	/**
	  * 保存或更新分类信息-角色权限
	  * @param library
	  * @return
	  */
	  public int addOrUpdateMenu(Menu library) throws Exception{
	    return dao.addOrUpdateMenu(library);
	  }
	    
	  /**
	  * 删除分类-角色权限
	  * @param id
	  * @return
	  */
	  public int deleteMenu(String role_id,String typeId) throws Exception{
		  return dao.deleteMenu(role_id,typeId);
	  }

	  @Transient
	  public String deleteRole(String roleId) throws Exception{
		  Role ro = new Role();
		  ro.setId(roleId);
		  Role role = dao.getModel(ro);
		  int count = dao.countByRoleCode(role.getRoleCode());
		  if(count > 0)
			  return "exsit";
		  dao.deleteMenu(roleId, "0");
		  
		  return dao.delete(roleId)>0?"true":"false";
	  }


}
