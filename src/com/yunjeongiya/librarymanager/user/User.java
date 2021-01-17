package com.yunjeongiya.librarymanager.user;

import com.yunjeongiya.librarymanager.book.Book;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class User {

    private UserAuth auth;
    private String name, phone, birth;
    private Set<Book> rentedBooks = new HashSet<>();

    private User(UserAuth auth, String name, String phone, String birth) {

        this.auth = auth;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
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

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirth() {
        return birth;
    }

    public boolean certificate(UserAuth auth) {

        return this.auth.equals(auth);
    }

    static class UserBuilder {

        private String id, pw, phone, birth, name;

        public UserBuilder id(String id) {
            this.id = id;
            return this;
        }

        public UserBuilder pass(String pw) {
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

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public User build() {

            UserAuth auth = new UserAuth(id, pw);
            return new User(auth, name, phone, birth);
        }
    }
}