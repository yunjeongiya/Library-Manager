package Library;

public class BookInfo {
    //책 이름과 장르
    private Book book;
    private int num; //재고


    public BookInfo(Book book, int left) {
        this.book = book;
        this.num = left;
    }

    public boolean borrowBook(User user) {
        if (num <= 0)
            return false;
        if (!user.borrowBook(book))
            return false;
        num--;
        return true;
    }

    public boolean returnBook(User user) {
        if (!user.returnBook(book))
            return false;
        num++;
        return true;
    }

    public String getName() {
        return book.toString();
    }

    @Override
    public String toString() {
        return book.toString() + " (" + num + ")";
    }
}
