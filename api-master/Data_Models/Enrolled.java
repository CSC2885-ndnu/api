
public class Enrolled {

    // Variables
    private Course course_id;
    private User user_id;

    // Constructor
    public Enrolled(Course course_id, User user_id) {
        this.course_id = course_id;
        this.user_id = user_id;
    }

    // Getters & Setters
    public Course getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Course course_id) {
        this.course_id = course_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    // toString for all Variables
    @Override
    public String toString() {
        return "Enrolled{" +
                "course_id=" + course_id +
                ", user_id=" + user_id +
                '}';
    }
}
