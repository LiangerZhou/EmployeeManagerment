package com.cmsz.dao;

import com.cmsz.domain.User;

public interface UserDao {

	User findUserExist(User user);
}
