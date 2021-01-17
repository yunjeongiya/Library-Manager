package Library;

public class Book {
    private String name, genre;

    public Book(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return name + " " + genre;
    }
}