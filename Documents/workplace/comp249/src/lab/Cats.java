package lab;

public class Cats extends Pet {
	
	//no new attribute
	
	//ctor
	public Cats(){
	}
	
	public Cats(String t, double p, double w){
		super(t,p,w);
	}
	
	public Cats(Cats c){
		setType(c.getType());
		setPrice(c.getPrice());
		setWeight(c.getWeight());
	}
	
	//no need to create computeFeedingCost() b/c same as super. 
	
	//toString
	public String toString(){
		return "This cat is "+getType()+" and the price is "+getPrice()+"$ and the weight is "+getWeight()+"pounds.";
	}
	
}
