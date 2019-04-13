package com.notefinder.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notefinder.dao.RecentSubmissionsDao;
import com.notefinder.models.RecentSubmission;

@Service("recentSubmissionsManager")
public class RecentSubmissionsManagerImpl implements RecentSubmissionsManager {
	
	@Autowired
	RecentSubmissionsDao dao;
	public List<RecentSubmission> getRecentSubmissions(int id) {
		return dao.getRecentSubmissions(id);
	}
}
