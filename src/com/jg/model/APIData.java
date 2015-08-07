package com.jg.model;

public class APIData {
	private int cod;
	private double message;
	private City city;
	private int cnt;
	private List[] list = { new List() };

	public APIData() {
	}
	
	@Override
	public boolean equals(Object obj) {
		APIData apiData = (APIData) obj;
		return this.cod == apiData.cod && this.message == apiData.message
				&& this.city == apiData.city && this.cnt == apiData.cnt
				&& this.list == apiData.list;
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public double getMessage() {
		return message;
	}

	public void setMessage(double message) {
		this.message = message;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public List[] getList() {
		return list;
	}

	public void setList(List[] list) {
		this.list = list;
	}

}