package lab;

public class Bicycle extends Vehicle{
	
	public Bicycle(){
		super(1,1930);
	}
	
	
	public String toString(){
		return "I am a bicycle built in "+getBuiltYear()+", and I carry "+getNbOfSeat()+" person";
	}
	
	public String greeting(){
		return toString()+", my power engine depends on you!";
	}

}
