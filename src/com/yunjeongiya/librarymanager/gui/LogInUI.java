package com.yunjeongiya.librarymanager.gui;

import com.yunjeongiya.librarymanager.user.AuthManager;
import com.yunjeongiya.librarymanager.user.User;
import com.yunjeongiya.librarymanager.user.UserAuth;
import com.yunjeongiya.librarymanager.user.UserSession;

import javax.swing.*;

public class LogInUI extends JFrame {
    private JPanel logIn;
    private JButton loginBtn;
    private JTextField idField;
    private JLabel pwLabel;
    private JLabel idLabel;
    private JPasswordField pwField;
    private AuthManager authManager;
    private UserSession session;
    private GUIHandler mediator;

    public LogInUI(AuthManager authManager, UserSession session, GUIHandler mediator) {
        this.authManager = authManager;
        this.session = session;
        this.mediator = mediator;
        add(logIn);
        setTitle("로그인 화면");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        loginBtn.addActionListener((e) -> {

            UserAuth auth = new UserAuth(idField.getText(), new String(pwField.getPassword()));

            User user = authManager.findUser(auth);

            session.login(user);

            if (!session.isValid()) {
                JOptionPane.showMessageDialog(null,
                        "아이디 혹은 비밀번호를 확인해주세요.");
                return;
            }
            idField.setText("");
            pwField.setText("");
            mediator.openUserUI();
            setVisible(false);
        });
    }
}