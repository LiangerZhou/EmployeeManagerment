package com.cmsz.action;

import java.util.List;

import com.cmsz.domain.Company;
import com.cmsz.domain.PageBean;
import com.cmsz.domain.Project;
import com.cmsz.service.CompanyService;
import com.cmsz.service.ProjectService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ProjectAction extends ActionSupport implements ModelDriven<Project>{
	
	private int currentPage=1;

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	private Project project = new Project();
	
	@Override
	public Project getModel() {
		return project;
	}
	
	private ProjectService projectService;
	private CompanyService companyService;
	
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public String findAll(){
		PageBean<Project> pageBean = projectService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//通过action返回跳转的jsp
	public String saveUI(){
		List<Company> list = companyService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "saveUI";
	}
	
	public String addProj() {
		projectService.save(project);
		return "addSuccess";
	}
	
	public String editProj() {
		project = projectService.edit(project.getProj_id());
		List<Company> list = companyService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "editSuccess";
	}
	
	public String updateProj() {
		System.out.println(project.getProj_name().toString());
		projectService.update(project);
		return "updateSuccess";
	}
	
	public String delProj() {
		projectService.delete(project);
		return "delSuccess";
	}
}
