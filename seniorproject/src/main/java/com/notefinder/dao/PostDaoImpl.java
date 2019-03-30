package com.notefinder.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
<<<<<<< HEAD
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
=======
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
>>>>>>> parent of 8a09f90... add and edit post working, classDate variable removed
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
<<<<<<< HEAD
=======
		
>>>>>>> parent of 8a09f90... add and edit post working, classDate variable removed
		return template.update(sql);
	}
	
	public int update(Post p) {
		String sql = "update post set id=" + p.getId() + ", title='" + p.getTitle() + "', courseID=" + p.getCourseID() + ", classDate=" + p.getClassDate() + ", postDate=" + p.getPostDate() + ", note='" + p.getNote() + "', userID=" + p.getUserID() + ", flagged=" + p.isFlagged() + " where id=" + p.getId()+"";
		return template.update(sql);
	}
	
	public int delete(int id){    
	    String sql="delete from post where id="+id+"";    
	    return template.update(sql);    
	} 
	
<<<<<<< HEAD
	public Post getPostById(int id){ 
=======
	public Post getPostById(int id){    
>>>>>>> parent of 8a09f90... add and edit post working, classDate variable removed
		String sql="select * from post where id=?";
		return template.queryForObject(sql,  new Object[] {id}, new BeanPropertyRowMapper<Post>(Post.class));
	}
		//return template.query("select * from post where id=" 
	//+ id, new RowMapper<Post>(){    
//	        public Post mapRow(ResultSet rs, int row) throws SQLException {    
//	            Post p=new Post();    
//	            p.setId(rs.getInt(1));    
//	            p.setTitle(rs.getString(2));    
//	            p.setCourseID(rs.getInt(3));    
//	            p.setClassDate(rs.getTimestamp(4));  
//	            p.setPostDate(rs.getTimestamp(5));
//	            p.setNote(rs.getString(6));
//	            p.setUserID(rs.getInt(7));
//	            p.setFlagged(rs.getBoolean(8));
//	            return p;    
//	        } 
//	        
//	    });
<<<<<<< HEAD
//		List<Post> retValue =  template.query("select * from post where id=" + id, new RowMapper<Post>(){    
//	        public Post mapRow(ResultSet rs, int row) throws SQLException {    
//	            Post p=new Post();    
//	            p.setId(rs.getInt(1));    
//	            p.setTitle(rs.getString(2));    
//	            p.setCourseID(rs.getInt(3));  
//	            p.setPostDate(rs.getTimestamp(4));
//	            p.setNote(rs.getString(5));
//	            p.setUserID(rs.getInt(6));
//	            p.setFlagged(rs.getBoolean(7));
//	            return p;    
//	        } 
//	        
//	    });
//		return retValue.get(0);
//	}
=======
	}
>>>>>>> parent of 8a09f90... add and edit post working, classDate variable removed
	
	public List<Post> getPosts(){    
	    return template.query("select * from post",new RowMapper<Post>(){    
	        public Post mapRow(ResultSet rs, int row) throws SQLException {    
	            Post p=new Post();    
	            p.setId(rs.getInt(1));    
	            p.setTitle(rs.getString(2));    
<<<<<<< HEAD
	            p.setCourseID(rs.getInt(3));    
	            p.setClassDate(rs.getTimestamp(4));  
	            p.setPostDate(rs.getTimestamp(5));
	            p.setNote(rs.getString(6));
	            p.setUserID(rs.getInt(7));
	            p.setFlagged(rs.getBoolean(8));
=======
	            p.setCourseID(rs.getInt(3));  
	            p.setPostDate(rs.getTimestamp(4));
	            p.setNote(rs.getString(5));
	            p.setUserID(rs.getInt(6));
	            p.setFlagged(rs.getBoolean(7));
>>>>>>> parent of 8a09f90... add and edit post working, classDate variable removed
	            return p;    
	        }    
	    });    
	}
}
