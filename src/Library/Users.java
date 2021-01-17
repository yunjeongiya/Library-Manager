package Library;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Users {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    LinkedList<User> userList = new LinkedList<>();
    UserManager manager;

    public Users(UserManager manager) {
        //관리자 계정 정보
        this.manager = manager;
        User admin = new User.UserBuilder().admin().birth("0000-00-00").id("Admin")
                .phone("000-0000-0000").pw("2019203006").name("관리자").build();
        userList.add(admin);
    }

    private User readUser(String id) {
        User userInfo = null;

        for (User e : userList) {
            if (e.getId().equals(id)) {
                userInfo = e;
                break;
            }
        }

        return userInfo;
    }

    public boolean register(String id, String pw, String birth, String phone) {
        if (readUser(id) != null)
            return false;

        User user = new User.UserBuilder().id(id).pw(pw)
                .birth(birth).phone(phone).build();
        userList.add(user);
        return true;
    }

    public boolean logIn(String id, String pw) {
        User user = readUser(id);

        if (user != null) {
            if (user.getPw().equals(pw)) {
                manager.loginWith(user);
                return true;
            }
        }
        return false;
    }
}