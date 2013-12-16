package com.dw.party.dao;

import java.io.Serializable;
import java.util.List;

import com.dw.party.pagination.Pager;

/**
 * Generic interface of DAO, defines the basic method
 * 
 * @author xingkong1221
 *
 * @param <T>	Entity(Pojo)
 * @param <PK>	Primay Key(Id)
 */
public interface IBaseDao<T extends Serializable, PK extends Serializable> {
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
	 * Merge pojo
	 * @param pojo
	 */
	public void merge(T pojo);
	
	/**
	 * Delete pojo
	 * @param pojo
	 */
	public void delete(T pojo);
	
	/**
	 * Delete pojo by id
	 * @param id
	 */
	public void deleteById(PK id);
	
	/**
	 * Get pojo by id
	 * @param id
	 * @return T
	 */
	public T get(PK id);
	
	/**
	 * Count number of all the records
	 * @return Integer
	 */
	public Long countAll();
	
	/**
	 * Return all records
	 * @return List<T>
	 */
	public List<T> listAll();
	
	/**
	 * Get pojo list by property
	 * @param key 
	 * @param value
	 * @return
	 */
	public List<T> loadByProperty(String key, Object value);
	
	/**
	 * Get pojo by pager and attribute
	 * @param pager
	 * @param paramName
	 * @param paramValue
	 * @return
	 */
	public List<T> list(Pager pager, String[] paramName, Object[] paramValue);
	
	/**
	 * Check record exists
	 * @param id
	 * @return
	 */
	public boolean exists(PK id);
	
	/**
	 * Check the field uniqueness
	 * @param field Field in the pojo
	 * @param value Field value
	 * @return 
	 */
	public boolean checkUnique(String field, String value);
	
	/**
	 * Flush Session
	 */
	public void flush();
}
