package com.kd.core.base;

import java.util.List;
import java.util.Map;


/**
 * @类名称:BaseServiceImpl.java
 * @类描述:BaseServiceImpl
 * @创建时间:2015年1月20日 上午9:23:17

 */
public class  BaseServiceImpl<T, E extends BaseDao<T>> implements BaseService<T> {
	protected E dao;
	
	@org.springframework.beans.factory.annotation.Autowired
	private com.github.abel533.entity.EntityMapper entityMapper;
	
	/**
	 * 用于spring注入
	 * 
	 * @param dao
	 */
	public void setDao(E dao) {
		this.dao = dao;
	}

	public void setEntityMapper(com.github.abel533.entity.EntityMapper entityMapper) {
		this.entityMapper = entityMapper;
	}



	/**
	 * 增加记录
	 * @param t
	 * @return
	 */
	public boolean insert(T t){
		int result = dao.insert(t);
		return result > 0 ? true : false;
	}

	/**
	 * 修改记录
	 * @param t
	 * @return
	 */
	public boolean update(T t){
		int result = dao.update(t);
		return result > 0 ? true : false;
	}

	/**
	 * 查询单条数据
	 * @param id
	 * @return
	 */
	public T getModel(String id){
		return dao.getModel(id);
	}

	/**
	 * 查询单条数据
	 * @param t
	 * @return
	 */	
	public T getModel(T t){
		return dao.getModel(t);
	}

	/**
	 * 批量删除
	 * @param map
	 * @return
	 */	
	public boolean batchDelete(Map<String, Object> map){
		int result = dao.batchDelete(map);
		return result > 0 ? true : false;
	}
	
	/**
	 * 批量删除
	 * @param list
	 * @return
	 */
	public boolean batchDelete(List list){
		int result = dao.batchDelete(list);
		return result > 0 ? true : false;
	}

	/**
	 * 批量删除
	 * @param map
	 * @return
	 */
	public boolean batchUpdate(Map<String, Object> map){
		int result = dao.batchUpdate(map);
		return result > 0 ? true : false;
	}
	
	/**
	 * 分页查询
	 * @param t
	 * @return
	 */
	public List<T> getPagedList(T t){
		return dao.getPagedList(t);
	}

	/**
	 * 无分页查询
	 * @param t
	 * @return
	 */
	public List<T> getModelList(T t){
		return dao.getModelList(t);
	}
	

	/**
	 * 无分页查询
	 * @param str
	 * @return
	 */
	public List<T> getModelList(String... str){

		return dao.getModelList(str);
	}

	/**
	 * 统计记录数
	 * @param t
	 * @return
	 */
	public int getCount(T t){
		return dao.getCount(t);
	}

	/**
	 * 删除单条数据
	 * @param id
	 * @return
	 */

	public boolean delete(String id) {

		int result = dao.delete(id);
		return result > 0 ? true : false;
	}
	
	/**
	 * 删除单条数据
	 * @param id
	 * @return
	 */

	public boolean delete(T t) {

		int result = dao.delete(t);
		return result > 0 ? true : false;
	}	
	

	/**
	 *
    * 插入数据库，主键字段没有值的时候不会出现在sql中
    * <br>如果是自增主键，会自动获取值
    * <br>如果是自增主键，并且该主键属性有值，会使用主键的属性值，不会使用自增
	 * 增加记录(通用mapper,不用写sql)
	 * @param t
	 * @return
	 */
	public boolean insertMapper(T t) {
		int result = entityMapper.insert(t);
		return result > 0 ? true : false;
	}

    /**
     * 插入非空字段，其他和上面方法类似
     *(通用mapper,不用写sql)
     * @param t
     * @return
     */
	public boolean insertSelective(T t) {
		int result = entityMapper.insertSelective(t);
		return result > 0 ? true : false;
	}

	/**
	 * 根据主键更新非空属性字段，不能给数据库数据设置null或空(通用mapper,不用写sql)
	 * @param t
	 * @return
	 */
	public boolean updateByPrimaryKeySelective(T t) {
		int result = entityMapper.updateByPrimaryKeySelective(t);
		return result > 0 ? true : false;
	}

    /**
     * 根据主键更新全部字段，空字段也会更新数据库(通用mapper,不用写sql)
     *
     * @param t
     * @return
     */
	public boolean updateByPrimaryKey(T t) {
		int result = entityMapper.updateByPrimaryKey(t);
		return result > 0 ? true : false;
	}

	/**
	 * 刪除记录(通用mapper,不用写sql)
	 * 
	 * @param t
	 * @return
	 */
	public boolean deleteMapper(T t) {
		int result = entityMapper.delete(t);
		return result > 0 ? true : false;
	}

	/**
	 * 分页查询(通用mapper,不用写sql)
	 * 
	 * @param t
	 * @return
	 */
	public List<T> getPagedSelect(T t) {
		return entityMapper.select(t);
	}

	/**
	 * 根据参数进行查询,record可以是Class<?>类型
     * <br>查询条件为属性String类型不为空，其他类型!=null时
     * <br>where property = ? and property2 = ? 条件
	 * 查询(通用mapper,不用写sql)
	 * 
	 * @param t
	 * @return
	 */	
	public List<T> select(T t) {
		return entityMapper.select(t);
	}

	/**
	 * 根据参数进行查询总数,t可以是Class<?>类型
     * <br>查询条件为属性String类型不为空，其他类型!=null时
     * <br>where property = ? and property2 = ? 条件
	 * 统计记录数(通用mapper,不用写sql)
	 * @param t
	 * @return
	 */
	public int getCountMapper(T t) {
		return entityMapper.count(t);
	}



}
