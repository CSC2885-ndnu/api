package com.notefinder.dao;

import java.util.List;	
import java.sql.ResultSet;    
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
				+ "values(" + p.getComment_id() + "," + p.getFlagger() + "," + p.getDate() + ","
				+ p.isActive() + ",'" + p.getNotes() + ")";
		return template.update(sql);	
	}

	public int update(CommentFlag p)
	{
		String sql = "update comment set commentID=" + p.getComment_id() 
				+ ", flagger=" + p.getFlagger() + ", flagDate='" + p.getDate() 
				+ "', active='" + p.isActive() + "', notes=" + p.getNotes() 
				+ " where id=" + p.getComment_id();
		return template.update(sql);
	}

	public int delete(int id)
	{
	    String sql="delete from comment where id=" + id;    
	    return template.update(sql); 
	}
	
	public CommentFlag getCommentFlagById(int id){
		String sql= "select commentID,flagger,flagDate,active,notes from comment_flag where id=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<CommentFlag>(CommentFlag.class));
	}

	public List<CommentFlag> getCommentFlags()
	{
		return template.query("select * from comment_flag", new RowMapper<CommentFlag>() {
			public CommentFlag mapRow(ResultSet rs, int row) throws SQLException {
				CommentFlag p = new CommentFlag();
				p.setComment_id(rs.getInt(1));
				p.setFlagger(rs.getInt(2));
				p.setDate(rs.getTimestamp(3));
				p.setActive(rs.getBoolean(4));
				p.setNotes(rs.getString(5));
				return p;
			}
		});
	}
}

