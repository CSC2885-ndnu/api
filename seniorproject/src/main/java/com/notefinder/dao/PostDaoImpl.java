package com.notefinder.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;
import com.notefinder.models.Post;

 
public class PostDaoImpl implements PostDao
{
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Post p) {
		String sql = "insert into post(title,courseID,postDate,note,userID,flagged) values('" + p.getTitle() + "'," + p.getCourseID() + ", now(), '" + p.getNote() + "'," + p.getUserID() + "," + p.isFlagged() + ")";
		return template.update(sql);
	}
	
	public int update(Post p) {
		String sql = "update post set id=" + p.getId() + ", title='" + p.getTitle() + "', courseID=" + p.getCourseID() + ", postDate=now()" + ", note='" + p.getNote() + "', userID=" + p.getUserID() + ", flagged=" + p.isFlagged() + " where id=" + p.getId()+"";
		return template.update(sql);
	}
	
	public int delete(int id){    
	    String sql="delete from post where id="+id+"";    
	    return template.update(sql);    
	} 
	
	public Post getPostById(int id){ 
		String sql="select * from post where id=?";
		return template.queryForObject(sql,  new Object[] {id}, new BeanPropertyRowMapper<Post>(Post.class));
	}
	
	public List<Post> getPosts(){    
	    return template.query("select id, title, courseID, classDate, postDate, note, userID, flagged from post",new RowMapper<Post>(){    
	        public Post mapRow(ResultSet rs, int row) throws SQLException {    
	            Post p=new Post();    
	            p.setId(rs.getInt(1));    
	            p.setTitle(rs.getString(2));    
	            p.setCourseID(rs.getInt(3));  
	            p.setPostDate(rs.getTimestamp(4));
	            p.setPostDate(rs.getTimestamp(5));
	            p.setNote(rs.getString(6));
	            p.setUserID(rs.getInt(7));
	            p.setFlagged(rs.getBoolean(8));
	            return p;    
	        }    
	    });    
	}
}
