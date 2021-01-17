package Library;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class User {
    //유저 정보 세터/게터 클래스
    private String id, pw, name, phone, birth;
    private boolean isAdmin;
    private Set<Book> rentedBooks = new HashSet<>();

    private User(String id, String pw, String name, String phone, String birth, boolean isAdmin) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.isAdmin = isAdmin;
    }

    public boolean borrowBook(Book book) {
        if (rentedBooks.contains(book))
            return false;
        rentedBooks.add(book);
        return true;
    }

    public boolean returnBook(Book book) {
        return rentedBooks.remove(book);
    }

    public Collection<Book> listBook() {
        return rentedBooks;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    //게터
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return name + "\n" + id + "\n" + phone + "\n" + birth;
    }

    static class UserBuilder {
        private String id, pw, phone, birth, name;
        private boolean isAdmin = false;

        public UserBuilder id(String id) {
            this.id = id;
            return this;
        }

        public UserBuilder pw(String pw) {
            this.pw = pw;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder birth(String birth) {
            this.birth = birth;
            return this;
        }

        public UserBuilder admin() {
            this.isAdmin = true;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public User build() {
            return new User(id, pw, name, phone, birth, isAdmin);
        }
    }
}