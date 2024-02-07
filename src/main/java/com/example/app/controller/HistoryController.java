package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.service.HistoryService;

@Controller
public class HistoryController {
	
	@Autowired
	HistoryService service;

	@PostMapping("/detail/{id}")
	public String detailItemPost(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) throws Exception {

		service.addCartItem(2, id); //管理者IDは仮設定
		redirectAttributes.addFlashAttribute("message", "商品をカートに追加しました");
		return "redirect:/itemList";
	}
}
