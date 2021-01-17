package GUI;

import Library.User;

import javax.swing.*;

public abstract class UserUI extends JFrame {
    protected User user;
    protected UIMediator mediator;

    public UserUI(User user, UIMediator mediator) {
        this.user = user;
        this.mediator = mediator;
    }
}