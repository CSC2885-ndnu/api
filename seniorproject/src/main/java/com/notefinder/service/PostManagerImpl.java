package com.notefinder.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notefinder.dao.PostDao;
import com.notefinder.models.Post;

@Service("postManager")
public class PostManagerImpl implements PostManager {
	
	@Autowired
	PostDao dao;
	
	public int save(Post p) {
		return dao.save(p);
	}
	
	public int update(Post p) {
		return dao.update(p);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}
	
	public Post getPostById(int id) {
		return dao.getPostById(id);
	}
	
	public List<Post> getPosts() {
		return dao.getPosts();
	}

}
