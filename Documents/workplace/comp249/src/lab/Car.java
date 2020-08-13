package lab;

public class Car extends Vehicle {
	
	private String enginePow;
	
	//ctors
	public Car(){
		enginePow = "10mile per hour";
	}
	
	public Car(Car c){
		enginePow =c.enginePow;
		
	}
	public Car(String s){
		enginePow= s;
	}
	//ctor using super
	public Car(int ns, int by, String s){
		super(ns,by);
		enginePow= s;
	}
	
	
	public String toString(){
		return "I'm a car, I was built in "+ getBuiltYear()+ ", I carry "+ getNbOfSeat()+" persons";
	}
	
	public String greeting(){
		return toString()+ " with the engine power of, " +enginePow;
	}
	
	
	
	public void setEnginePow(String e){
		enginePow=e;
	}
	
	public String getEnginePow(){
		return enginePow;
	}
	
}
