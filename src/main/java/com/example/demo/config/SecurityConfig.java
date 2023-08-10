package com.example.demo.config;


import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.servlet.DispatcherType;


@Configuration
public class SecurityConfig {
	
	   	@Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	
	   	@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.csrf().disable().cors().disable()
         .authorizeHttpRequests(request -> request
                 .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                 .requestMatchers(
                		 		new AntPathRequestMatcher("/resources/image/**")
                		 		,new AntPathRequestMatcher("/registerForm.lo")
                		 		,new AntPathRequestMatcher("/register-process.lo")
                		 		).permitAll()
                 .anyRequest().authenticated()
         )
         .formLogin(login -> login
                 .loginPage("/loginForm.lo")	// 커스텀 로그인 페이지 지정
                 .loginProcessingUrl("/login-process.lo")	// submit 받을 url
                 .usernameParameter("userId")	// submit할 아이디
                 .passwordParameter("userPassword")	//  submit할 비밀번호
                 .defaultSuccessUrl("/loginPage.lo", true)
                 .permitAll()
         )
         .logout(withDefaults());

	        return http.build();
	    }
	

}