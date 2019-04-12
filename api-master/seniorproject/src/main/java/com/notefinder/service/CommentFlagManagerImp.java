package com.notefinder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notefinder.dao.CommentFlagDao;
import com.notefinder.models.CommentFlag;

@Service("commentFlagManager")
public class CommentFlagManagerImp implements CommentFlagManager {

	@Autowired
	CommentFlagDao dao;
	
	public int save(CommentFlag p) {
		return dao.save(p);
	}
	
	public int update(CommentFlag p) {
		return dao.update(p);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}
	
	public List<CommentFlag> getCommentFlagById(int id) {
		return dao.getCommentFlagById(id);
	}
	
	public List<CommentFlag> getCommentFlags() {
		return dao.getCommentFlags();
	}


}
