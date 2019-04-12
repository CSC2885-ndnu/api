package com.notefinder.models;

import java.sql.Timestamp;

public class User {

    // Variables
    private int user_id;
    private String firstName;
    private String lastName;
    private int studentID;
    private String email;
    private String password;
    private String avatar;
    private boolean isAdmin;
    private boolean flagged;
    private Timestamp createdTS;


    // Getters & Setters
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean getFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public Timestamp getCreatedTS() {
        return createdTS;
    }

    public void setCreatedTS(Timestamp createdTS) {
        this.createdTS = createdTS;
    }

    // toString for all Variables
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentID=" + studentID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", isAdmin=" + isAdmin +
                ", flagged=" + flagged +
                ", createdTS=" + createdTS +
                '}';
    }
}