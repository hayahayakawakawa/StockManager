package com.stockmanager;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.stockmanager.entity.StockItem;
import com.stockmanager.repository.StockItemRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StockItemRepositoryTest {
	
	@Autowired
	private StockItemRepository stockItemRepository;
	
	/*
	 *  新規作成のテスト
	 */
	@Test
	public void testSaveItem() {
		// テストデータ作成
		StockItem item = new StockItem();
		String testName = "Create Test Item";
		String testCategory = "Create Test Category";
		item.setName(testName);
		item.setCategory(testCategory);
		
		// リポジトリを通じて保存
		StockItem savedItem = stockItemRepository.save(item);
		
		// 保存されたアイテムが期待値通りであることを確認
		assertThat(savedItem.getId()).isNotNull();
		assertThat(savedItem.getName()).isEqualTo(testName);
		assertThat(savedItem.getCategory()).isEqualTo(testCategory);
	}
	
	/*
	 * 削除のテスト
	 */
	@Test
	public void testDeleteItem() {
		// テストデータ作成
		StockItem item = new StockItem();
		String testName = "Delete Test Item";
		String testCategory = "Delete Test Category";
		item.setName(testName);
		item.setCategory(testCategory);
		StockItem savedItem = stockItemRepository.save(item);
		
		// リポジトリを通して削除
		stockItemRepository.deleteById(savedItem.getId());
		
		// アイテムが削除されたことを検証
		assertThat(stockItemRepository.findById(savedItem.getId())).isEmpty();
	}
	
	/*
	 * 編集のテスト
	 */
	@Test
	public void testUpdateItem() {
		// テストデータの作成
		StockItem item = new StockItem();
		String testName = "Update Test Item";
		String testCategory = "Update Test Category";
		item.setName(testName);
		item.setCategory(testCategory);
		StockItem savedItem = stockItemRepository.save(item);
		
		// アイテムの名前を変更
		String updatedName = "Name is Updated!";
		savedItem.setName(updatedName);
		stockItemRepository.saveAndFlush(savedItem);
		
		// 変更が反映されたことを確認
		StockItem updatedItem = stockItemRepository.findById(savedItem.getId()).orElse(null);
		assertThat(updatedItem).isNotNull();
		assertThat(updatedItem.getName()).isEqualTo(updatedName);
		
	}
}
