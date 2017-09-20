package com.cmsz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 项目信息实体类
 * 注解方式配置对应数据表
 * @author Zhou Liang
 * @Date 2017年7月14日 上午11:25:12
 */
@Entity
@Table(name = "project")
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer proj_id;//项目ID
	private String proj_name;//项目名称
	private Date proj_creTime;//项目创建时间
	private Date proj_endTime;//项目结束时间
	private String contract_name;//项目合同名
	private String contract_code;//项目合同号
	private String demand_side;//需求方
	private String qm_side;//质量管理方
	private String charge_man;//项目负责人
	private String workType;//工作类型
	private String remark;//备注
	
	private Company company;//实施方
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Integer getProj_id() {
		return proj_id;
	}
	public void setProj_id(Integer proj_id) {
		this.proj_id = proj_id;
	}


	public Date getProj_creTime() {
		return proj_creTime;
	}
	public void setProj_creTime(Date proj_creTime) {
		this.proj_creTime = proj_creTime;
	}
	public Date getProj_endTime() {
		return proj_endTime;
	}
	public void setProj_endTime(Date proj_endTime) {
		this.proj_endTime = proj_endTime;
	}
	
	public String getProj_name() {
		return proj_name;
	}
	
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
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
	public String getDemand_side() {
		return demand_side;
	}
	public void setDemand_side(String demand_side) {
		this.demand_side = demand_side;
	}

	public String getQm_side() {
		return qm_side;
	}
	public void setQm_side(String qm_side) {
		this.qm_side = qm_side;
	}
	public String getCharge_man() {
		return charge_man;
	}
	public void setCharge_man(String charge_man) {
		this.charge_man = charge_man;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
