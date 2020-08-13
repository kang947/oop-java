package lab;

public class Dogs extends Pet {
	
	private boolean trained;
	
	
	//ctor
	public Dogs(){
		trained=true;
	}
	public Dogs(String t, double p, double w, boolean tr){
		super(t,p,w);
		
		trained =tr; 
	}
	public Dogs(Dogs d){
		setType(d.getType());
		setPrice(d.getPrice());
		setWeight(d.getWeight());
		
		trained = d.trained;
	}
	
	
	
	public double computeFeedingCost(){
		if(trained)
			return (15+(weight*price/25));
		else
			return super.computeFeedingCost();
	}
	
	
	
	
	//toString
	public String toString(){
		String yes;
		if (trained)
			yes = "trained";
		else
			yes = "not trained";
		
		return "This dog is "+getType()+" and the price is "+getPrice()+"$ and the weight is "+getWeight()+"pounds. This dog is " +yes;
	}
	
}
