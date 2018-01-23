package com.cmsz.service;

import java.util.List;

import com.cmsz.domain.Employee;
import com.cmsz.domain.PageBean;

//员工管理的实现类接口
public interface EmployeeService{

	PageBean<Employee> findAll(int currentPage);

	void save(Employee employee);

	Employee edit(Integer eid);

	void update(Employee em);

	void delete(Employee employee);

//	InputStream exportExcel();

	List<Employee> findAll();

	List<Employee> findByName(String findname);
	
	List<Employee> findByIds(String eids);
	
}
