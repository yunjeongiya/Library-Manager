package GUI;

import Library.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUI extends JFrame {
    private JPanel register;
    private JTextField idField;
    private JTextField pwField;
    private JTextField birthField;
    private JTextField phoneField;
    private JLabel idLabel;
    private JLabel pwLabel;
    private JLabel birthLabel;
    private JLabel phoneLabel;
    private JButton registerButton;

    private Users users;
    private UIMediator mediator;

    public RegisterUI(Users users, UIMediator mediator) {
        this.mediator = mediator;
        this.users = users;
        add(register);
        setSize(450, 200);
        setTitle("회원가입");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerButton.addActionListener(e -> {
            String id = idField.getText();
            String pw = pwField.getText();
            String birth = birthField.getText();
            String phone = phoneField.getText();
            boolean result = users.register(id, pw, birth, phone);
            if (!result) {
                JOptionPane.showMessageDialog(null,
                        "이미 존재하는 아이디입니다.");
                return;
            }
            JOptionPane.showMessageDialog(null,
                    "회원가입이 성공적으로 완료되었습니다");
            idField.setText("");
            pwField.setText("");
            birthField.setText("");
            phoneField.setText("");
            setVisible(false);
            mediator.openMainUI();
        });
    }
}