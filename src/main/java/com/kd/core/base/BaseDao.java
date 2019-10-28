package com.kd.core.base;

import java.util.List;
import java.util.Map;

/**
 * @类名称:BaseDao.java
 * @类描述:BaseDao
 * @创建时间:2015年1月20日 上午9:30:37

 */
public interface BaseDao<T> {

	/**
	 * 增加记录
	 * 
	 * @param t
	 * @return
	 */
	public int insert(T t);

	/**
	 * 修改记录
	 * 
	 * @param t
	 * @return
	 */
	public int update(T t);
	
	
	/**
	 * 刪除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(String id);
	
	/**
	 * 刪除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(T t);	

	/**
	 * 查询单条数据
	 * 
	 * @param id
	 * @return
	 */
	public T getModel(String id);

	/**
	 * 查询单条数据
	 * 
	 * @param t
	 * @return
	 */
	public T getModel(T t);

	/**
	 * 批量删除
	 * 
	 * @param map
	 * @return
	 */
	public int batchDelete(Map<String, Object> map);

	/**
	 * 批量删除
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int batchDelete(List list);

	/**
	 * 批量修改
	 * 
	 * @param map
	 * @return
	 */
	public int batchUpdate(Map<String, Object> map);

	/**
	 * 分页查询
	 * 
	 * @param t
	 * @return
	 */
	public List<T> getPagedList(T t);

	/**
	 * 无分页查询
	 * 
	 * @param t
	 * @return
	 */
	public List<T> getModelList(T t);

	/**
	 * 无分页查询
	 * 
	 * @param str
	 * @return
	 */
	public List<T> getModelList(String... str);

	/**
	 * 统计记录数
	 * 
	 * @param t
	 * @return
	 */
	public int getCount(T t);  

}
