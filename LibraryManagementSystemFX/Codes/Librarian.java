import java.util.ArrayList;
import java.util.List;

public class Librarian extends Member {
    private static List<Librarian> librarianList = new ArrayList<>();

    public Librarian(String firstName, String lastName, String libraryId, String password) {
        super(firstName, lastName, libraryId, password);
    }

    public static List<Librarian> getLibrarianList() {
        return librarianList;
    }
}
