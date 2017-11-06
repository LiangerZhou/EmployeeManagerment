package com.cmsz.service;

import java.io.InputStream;
import java.util.List;

import com.cmsz.domain.Company;
import com.cmsz.domain.PageBean;

//部门管理的业务层接口
public interface CompanyService {

	PageBean<Company> findByPage(int currentPage);

	void save(Company department);

	Company editById(Integer cid);

	void update(Company company);

	void delete(Company company);

	List<Company> findAll();

	InputStream exportExcel();

	List<Company> findByName(String cpname);

	List<Object[]> findTaskEmp();

}
