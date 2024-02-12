package com.example.app.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

		MultipartFile upfile = item.getUpfile();
		if (!upfile.isEmpty()) {
			String photo = upfile.getOriginalFilename();
			// テーブルに画像ファイル名格納
			item.setPict(photo);
			// 画像ファイルの保存
			Path path = Paths.get("uploads/" + photo);
			upfile.transferTo(path);
		}

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

	@Override
	public List<Item> getCartItems(String buyer) throws Exception {
		return itemDao.cartSelectById(buyer);
	}

	@Override
	public Item addCartItem(String userId, Integer itemId) throws Exception {
		return itemDao.addCart(userId, itemId);
	}

	@Override
	public void addPurchaseRegist(Integer id) throws Exception {
		itemDao.purchaseRegist(id);
	}

	@Override
	public void cancelItem(Integer id) throws Exception {
		itemDao.cancelItem(id);
	}

}
