package com.cmsz.dao;

import java.util.List;

import com.cmsz.domain.Company;

public interface CompanyDao {

	int findCount();

	List<Company> findByPage(int begin, int pageSize);

	List<Company> findAll();
	
	void save(Company company);
	
	Company editById(Integer did);
	
	void update(Company company);
	
	void delete(Company company);

	List<Company> findByName(String cpname);

}
