package travelItems;

import java.util.ArrayList;

public class PackingList {
	ArrayList<Item> packingList = new ArrayList<Item>();

	// These are the default items on our packList
	// (name, minTemp, maxTamp, cloud, weatherCode, extreme, essential item,
	// included, warning/message)
	Item snowBoots = new Item("snow boots", 0, 0, 606, false);
	Item summerDress = new Item("summer dress", 80, 0, 0, false);
	Item tShirt = new Item("tshirt", 70, 0, 0, false);
	Item sunBlock = new Item("sunblock", 75, 0, 802, false);
	Item sunGlasses = new Item("sunglasses", 70, 0, 802, false);
	Item umbrella = new Item("umbrella", 0, 0, 406, false);
	Item lipBalm = new Item("lipbalm", 0, 0, 0, false);
	private Item rainJacket = new Item("rain jacket", 0, 0, 406, false);
	Item heavyCoat = new Item("heavy coat", 0, 40, 0, false);
	Item knitHat = new Item("knit hat", 0, 40, 0, false);
	Item scarf = new Item("scarf", 0, 40, 0, false);
	Item gloves = new Item("gloves", 0, 40, 0, false);
	Item woolSocks = new Item("wool socks", 0, 40, 0, false);
	Item longUndies = new Item("long undies", 0, 30, 0, false);
	Item winterBoots = new Item("winter boots", 0, 40, 706, false);
	Item SleevelessShirt = new Item("sleeveless shirt", 80, 0, 0, false);
	Item toothbrush = new Item("toothbrush", 0, 0, 0, true);
	Item shoes = new Item("shoes", 0, 0, 0, true);
	private Item toothpaste = new Item("toothpaste", 0, 0, 0, true);
	Item deodorant = new Item("deoderant", 0, 0, 0, true);
	Item shampoo = new Item("shampoo", 0, 0, 0, true);
	Item conditioner = new Item("conditioner", 0, 0, 0, true);
	Item soap = new Item("soap", 0, 0, 0, true);
	Item shaver = new Item("shaver", 0, 0, 0, true);
	Item socks = new Item("socks", 0, 0, 0, true);
	Item underwear = new Item("underwear", 0, 0, 0, true);

	public ArrayList<Item> getPackingList() {
		return packingList;
	}

	public void setPackingList(ArrayList<Item> packingList) {
		this.packingList = packingList;
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

	public Item getWinterBoots() {
		return winterBoots;
	}

	public void setWinterBoots(Item winterBoots) {
		this.winterBoots = winterBoots;
	}

	public Item getSleevelessShirt() {
		return SleevelessShirt;
	}

	public void setSleevelessShirt(Item sleevelessShirt) {
		SleevelessShirt = sleevelessShirt;
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
		return shaver;
	}

	public void setShaver(Item shaver) {
		this.shaver = shaver;
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

	public Item getRainJacket() {
		return rainJacket;
	}

	public void setRainJacket(Item rainJacket) {
		this.rainJacket = rainJacket;
	}

	// populates arrayList
	/*
	 * packingList.add(snowBoots); packingList.add(summerDress);
	 * packingList.add(tShirt); packingList.add(sunBlock);
	 * packingList.add(sunGlasses); packingList.add(umbrella);
	 * packingList.add(lipBalm); packingList.add(rainJacket);
	 * packingList.add(heavyCoat); packingList.add(knitHat);
	 * packingList.add(scarf); packingList.add(gloves);
	 * packingList.add(woolSocks); packingList.add(longUndies);
	 * packingList.add(winterBoots); packingList.add(SleevelessShirt);
	 * packingList.add(toothbrush); packingList.add(shoes);
	 * packingList.add(toothpaste); packingList.add(deodorant);
	 * packingList.add(shampoo); packingList.add(conditioner);
	 * packingList.add(soap); packingList.add(shaver); packingList.add(socks);
	 * packingList.add(underwear);
	 * 
	 * //hard coding the weather conditions WeatherMap.setExtreme(0);
	 * WeatherMap.setWeatherCode(601); WeatherMap.setTemp(25);
	 * 
	 * for (int i = 0; i < packingList.size(); i++) { //calls the includes()
	 * method for each index to test to see if it is included based on weather
	 * packingList.get(i).includes(); if (packingList.get(i).include == false){
	 * //print unnecessary items packingList.remove(i);} else
	 * if(packingList.get(i).include == true){
	 * System.out.println(packingList.get(i).name); //remove unnecessary items
	 * //packingList.remove(packingList.get(i));
	 * 
	 * }
	 * 
	 * }
	 */
}
