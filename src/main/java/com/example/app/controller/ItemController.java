package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Item;
import com.example.app.service.ItemService;

import jakarta.validation.Valid;

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
		return "admin/itemList";
	}
	
	@GetMapping("/admin/addItem")
	public String addItemGet(Model model) throws Exception{
		model.addAttribute("item", new Item());
		return "admin/addItem";
	}
	
	@PostMapping("/admin/addItem")
	public String addItemPost(@Valid Item item, Errors errors, RedirectAttributes redirectAttributes) throws Exception{
		
		if(errors.hasErrors()) {
			return "admin/addItem";
		}
		
		service.addItem(item);
		redirectAttributes.addFlashAttribute("message", "商品を登録しました");
		return "redirect:/admin/itemList";
	}
}
