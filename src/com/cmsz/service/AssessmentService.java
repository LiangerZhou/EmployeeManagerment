/**
 * 
 */
package com.cmsz.service;

import com.cmsz.domain.PageBean;
import com.cmsz.domain.Task_Assessment;

/**
 * @author lenovo
 *
 */
public interface AssessmentService {
	PageBean<Task_Assessment> findByPage(int currentPage);

}
