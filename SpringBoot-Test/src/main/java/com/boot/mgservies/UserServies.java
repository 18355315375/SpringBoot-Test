package com.boot.mgservies;

import java.util.List;

import com.neo.entity.User;

public interface UserServies {
   public void saveUser(User user);
   public List<User> getUsers();
}
