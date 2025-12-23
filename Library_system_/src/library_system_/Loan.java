package library_system_;

import java.time.LocalDate;

/**
 * Represents a book loan in the library system.
 */
public class Loan {

    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    /**
     * Constructor to create a Loan when a book is borrowed.
     */
    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * Marks the book as returned.
     */
    public void returnBook() {
        this.returnDate = LocalDate.now();
        book.setAvailable(true);
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    @Override
    public String toString() {
        return "Loan -> Book: " + book.getTitle() +
               ", Member: " + member.getName() +
               ", Borrowed on: " + borrowDate +
               ", Returned: " + (returnDate != null ? returnDate : "Not yet");
    }
}
