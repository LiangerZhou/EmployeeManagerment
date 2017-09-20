package com.cmsz.dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cmsz.dao.ProjectDao;
import com.cmsz.domain.Project;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao{

	@SuppressWarnings("unchecked")
	@Override
	public int findAllCount(int currentPage) {
		String hql = "select count(*) from Project";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findAll(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		List<Project> list = (List<Project>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Project> findAll() {
		String hql = "from Project";
		List<Project> list = (List<Project>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public void save(Project project) {
		this.getHibernateTemplate().save(project);
	}

	@Override
	public Project edit(Integer proj_id) {
		return this.getHibernateTemplate().get(Project.class,proj_id);
	}

	@Override
	public void delete(Project project) {
		this.getHibernateTemplate().delete(project);
	}

	@Override
	public void update(Project project) {
		this.getHibernateTemplate().update(project);
	}

}
