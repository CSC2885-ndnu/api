public class CommentRank {

    // Variables
    private Comment comment_id;
    private User flagger;
    private int rank;

    // Constructor
    public CommentRank(Comment comment_id, User flagger, int rank) {
        this.comment_id = comment_id;
        this.flagger = flagger;
        this.rank = rank;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    // toString for all Variables

    @Override
    public String toString() {
        return "CommentRank{" +
                "comment_id=" + comment_id +
                ", flagger=" + flagger +
                ", rank=" + rank +
                '}';
    }
}
