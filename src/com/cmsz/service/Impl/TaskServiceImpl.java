package com.cmsz.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cmsz.dao.TaskDao;
import com.cmsz.domain.PageBean;
import com.cmsz.domain.Task;
import com.cmsz.service.TaskService;

@Transactional(readOnly = false)
public class TaskServiceImpl implements TaskService{
	
	private TaskDao taskDao;


	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
	public PageBean<Task> findByPage(int currentPage) {
		PageBean<Task> pageBean = new PageBean<Task>();
		//每页显示的数量
		int pageSize = 5;
		//这个方法用于查找出所有的员工的数量
		int totalSize = taskDao.findAllCount(currentPage);
		int pageCount = (totalSize%pageSize)==0?(totalSize/pageSize):(totalSize/pageSize)+1;
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageCount(pageCount);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalSize(totalSize);
		int begin = (currentPage-1)*pageSize;
		//这个方法用于查找出指定页数中的List<Employee>
		List<Task> list = taskDao.findAll(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Task task) {
		taskDao.save(task);
	}

	@Override
	public Task edit(Integer task_id) {
		return taskDao.edit(task_id);
		
	}

	@Override
	public void delete(Task task) {
		taskDao.delete(task);
	}

	@Override
	public void update(Task task) {
		taskDao.update(task);		
	}

	@Override
	public List<Task> findAll() {
		return taskDao.findAll();
	}

	@Override
	public List<Task> findByProperties(String cpname) {
		// TODO Auto-generated method stub
		return taskDao.findByProperties(cpname);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findAllProperties(String cpname) {
		// TODO Auto-generated method stub
		return taskDao.findAllProperties(cpname);
	}


}
