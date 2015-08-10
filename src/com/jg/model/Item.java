package com.jg.model;

import java.io.Serializable;

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9145481207386604002L;
	private String name;
	private int quantity;
	private ItemCategory itemCategory;
	
	public enum ItemCategory {
		ESSENTIAL, SUNNY, RAINY, COLD, HOT, WINDY;
	}

	public Item()
	{
		setName("pants");
		itemCategory = ItemCategory.ESSENTIAL;
		quantity = 1;
	}
	
	
	public Item(String name, ItemCategory itemCategory) {
		super();
		this.setName(name);
		this.itemCategory = itemCategory;
		this.quantity = 1;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
