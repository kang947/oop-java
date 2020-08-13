package lab;

public class Pet {
	
	protected String type;
	protected double price;
	protected double weight;
	
	//ctor
	public Pet(){
		type = "Tiger";
		price = 50000.00;
		weight = 355.79;
	}
	
	public Pet(String t, double p , double w){
		type = t;
		price = p;
		weight = w;
	}
	
	public Pet(Pet p){
		type = p.type;
		price =p.price;
		weight= p.weight;
	}
	
	
	public double computeFeedingCost(){
		return (weight*price/25);
	}

	
	//getter and setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString(){
		return "The type of this pet is "+type+" and the price is "+price+"$ and the weight is "+weight+"pounds";
	}
	
}
