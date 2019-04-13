package com.notefinder.dao;
import java.util.List;

import com.notefinder.models.RecentSubmission;

public interface RecentSubmissionsDao {
	public List<RecentSubmission> getRecentSubmissions(int id);
}
