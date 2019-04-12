import java.sql.Timestamp;

public class PostFlag {
//EDIT: ~March 1st~ I am going to edit the variables name to match new database names.
    
    // Variables
    private int postID;
    private int flagger;
    private String notes;
    private Timestamp flagDate;
    private boolean active; //in the Database, this is a BIT value. If this fails, change database to Bool.

    // Constructor
    public PostFlag(int postID, int flagger, String notes, Timestamp flagDate, boolean active) {
        this.postID = postID;
        this.flagger = flagger;
        this.notes = notes;
        this.flagDate = flagDate;
        this.active = active;
    }

    // Getters & Setters
    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
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

    public Timestamp getflagDate() {
        return flagDate;
    }

    public void setflagDate(Timestamp flagDate) {
        this.flagDate = flagDate;
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
                "postID=" + postID +
                ", flagger=" + flagger +
                ", notes='" + notes + '\'' +
                ", flagDate=" + flagDate +
                ", active=" + active +
                '}';
    }
}
