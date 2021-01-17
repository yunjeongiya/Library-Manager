package com.yunjeongiya.librarymanager.user;

import java.util.HashMap;
import java.util.Map;

public class AuthManager {

    private final static String ADMIN_ID = "Admin",
                                ADMIN_PHONE_NUMBER = "000-000-000",
                                ADMIN_BIRTH = "0000-00-00",
                                ADMIN_NAME = "관리자",
                                ADMIN_PASSWORD = "202010655";


    Map<String, User> userMap = new HashMap<>();

    public AuthManager() {

        User admin = new User.UserBuilder().birth(ADMIN_BIRTH).id(ADMIN_ID)
                .phone(ADMIN_PHONE_NUMBER).pass(ADMIN_PASSWORD).name(ADMIN_NAME).build();

        userMap.put(ADMIN_ID, admin);

    }


    public boolean register(String id, String pw, String birth, String phone) {

        if (userMap.containsKey(id))
            return false;

        User user = new User.UserBuilder().id(id).pass(pw)
                .birth(birth).phone(phone).build();
        userMap.put(id, user);
        return true;
    }

    public User findUser(UserAuth auth) {

        User user = userMap.get(auth.getId());

        if (user != null && user.certificate(auth))
            return user;

        return null;
    }
}