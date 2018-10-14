package com.boot.mgservies.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.mgdao.UserDao;
import com.boot.mgservies.UserServies;
import com.neo.entity.User;
@Service
public class UserServiesImpl implements UserServies {
  @Autowired
  private UserDao userDao;
	@Override
	public void saveUser(User user) {
        userDao.saveUser(user);
	}
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

}
