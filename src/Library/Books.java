package Library;

import java.io.*;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.util.*;

public class Books {
    Map<String, BookInfo> bookMap = new HashMap<>();

    public Collection<BookInfo> listBooks() {
        return bookMap.values();
    }

    public Collection<BookInfo> searchBook(String search) {
        List<BookInfo> ret = new ArrayList<>();

        for (BookInfo b : listBooks()) {
            if (b.getName().contains(search))
                ret.add(b);
        }
        return ret;
    }

    public void loadBooks() throws FileNotFoundException, IOException {
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
            BookInfo info = new BookInfo(book, num);
            bookMap.put(name, info);
            buff.close();
            reader.close();
        }
    }
}