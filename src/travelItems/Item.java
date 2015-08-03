package travelItems;

public class Item {

	private String name;
	String itemCategory;
	public boolean included;
	
	public void checkWeatherConditions(int apiWeatherCode, double apiMinTemp, double apiMaxTemp) {
		// this will account for items needed for rainy days
		if ((apiWeatherCode >= 200 && apiWeatherCode < 600) && (itemCategory.contains("rainy"))) {
			included = true;	
		}
		//this will account for items needed for sunny days
		else if ((apiWeatherCode >= 800 && apiWeatherCode <=802) && (itemCategory.equalsIgnoreCase("sunny"))) {
			included = true;
		}
		// this will account for items needed for snow days
		else if ((apiWeatherCode >= 600 && apiWeatherCode < 700) && (itemCategory.equalsIgnoreCase("snow"))) {
			included = true;
		}
		// this will account for items needed for cold days
		else if ((apiMinTemp <= 40) && (itemCategory.equalsIgnoreCase("cold"))){
			included = true;
		}
		
		// this will account for items needed for hot days
		else if ((apiMaxTemp >= 75) && (itemCategory.equalsIgnoreCase("hot"))){
			included = true;
		}
		
		// this will account for items needed for windy days
		else if ((apiWeatherCode == 905 || (apiWeatherCode >= 953 && apiWeatherCode <= 957)) && (itemCategory.equalsIgnoreCase("windy"))){
			included = true;
		}
		
	}

	public Item(String name, String weatherCategory, boolean include) {
		super();
		this.setName(name);
		this.itemCategory = weatherCategory;
		this.included = include;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public boolean isInclude() {
		return included;
	}

	public void setInclude(boolean include) {
		this.included = include;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
