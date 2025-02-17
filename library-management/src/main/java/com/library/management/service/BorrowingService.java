package com.library.management.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.model.Book;
import com.library.management.model.BorrowingRecord;
import com.library.management.model.Member;
import com.library.management.repo.BookRepository;
import com.library.management.repo.BorrowingRecordRepository;
import com.library.management.repo.MemberRepository;

@Service
public class BorrowingService {

	@Autowired
	private BorrowingRecordRepository borrowingRecordRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MemberRepository memberRepository;

	// Borrow a book
	public String borrowBook(Long bookId, Long memberId) {
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		Optional<Member> memberOptional = memberRepository.findById(memberId);

		if (bookOptional.isPresent() && memberOptional.isPresent()) {
			Book book = bookOptional.get();

			if (!book.isAvailable()) {
				return "Book is already borrowed!";
			}

			BorrowingRecord record = new BorrowingRecord();
			record.setBook(book);
			record.setMember(memberOptional.get());
			record.setBorrowDate(LocalDate.now());
			record.setDueDate(LocalDate.now().plusDays(14)); // 2-week borrowing period
			record.setReturnDate(null);

			// Mark book as unavailable
			book.setAvailable(false);
			bookRepository.save(book);

			borrowingRecordRepository.save(record);
			return "Book borrowed successfully!";
		}

		return "Book or Member not found!";
	}

	// Return a book
	public String returnBook(Long bookId, Long memberId) {
		List<BorrowingRecord> records = borrowingRecordRepository.findByMemberId(memberId);
		for (BorrowingRecord record : records) {
			if (record.getBook().getId().equals(bookId) && record.getReturnDate() == null) {
				record.setReturnDate(LocalDate.now());
				borrowingRecordRepository.save(record);

				// Mark book as available again
				Book book = record.getBook();
				book.setAvailable(true);
				bookRepository.save(book);

				return "Book returned successfully!";
			}
		}
		return "No active borrowing record found for this book and member!";
	}

	// Get borrowing records of a member
	public List<BorrowingRecord> getBorrowingRecordsByMember(Long memberId) {
		return borrowingRecordRepository.findByMemberId(memberId);
	}

	// Get borrowing records of a book
	public List<BorrowingRecord> getBorrowingRecordsByBook(Long bookId) {
		return borrowingRecordRepository.findByBookId(bookId);
	}

	// Get all currently borrowed books
	public List<BorrowingRecord> getCurrentlyBorrowedBooks() {
		return borrowingRecordRepository.findByReturnDateIsNull();
	}

	// Get overdue books
	public List<BorrowingRecord> getOverdueBooks() {
		return borrowingRecordRepository.findByDueDateBeforeAndReturnDateIsNull(LocalDate.now());
	}
}
