

package com.notefinder.service;

import java.util.List;
import com.notefinder.models.CommentFlag;

public interface CommentFlagManager {
	public int save(CommentFlag p);
	public int update(CommentFlag p);
	public int delete(int id);
	public List<CommentFlag> getCommentFlagById(int id);
	public List<CommentFlag> getCommentFlags();
}
