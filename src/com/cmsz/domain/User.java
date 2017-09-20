package com.cmsz.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户信息实体类
 * 注解方式配置对应数据表
 * @author Zhou Liang
 * @Date 2017年7月14日 上午11:25:12
 */
@Entity
@Table(name = "user")
public class User {
	
	private int id;// 主键id
	private String username;// 姓名
	private String password;//密码
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
