package com.example.demo.config;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.login.domain.Member;
import com.example.demo.login.service.LoginService;

@Component
public class UserDetailService implements UserDetailsService {
	 	
		private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
		private final LoginService loginservice;

	    @Autowired
	    public UserDetailService(LoginService loginservice) {
	        this.loginservice = loginservice;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
	    	logger.debug("찾으시는 아이디입니다.{}", insertedUserId);
	        Optional<Member> findOne = loginservice.findOne(insertedUserId);
	        Member member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

	        return User.builder()
	                .username(member.getUserId())
	                .password(member.getUserPassword())
	                .roles(member.getUserRole())
	                .build();
	    }

}
