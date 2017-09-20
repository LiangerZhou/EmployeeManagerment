package com.cmsz.service;

import java.util.List;

import com.cmsz.domain.PageBean;
import com.cmsz.domain.Project;

public interface ProjectService {

	PageBean<Project> findByPage(int currentPage);
	
	List<Project> findAll();

	void save(Project project);

	Project edit(Integer proj_id);

	void delete(Project project);

	void update(Project project);


}
