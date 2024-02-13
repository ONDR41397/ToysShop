package com.example.app.domain;

import java.util.Date;

import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Item {

	// ID
	private Integer id;
	
	// 商品名
	@NotBlank
	@Size(max=20)
	private String name;
	
	// 価格
	@NotNull
	@Range(min = 1, max = 99999999)
	private Integer price;
	
	// 商品説明
	@NotBlank
	@Size(max=300)
	private String descript;
	
	// 商品画像
	private String pict;
	
	// ステータス
	private String status;
	
	// 登録日
	private Date created;
	
	// 画像のアップロード
	private MultipartFile upfile;
	
	// 購入者情報
	private Admins buyer;
	
	// 購入有無
	private Integer purchase;
}
