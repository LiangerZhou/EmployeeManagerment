package com.cmsz.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 外援信息实体类
 * 注解方式配置对应数据表
 * @author Zhou Liang
 * @Date 2017年7月14日 上午11:25:12
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer eid; //id
	private String ename; //姓名
	private String sex; //性别
	private Date joinDate; //入职日期
	private Date leftDate; //离职日期
	private String e_level; //外援等级
	private String on_off_duty; //在职状态
	private String idCard; //身份证号
	private String workplace; //工作地点
	private String Net_account; //网络账号
	private String Net_role; //网络角色
	private Integer Price;//单价
	//所属公司
	private Company company;
	//所属任务
	private Task task;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getLeftDate() {
		return leftDate;
	}

	public void setLeftDate(Date leftDate) {
		this.leftDate = leftDate;
	}

	public String getE_level() {
		return e_level;
	}

	public void setE_level(String e_level) {
		this.e_level = e_level;
	}

	public String getOn_off_duty() {
		return on_off_duty;
	}

	public void setOn_off_duty(String on_off_duty) {
		this.on_off_duty = on_off_duty;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getNet_account() {
		return Net_account;
	}

	public void setNet_account(String net_account) {
		Net_account = net_account;
	}

	public String getNet_role() {
		return Net_role;
	}

	public void setNet_role(String net_role) {
		Net_role = net_role;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

}
