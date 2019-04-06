package com.notefinder.models;

public class Attachments {
	 private int id;
	    private int postId;
	    private String link;
	    private String type;


	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getPostId() {
	        return postId;
	    }

	    public void setPostId(int postId) {
	        this.postId = postId;
	    }

	    public String getLink() {
	        return link;
	    }

	    public void setLink(String link) {
	        this.link = link;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    @Override
	    public String toString() {
	        return "Attachment" +
	                "id=" + id +
	                ", post_id=" + postId + '\'' +
	                ", link=" + link +
	                ", type=" + type
	             	;
	    }

	}