import java.sql.Timestamp;

public class PostFlag {

    // Variables
    private Post post_id;
    private User flagger;
    private String notes;
    private Timestamp date;
    private boolean active;

    // Constructor
    public PostFlag(Post post_id, User flagger, String notes, Timestamp date, boolean active) {
        this.post_id = post_id;
        this.flagger = flagger;
        this.notes = notes;
        this.date = date;
        this.active = active;
    }

    // Getters & Setters
    public Post getPost_id() {
        return post_id;
    }

    public void setPost_id(Post post_id) {
        this.post_id = post_id;
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
        return "PostFlag{" +
                "post_id=" + post_id +
                ", flagger=" + flagger +
                ", notes='" + notes + '\'' +
                ", date=" + date +
                ", active=" + active +
                '}';
    }
}
