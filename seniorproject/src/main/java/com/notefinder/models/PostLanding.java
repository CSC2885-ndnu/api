package com.notefinder.models;

import java.sql.Timestamp;

public class PostLanding {

	private int id;
    private String submission_title;
    private String submission_course_name;
    private Timestamp submission_date;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubmission_title() {
		return submission_title;
	}
	public void setSubmission_title(String submission_title) {
		this.submission_title = submission_title;
	}
	public String getSubmission_course_name() {
		return submission_course_name;
	}
	public void setSubmission_course_name(String submission_course_name) {
		this.submission_course_name = submission_course_name;
	}
	public Timestamp getSubmission_date() {
		return submission_date;
	}
	public void setSubmission_date(Timestamp submission_date) {
		this.submission_date = submission_date;
	}
}
