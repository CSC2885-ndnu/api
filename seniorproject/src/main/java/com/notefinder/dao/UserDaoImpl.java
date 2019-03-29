package com.notefinder.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.notefinder.models.User;

public class UserDaoImpl implements UserDao{
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(User u) {
		String sql = "insert into user(id,firstName,lastName,studentID,email,password,avatar,isAdmin,flagged,createdTS)"
			+ "values(" + u.getUser_id() + ",'" + u.getFirstName() + "','" + u.getLastName() 
			+ "'," + u.getStudentID() + ",'" + u.getEmail() +  "','" + u.getPassword()
			+ "','" + u.getAvatar() + "'," + u.getIsAdmin() + "," + u.getFlagged()
			+ "," + u.getIsLoggedIn() + ", now())";
				
		return template.update(sql);
	}
	
	public int update(User u) {
		String sql = "UPDATE user SET firstName='" + u.getFirstName() 
		+ "', lastName='" + u.getLastName() + "', studentID=" 
		+ u.getStudentID() + ", email='" + u.getEmail() 
		+ "', password='" + u.getPassword() + "', avatar='" 
		+ u.getAvatar() + "', isAdmin=" + u.getIsAdmin() 
		+ ", flagged=" + u.getFlagged() + ", isLoggedIn=" 
		+ u.getIsLoggedIn() + ", createdTS=" + ", now() where id=" + u.getUser_id();
		return template.update(sql);
	}
	
	public int delete(int studentID){    
	    String sql="DELETE FROM user WHERE studentID="+studentID+"";    
	    return template.update(sql);    
	} 
	
	public User getUserById(int studentID){
		String sql= "SELECT * FROM user WHERE studentID=?";
		return template.queryForObject(sql, new Object[]{studentID},new BeanPropertyRowMapper<User>(User.class));
	}
	
	
	public List<User> getUser(){    
	    return template.query("SELECT * FROM user",new RowMapper<User>(){    
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
	            u.setIsLoggedIn(rs.getBoolean(10));
	            u.setCreatedTS(rs.getTimestamp(11));
	            return u;    
	        }    
	    });

}
}
	