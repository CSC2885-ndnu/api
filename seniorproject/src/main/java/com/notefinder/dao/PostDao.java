package com.notefinder.dao;

import java.util.List;
import com.notefinder.models.Post; 

public interface PostDao {
	public int save(Post p);
	public int update(Post p);
	public int delete(int id);
	public Post getPostById(int id);
	public List<Post> getPosts();
}
