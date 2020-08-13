package assignment2.b2;

//---------------------------------------------------------------------
//Assignment #2

//Part: 1
//Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//---------------------------------------------------------------------

import assignment2.PublicTransportation;

public class AirCraft extends PublicTransportation {
	
	//enum delcare
	public static enum availClass {Helicopter, Airline, Glider, Balloon}
	public static enum availMaintenance {Weekly, Monthly, Yearly}
	
	
	//attributes
	private availClass airClass;
	private availMaintenance airMaintenance;
	
	//c-tor
	public AirCraft(){
		airClass =availClass.Helicopter;
		airMaintenance = availMaintenance.Weekly;
		
	}
	
	public AirCraft(double t, int n, availClass c, availMaintenance m){
		super(t,n);
		
		airClass=c;
		airMaintenance =m;
	}
	
	public AirCraft(AirCraft a){
		
		//father attribute
		setTicketPrice(a.getTicketPrice());
		setNbOfStops(a.getNbOfStops());
		
		//child attribute
		airClass =a.airClass;
		airMaintenance = a.airMaintenance;
	}
	
	
	//getters & setters
	public void setAirClass(availClass c){
		this.airClass=c;
	}
	
	public availClass getAirClass(){
		return airClass;
	}
	
	public void setAirMaintenance(availMaintenance m){
		this.airMaintenance=m;
	}
	public availMaintenance getAirMaintenance(){
		return airMaintenance;
	}
	
	
	//equals() & toString()
	
	public boolean equals(Object x){
		if(x==null)
			return false;
		else if(this.getClass()!=x.getClass())
			return false;
		else{
			AirCraft c = (AirCraft) x;
			return (this.getNbOfStops()==c.getNbOfStops() && this.getTicketPrice()==c.getTicketPrice() &&
					this.airClass==c.airClass && this.airMaintenance==c.airMaintenance);
		}
	}
	
	public String toString(){
		return "This AirCraft has "+getNbOfStops()+" stops, and costs "+getTicketPrice()+"$. The class type of this AirCraft is "
	+airClass+" and it has "+ airMaintenance+" maintenance checkups.";
	}
	
	
	
	
	
	
	
	
	
	

}
