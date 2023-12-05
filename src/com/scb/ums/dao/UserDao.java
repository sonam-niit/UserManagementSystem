package com.scb.ums.dao;

import java.util.List;

import com.scb.ums.model.User;

public interface UserDao {

	public int createUser(User user);
	public List<User> getAllUsers();
	public User updateUser(User user, int id);
	public boolean deleteUser(int id);
	public User getUserById(int id);
}


