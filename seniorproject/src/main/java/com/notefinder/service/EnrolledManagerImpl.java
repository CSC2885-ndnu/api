package com.notefinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.notefinder.dao.EnrolledDao;
import com.notefinder.models.Enrolled;
import com.notefinder.models.EnrolledAdmin;

@Service("enrolledManager")
public class EnrolledManagerImpl implements EnrolledManager {
	
	@Autowired
	EnrolledDao dao;
	
	public int save(Enrolled e) {
		return dao.save(e);
	}
	
	public int delete(int courseID, int userID) {
		return dao.delete(courseID, userID);
	}
	
	public List<Enrolled> getEnrolled() {
		return dao.getEnrolled();
	}
	
	public List<EnrolledAdmin> getEnrolledForAdmin(int id) {
		return dao.getEnrolledForAdmin(id);
	}

}
