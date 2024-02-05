package com.example.app.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Item {

	// ID
	private Integer id;
	
	// 商品名
	private String name;
	
	// 価格
	private String price;
	
	// 商品説明
	private String desc;
	
	// 商品画像
	private String pict;
	
	// ステータス
	private String status;
	
	// 登録日
	private Date created;
}
