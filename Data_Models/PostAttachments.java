
enum Type {

}

public class PostAttachments {

    // Variables
    private int attachments_id;
    private Post post_id;
    private String link;
    private Type type;

    // Constructor
    public PostAttachments(int attachments_id, Post post_id, String link, Type type) {
        this.attachments_id = attachments_id;
        this.post_id = post_id;
        this.link = link;
        this.type = type;
    }

    // Getters & Setters
    public int getAttachments_id() {
        return attachments_id;
    }

    public void setAttachments_id(int attachments_id) {
        this.attachments_id = attachments_id;
    }

    public Post getPost_id() {
        return post_id;
    }

    public void setPost_id(Post post_id) {
        this.post_id = post_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    // toString for all Variables
    @Override
    public String toString() {
        return "PostAttachments{" +
                "attachments_id=" + attachments_id +
                ", post_id=" + post_id +
                ", link='" + link + '\'' +
                ", type=" + type +
                '}';
    }
}
