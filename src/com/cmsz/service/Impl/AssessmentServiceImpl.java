package com.cmsz.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cmsz.dao.AssessmentDao;
import com.cmsz.domain.PageBean;
import com.cmsz.domain.Task_Assessment;
import com.cmsz.service.AssessmentService;

@Transactional(readOnly = false)
public class AssessmentServiceImpl implements AssessmentService{

	private AssessmentDao AssessmentDao = new AssessmentDao() {
		
		@Override
		public List<Task_Assessment> findByPage(int begin, int pageSize) {
			// TODO Auto-generated method stub
			return null;
		}
	};

	public AssessmentDao getAssessmentDao() {
		return AssessmentDao;
	}

	public void setAssessmentDao(AssessmentDao assessmentDao) {
		this.AssessmentDao = assessmentDao;
	}



	@Override
	public PageBean<Task_Assessment> findByPage(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

}
