package com.notefinder.dao;

import java.util.List;
import com.notefinder.models.Enrolled;
import com.notefinder.models.EnrolledAdmin;

public interface EnrolledDao {
	public int save(Enrolled e);
	public int delete(int courseID, int userID);
	public List<Enrolled> getEnrolled();
	public List<EnrolledAdmin> getEnrolledForAdmin(int id);

}
