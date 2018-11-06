package com.tcmap.mgdao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.tcmap.entity.User;
import com.tcmap.mgdao.UserDao;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		mongoTemplate.save(user);
	}
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(User.class);
	}

}
