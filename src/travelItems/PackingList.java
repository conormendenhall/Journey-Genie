package travelItems;

import java.util.ArrayList;

public class PackingList {
	ArrayList<Item> stagingList = new ArrayList<>();

	ArrayList<Item> packingList = new ArrayList<Item>();

	// args:(name, itemCategory, included)
	// cold weather items:
	private Item snowBoots = new Item("snow boots", "cold", false);
	private Item heavyCoat = new Item("heavy coat", "cold", false);
	private Item knitHat = new Item("knit hat", "cold", false);
	private Item scarf = new Item("scarf", "cold", false);
	private Item gloves = new Item("gloves", "cold", false);
	private Item longUndies = new Item("long undies", "cold", false);
	private Item woolSocks = new Item("wool socks", "cold", false);
	// hot weather items:
	private Item summerDress = new Item("summer dress", "hot", false);
	
	private Item sleevelessShirt = new Item("sleeveless shirt", "hot", false);
	// rainy weather items:
	private Item umbrella = new Item("umbrella", "rainy", false);
	private Item rainJacket = new Item("rain jacket", "rainy", false);
	// sunny weather items
	private Item sunBlock = new Item("sunblock", "sunny", false);

	private Item sunGlasses = new Item("sunglasses", "sunny", false);
	private Item sunHat = new Item("sun hat", "sunny", false);
	// windy weather items:
	private Item windBreaker = new Item("wind breaker", "windy", false);
	
	// To do: split non-essential items into two ArrayLists: temperature-based and weather code-based

	// Essential Items
	private Item lipBalm = new Item("lipbalm", "", true);
	private Item toothbrush = new Item("toothbrush","", true);
	private Item toothpaste = new Item("toothpaste","", true);
	private Item deodorant = new Item("deodorant","", true);
	private Item shampoo = new Item("shampoo","", true);
	private Item conditioner = new Item("conditioner","", true);
	private Item soap = new Item("soap","", true);
	private Item razor = new Item("razor","", true);
	private Item shoes = new Item("shoes","", true);
	private Item socks = new Item("socks","", true);
	private Item underwear = new Item("underwear","", true);
	private Item tShirt = new Item("tshirt", "", true);


	// fill staging area with non-essential items
	public void fillStagingList() {

		stagingList.add(snowBoots);
		stagingList.add(heavyCoat);
		stagingList.add(knitHat);
		stagingList.add(scarf);
		stagingList.add(gloves);
		stagingList.add(longUndies);
		stagingList.add(woolSocks);
		stagingList.add(summerDress);
		stagingList.add(tShirt);
		stagingList.add(sleevelessShirt);
		stagingList.add(umbrella);
		stagingList.add(rainJacket);
		stagingList.add(sunBlock);
		stagingList.add(sunGlasses);
		stagingList.add(sunHat );
		stagingList.add(windBreaker);

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

	public Item getRainJacket() {
		return rainJacket;
	}

	public void setRainJacket(Item rainJacket) {
		this.rainJacket = rainJacket;
	}

}
