package library_system_;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryManagerTest {

    @Test
    public void testBorrowBook() {
        LibraryManager library = new LibraryManager();
        Book book = new Book(1, "Clean Code", "Robert Martin");
        Member member = new Member(1, "Ahmed");

        library.addBook(book);

        boolean borrowed = library.borrowBook(1, member);

        assertTrue(borrowed);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testReturnBook() {
        LibraryManager library = new LibraryManager();
        Book book = new Book(2, "Effective Java", "Joshua Bloch");
        Member member = new Member(2, "Sara");

        library.addBook(book);
        library.borrowBook(2, member);

        boolean returned = library.returnBook(2);

        assertTrue(returned);
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBorrowUnavailableBook() {
        LibraryManager library = new LibraryManager();
        Book book = new Book(3, "Design Patterns", "GoF");
        Member member = new Member(3, "Omar");

        library.addBook(book);
        library.borrowBook(3, member);

        // Try to borrow again
        boolean borrowedAgain = library.borrowBook(3, member);

        assertFalse(borrowedAgain);
    }
}
