package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Item;

@Mapper
public interface ItemDao {

	// 全ての商品情報を取得
	List<Item> selectAll() throws Exception;

	// 指定した商品IDの情報のみ取得
	Item selectById(Integer id) throws Exception;

	// 商品の追加
	void insert(Item item) throws Exception;

	// 商品の更新
	void update(Item item) throws Exception;

	// 商品の削除
	void delete(Integer id) throws Exception;

}
