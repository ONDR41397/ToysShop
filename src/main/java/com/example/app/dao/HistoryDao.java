package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.History;

@Mapper
public interface HistoryDao {

	// カートの中身情報取得
	//History cartSelectById(Integer userId) throws Exception;
	List<History> selectAll(Integer userId) throws Exception;
	
	// 購入商品の履歴情報取得
	
	// 商品のカート追加
	History addCart(Integer userId, Integer itemId) throws Exception;
	
	// 商品の購入

}
