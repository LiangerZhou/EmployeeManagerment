package com.cmsz.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cmsz.domain.Company;
import com.cmsz.domain.Employee;
import com.cmsz.domain.PageBean;
import com.cmsz.domain.Project;
import com.cmsz.service.CompanyService;
import com.cmsz.service.EmployeeService;
import com.cmsz.service.ProjectService;
import com.cmsz.util.PoiExcel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	private int currentPage=1;
	
	private String fileName;
	
	private String findname;
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFindname() {
		return findname;
	}
	public void setFindname(String findname) {
		this.findname = findname;
	}
	
	//模型驱动使用的对象
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	
	//注入业务层的类
	private EmployeeService employeeService;
	//spring注入部门管理的service
	private CompanyService companyService;
	//注入项目的service
	private ProjectService projectService;
	
	
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	//查找
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findAll(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String attend(){
		PageBean<Employee> pageBean = employeeService.findAll(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "attend";
	}
	
	public String saveUI(){
		//用于查询出所有的部门和项目信息
		List<Company> list1 = companyService.findAll();
		List<Project> list2 = projectService.findAll();
		ActionContext.getContext().getSession().put("list1", list1);
		ActionContext.getContext().getSession().put("list2", list2);
		return "saveUI";
	}
	//新增
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	//编辑
	public String edit(){
		employee = employeeService.edit(employee.getEid());
		List<Company> list1 = companyService.findAll();
		List<Project> list2 = projectService.findAll();
		ActionContext.getContext().getSession().put("list1", list1);
		ActionContext.getContext().getSession().put("list2", list2);
		return "editSuccess";
	}
	//根据姓名查找
	public String findByName() {
		List<Employee> list = employeeService.findByName(findname);
		ActionContext.getContext().getValueStack().set("list", list);
		return "findone";
	}
	//更新
	public String update(){
		System.out.println(employee);
		employeeService.update(employee);
		return "updateSuccess";
	}
	//删除
	public String delete() {
		System.out.println(employee);
		employeeService.delete(employee);
		return "deleteSuccess";
	}
	//导出excel考勤表
	public String exportExcel() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String workdays = request.getParameter("Alldays");//工作日列表，逗号分隔形式为yyyy/MM/dd
		String[] workArr = workdays.split(",");
		List<Employee> eList = employeeService.findByIds(request.getParameter("eids"));////选中的员工id列表，逗号分隔
		String path =request.getSession().getServletContext().getRealPath("/")+"Templet\\新合同外援考勤表-模板.xls";//获取存在项目中的模板的真实路径
		PoiExcel poiExcel = new PoiExcel();
		poiExcel.attendExcel(workArr, eList,path);
		return "exportSuccess";
	}

}
