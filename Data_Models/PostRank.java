public class PostRank {

    // Variables
    private Post post_id;
    private User flagger;
    private int rank;

    // Constructor
    public PostRank(Post post_id, User flagger, int rank) {
        this.post_id = post_id;
        this.flagger = flagger;
        this.rank = rank;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    // toString for all Variables
    @Override
    public String toString() {
        return "PostRank{" +
                "post_id=" + post_id +
                ", flagger=" + flagger +
                ", rank=" + rank +
                '}';
    }
}
