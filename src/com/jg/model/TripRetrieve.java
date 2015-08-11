package com.jg.model;

public class TripRetrieve {
	private ItemFromArray[] a;
	private String startDate;
	private String endDate;
	private String location;
	public ItemFromArray[] getA() {
		return a;
	}
	public void setA(ItemFromArray[] a) {
		this.a = a;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
