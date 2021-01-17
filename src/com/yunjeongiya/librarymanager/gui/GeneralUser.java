package com.yunjeongiya.librarymanager.gui;

import com.yunjeongiya.librarymanager.user.UserSession;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GeneralUser extends UserUI {

    private JPanel genUser;
    private JButton searchBtn;
    private JButton logoutBtn;
    private JLabel menu;

    public GeneralUser(UserSession session, GUIHandler mediator) {
        super(session, mediator);
        setTitle("회원 메뉴");
        add(genUser);
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        searchBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mediator.openSearchUI();
                setVisible(false);
            }
        });

        logoutBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                session.logout();
                mediator.openMainUI();
                setVisible(false);
            }
        });
    }
}