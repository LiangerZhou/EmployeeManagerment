package com.cmsz.dao;

import java.util.List;

import com.cmsz.domain.Task;

public interface TaskDao {

	int findAllCount(int currentPage);

	List<Task> findAll(int begin, int pageSize);

	void save(Task task);

	Task edit(Integer task_id);

	void delete(Task task);

	void update(Task task);

	List<Task> findAll();

}
