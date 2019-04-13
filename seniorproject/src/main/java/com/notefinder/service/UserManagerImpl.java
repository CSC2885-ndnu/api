package com.notefinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notefinder.dao.UserDao;
import com.notefinder.models.User;

@Service("userManager")
public class UserManagerImpl implements UserManager {
	
	@Autowired
	UserDao dao;
	
	public int save(User u) {
		return dao.save(u);
	}
	
	public int update(User u) {
		return dao.update(u);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}
	
	public List<User> getUserById(int id) {
		return dao.getUserById(id);
	}
	
	public List<User> getUser() {
		return dao.getUser();
	}
	
	public User getUserByNameAndPassword(String userName, String password)
	{
		return dao.getUserByNameAndPassword(userName, password);
	}
}
