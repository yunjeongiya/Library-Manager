package com.yunjeongiya.librarymanager.user;

public class UserAuth {

    private String id;

    private String password;

    public UserAuth(String id, String password) {

        this.id = id;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof UserAuth))
            return false;
        UserAuth compare = (UserAuth) obj;
        return this.id.equals(compare.id) && this.password.equals(compare.password);
    }

    public String getId() {

        return this.id;
    }
}
