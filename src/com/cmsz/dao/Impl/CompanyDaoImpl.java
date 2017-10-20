package com.cmsz.dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cmsz.dao.CompanyDao;
import com.cmsz.domain.Company;

public class CompanyDaoImpl extends HibernateDaoSupport implements CompanyDao {

	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		String hql = "select count(*) from Company";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}else{
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findByPage(int begin, int pageSize) {
		//通过分离标准方法得到数据
		DetachedCriteria criteria = DetachedCriteria.forClass(Company.class);
		List<Company> list = (List<Company>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAll() {
		String hql = "from Company";
		List<Company> list = (List<Company>) this.getHibernateTemplate().find(hql);
		return list;
	}
	@Override
	public void save(Company company) {
		this.getHibernateTemplate().save(company);
	}
	@Override
	public Company editById(Integer cid) {
		return this.getHibernateTemplate().get(Company.class,cid);
	}
	@Override
	public void update(Company company) {
		this.getHibernateTemplate().update(company);
	}
	@Override
	public void delete(Company company) {
		this.getHibernateTemplate().delete(company);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findByName(String cpname) {
		String hql = "from Company where cname= ?";
		List<Company> list = (List<Company>) this.getHibernateTemplate().find(hql,cpname);
		return list;
	}

}
