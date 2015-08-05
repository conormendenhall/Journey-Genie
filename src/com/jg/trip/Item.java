package com.jg.trip;

public class Item {

	private String name;
	private String itemCategory;
	private boolean included;
	private int quantity;
	
	public Item(String name, String weatherCategory, boolean include) {
		super();
		this.setName(name);
		this.itemCategory = weatherCategory;
		this.setIncluded(include);
		this.quantity = 1;
	}
	
	public void checkWeatherConditions(int apiWeatherCode, double apiMinTemp, double apiMaxTemp) {
		// this will account for items needed for rainy days
		if ((apiWeatherCode >= 200 && apiWeatherCode < 600) && (itemCategory.contains("rainy"))) {
			setIncluded(true);	
		}
		//this will account for items needed for sunny days
		else if ((apiWeatherCode >= 800 && apiWeatherCode <=802) && (itemCategory.equalsIgnoreCase("sunny"))) {
			setIncluded(true);
		}
		// this will account for items needed for snow days
		else if ((apiWeatherCode >= 600 && apiWeatherCode < 700) && (itemCategory.equalsIgnoreCase("snow"))) {
			setIncluded(true);
		}
		// this will account for items needed for cold days
		else if ((apiMinTemp <= 40) && (itemCategory.equalsIgnoreCase("cold"))){
			setIncluded(true);
		}
		
		// this will account for items needed for hot days
		else if ((apiMaxTemp >= 75) && (itemCategory.equalsIgnoreCase("hot"))){
			setIncluded(true);
		}
		
		// this will account for items needed for windy days
		else if ((apiWeatherCode == 905 || (apiWeatherCode >= 953 && apiWeatherCode <= 957)) && (itemCategory.equalsIgnoreCase("windy"))){
			setIncluded(true);
		}
		
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
