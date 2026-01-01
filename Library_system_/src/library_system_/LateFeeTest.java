package library_system_;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

/**
 * Unit tests for late fee calculation.
 */
public class LateFeeTest {

    @Test
    public void testLateFeeForRegularMember() {
        LibraryManager library = new LibraryManager();
        Book book = new Book(10, "Databases", "Elmasri");
        Member member = new Member(100, "Ahmed");

        library.addBook(book);
        library.borrowBook(10, member);

        // simulate old borrow date (10 days ago)
        Loan loan = library.searchByTitle("Databases") != null
                ? library.loans.get(0)
                : null;

        assertNotNull(loan);
        loan.setBorrowDate(LocalDate.now().minusDays(10));

        double fee = library.calculateLateFee(10);

        // (10 - 7) * 2 = 6
        assertEquals(6.0, fee);
    }

    @Test
    public void testLateFeeForStudentMember() {
        LibraryManager library = new LibraryManager();
        Book book = new Book(11, "Operating Systems", "Tanenbaum");
        Member student = new StudentMember(101, "Sara");

        library.addBook(book);
        library.borrowBook(11, student);

        Loan loan = library.loans.get(0);
        loan.setBorrowDate(LocalDate.now().minusDays(9));

        double fee = library.calculateLateFee(11);

        // (9 - 7) * 1 = 2
        assertEquals(2.0, fee);
    }

    @Test
    public void testNoLateFeeWithinGracePeriod() {
        LibraryManager library = new LibraryManager();
        Book book = new Book(12, "Networks", "Kurose");
        Member member = new Member(102, "Omar");

        library.addBook(book);
        library.borrowBook(12, member);

        Loan loan = library.loans.get(0);
        loan.setBorrowDate(LocalDate.now().minusDays(5));

        double fee = library.calculateLateFee(12);

        assertEquals(0.0, fee);
    }
}
