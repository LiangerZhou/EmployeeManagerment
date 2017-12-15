package com.cmsz.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 项目任务实体类，即工作内容摘要
 * 注解方式配置对应数据表
 * @author Zhou Liang
 * @Date 2017年7月14日 上午11:25:12
 */
@Entity
@Table(name = "task")
public class Task implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer task_id;//任务ID
	private String task_name;//任务名称
	private Date task_creTime;//任务开始时间
	private Date task_endTime;//计划完成时间
	private Date real_endTime;//实际完成时间
	private Integer workdays;//工作量
	private Integer workratio;//工作量占比
	private Integer work_efficiency;//工作效率，总分30分
	private Integer work_quality;//工作质量，总分40分
	private Integer work_norm;//流程规范执行情况，总分30分
	private Integer work_score;//工作任务考核得分
	private Integer convert_score;//工作任务考核得分折算	
	private String budget_name;//归属预算名称,项目名
	private String qm_side;//归属科室/业务线
	private String charge_man;//服务质量评审人
	private String workType;//工作类型
	private String remark;//备注
	
	private Set<Employee> emps = new HashSet<Employee>();

	public Integer getTask_id() {
		return task_id;
	}
	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public Date getTask_creTime() {
		return task_creTime;
	}
	public void setTask_creTime(Date task_creTime) {
		this.task_creTime = task_creTime;
	}
	public Date getTask_endTime() {
		return task_endTime;
	}
	public void setTask_endTime(Date task_endTime) {
		this.task_endTime = task_endTime;
	}
	public Date getReal_endTime() {
		return real_endTime;
	}
	public void setReal_endTime(Date real_endTime) {
		this.real_endTime = real_endTime;
	}
	public Integer getWorkdays() {
		return workdays;
	}
	public void setWorkdays(Integer workdays) {
		this.workdays = workdays;
	}
	public Integer getWorkratio() {
		return workratio;
	}
	public void setWorkratio(Integer workratio) {
		this.workratio = workratio;
	}
	public Integer getWork_efficiency() {
		return work_efficiency;
	}
	public void setWork_efficiency(Integer work_efficiency) {
		this.work_efficiency = work_efficiency;
	}
	public Integer getWork_quality() {
		return work_quality;
	}
	public void setWork_quality(Integer work_quality) {
		this.work_quality = work_quality;
	}
	public Integer getWork_norm() {
		return work_norm;
	}
	public void setWork_norm(Integer work_norm) {
		this.work_norm = work_norm;
	}
	public Integer getWork_score() {
		return work_score;
	}
	public void setWork_score(Integer work_score) {
		this.work_score = work_score;
	}
	public Integer getConvert_score() {
		return convert_score;
	}
	public void setConvert_score(Integer convert_score) {
		this.convert_score = convert_score;
	}
	public String getBudget_name() {
		return budget_name;
	}
	public void setBudget_name(String budget_name) {
		this.budget_name = budget_name;
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
		this.remark = "维护类开发";//此处以后要改，暂时先这样写死，为了减少页面修改工作量
	}
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	
}
