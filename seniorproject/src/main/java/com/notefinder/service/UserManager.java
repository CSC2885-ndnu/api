package com.notefinder.service;

import java.util.List;

import com.notefinder.models.User;
import com.notefinder.models.UserPass;

public interface UserManager {
	
	public int save(User u);
	public int update(User u);
	public int delete(int id);
	public User getUserById(int id);
	public List<User> getUser();
	public User getUserByNameAndPassword(String userName, String password);
	public List<UserPass> getPassword(int studentID);
}
