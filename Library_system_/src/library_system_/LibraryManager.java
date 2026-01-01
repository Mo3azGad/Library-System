package library_system_;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages library operations such as adding books,
 * searching, borrowing, and returning.
 */
public class LibraryManager implements Searchable {

    private List<Book> books;
    private List<Loan> loans;

    public LibraryManager() {
        books = new ArrayList<>();
        loans = new ArrayList<>();
    }

    // Add a new book
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove a book
    public boolean removeBook(int bookId) {
        return books.removeIf(book -> book.getId() == bookId);
    }

    // Search by title
    @Override
    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Search by author
    @Override
    public Book searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    // Borrow a book
    public boolean borrowBook(int bookId, Member member) {
        for (Book book : books) {
            if (book.getId() == bookId && book.isAvailable()) {
                book.setAvailable(false);
                loans.add(new Loan(book, member));
                return true;
            }
        }
        return false;
    }

    // Return a book
    public boolean returnBook(int bookId) {
        for (Loan loan : loans) {
            if (loan.getBook().getId() == bookId && !loan.isReturned()) {
                loan.returnBook();
                return true;
            }
        }
        return false;
    }

    // Display all books
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
    // Display all borrowed books
    
    public void displayBorrowedBooks() {
        boolean found = false;

        for (Loan loan : loans) {
            if (!loan.isReturned()) {
                System.out.println(
                    "Book: " + loan.getBook().getTitle() +
                    " | Borrowed by: " + loan.getMember().getName() +
                    " | Date: " + loan.getBorrowDate()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No borrowed books at the moment.");
        }
    }

}
