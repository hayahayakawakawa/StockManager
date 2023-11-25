package com.stockmanager.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanager.entity.StockItem;
import com.stockmanager.repository.StockItemRepository;

@RestController
@RequestMapping("/api/item")
public class StockController {
	private final StockItemRepository stockItemRepository;
	
	public StockController(StockItemRepository stockItemRepository) {
		this.stockItemRepository = stockItemRepository;
	}
	
	// 以下エンドポイント
	// IDで検索して取得
	@GetMapping("/{id}")
	public ResponseEntity<StockItem> getItemById(@PathVariable Long itemId) {
		Optional<StockItem> item = stockItemRepository.findById(itemId);
		return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	// 新規作成
	@PostMapping
	public ResponseEntity<StockItem> createItem(@RequestBody StockItem item) {
		StockItem savedItem = stockItemRepository.save(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
	}
	
	// 削除
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
		stockItemRepository.deleteById(itemId);
		return ResponseEntity.noContent().build();
	}
	
	// 更新
	@PutMapping("/{id}")
	public ResponseEntity<StockItem> updateItem(@PathVariable Long itemId, @RequestBody StockItem updateItem) {
		Optional<StockItem> existingItem = stockItemRepository.findById(itemId);
		if (existingItem.isPresent()) {
			// DBのアイテムを変更
			StockItem itemToUpdate = existingItem.get();
			itemToUpdate.setId(updateItem.getId());
			itemToUpdate.setName(updateItem.getName());
			itemToUpdate.setCategory(updateItem.getCategory());
			itemToUpdate.setPics(updateItem.getPics());
			itemToUpdate.setRegistDate(updateItem.getRegistDate());
			itemToUpdate.setExpirationDays(updateItem.getExpirationDays());
			StockItem savedItem = stockItemRepository.save(itemToUpdate);
			return ResponseEntity.ok(savedItem);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}