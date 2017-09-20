package com.cmsz.dao;

import java.util.List;

import com.cmsz.domain.Project;

public interface ProjectDao {

	int findAllCount(int currentPage);

	List<Project> findAll(int begin, int pageSize);

	void save(Project project);

	Project edit(Integer proj_id);

	void delete(Project project);

	void update(Project project);

	List<Project> findAll();

}
