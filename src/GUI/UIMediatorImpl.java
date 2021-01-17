package GUI;

import Library.Books;
import Library.User;
import Library.UserManager;
import Library.Users;

public class UIMediatorImpl implements UIMediator {

    private UserManager manager;
    private Users users;
    private MainUI mainUI;
    private RegisterUI registerUI;
    private LogInUI logInUI;
    private UserUI userUI;
    private Books books;

    public UIMediatorImpl() {
        manager = new UserManager();
        this.users = new Users(manager);
        mainUI = new MainUI(this);
        registerUI = new RegisterUI(users, this);
        logInUI = new LogInUI(users, this);
        this.books = new Books();

        try {
            books.loadBooks();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void openSearchUI() {
        SearchBook ui = new SearchBook(manager.getUser(), books, this);
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
        User user = manager.getUser();
        if (userUI == null)
            userUI = makeUserUI(user);
        userUI.setVisible(true);
    }

    private UserUI makeUserUI(User user) {
        return new GeneralUser(user, this);
    }

    @Override
    public void logOut() {
        manager.logOut();
        userUI = null;
        openMainUI();
    }
}
