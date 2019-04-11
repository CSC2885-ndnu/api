package com.notefinder.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;
import com.notefinder.models.Post;
import com.notefinder.models.PostLanding;

 
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
	            p.setNote(rs.getString(5));
	            p.setUserID(rs.getInt(6));
	            p.setFlagged(rs.getBoolean(7));
	            return p;    
	        }    
	    });    
	}
	
	public List<PostLanding> getPostsForLanding(int numberOfPosts){
	    return template.query("select p.id, p.title, c.name, p.postDate from post p, course c where p.courseID = c.id limit " + numberOfPosts,new RowMapper<PostLanding>(){    
	        public PostLanding mapRow(ResultSet rs, int row) throws SQLException {    
	        	PostLanding p=new PostLanding();    
	            p.setId(rs.getInt(1));
	            p.setSubmission_title(rs.getString(2));
	            p.setSubmission_course_name(rs.getString(3));
	            p.setSubmission_date(rs.getTimestamp(4));
	            return p;    
	        }    
	    });
	}
}
