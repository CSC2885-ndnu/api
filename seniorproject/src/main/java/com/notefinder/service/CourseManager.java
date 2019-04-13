package com.notefinder.service;

import java.util.List;
import com.notefinder.models.Course;
import com.notefinder.models.User;

public interface CourseManager {
	public int save(Course p);
	public int update(Course p);
	public int delete(int id);
	public List<Course> getCourseById(int id);
	public List<Course> getCourse();
	public List<Course> getUserCourses(int id);
	public List<User> getCourseStudents(int id);
}
