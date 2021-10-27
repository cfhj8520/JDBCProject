package com.fastcampus.biz.user;

import java.util.Date;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String password;
	private String name;
	private String content;
	private Date regDate;
	private String role;
}
