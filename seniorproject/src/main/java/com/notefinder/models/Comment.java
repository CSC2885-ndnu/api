package com.notefinder.models;

import java.sql.Timestamp;
import com.notefinder.models.User;
import com.notefinder.models.Post;

public class Comment {

	private int id;
	private Post post;
	private User user;
	private Timestamp createdTS;
	private Timestamp modified;
	private String comment;
	private Boolean flagged;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreatedTS() {
		return createdTS;
	}

	public void setCreatedTS(Timestamp createdTS) {
		this.createdTS = createdTS;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getFlagged() {
		return flagged;
	}

	public void setFlagged(Boolean flagged) {
		this.flagged = flagged;
	}

}
