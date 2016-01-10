package com.dy.basic.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.dy.model.Pager;
import com.dy.model.SystemContext;

@SuppressWarnings("unchecked")
public class BaseDao<T> implements IBaseDao<T> {
	private SessionFactory sessionFactory;
	private Class<T> clz;

	@Inject
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<T> getClz() {
		if (clz == null) {
			// 获取泛型的Class对象
			clz = ((Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass()))
					.getActualTypeArguments()[0]));
		}
		return clz;
	}

	public void add(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public void delte(int id) {
		sessionFactory.getCurrentSession().delete(this.load(id));
	}

	public T load(int id) {
		return (T) sessionFactory.getCurrentSession().load(getClz(), id);
	}

	private void setParameter(Query query, Object[] args) {
		if (args != null && args.length > 0) {
			int index = 0;
			for (Object arg : args) {
				query.setParameter(index++, arg);
			}
		}
	}

	public List<T> list(String hql, Object[] args) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		setParameter(query, args);
		return query.list();
	}

	public List<T> list(String hql, Object arg) {
		return list(hql, new Object[] { arg });
	}

	public List<T> list(String hql) {
		return list(hql, null);
	}
	
	@SuppressWarnings("rawtypes")
	private void setPagers(Query query,  Pager pages) {
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if (pageOffset == null || pageOffset < 0)
			pageOffset = 0;
		if (pageSize == null || pageSize < 0)
			pageSize = 15;
		pages.setPageOffset(pageOffset);
		pages.setPageSize(pageSize);
		query.setFirstResult(pageOffset).setMaxResults(pageSize);
	}

	private String getCountHql(String hql) {
		String e = hql.substring(hql.indexOf("from"));
		String c = "select count(*) " + e;
		c.replaceAll("fetch", "");
		return c;
	}

	public Pager<T> find(String hql, Object[] args) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		String chql = getCountHql(hql);
		Query cQuery = sessionFactory.getCurrentSession().createQuery(chql);
		setParameter(query, args);
		setParameter(cQuery, args);
		
		Pager<T> pages = new Pager<T>();
		setPagers(query, pages);
		pages.setData(query.list());
		pages.setPageTatal((Long) cQuery.uniqueResult());
		return pages;
	}

	public Pager<T> find(String hql, Object arg) {
		return find(hql, new Object[]{arg});
	}

	public Pager<T> find(String hql) {
		return find(hql, null);
	}

	public Object queryByHql(String hql, Object[] args) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		setParameter(query, args);
		return query.uniqueResult();
	}

	public Object queryByHql(String hql, Object arg) {
		return queryByHql(hql, new Object[]{arg});
	}

	public Object queryByHql(String hql) {
		return queryByHql(hql, null);
	}

	public void excuteByHql(String hql, Object[] args) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		setParameter(query, args);
		query.executeUpdate();
	}

	public void excuteByHql(String hql, Object arg) {
		this.queryByHql(hql, new Object[]{arg});
	}

	public void excuteByHql(String hql) {
		this.queryByHql(hql, null);
	}

	public List<Object> listByObj(String hql, Object[] args) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		setParameter(query, args);
		return query.list();
	}

	public List<Object> listByObj(String hql, Object arg) {
		return listByObj(hql, new Object[]{arg});
	}

	public List<Object> listByObj(String hql) {
		return listByObj(hql, null);
	}

	public Pager<Object> findByObj(String hql, Object[] args) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		String chql = getCountHql(hql);
		Query cQuery = sessionFactory.getCurrentSession().createQuery(chql);
		setParameter(query, args);
		setParameter(cQuery, args);
		
		Pager<Object> pages = new Pager<Object>();
		setPagers(query, pages);
		pages.setData(query.list());
		pages.setPageTatal((Long) cQuery.uniqueResult());
		return pages;
	}

	public Pager<Object> findByObj(String hql, Object arg) {
		return findByObj(hql, new Object[]{arg});
	}

	public Pager<Object> findByObj(String hql) {
		return findByObj(hql, null);
	}

}
