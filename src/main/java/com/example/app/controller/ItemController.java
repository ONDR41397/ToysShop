package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Item;
import com.example.app.service.ItemService;

import jakarta.validation.Valid;

@Controller
public class ItemController {

	// 1ページ当たりの表示件数
	private static final int NUM_PER_PAGE = 5;
	private static final int NUM_PER_PAGE_USER = 6;

	@Autowired
	ItemService service;

	// ここから管理者操作
	@GetMapping("/admin/itemList")
	public String itemList(@RequestParam(name = "page", defaultValue = "1") Integer page, Model model)
			throws Exception {
		model.addAttribute("items", service.getItemListByPage(page, NUM_PER_PAGE));
		model.addAttribute("page", page);
		model.addAttribute("totalPages", service.getTotalPages(NUM_PER_PAGE));
		return "admin/itemList";
	}

	@GetMapping("/admin/addItem")
	public String addItemGet(Model model) throws Exception {
		model.addAttribute("item", new Item());
		return "admin/addItem";
	}

	@PostMapping("/admin/addItem")
	public String addItemPost(@Valid Item item, Errors errors, RedirectAttributes redirectAttributes) throws Exception {

		// バリデーション
		MultipartFile upfile = item.getUpfile();
		if (!upfile.isEmpty()) {
			// 画像か否か判定する
			String type = upfile.getContentType();
			if (!type.startsWith("image/")) {
				// 画像ではない場合、エラーメッセージを表示
				errors.rejectValue("upfile", "error.not_image_file");
			}
		}

		if (errors.hasErrors()) {
			return "admin/addItem";
		}

		service.addItem(item);
		redirectAttributes.addFlashAttribute("message", "商品を登録しました");
		return "redirect:/admin/itemList";
	}

	@GetMapping("/admin/editItem/{id}")
	public String editItemGet(@PathVariable Integer id, Model model) throws Exception {
		model.addAttribute("item", service.getItemById(id));
		return "admin/editItem";
	}

	@PostMapping("/admin/editItem/{id}")
	public String editItemPost(@PathVariable Integer id, @Valid Item item, Errors errors,
			RedirectAttributes redirectAttributes) throws Exception {

		if (errors.hasErrors()) {
			return "admin/editItem";
		}

		service.editItem(item);
		redirectAttributes.addFlashAttribute("message", "商品を更新しました");
		return "redirect:/admin/itemList";
	}

	@GetMapping("/admin/deleteItem/{id}")
	public String deleteItem(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes)
			throws Exception {
		model.addAttribute("item", service.getItemById(id));
		service.deleteItem(id);
		redirectAttributes.addFlashAttribute("message", "商品を削除しました");
		return "redirect:/admin/itemList";
	}
	
	// ここからユーザー操作
	@GetMapping("/itemList")
	public String userItemList(@RequestParam(name = "page", defaultValue = "1") Integer page, Model model)
			throws Exception {
		model.addAttribute("items", service.getItemListByPage(page, NUM_PER_PAGE_USER));
		model.addAttribute("page", page);
		model.addAttribute("totalPages", service.getTotalPages(NUM_PER_PAGE_USER));
		return "user/itemList";
	}
	
	@GetMapping("/detail/{id}")
	public String detailItem(@PathVariable Integer id, Model model) throws Exception {
		model.addAttribute("item", service.getItemById(id));
		return "user/detail";
	}
	
	
	
	
	
	
	
	
	
	
}
