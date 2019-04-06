package com.notefinder.models;

enum Semester {
    spring, fall, summer1, summer2
}

public class Course {

    // Variables
    private int course_id;
    private int courseCode;
    private String department;
    private String courseName;
    private String courseDescription;
    private int section;
    private String courseSyllabus;
    private String semesterID;
    private String meetingDay;
	private int year;
    private String professor;
    private String link;


    // Getters & Setters
    public String getMeetingDay() {
		return meetingDay;
	}

	public void setMeetingDay(String meetingDay) {
		this.meetingDay = meetingDay;
	}
	
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int courseid) {
        this.course_id = courseid;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public String getCourseSyllabus() {
        return courseSyllabus;
    }

    public void setCourseSyllabus(String courseSyllabus) {
        this.courseSyllabus = courseSyllabus;
    }

    public String getSemester() {
        return semesterID;
    }

    public void setSemester(String semester) {
        this.semesterID = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    // toString for all Variables
    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", courseCode=" + courseCode +
                ", department='" + department + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", section=" + section +
                ", courseSyllabus='" + courseSyllabus + '\'' +
                ", semester=" + semesterID +
                ", year=" + year +
                ", professor='" + professor + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}