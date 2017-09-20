package com.cmsz.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cmsz.dao.ProjectDao;
import com.cmsz.domain.PageBean;
import com.cmsz.domain.Project;
import com.cmsz.service.ProjectService;

@Transactional(readOnly = false)
public class ProjectServiceImpl implements ProjectService{
	
	private ProjectDao projectDao;

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public PageBean<Project> findByPage(int currentPage) {
		PageBean<Project> pageBean = new PageBean<Project>();
		//每页显示的数量
		int pageSize = 5;
		//这个方法用于查找出所有的员工的数量
		int totalSize = projectDao.findAllCount(currentPage);
		int pageCount = (totalSize%pageSize)==0?(totalSize/pageSize):(totalSize/pageSize)+1;
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageCount(pageCount);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalSize(totalSize);
		int begin = (currentPage-1)*pageSize;
		//这个方法用于查找出指定页数中的List<Employee>
		List<Project> list = projectDao.findAll(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void save(Project project) {
		projectDao.save(project);
	}

	@Override
	public Project edit(Integer proj_id) {
		return projectDao.edit(proj_id);
		
	}

	@Override
	public void delete(Project project) {
		projectDao.delete(project);
	}

	@Override
	public void update(Project project) {
		projectDao.update(project);		
	}

	@Override
	public List<Project> findAll() {
		return projectDao.findAll();
	}


}
