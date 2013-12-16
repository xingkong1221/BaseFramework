package com.dw.party.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Id;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;

import com.dw.party.dao.IBaseDao;
import com.dw.party.pagination.Pager;
/**
 * Implement generic interface IBaseDao<T, PK>
 * @author xingkong1221
 *
 * @param <T>
 * @param <PK>
 */
public class BaseDaoImpl<T extends Serializable, PK extends Serializable> implements IBaseDao<T, PK> {

	private final Class<T> entityClass;
	private String pkName;
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Field[] fields = this.entityClass.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(Id.class)) {
				this.pkName = f.getName();
			}
		}
	}
	
	@Override
	public void save(T pojo) {
		getSession().save(pojo);
	}

	@Override
	public void update(T pojo) {
		getSession().update(pojo);
	}

	@Override
	public void merge(T pojo) {
		getSession().merge(pojo);
	}

	@Override
	public void delete(T pojo) {
		getSession().delete(pojo);
	}

	@Override
	public void deleteById(PK id) {
		getSession().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(PK id) {
		return (T) getSession().get(this.entityClass, id);
	}

	@Override
	public Long countAll() {
		String hql = "select count(*) from " + this.entityClass.getSimpleName();
		return (Long) getSession().createQuery(hql).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {
		String hql = "from " + this.entityClass.getSimpleName() + " order by " + pkName + " desc";
		return (List<T>) getSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> loadByProperty(String key, Object value) {
		String hql = "from " + this.entityClass.getSimpleName() + " where " + key + " = ?";
		return (List<T>) getSession().createQuery(hql).setParameter(0, value).list();
	}

	@Override
	public boolean exists(PK id) {
		return get(id) != null;
	}

	@Override
	public boolean checkUnique(String field, String value) {
		return !loadByProperty(field, value).isEmpty();
	}

	@Override
	public void flush() {
		getSession().flush();
	}
	
	@Override
	public List<T> list(Pager pager, String[] paramName, Object[] paramValue) {
		if (pager == null) {
			pager = new Pager();
			pager.setPageth(1);
		}
		return list(pager.getStartIndex(), pager.getPageSize(), paramName, paramValue, pager.getSort(), pager.getDir());
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(final int startIndex, final int pageSize, final String[] paramName, final Object[] paramValue, final String sort, final String order) {
		String hql = "from " + this.entityClass.getSimpleName() + buildWhere(paramName)  + buildOrderBy(sort, order);
		Query query = getSession().createQuery(hql);
		setPageParameter(query, startIndex, pageSize);
		setParameters(query, paramValue);
		return (List<T>) query.list();
	}
	
	/**
	 * Get current session
	 * @return Session session
	 */
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	/**
	 * Set parameters
	 * @param query
	 * @param paramList
	 */
	protected void setParameters(Query query, Object[] paramList) {
		if (paramList != null && paramList.length > 0) {
			for (int i = 0; i < paramList.length; i++) {
				query.setParameter(i, paramList[i]);
			}
		}
	}
	
	/**
	 * Build where condition
	 * @param where
	 * @return
	 */
	protected String buildWhere(String[] paramName) {
		StringBuffer buffer = new StringBuffer("");
		if (paramName != null && paramName.length > 0) {
			buffer.append(" where ");
			for (String param : paramName) {
				buffer.append(param + " = ? and ");
			}
			buffer.delete(buffer.length()-5, buffer.length());
		}
		return buffer.toString();
	}
	
	/**
	 * Build order by condition
	 * @param sort
	 * @param order
	 * @return
	 */
	protected String buildOrderBy(String sort, String order) {
		StringBuffer buffer = new StringBuffer("");
		if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
			buffer.append(" order by ").append(sort).append(" ").append(order);
		}
		return buffer.toString();
	}
	
	/**
	 * Set page parameter
	 * @param query
	 * @param startIndex
	 * @param pageSize
	 */
	protected void setPageParameter(Query query, int startIndex, int pageSize) {
		if (startIndex >= 0 && pageSize >= 1 ) {
			query.setMaxResults(pageSize).setFirstResult(startIndex);
		}
	}

}
