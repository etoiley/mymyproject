package com.example.demo.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.Member;
import com.example.demo.login.repository.LoginRepository;

@Service
public class LoginService {
	
	private final PasswordEncoder passwordEncoder;
	
    private final LoginRepository loginrepository;

    @Autowired
    public LoginService(LoginRepository loginrepository, PasswordEncoder passwordEncoder) {
    	this.passwordEncoder = passwordEncoder;
        this.loginrepository = loginrepository;
    }

    public Optional<Member> findOne(String userId) {
        return loginrepository.findByUserId(userId);
    }
    
    public Long join(String userid, String pw) {
        Member member = Member.createUser(userid, pw, passwordEncoder);
        validateDuplicateMember(member);
        loginrepository.save(member);

        return member.getUserIdx();
    }

    private void validateDuplicateMember(Member member) {
        loginrepository.findByUserId(member.getUserId())
		                .ifPresent(m -> {
		                    throw new IllegalStateException("이미 존재하는 회원입니다.");
		                });
    }
}
