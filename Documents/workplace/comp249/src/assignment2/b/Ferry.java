package assignment2.b;

//---------------------------------------------------------------------
//Assignment #2

//Part: 1
//Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//---------------------------------------------------------------------

import assignment2.PublicTransportation;

public class Ferry extends PublicTransportation{
	
	private int builtYear;
	private String shipName;
	
	
	public Ferry(){
		builtYear = 1909;
		shipName="Titanic";
	}
	
	public Ferry(double t, int n, int b, String s){
		super(t,n);
		
		builtYear =b;
		shipName=s;
	}
	
	public Ferry(Ferry f){
		//father attribute
		setTicketPrice(f.getTicketPrice());
		setNbOfStops(f.getNbOfStops());
		
		//child attribute
		builtYear= f.builtYear;
		shipName =f.shipName;
	}


		
	//setter and getter?
	public int getBuiltYear() {
		return builtYear;
	}

	public void setBuiltYear(int builtYear) {
		this.builtYear = builtYear;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
		
	//equal() & toString()
	
	public boolean equals(Object x){
		if(x == null)
			return false;
		else if(this.getClass()!=x.getClass())
			return false;
		else{
			Ferry f = (Ferry) x;
			return (this.getNbOfStops()==f.getNbOfStops() && this.getTicketPrice()==f.getTicketPrice() &&
					this.builtYear==f.builtYear && this.shipName==f.shipName);
		}
					
	}
	
	
	public String toString(){
		return "This Ferry has "+ getNbOfStops()+" stops, and costs "+getTicketPrice()+"$. It was built in "+ builtYear+
				", and the name of the ship is "+shipName;
	}

		
	
		
}
