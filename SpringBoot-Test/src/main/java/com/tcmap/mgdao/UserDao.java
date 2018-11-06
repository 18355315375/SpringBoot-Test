package com.tcmap.mgdao;

import java.util.List;

import com.tcmap.entity.User;

public interface UserDao {
   public void saveUser(User user);
   public List<User> getUsers();
}
