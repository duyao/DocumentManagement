package com.dy.basic.dao;

import java.util.List;

import com.dy.model.Pager;

public interface IBaseDao<T> {
	public void add(T t);
	public void update(T t);
	public void delte(int id);
	public T load(int id);
	
	//获取一组对象，不分页
	public List<T> list(String hql, Object[] args);
	public List<T> list(String hql, Object arg);
	public List<T> list(String hql);
	
	//获取一组对对象，分页
	public Pager<T> find(String hql, Object[] args);
	public Pager<T> find(String hql, Object arg);
	public Pager<T> find(String hql);
	
	public List<Object> listByObj(String hql, Object[] args);
	public List<Object> listByObj(String hql, Object arg);
	public List<Object> listByObj(String hql);
	
	public Pager<Object> findByObj(String hql, Object[] args);
	public Pager<Object> findByObj(String hql, Object arg);
	public Pager<Object> findByObj(String hql);
	
	
	//获取一个对象
	public Object queryByHql(String hql, Object[] args);
	public Object queryByHql(String hql, Object arg);
	public Object queryByHql(String hql);
	
	//更新
	public void excuteByHql(String hql, Object[] args);
	public void excuteByHql(String hql, Object arg);
	public void excuteByHql(String hql);
}
