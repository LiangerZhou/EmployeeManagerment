package com.cmsz.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cmsz.domain.Company;
import com.cmsz.domain.Employee;
import com.cmsz.domain.PageBean;
import com.cmsz.domain.Task;
import com.cmsz.service.CompanyService;
import com.cmsz.service.EmployeeService;
import com.cmsz.service.TaskService;
import com.cmsz.util.PoiExcel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class TaskAction extends ActionSupport implements ModelDriven<Task>{
	
	private int currentPage=1;

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	private Task task = new Task();
	
	@Override
	public Task getModel() {
		return task;
	}
	
	private TaskService taskService;
	
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}	
	
	public CompanyService companyService;
	


	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public String findAll(){
		PageBean<Task> pageBean = taskService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String assessment() {
		PageBean<Task> pageBean = taskService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		List<Company> clist = companyService.findAll();
		ActionContext.getContext().getSession().put("clist", clist);
		return "assessment";
	}

	private List<Task> list;
	
	public List<Task> getList() {
		return list;
	}

	public void setList(List<Task> list) {
		this.list = list;
	}

	public String findByCpname() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cpname = request.getParameter("cpname");
		list = taskService.findByProperties(cpname);
		System.out.println(list.size());
		
		 //将list转化成JSON对象  
/*        JSONArray jsonArray = JSONArray.fromObject(list);  
        HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);  
        response.setCharacterEncoding("UTF-8");   
        try {
			response.getWriter().print(jsonArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
//		ActionContext.getContext().getValueStack().push(list);
		return "assessmentByComp";
	}
	
	//通过action返回跳转的jsp
	public String saveUI(){
		List<Employee> list = employeeService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "saveUI";
	}
	
	public String addTask() {
		taskService.save(task);
		return "addSuccess";
	}
	
	public String editTask() {
		task = taskService.edit(task.getTask_id());
		List<Employee> list = employeeService.findAll();
		ActionContext.getContext().getSession().put("list", list);
		return "editSuccess";
	}
	
	public String updateTask() {
		System.out.println(task.getTask_name().toString());
		taskService.update(task);
		return "updateSuccess";
	}
	
	public String delTask() {
		taskService.delete(task);
		return "delSuccess";
	}
	
	public String exportExcel() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cpname = request.getParameter("cpname");
		List<Company> cList = companyService.findByName(cpname);
		
		list = taskService.findByProperties(cpname);
		String path =request.getSession().getServletContext().getRealPath("/")+"Templet\\1.付款凭证-任务考核表-维护类开发-测评业务线-纸质签字版反馈综合室-模板.xls";//获取存在项目中的模板的真实路径
		PoiExcel poiExcel = new PoiExcel();
		poiExcel.assessExcel(list,path,cList);
		return null;
	}

}
