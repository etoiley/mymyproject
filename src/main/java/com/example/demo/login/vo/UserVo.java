package com.example.demo.login.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserVo {
	private int userIdx;
	private String userId;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userStatus;
	private Date userDate;
	private String userRole;
	
	//vo --> entity
	public UserVo toEntity() {
		
		UserVo user = UserVo.builder()
							.userId(userId)
							.userPassword(userPassword)
							.userName(userName)
							.userEmail(userEmail)
							.userPhone(userPhone)
							.build();
		
		return user;
		
	}
	
	
}
