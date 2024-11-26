import java.time.LocalDateTime;
import java.util.*;

public class Borrow {
    private Member member;
    private Book book;
    private LocalDateTime borrowDateTime;
    private LocalDateTime borrowBackDateTime;

    private static List<Borrow> allPeopleWhoBorrowed = new ArrayList<>();

    public Borrow(Member member, Book book, LocalDateTime borrowDateTime) {
        this.member = member;
        this.book = book;
        this.borrowDateTime = borrowDateTime;
        this.borrowBackDateTime = null;
    }

    @Override
    public String toString() {
        if (borrowBackDateTime == null)
            return "(" + member + ")   (" + book + ")   (" + borrowDateTime + ")";
        return "(" + member + ")   (" + book + ")   (" + borrowDateTime + ")   (" + borrowBackDateTime + ")";
    }

    private void setBorrowBackDateTime(LocalDateTime borrowBackDateTime) {
        this.borrowBackDateTime = borrowBackDateTime;
    }

    public static List<Borrow> getAllPeopleWhoBorrowed() {
        return allPeopleWhoBorrowed;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public static void borrowBook(Member member, List<Book> booksList, Book selectedBook) {
        for (Book book : booksList) {
            if (selectedBook.getName().equals(book.getName()) && selectedBook.getIsbn().equals(book.getIsbn())) {
                book.setAvailable(false);
                allPeopleWhoBorrowed.add(new Borrow(member, book, LocalDateTime.now()));
                break;
            }
        }
    }

    public static void borrowBackBook(Member member, Book selectedBook) {
        for (Borrow borrow : allPeopleWhoBorrowed) {
            if (borrow.member == member && borrow.book == selectedBook && borrow.borrowBackDateTime == null) {
                borrow.setBorrowBackDateTime(LocalDateTime.now());
                selectedBook.setAvailable(true);
                break;
            }
        }
    }

    public static List<Book> booksOfAMember(Member member) {
        Set<Book> booksMember = new HashSet<>();

        for (Borrow borrow : allPeopleWhoBorrowed) {
            if (borrow.getMember() == member && !borrow.getBook().isAvailable() && borrow.borrowBackDateTime == null) {
                booksMember.add(borrow.getBook());
            }
        }

        List<Book> b = new ArrayList<>();
        b.addAll(booksMember);

        return b;
    }
}
