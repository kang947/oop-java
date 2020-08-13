package assignment2;

//---------------------------------------------------------------------
//Assignment #2
//Part: 1
//Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//---------------------------------------------------------------------

public class PublicTransportation {

	protected double ticketPrice;
	protected int nbOfStops;
	
	
	//ctors
	public PublicTransportation(){
		ticketPrice=100.00;
		nbOfStops=4;
	}
	public PublicTransportation(double t, int n){
		ticketPrice= t;
		nbOfStops=n;
	}
	public PublicTransportation(PublicTransportation p){
		ticketPrice=p.ticketPrice;
		nbOfStops=p.nbOfStops;
	}
	
	
	
	//getter and setter
	public void setTicketPrice(double t){
		ticketPrice=t;
	}
	public double getTicketPrice(){
		return ticketPrice;
	}
	
	public void setNbOfStops(int n){
		nbOfStops=n;
	}
	public int getNbOfStops(){
		return nbOfStops;
	}
	
	//equal() & toString()
	public boolean equals(Object x){
		if(x == null)// equal() does not check null condition because the argument must be an object, which null is not.
			return false; // having a 'null verification' helps to prevent runtime error.
		else if(this.getClass()!=x.getClass())
			return false;
		else{
			//casting passed to this
			PublicTransportation p = (PublicTransportation) x;
			return(this.nbOfStops==p.nbOfStops&&this.ticketPrice==p.ticketPrice);
		}
	}
	
	public String toString(){
		return "This vehicle has " +nbOfStops+" stops and the ticket price is "+ ticketPrice+"$. ";
	}
	
	
	
}
