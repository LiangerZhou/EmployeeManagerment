package com.cmsz.action;

import com.cmsz.domain.Task_Assessment;
import com.cmsz.service.AssessmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class AssessmentAction extends ActionSupport implements ModelDriven<Task_Assessment>{

	private Task_Assessment Task_Assessment = new Task_Assessment();
	
	public void setAssessmentService(AssessmentService assessmentService) {
	}
	@Override
	public Task_Assessment getModel() {
		return Task_Assessment;
	}
	//实现多条件查询
	public String find() {
		return null;
		
	}
	
	
	
	//实现条目添加
	public String add() {
		return null;
		
	}
	
	//实现条目删除
	public String del() {
		return null;
		
	}
	
	//实现条目更改
	public String edit() {
		return null;
	}
	
	//实现考核表导出（分两种情况，如果选择公司名，则按公司分别导出，如果选择全部，则按月度汇总表导出）
	public String export() {
		return null;
	}
}
