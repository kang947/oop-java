package lab;

public abstract class Vehicle {

	private int nbOfSeat;
	private int builtYear;
	
	public String toString(){
		return "This vehicle was built in, "+builtYear +" and it can carry, "+nbOfSeat +" persons";
	}
	
	//ctor
	public Vehicle(){
		nbOfSeat =1;
		builtYear =1997;
	}
	
	//copy ctor
	public Vehicle(Vehicle v){
		nbOfSeat = v.nbOfSeat;
		builtYear = v.builtYear;
	}
	
	public Vehicle(int ns, int by){
		nbOfSeat=ns;
		this.builtYear=by;
	}
	
	//abstract
	public abstract String greeting();

	
	//get set
	public int getNbOfSeat() {
		return nbOfSeat;
	}

	public void setNbOfSeat(int nbOfSeat) {
		this.nbOfSeat = nbOfSeat;
	}

	public int getBuiltYear() {
		return builtYear;
	}

	public void setBuiltYear(int builtYear) {
		this.builtYear = builtYear;
	}
	
	
	
	
	
}
