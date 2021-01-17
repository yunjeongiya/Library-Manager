package GUI;

import Library.Book;
import Library.BookInfo;
import Library.Books;
import Library.User;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class SearchBook extends JFrame {
    private JPanel searchBook;
    private JButton backBtn;
    private JList<BookInfo> bookList;
    private JTextField bookNameField;
    private JButton borrowBtn;
    private JButton searchBtn;
    private JButton returnBtn;
    private JScrollPane bookPane;
    private JList<Book> list1;
    private Books books;
    private UIMediator mediator;
    private User user;

    public SearchBook(User user, Books books, UIMediator mediator) {
        this.user = user;
        add(searchBook);
        setTitle("도서 검색");
        setSize(500, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.books = books;
        this.mediator = mediator;
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Vector<BookInfo> v = new Vector();
        v.addAll(books.listBooks());
        bookList.setListData(v);
        updateUserBook();

        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mediator.openUserUI();
                setVisible(false);
            }
        });
        searchBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Vector<BookInfo> v = new Vector<>();
                v.addAll(books.searchBook(bookNameField.getText()));
                bookList.setListData(v);
            }
        });
        borrowBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BookInfo bookInfo = bookList.getSelectedValue();
                if (bookInfo == null)
                    return;
                boolean success = bookInfo.borrowBook(user);
                if (!success) {
                    JOptionPane.showMessageDialog(null,
                            "이미 대출했거나 재고가 없는 도서입니다.");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "성공적으로 대출하였습니다.");
                    updateUserBook();
                }
            }
        });
        returnBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BookInfo bookInfo = bookList.getSelectedValue();
                if (bookInfo == null)
                    return;
                boolean success = bookInfo.returnBook(user);
                if (!success) {
                    JOptionPane.showMessageDialog(null,
                            "대출하지 않은 도서입니다");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "성공적으로 반납하였습니다");
                    updateUserBook();
                }
            }
        });
    }

    private void updateUserBook() {
        Vector<Book> list = new Vector<>();
        list.addAll(user.listBook());
        list1.setListData(list);
    }
}