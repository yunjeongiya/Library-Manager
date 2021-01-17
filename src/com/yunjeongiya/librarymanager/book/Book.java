package com.yunjeongiya.librarymanager.book;

public class Book {
    private String name, genre;

    public Book(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book))
            return false;
        Book compare = (Book) obj;
        return name.equals(compare.name) && genre.equals(compare.genre);
    }

    @Override
    public String toString() {
        return name + " " + genre;
    }
}