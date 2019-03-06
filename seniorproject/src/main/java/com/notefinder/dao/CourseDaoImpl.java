package com.notefinder.dao;

import java.sql.ResultSet;
    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.notefinder.models.Course;
import com.notefinder.models.Course;

 
public class CourseDaoImpl implements CourseDao
{
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Course p) {
		String sql = "insert into course(id,courseCode,dept,name,description,section,syllabus,semester,year,prof,link) values(" + p.getCourse_id() 
							+ "," + p.getCourseCode() + ",'" + p.getDepartment() + "','" + p.getCourseName()  + "','" 
									+ p.getCourseDescription() + "'," + p.getSection() + ",'" + p.getCourseSyllabus() + "','" + p.getSemester() + "'," + p.getYear() 
									+ ",'" + p.getProfessor() + "','" + p.getLink() + "')";
		return template.update(sql);
	}
	
	public int update(Course p) {
		String sql = "update course set courseCode=" + p.getCourseCode() + ", dept='" + p.getDepartment() + "', name='" 
						+ p.getCourseName() + "', description='" + p.getCourseDescription() + "', section=" + p.getSection() + ", syllabus='" 
							+ p.getCourseSyllabus() + "', semester='" + p.getSemester() + "', year=" + p.getYear() + ", prof='" + p.getProfessor() 
									+ "', link='" + p.getLink() + "' WHERE id=" + p.getCourse_id() ;
		return template.update(sql);
	}
	
	public int delete(int id){    
	    String sql="delete from course where id="+id+"";    
	    return template.update(sql);    
	} 
	
	public List<Course> getCourseById(int id){    
	    //String sql="select * from course where id="+ id;    
	    //return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<CourseId>(CourseId.class)); 
	    
	    return template.query("select * from course where id="+id,new RowMapper<Course>(){    
	        public Course mapRow(ResultSet rs, int row) throws SQLException {    
	            Course p=new Course();    
	            p.setCourse_id(rs.getInt(1));    
	            p.setCourseCode(rs.getInt(2));    
	            p.setDepartment(rs.getString(3));
	            p.setCourseName(rs.getString(4));
	            p.setCourseDescription(rs.getString(5));  
	            p.setSection(rs.getInt(6));
	            p.setCourseSyllabus(rs.getString(7));
	            p.setSemester(rs.getString(8));
	            p.setYear(rs.getInt(9));
	            p.setProfessor(rs.getString(10));
	            p.setLink(rs.getString(11));
	            return p;    
	        }    
	    }); 
	}
	
	public List<Course> getCourse(){    
	    return template.query("select * from course",new RowMapper<Course>(){    
	        public Course mapRow(ResultSet rs, int row) throws SQLException {    
	            Course p=new Course();    
	            p.setCourse_id(rs.getInt(1));    
	            p.setCourseCode(rs.getInt(2));    
	            p.setDepartment(rs.getString(3));
	            p.setCourseName(rs.getString(4));
	            p.setCourseDescription(rs.getString(5));  
	            p.setSection(rs.getInt(6));
	            p.setCourseSyllabus(rs.getString(7));
	            p.setSemester(rs.getString(8));
	            p.setYear(rs.getInt(9));
	            p.setProfessor(rs.getString(10));
	            p.setLink(rs.getString(11));
	            return p;    
	        }    
	    });    
	}
}