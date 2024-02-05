package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.service.ItemService;

@Controller
public class ItemController {
	
	// 1ページ当たりの表示人数
	private static final int NUM_PER_PAGE = 5;

	@Autowired
	ItemService service;

	@GetMapping("/admin/itemList")
	public String itemList(@RequestParam(name = "page", defaultValue = "1") Integer page, 
			Model model) throws Exception {
		model.addAttribute("items", service.getItemListByPage(page, NUM_PER_PAGE));
		model.addAttribute("page", page);
		model.addAttribute("totalPages", service.getTotalPages(NUM_PER_PAGE));
		//model.addAttribute("itemList", service.getItemList());
		return "itemList";
	}
}
