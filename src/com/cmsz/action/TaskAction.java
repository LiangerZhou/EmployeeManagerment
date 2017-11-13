package com.cmsz.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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
		return "assessmentByComp";
	}
	
	//通过action返回跳转的jsp
	public String saveUI(){
		List<Employee> elist = employeeService.findAll();
		ActionContext.getContext().getSession().put("elist", elist);
		return "saveUI";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String addTask() {
		Set<Employee> employee = new HashSet(employeeService.findByIds(task.getEmps().iterator().next().getEid().toString()));
		task.setEmps(employee);
		task.getEmps().iterator().next().setTask(task);
		taskService.save(task);
		return "addSuccess";
	}
	
	public String editTask() {
		task = taskService.edit(task.getTask_id());
		List<Employee> elist = employeeService.findAll();
		ActionContext.getContext().getSession().put("elist", elist);
		return "editSuccess";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String updateTask() {
		Set<Employee> employee = new HashSet(employeeService.findByIds(task.getEmps().iterator().next().getEid().toString())); 
		task.setEmps(employee);
		task.getEmps().iterator().next().setTask(task);
		taskService.update(task);
		return "updateSuccess";
	}
	
	public String delTask() {
		taskService.delete(task);
		return "delSuccess";
	}
//考核表导出	
	public String exportAss() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cpname = request.getParameter("cpname");
		List<Task> list = taskService.findByProperties(cpname);
		PoiExcel poiExcel = new PoiExcel();
		String path;
		if("".equals(cpname)||cpname.isEmpty()) {
		    path = request.getSession().getServletContext().getRealPath("/")+"Templet\\2.付款凭证-任务考核表-电子版反馈给综合室.xlsx";
			poiExcel.assessAllExcel(list, path);
		}else {
			List<Company> cList = companyService.findByName(cpname);
			path = request.getSession().getServletContext().getRealPath("/")+"Templet\\1.付款凭证-任务考核表-维护类开发-测评业务线-纸质签字版反馈综合室（各公司总表） - 模板.xlsx";//获取存在项目中的模板的真实路径
			poiExcel.assessExcel(list,path,cList);//各公司分表
		}
		return null;
	}
//中间表导出
	public String exportMid() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String cpname = request.getParameter("cpname");
		List<Employee> list = taskService.findAllProperties(cpname);//查询所有任务根据公司名，若为空就是查询所有的
		PoiExcel poiExcel = new PoiExcel();
		String path;
		if("".equals(cpname)||cpname.isEmpty()) {
		    path = request.getSession().getServletContext().getRealPath("/")+"Templet\\4.付款凭证-中间表-电子版反馈给综合室 - 模板.xlsx";
			poiExcel.midAllExcel(list, path);
		}else {
			List<Company> cList = companyService.findByName(cpname);
			path = request.getSession().getServletContext().getRealPath("/")+"Templet\\3.付款凭证-中间表-维护类开发-测评业务线-纸质签字版反馈给综合室（各公司汇总总表） - 模板.xlsx";//获取存在项目中的模板的真实路径"
			poiExcel.midExcel(list,path,cList);//各公司分表
		}
		return null;
	}
	
//合同台账导出	
	public String exportContract() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getSession().getServletContext().getRealPath("/")+"Templet\\合同台账-订单接收表-模板-测评业务线.xlsx";//获取存在项目中的模板的真实路径"
		List<Object[]> list = companyService.findTaskEmp();
		PoiExcel poiExcel = new PoiExcel();
		poiExcel.contract(list,path);
		return null;
	}
}
