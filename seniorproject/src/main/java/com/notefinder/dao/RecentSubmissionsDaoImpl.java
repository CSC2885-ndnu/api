package com.notefinder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.notefinder.models.RecentSubmission;

public class RecentSubmissionsDaoImpl implements RecentSubmissionsDao{
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<RecentSubmission> getRecentSubmissions(int id){
		return template.query("SELECT p.id as id,c.name as submission_course_name, p.title as submission_title, p.postDate as submission_date,c.meetingDay as submission_time_class_meets,p.note as submission_notes,a.link as submission_link,pf.active AS submission_flag FROM post p JOIN course c on p.courseID = c.id join attachments a on p.id = a.postID JOIN post_flag pf on p.id = pf.postID where userID = " + id + " order by postDate desc",new RowMapper<RecentSubmission>(){    
	        public RecentSubmission mapRow(ResultSet rs, int row) throws SQLException {    
	        	RecentSubmission p=new RecentSubmission(); 
	        	p.setPostId(rs.getInt(1));
	        	p.setSubmission_course_name(rs.getString(2));
	        	p.setSubmission_title(rs.getString(3));
	        	p.setSubmission_date(rs.getString(4));
	        	p.setSubmission_time_class_meets(rs.getString(5));
	        	p.setSubmission_notes(rs.getString(6));
	        	p.setSubmission_link(rs.getString(7));
	        	p.setSubmission_flag(rs.getString(8));
	            return p;    
	        }    
	    });
	}
}
