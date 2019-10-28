/**
*
 * @package:com.kd.core.service.intercore
 * @projectName:cloud-core
 * @CreateTime:2015年1月20日-下午1:35:06
 *  2015杭州宽达信息技术有限公司-版权所有
 *
 */
package com.kd.core.service.intercore;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kd.core.base.BaseService;
import com.kd.core.entity.InterfaceAccountInfo;
/**
 * 接口 接口定义类
 * @Class:InterfaceService
 * @Autor:glt
 * @CreateTime:2015年1月20日 下午1:35:06
 * @version 1.0.0
 *
 */
public interface InterfaceAccountService extends BaseService<InterfaceAccountInfo>{
	
	
	/**
	 * 
	 * addInterfaceAccount(接口新增)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param interfaceInfo
	 * @return
	 *int
	 * @exception
	 * @since  1.0.0
	 */
	public boolean addInterfaceAccount(InterfaceAccountInfo interfaceAccountInfo) throws Exception ;
	/**
	 * 
	 * updateInterfaceAccount(接口修改)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param interfaceInfo
	 * @return
	 *int
	 * @exception
	 * @since  1.0.0
	 */
	public boolean updateInterfaceAccount(InterfaceAccountInfo interfaceAccountInfo) throws Exception ;
	/**
	 * 
	 *@描述  ：上游接口账户充值（带接口日志写入的）
	
	 *@创建时间：2015年4月1日 下午5:05:54
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param interfaceAccountInfo
	 *@return
	 */
	public String updateAccountCash(InterfaceAccountInfo interfaceAccountInfo);
	/**
	 * 
	 * queryAllInterface(接口列表)
	 * (这里描述这个方法适用条件 – 可选)
	 * @return
	 *List<InterfaceInfo>
	 * @exception
	 * @since  1.0.0
	 */
	public List<InterfaceAccountInfo> queryAllInterfaceAccount() throws Exception ;
	/**
	 * 
	 * queryInterfaceAccountByName(根据name查询接口列表)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param id
	 * @return
	 *List<InterfaceInfo>
	 * @exception
	 * @since  1.0.0
	 */
	public List<InterfaceAccountInfo> queryInterfaceAccountByName(@Param("account_name") String account_name) throws Exception ;
	
	/**
	 * 
	 * deleteInterfaceAccount(删除接口)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param id
	 * @return
	 *int
	 * @exception
	 * @since  1.0.0
	 */
	public boolean deleteInterfaceAccount(@Param("id") long id) throws Exception ;
	
	/**
	 * 
	 * queryInterfaceAccountById(通过id查询)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param id
	 * @return
	 * @throws Exception
	 * InterfaceAccountInfo
	 * @exception
	 * @since  1.0.0
	 */
	public InterfaceAccountInfo queryInterfaceAccountById(@Param("id") long id) throws Exception ;

	/**
	 * 
	 *@描述  ：根据接口id查询接口账户的数量
	
	 *@创建时间：2015年4月2日 下午1:35:53
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 *@param id
	 *@return
	 */
	
	
	public String getAccountCountByinterfaceId(String id);
	
	
	public List<InterfaceAccountInfo> searchInfo();
	
	/**
	 * 根据接口账户名称查询接口账户数量
	 * @param accountName 账户名称
	 * @return 数量
	 */
	public Integer findInterfaceByName(String accountName);
	
	
	
	
	
	

}
