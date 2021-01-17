package com.yunjeongiya.librarymanager.gui;

import javax.swing.*;

public class MainUI extends JFrame {
    private JButton loginBtn;
    private JPanel menu;
    private JButton registerBtn;
    private JLabel mainLabel;

    private GUIHandler mediator;

    public MainUI(GUIHandler mediator) {
        this.mediator = mediator;
        add(menu);
        setTitle("도서관 관리 프로그램");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginBtn.addActionListener(e -> {
            mediator.openLoginUI();
            dispose();
        });
        registerBtn.addActionListener(e -> {
            mediator.openRegisterUI();
            dispose();
        });
    }
}