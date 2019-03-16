package com.notefinder.dao;

import java.util.List;
import java.sql.ResultSet;    
import java.sql.SQLException;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;
import com.notefinder.models.Comment;
import com.notefinder.models.Course;

public class CommentDaoImpl implements CommentDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Comment p)
	{
		String sql = "insert into comment(id,postID,user,createdTS,modified,comment,flagged) "
				+ "values(" + p.getId() + "," + p.getPost().getId() + "," + p.getUser().getUser_id() + ",'"
				+ p.getCreatedTS().toString() + "','" + p.getModified().toString() + "','" 
				+ p.getComment() + "'," + p.getFlagged() + ")";
		return template.update(sql);	
	}

	public int update(Comment p)
	{
		String sql = "update comment set postID=" + p.getPost().getId() 
				+ ", user=" + p.getUser().getUser_id() + ", modified='" + p.getModified().toString() 
				+ "', comment='" + p.getComment() + "', flagged=" + p.getFlagged() 
				+ " where id=" + p.getId();
		return template.update(sql);
	}

	public int delete(int id)
	{
	    String sql="delete from comment where id=" + id;    
	    return template.update(sql); 
	}

	public Comment getCommentById(int id)
	{
		List<Comment> retValue = template.query("select id,postID,user,createdTS,modified,comment,flagged from comment where id=" + id, new RowMapper<Comment>() {
			public Comment mapRow(ResultSet rs, int row) throws SQLException {
				Comment p = new Comment();
				p.setId(rs.getInt(1));
				PostDaoImpl postDao = new PostDaoImpl();
				p.setPost(postDao.getPostById(rs.getInt(2)));
				UserDaoImpl userDao = new UserDaoImpl();
				p.setUser(userDao.getUserById(rs.getInt(3)));
				p.setCreatedTS(rs.getTimestamp(4));
				p.setModified(rs.getTimestamp(5));
				p.setComment(rs.getString(6));
				p.setFlagged(rs.getBoolean(7));
				return p;
			}
		});
		return retValue.get(0);
	}

	public List<Comment> getComments()
	{
		return template.query("select id,postID,user,createdTS,modified,comment,flagged from comment", new RowMapper<Comment>() {
			public Comment mapRow(ResultSet rs, int row) throws SQLException {
				Comment p = new Comment();
				p.setId(rs.getInt(1));
				PostDaoImpl postDao = new PostDaoImpl();
				p.setPost(postDao.getPostById(rs.getInt(2)));
				UserDaoImpl userDao = new UserDaoImpl();
				p.setUser(userDao.getUserById(rs.getInt(3)));
				p.setCreatedTS(rs.getTimestamp(4));
				p.setModified(rs.getTimestamp(5));
				p.setComment(rs.getString(6));
				p.setFlagged(rs.getBoolean(7));
				return p;
			}
		});
	}
}
