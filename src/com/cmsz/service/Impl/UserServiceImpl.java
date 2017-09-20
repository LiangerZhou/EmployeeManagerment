package com.cmsz.service.Impl;

import org.springframework.transaction.annotation.Transactional;

import com.cmsz.dao.UserDao;
import com.cmsz.domain.User;
import com.cmsz.service.UserService;

@Transactional(readOnly = false)
public class UserServiceImpl implements UserService{
	/**
	 * 业务层登录的方法
	 */
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//登陆方法确定用户是否存在
	@Override
	public User login(User user) {
			User existUser = userDao.findUserExist(user);
			return existUser;
	}
}
