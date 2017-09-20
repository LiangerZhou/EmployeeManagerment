package com.cmsz.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.cmsz.domain.Company;
import com.cmsz.domain.PageBean;
import com.cmsz.service.CompanyService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class CompanyAction extends ActionSupport implements ModelDriven<Company> {

	//模型驱动使用的对象
	private Company company = new Company();
	private CompanyService companyService;
	
	//struts结合spring自动注入的department
	private int currentPage=1;
	
	private String fileName;
	
	private InputStream excelStream;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
	@Override
	public Company getModel() {
		return company;
	}

	//提供一个查询的方法
	public String findAll(){
		PageBean<Company> pageBean = companyService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//通过action返回添加的视图的jsp
	public String saveUI(){
		return "saveUI";
	}
	//添加部门的save方法
	public String saveInfo(){
		companyService.save(company);
		return "saveSuccess";
	}
	//通过ID找出对应的Company
	public String editById(){
		company = companyService.editById(company.getCid());
		return "editSuccess";
	}
	//修改对应的Department
	public String update(){
		companyService.update(company);
		return "updateSuccess";
	}
	public String delete(){
		Company dep = companyService.editById(company.getCid());
		companyService.delete(dep);
		return "deleteSuccess";
	}
	public String exportExcel() {
		excelStream = companyService.exportExcel();
		fileName = "合同台账-订单接收表-6月-测评业务线.xlsx";
		try {
			fileName = new String(fileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "exportSuccess";
	}

}
