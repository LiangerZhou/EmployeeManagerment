package com.cmsz.dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cmsz.dao.TaskDao;
import com.cmsz.domain.Task;

public class TaskDaoImpl extends HibernateDaoSupport implements TaskDao{

	@SuppressWarnings("unchecked")
	@Override
	public int findAllCount(int currentPage) {
		String hql = "select count(*) from Task";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> findAll(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Task.class);
		List<Task> list = (List<Task>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> findAll() {
		String hql = "from Task";
		List<Task> list = (List<Task>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public void save(Task task) {
		this.getHibernateTemplate().save(task);
	}

	@Override
	public Task edit(Integer task_id) {
		return this.getHibernateTemplate().get(Task.class,task_id);
	}

	@Override
	public void delete(Task task) {
		this.getHibernateTemplate().delete(task);
	}

	@Override
	public void update(Task task) {
		this.getHibernateTemplate().update(task);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> findByProperties(String cpname) {
		int a;
		List<Task> list;
		if(cpname==null||"".equals(cpname)) {
			String hql = "from Task ";
			list = (List<Task>) this.getHibernateTemplate().find(hql);
		}else {
			String hql = "select t from Task t,Employee e, Company c where t.task_id = e.task and e.company = c.cid and c.cid = ? ";
			a = Integer.parseInt(cpname);
			list = (List<Task>) this.getHibernateTemplate().find(hql,a);
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findAllProperties(String cpname) {
		int a;
		List list;
		if(cpname==null||"".equals(cpname)) {
			String hql = "from Task t,Employee e, Company c where t.task_id = e.task and e.company = c.cid ";
			list = this.getHibernateTemplate().find(hql);
		}else {
			String hql = " from Task t,Employee e, Company c where t.task_id = e.task and e.company = c.cid and c.cid = ? ";
			a = Integer.parseInt(cpname);
			list =  this.getHibernateTemplate().find(hql,a);
		}
		return list;
	}

}
