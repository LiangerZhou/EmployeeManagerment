package com.cmsz.domain;

import java.io.Serializable;
import java.util.Date;

public class Task_Assessment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String assessment_id;
	private String task_name;//工作任务摘要
	private Date start_Date;//工作开始时间
	private Date end_Date;//工作结束时间
	private Integer workdays;//工作量
	private Integer work_efficiency;//工作效率，总分30分
	private Integer work_quality;//工作质量，总分40分
	private Integer work_norm;//流程规范执行情况，总分30分
	private Integer work_score;//工作任务考核得分
	private Integer convert_work_score;//工作任务考核得分折算
	private String qc_man;//服务质量评审人
	private String remark;//备注
	
	private Company company; //公司名

	public String getAssessment_id() {
		return assessment_id;
	}

	public void setAssessment_id(String assessment_id) {
		this.assessment_id = assessment_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public Date getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(Date start_Date) {
		this.start_Date = start_Date;
	}

	public Date getEnd_Date() {
		return end_Date;
	}

	public void setEnd_Date(Date end_Date) {
		this.end_Date = end_Date;
	}

	public Integer getWorkdays() {
		return workdays;
	}

	public void setWorkdays(Integer workdays) {
		this.workdays = workdays;
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

	public Integer getConvert_work_score() {
		return convert_work_score;
	}

	public void setConvert_work_score(Integer convert_work_score) {
		this.convert_work_score = convert_work_score;
	}

	public String getQc_man() {
		return qc_man;
	}

	public void setQc_man(String qc_man) {
		this.qc_man = qc_man;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
