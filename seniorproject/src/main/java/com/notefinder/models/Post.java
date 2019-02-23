package com.notefinder.models;

import java.sql.Timestamp;


public class Post {


    private int id;
    private String title;
    private int courseID;
    private Timestamp classDate;
    private Timestamp postDate;
    private String note;
    private int userID;
    private boolean flagged;

//    public Post(int post_id, String title, Course course, Timestamp class_date, Timestamp postDate, String note, User user, boolean flagged) {
//        this.post_id = post_id;
//        this.title = title;
//        this.course = course;
//        this.class_date = class_date;
//        this.post_date = postDate;
//        this.note = note;
//        this.user = user;
//        this.flagged = flagged;
//    }

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

    public Timestamp getClassDate() {
        return classDate;
    }

    public void setClassDate(Timestamp class_date) {
        this.classDate = class_date;
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
                ", class_date=" + classDate +
                ", postDate=" + postDate +
                ", note='" + note + '\'' +
                ", user=" + userID +
                ", flagged=" + flagged +
                '}';
    }
}
