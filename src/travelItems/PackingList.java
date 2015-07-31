package travelItems;

import java.util.ArrayList;

public class PackingList {
	ArrayList<Item> stagingList = new ArrayList<>();

	ArrayList<Item> packingList = new ArrayList<Item>();

	// These are the default items on our packList
	// (name, minTemp, maxTamp, cloud, weatherCode, extreme, essential item, included, warning/message)
	private Item snowBoots = new Item("snow boots", -1000, -1000, 606, false);
	private Item summerDress = new Item("summer dress", 70, 1000, 0, false);
	private Item tShirt = new Item("tshirt", 50, 1000, 0, false);
	private Item sunBlock = new Item("sunblock", -1000, -1000, 802, false);
	private Item sunGlasses = new Item("sunglasses", -1000, 1000, 802, false);
	private Item umbrella = new Item("umbrella", -1000, -1000, 406, false);
	private Item lipBalm = new Item("lipbalm", -1000, 1000, 0, false);
	private Item rainJacket = new Item("rain jacket", -1000, -1000, 406, false);
	private Item heavyCoat = new Item("heavy coat", -1000, 40, 0, false);
	private Item knitHat = new Item("knit hat", -1000, 40, 0, false);
	private Item scarf = new Item("scarf", -1000, 40, 0, false);
	private Item gloves = new Item("gloves", -1000, 40, 0, false);
	private Item woolSocks = new Item("wool socks", -1000, 40, 0, false);
	private Item longUndies = new Item("long undies", -1000, 30, 0, false);
	private Item winterBoots = new Item("winter boots", -1000, 40, 706, false);
	private Item sleevelessShirt = new Item("sleeveless shirt", 80, 1000, 0, false);

	// Essential Items
	private Item toothbrush = new Item("toothbrush", 0, 0, 0, true);
	private Item shoes = new Item("shoes", 0, 0, 0, true);
	private Item toothpaste = new Item("toothpaste", 0, 0, 0, true);
	private Item deodorant = new Item("deodorant", 0, 0, 0, true);
	private Item shampoo = new Item("shampoo", 0, 0, 0, true);
	private Item conditioner = new Item("conditioner", 0, 0, 0, true);
	private Item soap = new Item("soap", 0, 0, 0, true);
	private Item shaver = new Item("shaver", 0, 0, 0, true);
	private Item socks = new Item("socks", 0, 0, 0, true);
	private Item underwear = new Item("underwear", 0, 0, 0, true);

	// fill staging area with non-essential items
	public void fillStagingList() {

		stagingList.add(snowBoots);
		stagingList.add(summerDress);
		stagingList.add(tShirt);
		stagingList.add(sunBlock);
		stagingList.add(sunGlasses);
		stagingList.add(umbrella);
		stagingList.add(lipBalm);
		stagingList.add(rainJacket);
		stagingList.add(heavyCoat);
		stagingList.add(knitHat);
		stagingList.add(scarf);
		stagingList.add(gloves);
		stagingList.add(woolSocks);
		stagingList.add(longUndies);
		stagingList.add(winterBoots);
		stagingList.add(sleevelessShirt);

	}

	public ArrayList<Item> getStagingList() {
		return stagingList;
	}

	public void setStagingList(ArrayList<Item> stagingList) {
		this.stagingList = stagingList;
	}

	public ArrayList<Item> getPackingList() {
		return packingList;
	}

	public void setPackingList(ArrayList<Item> packingList) {
		this.packingList = packingList;
	}
	
	// getters and setters for all items
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
		return sleevelessShirt;
	}

	public void setSleevelessShirt(Item sleevelessShirt) {
		this.sleevelessShirt = sleevelessShirt;
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

}
