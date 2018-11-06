package com.tcmap.mgservies.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.tcmap.entity.User;
import com.tcmap.mgdao.UserDao;
import com.tcmap.mgservies.UserServies;
@Service
public class UserServiesImpl implements UserServies,Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Autowired
  private UserDao userDao;
	@Override
	public void saveUser(User user) {
        userDao.saveUser(user);
	}
	@Override
	public List<User> getUsers() {
		System.out.println(1);
		return userDao.getUsers();
	}

}
