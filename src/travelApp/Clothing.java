package travelApp;

public interface Clothing extends Item{
	public int getMinTemp();
	public void setMinTemp(int temp);
	public int getMaxTemp();
	public void setMaxTemp(int temp);
}
