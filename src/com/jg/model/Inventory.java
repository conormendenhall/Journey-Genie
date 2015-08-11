package com.jg.model;

import java.util.ArrayList;

public class Inventory {
	
//	ArrayList<Item> stagingList = new ArrayList<Item>();
//	ArrayList<Item> packingList = new ArrayList<Item>();
	
	private ArrayList<Item> essentialList = new ArrayList<Item>();
	private ArrayList<Item> coldList = new ArrayList<Item>();
	private ArrayList<Item> hotList = new ArrayList<Item>();
	private ArrayList<Item> rainyList = new ArrayList<Item>();
	private ArrayList<Item> sunnyList = new ArrayList<Item>();
	private ArrayList<Item> windyList = new ArrayList<Item>();

	// args:(name, itemCategory, included)
	// cold weather items:
	// not quantity specific
	private Item snowBoots = new Item("snow boots", Item.ItemCategory.COLD);
	private Item heavyCoat = new Item("heavy coat", Item.ItemCategory.COLD);
	private Item knitHat = new Item("knit hat", Item.ItemCategory.COLD);
	private Item scarf = new Item("scarf", Item.ItemCategory.COLD);
	private Item gloves = new Item("gloves", Item.ItemCategory.COLD);
	private Item longUndies = new Item("long undies", Item.ItemCategory.COLD);
	private Item woolSocks = new Item("wool socks", Item.ItemCategory.COLD);

	// hot weather items:
	private Item summerDress = new Item("summer dress", Item.ItemCategory.HOT);
	private Item swimSuit = new Item("swimsuit", Item.ItemCategory.HOT);
	private Item shorts = new Item("shorts", Item.ItemCategory.HOT);
	// rainy weather items:
	private Item umbrella = new Item("umbrella", Item.ItemCategory.RAINY);
	private static Item rainJacket = new Item("rain jacket", Item.ItemCategory.RAINY);
	// sunny weather items
	private Item sunBlock = new Item("sunblock", Item.ItemCategory.SUNNY);
	private Item sunGlasses = new Item("sunglasses", Item.ItemCategory.SUNNY);
	private Item sunHat = new Item("sun hat", Item.ItemCategory.SUNNY);
	// windy weather items:
	private Item windBreaker = new Item("wind breaker", Item.ItemCategory.WINDY);

	// To do: split non-essential items into two sub-categories:
	// temperature-based and weather code-based

	// Essential Items
	private Item lipBalm = new Item("lipbalm", Item.ItemCategory.ESSENTIAL);
	private Item toothbrush = new Item("toothbrush", Item.ItemCategory.ESSENTIAL);
	private Item toothpaste = new Item("toothpaste", Item.ItemCategory.ESSENTIAL);
	private Item deodorant = new Item("deodorant", Item.ItemCategory.ESSENTIAL);
	private Item shampoo = new Item("shampoo", Item.ItemCategory.ESSENTIAL);
	private Item conditioner = new Item("conditioner", Item.ItemCategory.ESSENTIAL);
	private Item soap = new Item("soap", Item.ItemCategory.ESSENTIAL);
	private Item razor = new Item("razor", Item.ItemCategory.ESSENTIAL);
	private Item shoes = new Item("shoes", Item.ItemCategory.ESSENTIAL);
	private Item socks = new Item("socks", Item.ItemCategory.ESSENTIAL);
	private Item underwear = new Item("underwear", Item.ItemCategory.ESSENTIAL);
	private Item tShirt = new Item("tshirt", Item.ItemCategory.ESSENTIAL);
	private Item pants = new Item("pants", Item.ItemCategory.ESSENTIAL);
	
	// fill staging area with non-essential items
	public void fillCategoryLists() {
		essentialList.add(lipBalm);
		essentialList.add(toothbrush);
		essentialList.add(toothpaste);
		essentialList.add(deodorant);
		essentialList.add(shampoo);
		essentialList.add(conditioner);
		essentialList.add(soap);
		essentialList.add(razor);
		essentialList.add(shoes);
		essentialList.add(socks);
		essentialList.add(underwear);
		essentialList.add(tShirt);
		essentialList.add(pants);
		
		
		coldList.add(snowBoots);
		coldList.add(heavyCoat);
		coldList.add(knitHat);
		coldList.add(scarf);
		coldList.add(gloves);
		coldList.add(longUndies);
		coldList.add(woolSocks);
		
		hotList.add(summerDress);
		hotList.add(swimSuit);
		hotList.add(shorts);
		
		rainyList.add(umbrella);
		rainyList.add(rainJacket);
		
		sunnyList.add(sunBlock);
		sunnyList.add(sunGlasses);
		sunnyList.add(sunHat);
		
		windyList.add(windBreaker);

	}

	public ArrayList<Item> getEssentialList() {
		return essentialList;
	}


	public void setEssentialList(ArrayList<Item> essentialList) {
		this.essentialList = essentialList;
	}


	public ArrayList<Item> getColdList() {
		return coldList;
	}


	public void setColdList(ArrayList<Item> coldList) {
		this.coldList = coldList;
	}


	public ArrayList<Item> getHotList() {
		return hotList;
	}


