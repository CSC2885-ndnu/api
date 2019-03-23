package com.notefinder.service;

import java.util.List;
import com.notefinder.models.Post;

public interface PostManager {
	public int save(Post p);
	public int update(Post p);
	public int delete(int id);
	public List<Post> getPostById(int id);
	public List<Post> getPosts();
}
