package travelItems;
import java.util.ArrayList;

public class PackingList {

	public static void main(String[] args) {
		ArrayList <Item> packingList = new ArrayList<Item>();
		
		//These are the default items on our packList
		// (name, minTemp, maxTamp, cloud, weatherCode, extreme, essential item, included, warning/message)
		Item snowBoots = new Item("snow boots", 0, 0, 606, false);
		Item summerDress = new Item("summer dress", 80, 0, 0, false);
		Item tShirt = new Item("tshirt", 70, 0, 0, false);
		Item sunBlock = new Item("sunblock", 75, 0, 802, false);
		Item sunGlasses = new Item("sunglasses", 70, 0, 802, false);
		Item umbrella = new Item("umbrella", 0, 0, 406, false);
		Item lipBalm = new Item("lipbalm", 0, 0, 0, false);
		Item rainJacket = new Item("rain jacket", 0, 0, 406, false);
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
		Item toothpaste = new Item("toothpaste", 0, 0, 0, true);
		Item deodorant = new Item("deoderant", 0, 0, 0, true);
		Item shampoo = new Item("shampoo", 0, 0, 0, true);
		Item conditioner = new Item("conditioner", 0, 0, 0, true);
		Item soap = new Item("soap", 0, 0, 0, true);
		Item shaver = new Item("shaver", 0, 0, 0, true);
		Item socks = new Item("socks", 0, 0, 0, true);
		Item underwear = new Item("underwear", 0, 0, 0,true);

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
