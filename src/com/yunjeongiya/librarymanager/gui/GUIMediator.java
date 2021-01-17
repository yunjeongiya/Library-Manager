package com.yunjeongiya.librarymanager.gui;

import com.yunjeongiya.librarymanager.book.BookRepository;
import com.yunjeongiya.librarymanager.user.AuthManager;
import com.yunjeongiya.librarymanager.user.UserSession;

import javax.swing.*;

public class GUIMediator implements GUIHandler {

    private AuthManager authManager;
    private UserSession session;
    private BookRepository bookRepository;
    private JFrame mainUI;
    private JFrame registerUI;
    private JFrame logInUI;
    private JFrame userUI;


    public GUIMediator(UserSession session, BookRepository bookRepo, AuthManager authManager) {

        this.authManager = authManager;
        this.session = session;
        this.bookRepository = bookRepo;
        mainUI = new MainUI(this);
        registerUI = new RegisterUI(authManager, this);
        logInUI = new LogInUI(authManager, session, this);

    }

    @Override
    public void openSearchUI() {

        SearchBookUI ui = new SearchBookUI(session.getUser(), bookRepository, this);
        ui.setVisible(true);
    }

    @Override
    public void openRegisterUI() {
        registerUI.setVisible(true);
    }

    @Override
    public void openLoginUI() {
        logInUI.setVisible(true);
    }

    @Override
    public void openMainUI() {
        mainUI.setVisible(true);
    }

    @Override
    public void openUserUI() {

        userUI = new GeneralUser(session, this);
        userUI.setVisible(true);
    }



}
