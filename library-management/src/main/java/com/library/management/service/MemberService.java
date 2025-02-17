package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.model.Member;
import com.library.management.repo.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	// Register a new member
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}

	// Get all members
	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	// Get member by ID
	public Optional<Member> getMemberById(Long id) {
		return memberRepository.findById(id);
	}

	// Get member by Email
	public Optional<Member> getMemberByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	// Get member by Phone Number
	public Optional<Member> getMemberByPhoneNumber(String phoneNumber) {
		return memberRepository.findByPhoneNumber(phoneNumber);
	}

	// Delete a member
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}
}
