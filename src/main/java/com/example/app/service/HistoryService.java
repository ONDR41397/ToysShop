package com.example.app.service;

import com.example.app.domain.History;

public interface HistoryService {

	History getCartItemById(Integer id) throws Exception;
	
	History addCartItem(Integer userId, Integer itemId) throws Exception;

}
