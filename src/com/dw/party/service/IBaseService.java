package com.dw.party.service;

import java.io.Serializable;
import java.util.List;

import com.dw.party.pagination.Pager;

/**
 * Generic interface of SERVICE, defines the basic method
 * 
 * @author xingkong1221
 *
 * @param <T>
 * @param <PK>
 */
public interface IBaseService<T extends Serializable, PK extends Serializable> {
	
	/**
	 * Save pojo
	 * @param pojo
	 */
	public void save(T pojo);
	
	/**
	 * Update pojo
	 * @param pojo
	 */
	public void update(T pojo);
	
	/**
	 * Delete pojo
	 * @param pojo
	 */
	public void delete(T pojo);
	
	/**
	 * Delete record by id
	 * @param id
	 */
	public void deleteById(PK id);
	
	/**
	 * Count all records
	 * @return
	 */
	public Long countAll();
	
	/**
	 * Get pojo by id
	 * @param id
	 * @return
	 */
	public T get(PK id);

	/**
	 * Get all records
	 * @return
	 */
	public List<T> listAll();
	
	/**
	 * Get pojo by property
	 * @param key
	 * @param value
	 * @return
	 */
	public List<T> loadByProperty(String key, Object value);
	
	/**
	 * Get pojo list by pager and attribute array
	 * @param pager
	 * @param paramName
	 * @param paramValue
	 * @return
	 */
	public List<T> list(Pager pager, String[] paramName, Object[] paramValue);
	
	/**
	 * Get pojo list by pager and attribute 
	 * @param pager
	 * @param paramName
	 * @param paramValue
	 * @return
	 */
	public List<T> list(Pager pager, String paramName, Object paramValue);
	
	/**
	 * Cheack the record exists
	 * @param id
	 * @return
	 */
	public boolean exists(PK id);
	
	/**
	 * Check the field value is unique
	 * @param field
	 * @param value
	 * @return
	 */
	public boolean checkUnique(String field, String value);
	
	/**
	 * Flush session
	 */
	public void flush();
}
