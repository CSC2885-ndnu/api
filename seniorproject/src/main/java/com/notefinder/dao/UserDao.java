package com.notefinder.dao;


import java.util.List;
import com.notefinder.models.User;

public interface UserDao {
		
	public int save(User u);
	public int update(User u);
	public int delete(int id);
	public User getUserById(int id);
	public List<User> getUser();
}
