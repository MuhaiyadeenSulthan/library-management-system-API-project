package com.library.management.repo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.library.management.model.BorrowingRecord;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {

    // Find borrowing records by member ID
    List<BorrowingRecord> findByMemberId(Long memberId);

    // Find borrowing records by book ID
    List<BorrowingRecord> findByBookId(Long bookId);

    // Find all currently borrowed books (not yet returned)
    List<BorrowingRecord> findByReturnDateIsNull();

    // Find overdue books (due date passed & book not yet returned)
    List<BorrowingRecord> findByDueDateBeforeAndReturnDateIsNull(LocalDate currentDate);
}
