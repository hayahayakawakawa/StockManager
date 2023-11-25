package com.stockmanager.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stockmanager.entity.StockItem;
import com.stockmanager.repository.StockItemRepository;

@Controller
public class HomeController {
	
	private final StockItemRepository stockItemRepository;
	
	public HomeController(StockItemRepository stockItemRepository) {
		this.stockItemRepository = stockItemRepository;
	}
	
	// 初期表示
	@GetMapping("")
	public String home(Model model) {
		
		List<StockItem> itemList = stockItemRepository.findAll();
		
		model.addAttribute("itemList", itemList);
		
		return "home";
	}
	
	// home.jspへのリダイレクト用
	@GetMapping("home")
	public String backHome(Model model) {
		
		List<StockItem> itemList = stockItemRepository.findAll();
		
		model.addAttribute("itemList", itemList);
		
		return "home";
	}
	
	// 新規登録ボタン
	@PostMapping("/addForm")
	public String addForm(@RequestParam("name") String name, 
			@RequestParam("category") String category,
			@RequestParam("pics") int pics,
			@RequestParam("registDate") LocalDate registDate,
			@RequestParam("expirationDays") int expirationDays) {
		StockItem stockItem = new StockItem();
		stockItem.setName(name);
	    stockItem.setCategory(category);
	    stockItem.setPics(pics);
	    stockItem.setRegistDate(registDate);
	    stockItem.setExpirationDays(expirationDays);
	    
		stockItemRepository.save(stockItem);
		
		return "redirect:/home";
	}
	
	// 削除ボタン
	@PostMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		
		stockItemRepository.deleteById(id);
		
		return "redirect:home";
	}

}