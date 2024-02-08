package com.example.app.domain;

import java.util.Date;

import lombok.Data;

@Data
public class History {

	// No
	private Integer no;
	
	// 管理者ID
	private Integer userId;
	
	// 商品ID
	private Integer itemId;
	
	// カート格納有無
	private Integer cart;
	
	// 購入日時
	private Date purchaseDate;
}
