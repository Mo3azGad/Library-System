package library_system_;

/**
 * Interface for searchable objects in the library system.
 */
public interface Searchable {

    /**
     * Search for a book by its title.
     */
    Book searchByTitle(String title);

    /**
     * Search for a book by its author.
     */
    Book searchByAuthor(String author);
}
