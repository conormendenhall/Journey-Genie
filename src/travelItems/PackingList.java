package travelItems;
import java.util.ArrayList;

public class PackingList {

	public static void main(String[] args) {
		ArrayList <Item> packingList = new ArrayList<Item>();
		
		//These are the default items on our packList
		// (name, minTemp, maxTamp, cloud, weatherCode, extreme, essential item, included, warning/message)
		Item snowBoots = new Item("snow boots", 0, 0, 0, 606, 0, false, false, null);
		Item summerDress = new Item("summer dress", 80, 0, 0, 0, 0, false, false, null);
		Item tShirt = new Item("tshirt", 70, 0, 0, 0, 0, false, false, null);
		Item sunBlock = new Item("sunblock", 75, 0, 0, 802, 904, false, false, null);
		Item sunGlasses = new Item("sunglasses", 70, 0, 0, 802, 904, false, false, null);
		Item umbrella = new Item("umbrella", 0, 0, 0, 406, 0, false, false, null);
		Item lipBalm = new Item("lipbalm", 0, 0, 0, 0, 905, false, false, null);
		Item rainJacket = new Item("rain jacket", 0, 0, 0, 406, 0, false, false, null);
		Item heavyCoat = new Item("heavy coat", 0, 40, 0, 0, 0, false, false, null);
		Item knitHat = new Item("knit hat", 0, 40, 0, 0, 0, false, false, null);
		Item scarf = new Item("scarf", 0, 40, 0, 0, 0, false, false, null);
		Item gloves = new Item("gloves", 0, 40, 0, 0, 0, false, false, null);
		Item woolSocks = new Item("wool socks", 0, 40, 0, 0, 0, false, false, null);
		Item longUndies = new Item("long undies", 0, 30, 0, 0, 0, false, false, null);
		Item winterBoots = new Item("winter boots", 0, 40, 0, 706, 0, false, false, null);
		Item SleevelessShirt = new Item("sleeveless shirt", 80, 0, 0, 0, 0, false, false, null);
		Item toothbrush = new Item("toothbrush", 0, 0, 0, 0, 0, true, false, null);
		Item shoes = new Item("shoes", 0, 0, 0, 0, 0, true, false, null);
		Item toothpaste = new Item("toothpaste", 0, 0, 0, 0, 0, true, false, null);
		Item deodorant = new Item("deoderant", 0, 0, 0, 0, 0, true, false, null);
		Item shampoo = new Item("shampoo", 0, 0, 0, 0, 0, true, false, null);
		Item conditioner = new Item("conditioner", 0, 0, 0, 0, 0, true, false, null);
		Item soap = new Item("soap", 0, 0, 0, 0, 0, true, false, null);
		Item shaver = new Item("shaver", 0, 0, 0, 0, 0, true, false, null);
		Item socks = new Item("socks", 0, 0, 0, 0, 0, true, false, null);
		Item underwear = new Item("underwear", 0, 0, 0, 0, 0, true, false, null);

		//populates arrayList
		packingList.add(snowBoots);
		packingList.add(summerDress);
		packingList.add(tShirt);
		packingList.add(sunBlock);
		packingList.add(sunGlasses);
		packingList.add(umbrella);
		packingList.add(lipBalm);
		packingList.add(rainJacket);
		packingList.add(heavyCoat);
		packingList.add(knitHat);
		packingList.add(scarf);
		packingList.add(gloves);
		packingList.add(woolSocks);
		packingList.add(longUndies);
		packingList.add(winterBoots);
		packingList.add(SleevelessShirt);
		packingList.add(toothbrush);
		packingList.add(shoes);
		packingList.add(toothpaste);
		packingList.add(deodorant);
		packingList.add(shampoo);
		packingList.add(conditioner);
		packingList.add(soap);
		packingList.add(shaver);
		packingList.add(socks);
		packingList.add(underwear);

		//hard coding the weather conditions
		WeatherMap.setExtreme(0);
		WeatherMap.setWeatherCode(601);
		WeatherMap.setTemp(25);
		
		for (int i = 0; i < packingList.size(); i++) {
			//calls the includes() method for each index to test to see if it is included based on weather
			packingList.get(i).includes();
			if (packingList.get(i).include == false){
				//print unnecessary items
				packingList.remove(i);}
			else if(packingList.get(i).include == true){
				System.out.println(packingList.get(i).name);
				//remove unnecessary items
				//packingList.remove(packingList.get(i));
	
		}
	
	}
	
	}
}
