import java.sql.Timestamp;

public class Comment {

    // Variables
    private int comment_id;
    private Post post_id;
    private User user_id;
    private Timestamp created_ts;
    private Timestamp modified;
    private String comment;
    private boolean flagged;

    // Constructor
    public Comment(int comment_id, Post post_id, User user_id, Timestamp created_ts, Timestamp modified, String comment, boolean flagged) {
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.user_id = user_id;
        this.created_ts = created_ts;
        this.modified = modified;
        this.comment = comment;
        this.flagged = flagged;
    }

    // Getters & Setters
    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public Post getPost_id() {
        return post_id;
    }

    public void setPost_id(Post post_id) {
        this.post_id = post_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Timestamp getCreated_ts() {
        return created_ts;
    }

    public void setCreated_ts(Timestamp created_ts) {
        this.created_ts = created_ts;
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

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    // toString for all Variables
    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", post_id=" + post_id +
                ", user_id=" + user_id +
                ", created_ts=" + created_ts +
                ", modified=" + modified +
                ", comment='" + comment + '\'' +
                ", flagged=" + flagged +
                '}';
    }
}
