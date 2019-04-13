package com.notefinder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notefinder.dao.PostFlagDao;
import com.notefinder.models.PostFlag;

@Service("postFlagManager")
public class PostFlagManagerImpl implements PostFlagManager {

	@Autowired
	PostFlagDao dao;
	
	public int save(PostFlag p) {
		return dao.save(p);
	}
	
	public int update(PostFlag p) {
		return dao.update(p);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}
	
	public PostFlag getPostFlagById(int id) {
		return dao.getPostFlagById(id);
	}
	
	public List<PostFlag> getPostFlags() {
		return dao.getPostFlags();
	}


}
