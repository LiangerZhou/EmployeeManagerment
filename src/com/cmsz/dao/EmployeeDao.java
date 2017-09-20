package com.cmsz.dao;
//员工管理的DAO接口

import java.util.List;

import com.cmsz.domain.Employee;

public interface EmployeeDao {
	
	int findAllCount(int page);

	List<Employee> findAll(int begin, int pageSize);
	
	List<Employee> findAll();

	Employee findUserExist(Employee employee);

	void save(Employee employee);

	Employee edit(Integer eid);

	void update(Employee em);

	void delete(Employee employee);

	List<Employee> findByName(String findname);
	
	List<Employee> findByIds(String eids);//获取前台得到的选中的id，处理成字符串以逗号分隔
	
}
