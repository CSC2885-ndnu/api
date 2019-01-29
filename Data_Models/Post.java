import java.sql.Timestamp;


public class Post {


    private int post_id;
    private String title;
    private Course course;
    private Timestamp class_date;
    private Timestamp postDate;
    private String note;
    private User user;
    private boolean flagged;

    public Post(int post_id, String title, Course course, Timestamp class_date, Timestamp postDate, String note, User user, boolean flagged) {
        this.post_id = post_id;
        this.title = title;
        this.course = course;
        this.class_date = class_date;
        this.postDate = postDate;
        this.note = note;
        this.user = user;
        this.flagged = flagged;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int postid) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Timestamp getClass_date() {
        return class_date;
    }

    public void setClass_date(Timestamp class_date) {
        this.class_date = class_date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                "post_id=" + post_id +
                ", title='" + title + '\'' +
                ", course=" + course +
                ", class_date=" + class_date +
                ", postDate=" + postDate +
                ", note='" + note + '\'' +
                ", user=" + user +
                ", flagged=" + flagged +
                '}';
    }
}
