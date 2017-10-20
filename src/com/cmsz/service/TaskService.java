package com.cmsz.service;

import java.util.List;

import com.cmsz.domain.PageBean;
import com.cmsz.domain.Task;

public interface TaskService {

	PageBean<Task> findByPage(int currentPage);
	
	List<Task> findAll();

	void save(Task task);

	Task edit(Integer task_id);

	void delete(Task task);

	void update(Task task);

	List<Task> findByProperties(String cpname);

	List<Task> findAllProperties(String cpname);


}
