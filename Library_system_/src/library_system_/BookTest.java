package library_system_;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Book class.
 */
public class BookTest {

    @Test
    public void testBookCreation() {
        Book book = new Book(1, "Clean Code", "Robert Martin");

        assertEquals(1, book.getId());
        assertEquals("Clean Code", book.getTitle());
        assertEquals("Robert Martin", book.getAuthor());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBookAvailabilityChange() {
        Book book = new Book(2, "Effective Java", "Joshua Bloch");

        book.setAvailable(false);
        assertFalse(book.isAvailable());

        book.setAvailable(true);
        assertTrue(book.isAvailable());
    }
}
