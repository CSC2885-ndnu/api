package com.notefinder.models;

import java.sql.Timestamp;


public class Post {

    private int id;
    private String title;
    private int courseID;
    private Timestamp postDate;
    private String note;
    private int userID;
    private boolean flagged;

    public int getId() {
        return id;
    }

    public void setId(int post_id) {
        this.id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", course=" + courseID +
                ", postDate=" + postDate +
                ", note='" + note + '\'' +
                ", user=" + userID +
                ", flagged=" + flagged +
                '}';
    }
}