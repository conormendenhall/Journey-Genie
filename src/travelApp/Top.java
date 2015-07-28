package travelApp;

public class Top implements Clothing{
	private static int amount;
	private String name;
	private int minTemp;
	private int maxTemp;

	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public void setAmount(int amt) {
		amount=amt;	
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;	
	}

	@Override
	public int getMinTemp() {
		return minTemp;
	}

	@Override
	public void setMinTemp(int temp) {
		minTemp = temp;
	}

	@Override
	public int getMaxTemp() {
		return maxTemp;
	}

	@Override
	public void setMaxTemp(int temp) {
		maxTemp = temp;
	}

}
