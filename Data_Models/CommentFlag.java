import java.sql.Timestamp;

public class CommentFlag {

    // Variables
    private Comment comment_id;
    private User flagger;
    private String notes;
    private Timestamp date;
    private boolean active;

    // Constructor
    public CommentFlag(Comment comment_id, User flagger, String notes, Timestamp date, boolean active) {
        this.comment_id = comment_id;
        this.flagger = flagger;
        this.notes = notes;
        this.date = date;
        this.active = active;
    }

    // Getters & Setters
    public Comment getComment_id() {
        return comment_id;
    }

    public void setComment_id(Comment comment_id) {
        this.comment_id = comment_id;
    }

    public User getFlagger() {
        return flagger;
    }

    public void setFlagger(User flagger) {
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
