package com.yunjeongiya.librarymanager.book;

import java.io.*;
import java.util.*;

public class BookRepository {

    public BookRepository() {

        try {
            loadBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Map<String, BookStock> bookMap = new HashMap<>();

    public Collection<BookStock> listBooks() {
        return bookMap.values();
    }

    public Collection<BookStock> searchBook(String search) {
        List<BookStock> ret = new ArrayList<>();

        for (BookStock b : listBooks()) {
            if (b.getName().contains(search))
                ret.add(b);
        }
        return ret;
    }

    private void loadBooks() throws FileNotFoundException, IOException {
        File dir = new File("books");

        //name, genre, num
        if (!dir.exists())
            dir.mkdir();
        for (File f : Objects.requireNonNull(dir.listFiles())) {
            if (!f.getName().endsWith(".dat"))
                continue;

            FileReader reader = new FileReader(f);
            BufferedReader buff = new BufferedReader(reader);
            String name = buff.readLine();
            String genre = buff.readLine();
            String numStr = buff.readLine();

            if (name == null || genre == null || numStr == null)
                continue;

            int num = 1;

            try {
                num = Integer.parseInt(numStr);
            } catch (NumberFormatException ignored) {
            }

            Book book = new Book(name, genre);
            BookStock info = new BookStock(book, num);
            bookMap.put(name, info);
            buff.close();
            reader.close();
        }
    }
}