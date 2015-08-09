package com.jg.model;

public class Item {
	Object o = new Object();
	
	private String name;
	private int quantity;
	private ItemCategory itemCategory;
	
	public enum ItemCategory {
		ESSENTIAL, SUNNY, RAINY, COLD, HOT, WINDY;
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
	
	@Override
	public boolean equals(Object obj) {
		Item i = (Item)obj;
		return i.itemCategory == this.itemCategory && i.name == this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
