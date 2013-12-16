package com.dw.party.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dw.party.dao.IBaseDao;
import com.dw.party.pagination.Pager;
import com.dw.party.service.IBaseService;

/**
 * Implement generic interface IBaseService<T, PK>
 * 
 * @author xingkong1221
 *
 * @param <T>
 * @param <PK>
 */
public abstract class BaseServiceImpl<T extends Serializable, PK extends Serializable> implements IBaseService<T, PK> {
	
	protected IBaseDao<T, PK> baseDao;
	
	public abstract void setBaseDao(IBaseDao<T, PK> baseDao);
	
	@Override
	public void save(T pojo) {
		this.baseDao.save(pojo);
	}

	@Override
	public void update(T pojo) {
		this.baseDao.update(pojo);
	}

	@Override
	public void delete(T pojo) {
		this.baseDao.delete(pojo);
	}

	@Override
	public void deleteById(PK id) {
		this.baseDao.deleteById(id);
	}

	@Override
	public Long countAll() {
		return this.baseDao.countAll();
	}

	@Override
	public T get(PK id) {
		return this.baseDao.get(id);
	}

	@Override
	public List<T> listAll() {
		return this.baseDao.listAll();
	}

	@Override
	public List<T> loadByProperty(String key, Object value) {
		return this.baseDao.loadByProperty(key, value);
	}

	@Override
	public List<T> list(Pager pager, String[] paramName, Object[] paramValue) {
		return this.baseDao.list(pager, paramName, paramValue);
	}

	@Override
	public List<T> list(Pager pager, String paramName, Object paramValue) {
		return this.baseDao.list(pager, new String[] {paramName}, new Object[] {paramValue});
	}

	@Override
	public boolean exists(PK id) {
		return this.baseDao.exists(id);
	}

	@Override
	public boolean checkUnique(String field, String value) {
		return this.baseDao.checkUnique(field, value);
	}

	@Override
	public void flush() {
		this.baseDao.flush();
	}

}
