package com.notefinder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.notefinder.models.RecentSubmission;
import com.notefinder.service.RecentSubmissionsManager;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RecentSubmissionsController {
	@Autowired
	RecentSubmissionsManager manager;

	@RequestMapping(value = "/recentSubmissions/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecentSubmission>> getRecentSubmissions(@PathVariable("id") int id) {
		System.out.println("Fetching Recent Subs with User " + id);
		List<RecentSubmission> subs = manager.getRecentSubmissions(id);
		if (subs == null) {
			System.out.println("Recent Subs from User:  " + id + " not found");
			return new ResponseEntity<List<RecentSubmission>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<RecentSubmission>>(subs, HttpStatus.OK);
	}
}
