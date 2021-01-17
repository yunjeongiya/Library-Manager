package com.yunjeongiya.librarymanager.user;

public class UserSession {

    private User user;

    public boolean isValid() {

        return (user != null);
    }

    public void login(User user) {

        this.user = user;
    }

    public void logout() {

        this.user = null;
    }

    public User getUser() {
        return user;
    }
}
