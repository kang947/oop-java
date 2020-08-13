package Tutorial6;

import java.io.Serializable;

public class Outfit implements Serializable{//interface class
	
	private int month;
	private String outfitType;
	private int price;
	
	
	
	public Outfit() {
		
	}



	public Outfit(int month, String outfitType, int price) {
		
		this.month = month;
		this.outfitType = outfitType;
		this.price = price;
	}



	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		this.month = month;
	}



	public String getOutfitType() {
		return outfitType;
	}



	public void setOutfitType(String outfitType) {
		this.outfitType = outfitType;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
