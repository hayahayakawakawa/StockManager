package com.stockmanager.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StockItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String category;
	private int pics;
	private LocalDate registDate;
	private int expirationDays;
	
	// ゲッターとセッター
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPics() {
		return pics;
	}
	public void setPics(int pics) {
		this.pics = pics;
	}
	public LocalDate getRegistDate() {
		return registDate;
	}
	public void setRegistDate(LocalDate registDate) {
		this.registDate = registDate;
	}
	public int getExpirationDays() {
		return expirationDays;
	}
	public void setExpirationDays(int expirationDays) {
		this.expirationDays = expirationDays;
	}
}
