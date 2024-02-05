package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.dao.ItemDao;
import com.example.app.domain.Item;

@Service
@Transactional(rollbackFor = Exception.class)
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDao itemDao;

	@Override
	public List<Item> getItemList() throws Exception {
		return itemDao.selectAll();
	}

	@Override
	public Item getItemById(Integer id) throws Exception {
		return itemDao.selectById(id);
	}

	@Override
	public void addItem(Item item) throws Exception {
		itemDao.insert(item);
	}

	@Override
	public void editItem(Item item) throws Exception {
		itemDao.update(item);
	}

	@Override
	public void deleteItem(Integer id) throws Exception {
		itemDao.delete(id);
	}

	@Override
	public int getTotalPages(int numPerPage) throws Exception {
		double totalNum = (double) itemDao.count();
		return (int) Math.ceil(totalNum / numPerPage); 
	}

	@Override
	public List<Item> getItemListByPage(int page, int numPerPage) throws Exception {
		int offset = numPerPage * (page - 1);
		return itemDao.selectLimited(offset, numPerPage);
	}

}
