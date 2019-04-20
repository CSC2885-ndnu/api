package com.notefinder.service;
import java.util.List;
import com.notefinder.models.RecentSubmission;

public interface RecentSubmissionsManager {
	public List<RecentSubmission> getRecentSubmissions(int id);
}
