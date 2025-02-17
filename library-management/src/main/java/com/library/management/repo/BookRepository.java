package com.library.management.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.management.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Search books by title or author (partial match)
    List<Book> findByTitleContainingOrAuthorContaining(String title, String author);

    // Find books by category
    List<Book> findByCategory(String category);

    // Find available books in a specific category
    List<Book> findByCategoryAndAvailable(String category, boolean available);

    // Find a book by ISBN (since ISBN is unique)
    Optional<Book> findByIsbn(String isbn);
}
