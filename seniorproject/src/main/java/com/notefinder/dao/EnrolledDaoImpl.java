package com.notefinder.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;
import com.notefinder.models.Enrolled;
import com.notefinder.models.EnrolledAdmin;

public class EnrolledDaoImpl implements EnrolledDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Enrolled e) {
		String sql = "insert into enrolled(courseID,userID) values(" + e.getCourseID() + "," + e.getUserID() + ")";
		return template.update(sql);
	}
	
	public int delete(int courseID, int userID) {
		String sql="delete from post where courseID="+courseID+" and userID="+userID+"";    
	    return template.update(sql); 
	}
	
	public List<Enrolled> getEnrolled() {
		return template.query("select courseID, userID from enrolled",new RowMapper<Enrolled>(){    
	        public Enrolled mapRow(ResultSet rs, int row) throws SQLException {    
	            Enrolled e=new Enrolled();    
	            e.setCourseID(rs.getInt(1));    
	            e.setUserID(rs.getInt(2));
	            return e;
	        }    
	    });
	}
	
	public List<EnrolledAdmin> getEnrolledForAdmin() {
		return template.query("select u.firstName, u.lastName, u.studentID from user u inner join enrolled e on u.user_id = e.userID inner join course c on e.courseID = c.course_id",new RowMapper<EnrolledAdmin>(){    
	        public EnrolledAdmin mapRow(ResultSet rs, int row) throws SQLException {    
	            EnrolledAdmin e=new EnrolledAdmin();    
	            e.setEnrolledFirstName(rs.getString(1));    
	            e.setEnrolledLastName(rs.getString(2));
	            e.setEnrolledStudentID(rs.getInt(3));
	            return e;
	        }    
	    });
	}
	
	

}
