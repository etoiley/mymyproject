package com.example.demo.login.domain;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//Entity --> DB에 쓰인 컬럼명과 동일하게 써줘야한다(카멜사용) 안 그러면 에러 발생
@Entity
@Table(name="TB_USER")
public class Member {
    @Id//해당 테이블의 pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//pk 생성규칙, generationTyupe.Identity는 auto_increment라는 조건을 의미함
    @Column(name = "USER_IDX")
    private Long userIdx;

    @Column(name = "USER_ID", unique = true)
    private String userId;
    
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    
    @Column(name = "USER_NAME")
    private String userName;
    
    @Column(name = "USER_EMAIL")
    private String userEmail;
    
    @Column(name = "USER_PHONE")
    private String userPhone;
    
    @Column(name = "USER_ROLE")
    private String userRole;

    private Member(Long userIdx, String userId, String userPassword, String userRole) {
        this.userIdx = userIdx;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    protected Member() {}

    public static Member createUser(String userId, String userPassword, PasswordEncoder passwordEncoder) {
        return new Member(null, userId, passwordEncoder.encode(userPassword), "USER");
    }

    public Long getUserIdx() {
        return userIdx;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserRole() {
        return userRole;
    }
}
