package com.notefinder.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notefinder.dao.PostDao;
import com.notefinder.models.CommentPostView;
import com.notefinder.models.Post;
import com.notefinder.models.PostLanding;
import com.notefinder.models.PostView;

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
	
	public List<PostLanding> getPostsForLanding(int numberOfPosts) {
		return dao.getPostsForLanding(numberOfPosts);
	}
	
	public List<PostView> getPostsForView(int id) {
		return dao.getPostsForView(id);
	}
	
	public List<CommentPostView> getCommentsForView(int id) {
		return dao.getCommentsForView(id);
	}
	
	public List<Post> getCoursePosts(int id){
		return dao.getCoursePosts(id);
	}
	
	public List<Post> getPostsForUser(int id) {
		return dao.getPostsForUser(id);
	}
}
