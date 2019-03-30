package com.notefinder.dao;

import java.util.List;
import com.notefinder.models.Course; 

public interface CourseDao {
	public int save(Course p);
	public int update(Course p);
	public int delete(int id);
	public List<Course> getCourseById(int id);
	public List<Course> getCourse();
}
