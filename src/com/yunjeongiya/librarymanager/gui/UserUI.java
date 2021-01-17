package com.yunjeongiya.librarymanager.gui;

import com.yunjeongiya.librarymanager.user.UserSession;

import javax.swing.*;

public abstract class UserUI extends JFrame {
    protected UserSession session;
    protected GUIHandler mediator;

    public UserUI(UserSession user, GUIHandler mediator) {
        this.session = user;
        this.mediator = mediator;
    }
}