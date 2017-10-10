/**
 * 
 */
package com.cmsz.dao;

import java.util.List;

import com.cmsz.domain.Task_Assessment;

/**
 * @author lenovo
 *
 */
public interface AssessmentDao {
	List<Task_Assessment> findByPage(int begin, int pageSize);

}
