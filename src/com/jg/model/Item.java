package com.jg.model;

public class Item {

	private String name;
	private String itemCategory;
	private boolean included;
	private int quantity;

	public Item(String name, String itemCategory, boolean include) {
		super();
		this.setName(name);
		this.itemCategory = itemCategory;
		this.setIncluded(include);
		this.quantity = 1;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public boolean isInclude() {
		return isIncluded();
	}

	public void setInclude(boolean include) {
		this.setIncluded(include);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIncluded() {
		return included;
	}

	public void setIncluded(boolean included) {
		this.included = included;
	}

}
