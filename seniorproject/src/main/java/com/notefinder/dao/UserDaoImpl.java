package com.notefinder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;    
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;

import com.notefinder.models.User;

public class UserDaoImpl implements UserDao{
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(User u) {
		String sql = "insert into user(firstName,lastName,studentID,email,password,avatar,isAdmin,flagged,createdTS)"
			+ "values('" + u.getFirstName() + "','" + u.getLastName() 
			+ "'," + u.getStudentID() + ",'" + u.getEmail() +  "','" + u.getPassword()
			+ "','" + u.getAvatar() + "'," + false + "," + false
			+ ", now())";
				
		return template.update(sql);
	}
	
	public int update(User u) {
		String sql = "UPDATE user SET firstName='" + u.getFirstName() 
		+ "', lastName='" + u.getLastName() + "', studentID=" 
		+ u.getStudentID() + ", email='" + u.getEmail() 
		+ "', password='" + u.getPassword() + "', avatar='" 
		+ u.getAvatar() + "', isAdmin=" + u.getIsAdmin() 
		+ ", flagged=" + u.getFlagged() + ", createdTS=" + ", now() where id=" + u.getUser_id();
		return template.update(sql);
	}
	
	public int delete(int studentID){    
	    String sql="DELETE FROM user WHERE studentID="+studentID+"";    
	    return template.update(sql);    
	} 
	
	public List<User> getUserById(int id){
		return template.query("select * from user where id="+id,new RowMapper<User>(){    
	        public User mapRow(ResultSet rs, int row) throws SQLException {
	            User u=new User();    
	            u.setUser_id(rs.getInt(1));    
	            u.setFirstName(rs.getString(2));    
	            u.setLastName(rs.getString(3));    
	            u.setStudentID(rs.getInt(4));  
	            u.setEmail(rs.getString(5));
	            u.setPassword(rs.getString(6));
	            u.setAvatar(rs.getString(7));
	            u.setIsAdmin(rs.getBoolean(8));	            
	            u.setFlagged(rs.getBoolean(9));
	            u.setCreatedTS(rs.getTimestamp(10));
	            return u; 
	            }
	    }); 
	}
	
	
	public List<User> getUser(){    
	    return template.query("SELECT id, firstName, lastName, studentID, email, password, avatar, isAdmin, flagged, createdTS FROM user",new RowMapper<User>(){    
	        public User mapRow(ResultSet rs, int row) throws SQLException {    
	            User u=new User();    
	            u.setUser_id(rs.getInt(1));    
	            u.setFirstName(rs.getString(2));    
	            u.setLastName(rs.getString(3));    
	            u.setStudentID(rs.getInt(4));  
	            u.setEmail(rs.getString(5));
	            u.setPassword(rs.getString(6));
	            u.setAvatar(rs.getString(7));
	            u.setIsAdmin(rs.getBoolean(8));	            
	            u.setFlagged(rs.getBoolean(9));
	            u.setCreatedTS(rs.getTimestamp(10));
	            return u;    
	        }    
	    });
	}
	
	public User getUserByNameAndPassword(String userName, String password)
	{
	  	try
	  	{
	  		String sql="select * from user where studentID=? and password=?";
			return template.queryForObject(sql,  new Object[] {userName, password}, new BeanPropertyRowMapper<User>(User.class));
	  	}
	  	catch (DataAccessException ex)
	  	{
	  		return null;
	  	}
	}
}
	