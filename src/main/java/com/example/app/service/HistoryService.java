package com.example.app.service;

import java.util.List;

import com.example.app.domain.History;

public interface HistoryService {

	//History getCartItemById(Integer userId) throws Exception;
	List<History> getItemList(Integer userId) throws Exception;
	
	History addCartItem(Integer userId, Integer itemId) throws Exception;

}
