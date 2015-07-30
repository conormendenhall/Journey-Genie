package travelItems;

import java.io.Serializable;
import java.util.ArrayList;

import jSONConverterProject.WeatherInfoObject;

public class Trip implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 618353573734930660L;
	private WeatherInfoObject w;
	private ArrayList<Item> items;
	private PackingList packing = new PackingList();
	private ArrayList<String> dates;
	
	public Trip()
	{
		items.add(packing.getConditioner());
		items.add(packing.getDeodorant());
		items.add(packing.getShampoo());
		items.add(packing.getShaver());
		items.add(packing.getSoap());
	}
	
	
	public WeatherInfoObject getW() {
		return w;
	}
	public void setW(WeatherInfoObject w) {
		this.w = w;
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
	public void makePackingList()
	{
		
	}
	
}
