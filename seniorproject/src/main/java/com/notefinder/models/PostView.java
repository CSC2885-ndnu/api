package com.notefinder.models;

import java.sql.Timestamp;
import java.util.List;
import com.notefinder.models.CommentPostView;

public class PostView {
	
	private int id;
	private String title;
	private String course_name;
	private String class_date;
	private Timestamp post_created_date;
	private String note;
	private String user;
	private List<CommentPostView> commentList;
	
	public List<CommentPostView> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<CommentPostView> commentList) {
		this.commentList = commentList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getClass_date() {
		return class_date;
	}
	public void setClass_date(String class_date) {
		this.class_date = class_date;
	}
	public Timestamp getPost_created_date() {
		return post_created_date;
	}
	public void setPost_created_date(Timestamp post_created_date) {
		this.post_created_date = post_created_date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	

}
