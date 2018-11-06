package com.tcmap.mgservies;

import java.util.List;

import com.tcmap.entity.User;

public interface UserServies {
   public void saveUser(User user);
   public List<User> getUsers();
}
