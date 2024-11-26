import java.util.ArrayList;
import java.util.List;

public class Book {
    private String name;
    private String isbn;
    private boolean available;
    private static List<Book> allBooksList = new ArrayList<>();

    public Book(String name, String isbn, boolean available) {
        this.name = name;
        this.isbn = isbn;
        this.available = available;
    }

    @Override
    public String toString() {
        if (available)
            return name + "  " + isbn + "  Available";
        return name + "  " + isbn + "  Not Available";
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static List<Book> getAllBooksList() {
        return allBooksList;
    }

    public static void addBook(Book b) {
        allBooksList.add(b);
    }

    public static void removeBook(Book b) {
        allBooksList.remove(b);
    }
}
