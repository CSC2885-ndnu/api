package com.notefinder.models;

public class RecentSubmission {
	
	private int postId;
	private String submission_course_name;
	private String submission_title;
	private String submission_date;
	private String submission_time_class_meets;
	private String submission_notes;
	private String submission_link;
	private String submission_flag;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getSubmission_course_name() {
		return submission_course_name;
	}
	public void setSubmission_course_name(String submission_course_name) {
		this.submission_course_name = submission_course_name;
	}
	public String getSubmission_title() {
		return submission_title;
	}
	public void setSubmission_title(String submission_title) {
		this.submission_title = submission_title;
	}
	public String getSubmission_date() {
		return submission_date;
	}
	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	public String getSubmission_time_class_meets() {
		return submission_time_class_meets;
	}
	public void setSubmission_time_class_meets(String submission_time_class_meets) {
		this.submission_time_class_meets = submission_time_class_meets;
	}
	public String getSubmission_notes() {
		return submission_notes;
	}
	public void setSubmission_notes(String submission_notes) {
		this.submission_notes = submission_notes;
	}
	public String getSubmission_link() {
		return submission_link;
	}
	public void setSubmission_link(String submission_link) {
		this.submission_link = submission_link;
	}
	public String getSubmission_flag() {
		return submission_flag;
	}
	public void setSubmission_flag(String submission_flag) {
		this.submission_flag = submission_flag;
	}
}
