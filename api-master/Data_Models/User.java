import java.sql.Timestamp;

public class User {

    // Variables
    private int user_id;
    private String firstName;
    private String lastName;
    private int student_id;
    private String email;
    private String password;
    private String avatar;
    private boolean is_admin;
    private boolean flagged;
    private boolean isLoggedIn;
    private Timestamp created_ts;

    // Constructor
    public User(int user_id, String firstName, String lastName, int student_id, String email, String password, String avatar, boolean is_admin, boolean flagged, boolean isLoggedIn, Timestamp created_ts) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.student_id = student_id;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.is_admin = is_admin;
        this.flagged = flagged;
        this.isLoggedIn = isLoggedIn;
        this.created_ts = created_ts;
    }

    // Getters & Setters
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public Timestamp getCreated_ts() {
        return created_ts;
    }

    public void setCreated_ts(Timestamp created_ts) {
        this.created_ts = created_ts;
    }

    // toString for all Variables
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", student_id=" + student_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", is_admin=" + is_admin +
                ", flagged=" + flagged +
                ", isLoggedIn=" + isLoggedIn +
                ", created_ts=" + created_ts +
                '}';
    }
}
