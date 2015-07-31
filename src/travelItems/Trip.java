package travelItems;

import java.io.Serializable;
import java.util.ArrayList;

import jSONConverterProject.WeatherInfoObject;
import jSONConverterProject.WeatherObjectConverter;

public class Trip implements Serializable {

	private static final long serialVersionUID = 618353573734930660L;
	private WeatherInfoObject weatherInfoObject;
	private ArrayList<Item> items = new ArrayList<Item>();
	private PackingList packingList = new PackingList();
	private ArrayList<String> dates;

	double apiMinTemp; // = weatherInfoObject.list[0].temp.min;
	double apiMaxTemp; // = weatherInfoObject.list[0].temp.max;

	int apiWeatherCode;// = weatherInfoObject.list[0].weather[0].id; // (this is old code)

	public Trip() {
//		apiMinTemp = apiMinTemp2;
//		apiMaxTemp = apiMaxTemp2;
		
		// add essential items
		items.add(packingList.getConditioner());
		items.add(packingList.getDeodorant());
		items.add(packingList.getToothbrush());
		items.add(packingList.getToothpaste());
		items.add(packingList.getShampoo());
		items.add(packingList.getShaver());
		items.add(packingList.getSoap());

		// quantity specific items
		items.add(packingList.getShoes());
		items.add(packingList.getSocks());
		items.add(packingList.getUnderwear());

		packingList.fillStagingList();

	}

	private void addNonEssentialItemsToItemsArrayList() {
		for (int i = 0; i < packingList.stagingList.size(); i++) {
			packingList.stagingList.get(i).includes(apiWeatherCode, apiMinTemp, apiMaxTemp);
			if (packingList.stagingList.get(i).include == true) {
				items.add(packingList.stagingList.get(i));
			}
		}
	}

	public WeatherInfoObject getWeatherInfoObject() {
		return weatherInfoObject;
	}

	public void setWeatherInfoObject(WeatherInfoObject weatherInfoObject) {
		this.weatherInfoObject = weatherInfoObject;
		apiMinTemp = weatherInfoObject.list[0].temp.min;
		apiMaxTemp = weatherInfoObject.list[0].temp.max;
		apiWeatherCode = weatherInfoObject.list[0].weather[0].id;
		// add non-essential items to "items" ArrayList
		addNonEssentialItemsToItemsArrayList();
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public ArrayList<String> getDates() {
		return dates;
	}

	public void setDates(ArrayList<String> dates) {
		this.dates = dates;
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