	public void setHotList(ArrayList<Item> hotList) {
		this.hotList = hotList;
	}


	public ArrayList<Item> getRainyList() {
		return rainyList;
	}


	public void setRainyList(ArrayList<Item> rainyList) {
		this.rainyList = rainyList;
	}


	public ArrayList<Item> getSunnyList() {
		return sunnyList;
	}


	public void setSunnyList(ArrayList<Item> sunnyList) {
		this.sunnyList = sunnyList;
	}


	public ArrayList<Item> getWindyList() {
		return windyList;
	}


	public void setWindyList(ArrayList<Item> windyList) {
		this.windyList = windyList;
	}


	public Item getSwimSuit() {
		return swimSuit;
	}

	public void setSwimSuit(Item swimSuit) {
		this.swimSuit = swimSuit;
	}

	public Item getPants() {
		return pants;
	}

	public void setPants(Item pants) {
		this.pants = pants;
	}

	public void setShorts(Item shorts) {
		this.shorts = shorts;
	}

	public Item getWindBreaker() {
		return windBreaker;
	}

	public void setWindBreaker(Item windBreaker) {
		this.windBreaker = windBreaker;
	}

	public Item getRazor() {
		return razor;
	}

	public void setRazor(Item razor) {
		this.razor = razor;
	}

	public Item getSnowBoots() {
		return snowBoots;
	}

	public void setSnowBoots(Item snowBoots) {
		this.snowBoots = snowBoots;
	}

	public Item getSummerDress() {
		return summerDress;
	}

	public void setSummerDress(Item summerDress) {
		this.summerDress = summerDress;
	}

	public Item gettShirt() {
		return tShirt;
	}

	public void settShirt(Item tShirt) {
		this.tShirt = tShirt;
	}

	public Item getSunBlock() {
		return sunBlock;
	}

	public void setSunBlock(Item sunBlock) {
		this.sunBlock = sunBlock;
	}

	public Item getSunGlasses() {
		return sunGlasses;
	}

	public void setSunGlasses(Item sunGlasses) {
		this.sunGlasses = sunGlasses;
	}

	public Item getSunHat() {
		return sunHat;
	}

	public void setSunHat(Item sunHat) {
		this.sunHat = sunHat;
	}

	public Item getUmbrella() {
		return umbrella;
	}

	public void setUmbrella(Item umbrella) {
		this.umbrella = umbrella;
	}

	public Item getLipBalm() {
		return lipBalm;
	}

	public void setLipBalm(Item lipBalm) {
		this.lipBalm = lipBalm;
	}

	public Item getHeavyCoat() {
		return heavyCoat;
	}

	public void setHeavyCoat(Item heavyCoat) {
		this.heavyCoat = heavyCoat;
	}

	public Item getKnitHat() {
		return knitHat;
	}

	public void setKnitHat(Item knitHat) {
		this.knitHat = knitHat;
	}

	public Item getScarf() {
		return scarf;
	}

	public void setScarf(Item scarf) {
		this.scarf = scarf;
	}

	public Item getGloves() {
		return gloves;
	}

	public void setGloves(Item gloves) {
		this.gloves = gloves;
	}

	public Item getWoolSocks() {
		return woolSocks;
	}

	public void setWoolSocks(Item woolSocks) {
		this.woolSocks = woolSocks;
	}

	public Item getLongUndies() {
		return longUndies;
	}

	public void setLongUndies(Item longUndies) {
		this.longUndies = longUndies;
	}

	public Item getShorts() {
		return shorts;
	}

	public void setSleevelessShirt(Item shorts) {
		this.shorts = shorts;
	}

	public Item getToothbrush() {
		return toothbrush;
	}

	public void setToothbrush(Item toothbrush) {
		this.toothbrush = toothbrush;
	}

	public Item getShoes() {
		return shoes;
	}

	public void setShoes(Item shoes) {
		this.shoes = shoes;
	}

	public Item getDeodorant() {
		return deodorant;
	}

	public void setDeodorant(Item deodorant) {
		this.deodorant = deodorant;
	}

	public Item getShampoo() {
		return shampoo;
	}

	public void setShampoo(Item shampoo) {
		this.shampoo = shampoo;
	}

	public Item getConditioner() {
		return conditioner;
	}

	public void setConditioner(Item conditioner) {
		this.conditioner = conditioner;
	}

	public Item getSoap() {
		return soap;
	}

	public void setSoap(Item soap) {
		this.soap = soap;
	}

	public Item getShaver() {
		return razor;
	}

	public void setShaver(Item shaver) {
		this.razor = shaver;
	}

	public Item getSocks() {
		return socks;
	}

	public void setSocks(Item socks) {
		this.socks = socks;
	}

	public Item getUnderwear() {
		return underwear;
	}

	public void setUnderwear(Item underwear) {
		this.underwear = underwear;
	}

	public Item getToothpaste() {
		return toothpaste;
	}

	public void setToothpaste(Item toothpaste) {
		this.toothpaste = toothpaste;
	}

	public static Item getRainJacket() {
		return rainJacket;
	}

	public void setRainJacket(Item rainJacket) {
		this.rainJacket = rainJacket;
	}

}