package com.library.management.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.library.management.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // Find member by email (unique)
    Optional<Member> findByEmail(String email);

    // Find member by phone number (unique)
    Optional<Member> findByPhoneNumber(String phoneNumber);
}
