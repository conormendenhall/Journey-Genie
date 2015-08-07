package com.jg.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Trip implements Serializable {

	private static final long serialVersionUID = 618353573734930660L;
	private APIData apiData;
	private ArrayList<Item> items = new ArrayList<Item>();
	private Inventory inventory = new Inventory();
	private int startDate;
	private int endDate;

	public Trip() {

		// add essential items
		items.add(inventory.getLipBalm());
		items.add(inventory.getConditioner());
		items.add(inventory.getDeodorant());
		items.add(inventory.getToothbrush());
		items.add(inventory.getToothpaste());
		items.add(inventory.getShampoo());
		items.add(inventory.getShaver());
		items.add(inventory.getSoap());
		items.add(inventory.getShoes());

		// add quantity specific items
		items.add(inventory.getSocks());
		items.add(inventory.getUnderwear());
		items.add(inventory.gettShirt());
		items.add(inventory.getPants());

		// fills staging list with non-essential items
		inventory.fillCategoryLists();
	}

	public Inventory getInventory() {
		return inventory;
	}

	public APIData getAPIData() {
		return apiData;
	}

	public void setAPIData(APIData apiData) {
		this.apiData = apiData;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public void makePackingList() {

	}
}
