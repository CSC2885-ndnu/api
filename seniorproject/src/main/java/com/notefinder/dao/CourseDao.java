package com.notefinder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.notefinder.dao.PostDaoImpl;
import com.notefinder.models.Course; 

public interface CourseDao {
	public int save(Course p);
	public int update(Course p);
	public int delete(int id);
	public List<Course> getCourseById(int id);
	public List<Course> getCourse();
}
