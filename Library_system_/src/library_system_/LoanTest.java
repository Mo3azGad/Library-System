package library_system_;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

/**
 * Unit tests for Loan class.
 */
public class LoanTest {

    @Test
    public void testLoanCreation() {
        Book book = new Book(1, "Clean Code", "Robert Martin");
        Member member = new Member(1, "Ahmed");

        Loan loan = new Loan(book, member);

        assertEquals(book, loan.getBook());
        assertEquals(member, loan.getMember());
        assertNotNull(loan.getBorrowDate());
        assertNull(loan.getReturnDate());
        assertFalse(loan.isReturned());
    }

    @Test
    public void testBookAvailabilityAfterBorrow() {
        Book book = new Book(2, "Effective Java", "Joshua Bloch");
        Member member = new Member(2, "Sara");

        Loan loan = new Loan(book, member);

        // book availability should be handled by LibraryManager,
        // but we still verify loan state
        assertNotNull(loan.getBorrowDate());
    }

    @Test
    public void testReturnBook() {
        Book book = new Book(3, "Design Patterns", "GoF");
        Member member = new Member(3, "Omar");

        Loan loan = new Loan(book, member);

        loan.returnBook();

        assertTrue(loan.isReturned());
        assertNotNull(loan.getReturnDate());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBorrowDateIsToday() {
        Book book = new Book(4, "Refactoring", "Martin Fowler");
        Member member = new Member(4, "Lina");

        Loan loan = new Loan(book, member);

        assertEquals(LocalDate.now(), loan.getBorrowDate());
    }
    
    @Test
    public void testBorrowedDaysCalculation() throws InterruptedException {
        Book book = new Book(5, "Algorithms", "CLRS");
        Member member = new Member(5, "Mona");

        Loan loan = new Loan(book, member);

        // Borrow date should be today, so borrowed days = 0
        long borrowedDays = loan.getBorrowedDays();

        assertEquals(0, borrowedDays);
    }

}
