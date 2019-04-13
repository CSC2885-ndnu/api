package com.notefinder.service;

import java.util.List;
import com.notefinder.models.User;

public interface UserManager {
	
	public int save(User u);
	public int update(User u);
	public int delete(int id);
	public List<User> getUserById(int id);
	public List<User> getUser();
	public User getUserByNameAndPassword(String userName, String password);
}
