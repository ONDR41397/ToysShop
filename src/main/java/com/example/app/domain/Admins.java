package com.example.app.domain;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Admins {

	// 管理者ID
	private Integer id;
	
	// 氏名
	private String name;
	
	// ユーザーID
	@Size(max=20)
	private String userId;
	
	// パスワード
	@Size(max=60)
	private String pass;
	
	// ログイン権限
	private Integer type;
}
