package com.example.app.service;

import java.util.List;

import com.example.app.domain.Item;

public interface ItemService {

	List<Item> getItemList() throws Exception;
	
	List<Item> getCartItems(String buyer) throws Exception;
	
	Item addCartItem(String buyer, Integer id) throws Exception;

	Item getItemById(Integer id) throws Exception;
	
	void cancelItem(Integer id) throws Exception;
	
	void addPurchaseRegist(Integer id) throws Exception;

	void addItem(Item item) throws Exception;

	void editItem(Item item) throws Exception;

	void deleteItem(Integer id) throws Exception;

	// ページ分割機能用
	int getTotalPages(int numPerPage) throws Exception;
	List<Item> getItemListByPage(int page, int numPerPage) throws Exception;
}
