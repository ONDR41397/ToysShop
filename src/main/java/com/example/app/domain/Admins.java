package com.example.app.domain;

import lombok.Data;

@Data
public class Admins {

	// 管理者ID
	private Integer id;
	
	// 氏名
	private String name;
	
	// ユーザーID
	private String userId;
	
	// パスワード
	private String pass;
	
	// ログイン権限
	private Integer type;
}
