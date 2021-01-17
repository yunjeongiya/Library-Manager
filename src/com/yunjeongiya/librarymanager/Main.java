package com.yunjeongiya.librarymanager;

import com.yunjeongiya.librarymanager.book.BookRepository;
import com.yunjeongiya.librarymanager.gui.GUIHandler;
import com.yunjeongiya.librarymanager.gui.GUIMediator;
import com.yunjeongiya.librarymanager.user.AuthManager;
import com.yunjeongiya.librarymanager.user.UserSession;

public class Main {
    public static void main(String[] args) {

        AuthManager authManager = new AuthManager();
        BookRepository repository = new BookRepository();
        UserSession session = new UserSession();
        GUIHandler mediator = new GUIMediator(session, repository, authManager);
        mediator.openMainUI();
    }
}