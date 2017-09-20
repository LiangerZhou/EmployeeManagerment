package com.cmsz.dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cmsz.dao.UserDao;
import com.cmsz.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
		
		@SuppressWarnings("unchecked")
		@Override
		public User findUserExist(User user) {
			String hql = " from User where username = ? and password = ?";
			List<User> list = (List<User>) this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword());
			if(list.size()>0){
				return list.get(0);
			}
			return null;
		}
}