package com.notefinder.models;

import java.sql.Timestamp;

public class CommentFlag {

    // Variables
	private int id;
    private int comment_id;
    private int flagger;
    private String notes;
    private Timestamp date;
    private boolean active;

    // Getters & Setters
    
    public int getComment_id() {
        return comment_id;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getFlagger() {
        return flagger;
    }

    public void setFlagger(int flagger) {
        this.flagger = flagger;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // toString for all Variables
    @Override
    public String toString() {
        return "CommentFlag{" +
                "comment_id=" + comment_id +
                ", flagger=" + flagger +
                ", notes='" + notes + '\'' +
                ", date=" + date +
                ", active=" + active +
                '}';
    }
}
