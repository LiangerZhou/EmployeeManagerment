package com.cmsz.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cmsz.dao.EmployeeDao;
import com.cmsz.domain.Employee;

//员工管理的DAO实现类
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public int findAllCount(int currentPage) {
		String hql = "select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee findUserExist(Employee employee) {
		String hql = " from Employee where username = ?";
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql,employee.getEname());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}
	@Override
	public Employee edit(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}
	@Override
	public void update(Employee em) {
		this.getHibernateTemplate().update(em);
	}

	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		String hql = "from Employee";
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByName(String findname) {
		List<Employee> list;
		if(findname==null||"".equals(findname)) {
			String hql = "from Employee";
			list = (List<Employee>) this.getHibernateTemplate().find(hql);
		}else {
			String hql = " from Employee where ename = ?";
			list = (List<Employee>) this.getHibernateTemplate().find(hql,findname);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByIds(String eids) {
		List<Employee> list = new ArrayList<Employee>();
		if(eids==null||"".equals(eids)) {
			return null;
		}else {
			String[] eidsArr = eids.split(",");
			int[] eidArray = new int[eidsArr.length];
			for(int i = 0;i<eidsArr.length;i++) {
				eidArray[i] = Integer.parseInt(eidsArr[i]);
			String hql = " from Employee where eid = ?";//此处可写成where eid in 数组或list，可考虑传入的eids是个list，比较懒，待优化
			list.addAll((List<Employee>) this.getHibernateTemplate().find(hql,eidArray[i]));
			}
		}
		return list;
	}

}
