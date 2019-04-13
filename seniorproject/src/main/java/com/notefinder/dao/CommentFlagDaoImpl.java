package com.notefinder.dao;

import java.util.List;	
import java.sql.ResultSet;    
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;
import com.notefinder.models.CommentFlag;

public class CommentFlagDaoImpl implements CommentFlagDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(CommentFlag p)
	{
		String sql = "insert into comment_flag(commentID,flagger,flagDate,active,notes) "
				+ "values(" + p.getComment_id() + "," + p.getFlagger() + ",'" + p.getDate() + "',"
				+ p.isActive() + ",'" + p.getNotes() + "')";
		return template.update(sql);	
	}

	public int update(CommentFlag p)
	{
		String sql = "update comment_flag set commentID=" + p.getComment_id() 
				+ ", flagger=" + p.getFlagger() + ", flagDate='" + p.getDate() 
				+ "', active=" + p.isActive() + ", notes='" + p.getNotes() 
				+ "' where id=" + p.getId();
		return template.update(sql);
	}

	public int delete(int id)
	{
	    String sql="delete from comment where id=" + id;    
	    return template.update(sql); 
	}
	
//	public CommentFlag getCommentFlagById(int id){
//		String sql= "select commentID,flagger,flagDate,active,notes from comment_flag where id=?";
//		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<CommentFlag>(CommentFlag.class));
//	}
	
	public List<CommentFlag> getCommentFlagById(int id){    
	    //String sql="select * from course where id="+ id;    
	    //return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<CourseId>(CourseId.class)); 
	    
	    return template.query("select * from comment_flag where id="+id,new RowMapper<CommentFlag>(){    
	        public CommentFlag mapRow(ResultSet rs, int row) throws SQLException {    
	        	CommentFlag p = new CommentFlag();
				p.setId(rs.getInt(1));
				p.setComment_id(rs.getInt(2));
				p.setFlagger(rs.getInt(3));
				p.setDate(rs.getTimestamp(4));
				p.setActive(rs.getBoolean(5));
				p.setNotes(rs.getString(6));
				return p;   
	        }    
	    }); 
	}

	public List<CommentFlag> getCommentFlags()
	{
		return template.query("select * from comment_flag", new RowMapper<CommentFlag>() {
			public CommentFlag mapRow(ResultSet rs, int row) throws SQLException {
				CommentFlag p = new CommentFlag();
				p.setId(rs.getInt(1));
				p.setComment_id(rs.getInt(2));
				p.setFlagger(rs.getInt(3));
				p.setDate(rs.getTimestamp(4));
				p.setActive(rs.getBoolean(5));
				p.setNotes(rs.getString(6));
				return p;
			}
		});
	}
}

