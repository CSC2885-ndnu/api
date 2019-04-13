package com.notefinder.service;

import java.util.List;

import com.notefinder.models.Enrolled;
import com.notefinder.models.EnrolledAdmin;

public interface EnrolledManager {
	public int save(Enrolled e);
	public int delete(int courseID, int userID);
	public List<Enrolled> getEnrolled();
	public List<EnrolledAdmin> getEnrolledForAdmin(int id);

}
