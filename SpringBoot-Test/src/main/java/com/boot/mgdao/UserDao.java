package com.boot.mgdao;

import java.util.List;

import com.neo.entity.User;

public interface UserDao {
   public void saveUser(User user);
   public List<User> getUsers();
}
