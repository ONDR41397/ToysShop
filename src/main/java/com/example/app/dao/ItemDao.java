package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Item;

@Mapper
public interface ItemDao {

	// 全ての商品情報を取得
	List<Item> selectAll() throws Exception;
	
	// 商品のカート追加
	Item addCart(String buyer, Integer id) throws Exception;
	
	// カート情報を取得
	List<Item> cartSelectById(String buyer) throws Exception;
	
	// カートから商品キャンセル
	void cancelItem(Integer id) throws Exception;
	
	// 購入登録
	void purchaseRegist(Integer id) throws Exception;

	// 指定した商品IDの情報のみ取得
	Item selectById(Integer id) throws Exception;
	
	// 商品の追加
	void insert(Item item) throws Exception;

	// 商品の更新
	void update(Item item) throws Exception;

	// 商品の削除
	void delete(Integer id) throws Exception;
	
	// ページ分割機能用
	Long count() throws Exception;
	List<Item> selectLimited(@Param("offset") int offset, @Param("num") int num) throws Exception;

}
