package com.cmsz.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 公司信息实体类
 * 注解方式配置对应数据表
 * @author Zhou Liang
 * @Date 2017年7月14日 上午11:25:12
 */
@Entity
@Table(name = "company")
public class Company implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cid; //id
	private String cname; //公司名称
	private String cdesc; //公司备注
	private String contract_name;//合同名称
	private String contract_code;//合同编号
	
	//外援的集合
	private Set<Employee> employees = new HashSet<Employee>();
	//项目任务的集合
	private Set<Project> projects = new HashSet<Project>();

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}

	public String getContract_code() {
		return contract_code;
	}

	public void setContract_code(String contract_code) {
		this.contract_code = contract_code;
	}
	
}
