package com.notefinder.service;

import java.util.List;
import com.notefinder.models.PostFlag;

public interface PostFlagManager {
	public int save(PostFlag p);
	public int update(PostFlag p);
	public int delete(int id);
	public PostFlag getPostFlagById(int id);
	public List<PostFlag> getPostFlags();
}


