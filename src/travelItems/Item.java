package travelItems;

public class Item {

	private String name;
	int maxTemp;
	int minTemp;
	int itemWeatherCode;
	public boolean include;

	public Item(String name, int minTemp, int maxTemp, int itemWeatherCode, boolean include) {
		super();
		this.setName(name);
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.itemWeatherCode = itemWeatherCode;
		this.include = include;
	}

	public int getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}

	public int getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}

	public int getItemWeatherCode() {
		return itemWeatherCode;
	}

	public void setItemWeatherCode(int itemWeatherCode) {
		this.itemWeatherCode = itemWeatherCode;
	}

	public boolean isInclude() {
		return include;
	}

	public void setInclude(boolean include) {
		this.include = include;
	}

//	public void includes(int apiWeatherCode) {
//		// this will account for items needed when raining
//		if (apiWeatherCode < 600 && apiWeatherCode > 0 && itemWeatherCode < 600 && itemWeatherCode > 0) {
//			include = true;
//		}
//		// this will account for items needed for sunny days
//		else if (itemWeatherCode >= 800 && itemWeatherCode < 900 && apiWeatherCode / 100 == itemWeatherCode / 100
//				&& apiWeatherCode % 10 <= itemWeatherCode % 10) {
//			include = true;
//		}
//		// this will account for items needed for snow days
//		else if (apiWeatherCode >= 600 && apiWeatherCode < 700 && apiWeatherCode / 100 == itemWeatherCode / 100) {
//			include = true;
//		}
//	}

	public void includes(int apiWeatherCode, double apiMinTemp, double apiMaxTemp) {
		// this will account for items needed when raining
		if (apiWeatherCode < 600 && apiWeatherCode > 0 && itemWeatherCode < 600 && itemWeatherCode > 0) {
			include = true;
		}
		 //this will account for items needed for sunny days
		else if (itemWeatherCode >= 800 && itemWeatherCode < 900 && apiWeatherCode / 100 == itemWeatherCode / 100
				&& apiWeatherCode % 10 <= itemWeatherCode % 10) {
			include = true;
		}
		// this will account for items needed for snow days
		else if (apiWeatherCode >= 600 && apiWeatherCode < 700 && apiWeatherCode / 100 == itemWeatherCode / 100) {
			include = true;
		}
		// this will account for items needed for cold days
//		if (maxTemp > 0 && apiMaxTemp <= maxTemp) {
//			include = true;
//		}
		else if (apiMinTemp <= maxTemp){
			include = true;
		}

		// this will account for items need for hot days
//		else if (minTemp > 0 && apiMinTemp >= minTemp) {
//			include = true;
//		}
		else if (apiMaxTemp <= minTemp){
			include = true;
		}

		// this will account for items needed for extreme hot days
		// else if (WeatherMap.getExtreme() == 904){
		// include = true;}

		// this will account for items needed for extreme cold days
		// else if (WeatherMap.getExtreme() == 903){
		// include = true;}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
