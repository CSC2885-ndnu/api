package com.notefinder.dao;

import java.util.List;	
import java.sql.ResultSet;    
import java.sql.SQLException;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;
import com.notefinder.models.CommentFlag;
import com.notefinder.models.Comment;
import com.notefinder.models.Course;
import com.notefinder.models.User;
import com.notefinder.service.UserManager;
import com.notefinder.service.UserManagerImpl;

public class CommentFlagDaoImpl implements CommentFlagDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(CommentFlag p)
	{
		String sql = "insert into comment_flag(commentID,flagger,flagDate,active,notes) "
				+ "values(" + p.getComment_id() + "," + p.getFlagger().getUser_id() + "," + p.getDate() + ","
				+ p.isActive() + ",'" + p.getNotes() + ")";
		return template.update(sql);	
	}

	public int update(CommentFlag p)
	{
		String sql = "update comment set commentID=" + p.getComment_id() 
				+ ", flagger=" + p.getFlagger().getUser_id() + ", flagDate='" + p.getDate() 
				+ "', active='" + p.isActive() + "', notes=" + p.getNotes() 
				+ " where id=" + p.getComment_id();
		return template.update(sql);
	}

	public int delete(int id)
	{
	    String sql="delete from comment where id=" + id;    
	    return template.update(sql); 
	}

	public CommentFlag getCommentFlagById(int id)
	{
		List<CommentFlag> retValue = template.query("select commentID,flagger,flagDate,active,notes from comment_flag where id=" + id, new RowMapper<CommentFlag>() {
			public CommentFlag mapRow(ResultSet rs, int row) throws SQLException {
				CommentFlag p = new CommentFlag();
				
				p.setComment_id(rs.getInt(1));
				
				UserDao userDao = new UserDaoImpl();
				p.setFlagger(userDao.getUserById(rs.getInt(2)));
				
				//Timestamp time = new Timestamp();
				java.sql.Timestamp ts = java.sql.Timestamp.valueOf( rs.getString(3) ) ;
				p.setDate(ts);
				
				p.setActive(rs.getBoolean(4));
				
				p.setNotes(rs.getString(5));
				
				return p;
			}
		});
		return retValue.get(0);
	}

	public List<CommentFlag> getCommentFlags()
	{
		return template.query("select * from comment_flag", new RowMapper<CommentFlag>() {
			public CommentFlag mapRow(ResultSet rs, int row) throws SQLException {
				CommentFlag p = new CommentFlag();
				
				p.setComment_id(rs.getInt(1));
				
				System.out.println(rs.getInt(2));
				
				UserDaoImpl userDao = new UserDaoImpl();
				//UserManager manager = new UserManagerImpl();
				userDao.setTemplate(template);
				User u = userDao.getUserById(rs.getInt(2));
				p.setFlagger(u);
				
				//Timestamp time = new Timestamp();
				java.sql.Timestamp ts = java.sql.Timestamp.valueOf( rs.getString(3) ) ;
				p.setDate(ts);
				
				p.setActive(rs.getBoolean(4));
				
				p.setNotes(rs.getString(5));
				
				return p;
				
				
			}
		});
	}
}

