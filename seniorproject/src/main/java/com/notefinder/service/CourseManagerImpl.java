package com.notefinder.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notefinder.dao.CourseDao;
import com.notefinder.models.Course;

@Service("courseManager")
public class CourseManagerImpl implements CourseManager {
	
	@Autowired
	CourseDao dao;
	
	public int save(Course p) {
		return dao.save(p);
	}
	
	public int update(Course p) {
		return dao.update(p);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}
	
	public List<Course> getCourseById(int id) {
		return dao.getCourseById(id);
	}
	
	public List<Course> getCourse() {
		return dao.getCourse();
	}

}
