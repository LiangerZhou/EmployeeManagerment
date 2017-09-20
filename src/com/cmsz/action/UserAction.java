package com.cmsz.action;

import com.cmsz.domain.User;
import com.cmsz.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	//模型驱动使用的对象
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	
	private UserService userService; //必须私有，否则找不到对应action
		
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {
		//登陆方法确定用户是否存在
		User exsitUser = userService.login(user);
		
		if(exsitUser==null){
			//登陆失败
			this.addActionError("用户名或者密码错误");
			return INPUT;
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("exsitUser",exsitUser);
			return SUCCESS;
		}
	}


}
