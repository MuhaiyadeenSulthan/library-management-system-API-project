package com.library.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.model.BorrowingRecord;
import com.library.management.service.BorrowingService;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingRecordController {
	
	@Autowired
    private BorrowingService borrowingService;
	
	// Borrow a Book
    @PostMapping("/borrow/{bookId}/member/{memberId}")
    public ResponseEntity<String> borrowBook(@PathVariable Long bookId, @PathVariable Long memberId) {
        String response = borrowingService.borrowBook(bookId, memberId);
        return ResponseEntity.ok(response);
    }

    // Return a Book
    @PostMapping("/return/{bookId}/member/{memberId}")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId, @PathVariable Long memberId) {
        String response = borrowingService.returnBook(bookId, memberId);
        return ResponseEntity.ok(response);
    }

    // Get Borrowing Records by Member
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<BorrowingRecord>> getBorrowingRecordsByMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(borrowingService.getBorrowingRecordsByMember(memberId));
    }

    // Get Borrowing Records by Book
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BorrowingRecord>> getBorrowingRecordsByBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(borrowingService.getBorrowingRecordsByBook(bookId));
    }

    // Get Currently Borrowed Books
    @GetMapping("/currently-borrowed")
    public ResponseEntity<List<BorrowingRecord>> getCurrentlyBorrowedBooks() {
        return ResponseEntity.ok(borrowingService.getCurrentlyBorrowedBooks());
    }

    // Get Overdue Books
    @GetMapping("/overdue")
    public ResponseEntity<List<BorrowingRecord>> getOverdueBooks() {
        return ResponseEntity.ok(borrowingService.getOverdueBooks());
    }
}
