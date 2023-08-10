package com.example.demo.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.login.domain.Member;


public interface LoginRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserId(String userId);
}
