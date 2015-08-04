package travelItems;

import java.io.Serializable;
import java.util.ArrayList;
import jSONConverterProject.WeatherInfoObject;

public class Trip implements Serializable {

	private static final long serialVersionUID = 618353573734930660L;
	private WeatherInfoObject weatherInfoObject;
	private ArrayList<Item> items = new ArrayList<Item>();
	private PackingList packingList = new PackingList();
	private int startDate;
	private int endDate;

	double apiMinTemp;
	double apiMaxTemp;
	int apiWeatherCode;

	public Trip() {
		
		// add essential items
		items.add(packingList.getLipBalm());
		items.add(packingList.getConditioner());
		items.add(packingList.getDeodorant());
		items.add(packingList.getToothbrush());
		items.add(packingList.getToothpaste());
		items.add(packingList.getShampoo());
		items.add(packingList.getShaver());
		items.add(packingList.getSoap());
		items.add(packingList.getShoes());

		// add quantity specific items
		items.add(packingList.getSocks());
		items.add(packingList.getUnderwear());
		items.add(packingList.gettShirt());
		items.add(packingList.getPants());

		// fills staging list with non-essential items
		packingList.fillStagingList();
	}

	public void countEssentialQuantitySpecificItems()  {
		int newQuantity = 0;
		for(int j = startDate; j < endDate; j++) {		
			for(int i = 9; i<= 12; i++ ) {
				newQuantity = items.get(i).getQuantity();
				items.get(i).setQuantity(++newQuantity);
			}
		}
	}
	
	
	public void addNonEssentialItemsToPackingList() {
		
		for(int j = startDate; j <= endDate; j++) { 
			if(j > 15)
			{
				break;
			}
		for (int i = 0; i < packingList.stagingList.size(); i++) {
			packingList.stagingList.get(i).checkWeatherConditions(weatherInfoObject.list[j].weather[0].id, weatherInfoObject.list[j].temp.min, weatherInfoObject.list[j].temp.max);
			if (packingList.stagingList.get(i).isIncluded() == true) {
					if(!items.contains(packingList.stagingList.get(i)))
					{
						items.add(packingList.stagingList.get(i));
					}
					else if(packingList.stagingList.get(i).getName().equals("shorts"))
					{
						items.get(items.indexOf(packingList.stagingList.get(i))).setQuantity(items.get(items.indexOf(packingList.stagingList.get(i))).getQuantity() + 1);	
					}
					if(packingList.stagingList.get(i).getName().equals("shorts"))
					{
						items.get(12).setQuantity(items.get(12).getQuantity() - 1);
					}
					
				}
				
			}
			}
		}


	public WeatherInfoObject getWeatherInfoObject() {
		return weatherInfoObject;
	}

	public void setWeatherInfoObject(WeatherInfoObject weatherInfoObject) {
		this.weatherInfoObject = weatherInfoObject;
		
//		could the following be extracted?
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
