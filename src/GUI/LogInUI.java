package GUI;

import Library.Main;
import Library.User;
import Library.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInUI extends JFrame {
    private JPanel logIn;
    private JButton loginBtn;
    private JTextField idField;
    private JLabel pwLabel;
    private JLabel idLabel;
    private JPasswordField pwField;
    private Users users;
    private UIMediator mediator;

    public LogInUI(Users user, UIMediator mediator) {
        this.users = user;
        this.mediator = mediator;
        add(logIn);
        setTitle("로그인 화면");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        loginBtn.addActionListener((e) -> {
            boolean success = users.logIn(idField.getText(), new String(pwField.getPassword()));

            if (!success) {
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