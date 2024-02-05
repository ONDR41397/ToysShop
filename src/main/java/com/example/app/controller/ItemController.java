package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService service;

	@GetMapping("/itemList")
	public String itemList(Model model) throws Exception {
		model.addAttribute("itemList", service.getItemList());
		return "itemList";
	}
}
