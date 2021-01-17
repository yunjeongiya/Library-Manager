package Library;

public class UserManager {
    private User user;

    public void loginWith(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public boolean isLoggedIn() {
        return (user != null);
    }

    public void logOut() {
        this.user = null;
    }
}