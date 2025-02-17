package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.model.Book;
import com.library.management.repo.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	//Add New Book
	public Book saveBook(Book book) {
		return bookRepository.save(book);		
	}
	
	// Get all books
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	// Get book by ID
	public Optional<Book> getBookById(Long id){
		return bookRepository.findById(id);
	}
	
	// Get book by ISBN
	public Optional<Book> getBookByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}
	
	// Search books by title or author
	public List<Book> searchBooks(String keyword) {
		return bookRepository.findByTitleContainingOrAuthorContaining(keyword, keyword);
	}
	
	// Get books by category
    public List<Book> getBooksByCategory(String category) {
        return bookRepository.findByCategory(category);
    }
    
	// Delete a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}










