package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.HistoryDao;
import com.example.app.domain.History;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	HistoryDao dao;

	@Override
	public History getCartItemById(Integer id) throws Exception {
		return dao.cartSelectById(id);
	}

	@Override
	public History addCartItem(Integer userId, Integer itemId) throws Exception {
		return dao.addCart(userId, itemId);
	}

}
