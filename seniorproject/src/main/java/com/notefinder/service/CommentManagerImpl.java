package com.notefinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notefinder.dao.CommentDao;
import com.notefinder.models.Comment;

@Service("commentManager")
public class CommentManagerImpl implements CommentManager {
	@Autowired
	CommentDao dao;
	
	public int save(Comment p) {
		return dao.save(p);
	}
	
	public int update(Comment p) {
		return dao.update(p);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}
	
	public Comment getCommentById(int id) {
		return dao.getCommentById(id);
	}
	
	public List<Comment> getComments() {
		return dao.getComments();
	}
}
