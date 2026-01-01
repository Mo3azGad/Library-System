package library_system_;

import java.util.Scanner;

/**
 * Main class to run the Library Management System.
 */
public class Main {

    public static void main(String[] args) {

        LibraryManager library = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        library.addBook(new Book(1, "Clean Code", "Robert Martin"));
        library.addBook(new Book(2, "Effective Java", "Joshua Bloch"));

        Member member = new Member(101, "Ahmed");
        StudentMember student = new StudentMember(102, "Sara");

        int choice;

        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Display all books");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. Display borrowed books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    boolean borrowed = library.borrowBook(borrowId, student);
                    System.out.println(borrowed ? "Book borrowed successfully." : "Book not available.");
                    break;

                case 3:
                    System.out.print("Enter book ID to return: ");
                    int returnId = scanner.nextInt();
                    boolean returned = library.returnBook(returnId);
                    System.out.println(returned ? "Book returned successfully." : "Return failed.");
                    break;
                    
                case 4:
                    library.displayBorrowedBooks();
                    break;


                case 0:
                    System.out.println("Exiting system...");
                    break;
                    

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        scanner.close();
    }
}
