package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.HistoryDao;
import com.example.app.domain.History;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	HistoryDao dao;

	/*
	 * @Override public History getCartItemById(Integer userId) throws Exception {
	 * return dao.cartSelectById(userId); }
	 */
	
	@Override
	public List<History> getItemList(Integer userId) throws Exception {
		return dao.selectAll(userId);
	}

	@Override
	public History addCartItem(Integer userId, Integer itemId) throws Exception {
		return dao.addCart(userId, itemId);
	}



}
