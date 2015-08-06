package com.jg.trip;

import java.io.Serializable;
import java.util.ArrayList;

import com.jg.obj.WeatherInfoObject;

public class Trip implements Serializable {

	private static final long serialVersionUID = 618353573734930660L;
	private WeatherInfoObject weatherInfoObject;
	private ArrayList<Item> items = new ArrayList<Item>();
	private Inventory inventory = new Inventory();
	private int startDate;
	private int endDate;

	double apiMinTemp;
	double apiMaxTemp;
	int apiWeatherCode;

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
		inventory.fillStagingList();
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public WeatherInfoObject getWeatherInfoObject() {
		return weatherInfoObject;
	}

	public void setWeatherInfoObject(WeatherInfoObject weatherInfoObject) {
		this.weatherInfoObject = weatherInfoObject;

		// could the following be extracted?
		apiMinTemp = weatherInfoObject.list[0].temp.min;
		apiMaxTemp = weatherInfoObject.list[0].temp.max;
		apiWeatherCode = weatherInfoObject.list[0].weather[0].id;
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

	public double getApiMinTemp() {
		return apiMinTemp;
	}

	public void setApiMinTemp(double apiMinTemp) {
		this.apiMinTemp = apiMinTemp;
	}

	public double getApiMaxTemp() {
		return apiMaxTemp;
	}

	public void setApiMaxTemp(double apiMaxTemp) {
		this.apiMaxTemp = apiMaxTemp;
	}

	public int getApiWeatherCode() {
		return apiWeatherCode;
	}

	public void setApiWeatherCode(int apiWeatherCode) {
		this.apiWeatherCode = apiWeatherCode;
	}
}
