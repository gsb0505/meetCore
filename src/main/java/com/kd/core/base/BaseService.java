package com.kd.core.base;

import java.util.List;
import java.util.Map;

/**
 * @类名称:BaseService.java
 * @类描述:BaseService
 * @创建时间:2015年1月20日 上午9:23:17

 */
public interface BaseService<T> {
	
	/**
	 * 增加记录
	 * @param t
	 * @return
	 */
	public boolean insert(T t);
	
	/**
	 * 刪除记录
	 * 
	 * @param id
	 * @return
	 */

	public boolean delete(String id);
	
	/**
	 * 刪除记录
	 * 
	 * @param id
	 * @return
	 */

	public boolean delete(T t);	
	
	/**
	 * 修改记录
	 * @param t
	 * @return
	 */
	public boolean update(T t);
	
	/**
	 * 查询单条数据
	 * @param id
	 * @return
	 */
	public T getModel(String id);
	
	/**
	 * 查询单条数据
	 * @param t
	 * @return
	 */
	public T getModel(T t);
	
	/**
	 * 批量删除
	 * @param map
	 * @return
	 */
	public boolean batchDelete(Map<String,Object> map);
	
	
	
	/**
	 * 批量删除
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean batchDelete(List list);
	
	/**
	 * 批量修改
	 * @param map
	 * @return
	 */
	public boolean batchUpdate(Map<String,Object> map);
	
	
	/**
	 * 分页查询
	 * @param t
	 * @return
	 */
	public List<T> getPagedList(T t);
	
	
	/**
	 * 无分页查询
	 * @param t
	 * @return
	 */
	public List<T> getModelList(T t);
	
	
	/**
	 * 无分页查询<br>
	 * <p>
	 * MyBatis中对重载方法支持缺陷：XML中使用该方法映射无<br>
	 * 参和一个string参数会无法映射，建议XML中仅映射此方法一次，<br>
	 * 若有其它类似业务在自己接口中定义其它方法。<br>
	 * </p>
	 * @param str
	 * @return
	 */
	public List<T> getModelList(String... str);
	
	/**
	 * 统计记录数
	 * @param t
	 * @return
	 */
	public int getCount(T t);
	
	/**
	 *
     * 插入数据库，主键字段没有值的时候不会出现在sql中
     * <br>如果是自增主键，会自动获取值
     * <br>如果是自增主键，并且该主键属性有值，会使用主键的属性值，不会使用自增
	 * 增加记录(通用mapper,不用写sql)
	 * @param t
	 * @return
	 */
	public boolean insertMapper(T t);
	
    /**
     * 插入非空字段，其他和上面方法类似
     *(通用mapper,不用写sql)
     * @param t
     * @return
     */
    public boolean insertSelective(T t);
	
	/**
	 * 根据主键更新非空属性字段，不能给数据库数据设置null或空(通用mapper,不用写sql)
	 * @param t
	 * @return
	 */
	public boolean updateByPrimaryKeySelective(T t);	
	
    /**
     * 根据主键更新全部字段，空字段也会更新数据库(通用mapper,不用写sql)
     *
     * @param t
     * @return
     */
	public boolean updateByPrimaryKey(T t);
	
	/**
	 * 刪除记录(通用mapper,不用写sql)
	 * 
	 * @param t
	 * @return
	 */

	public boolean deleteMapper(T t);
	
	/**
	 * 分页查询(通用mapper,不用写sql)
	 * 
	 * @param t
	 * @return
	 */
	public List<T> getPagedSelect(T t);
	
	/**
	 * 根据参数进行查询,record可以是Class<?>类型
     * <br>查询条件为属性String类型不为空，其他类型!=null时
     * <br>where property = ? and property2 = ? 条件
	 * 查询(通用mapper,不用写sql)
	 * 
	 * @param t
	 * @return
	 */	
	public List<T> select(T t);
	
	/**
	 * 根据参数进行查询总数,t可以是Class<?>类型
     * <br>查询条件为属性String类型不为空，其他类型!=null时
     * <br>where property = ? and property2 = ? 条件
	 * 统计记录数(通用mapper,不用写sql)
	 * @param t
	 * @return
	 */
	public int getCountMapper(T t);
	

}
