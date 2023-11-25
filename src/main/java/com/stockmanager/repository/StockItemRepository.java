package com.stockmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmanager.entity.StockItem;

public interface StockItemRepository extends JpaRepository<StockItem, Long> {
	
	// 新規登録
	StockItem save(StockItem item);
	
	// すべて取得
	List<StockItem> findAll();
	
	// 名前で検索
	Optional<StockItem> findByName(String name);
	
	// カテゴリで検索
	List<StockItem> findByCategory(String category);
	
	// IDで削除
	void deleteById(Long id);
	
	// 情報を更新
	StockItem saveAndFlush(StockItem item);
}
