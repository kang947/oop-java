package assignment2.e;

//---------------------------------------------------------------------
//Assignment #2

//Part: 2
//Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//---------------------------------------------------------------------

import assignment2.PublicTransportation;

public class CityBus extends PublicTransportation {

	 long routeNum;
	 int beginOpYr;
	 String lineName;
	 String driverName;
	
	//ctors
	public CityBus(){
		//default
		routeNum=100000;
		beginOpYr=1900;
		lineName="blue";
		driverName="Jack";
		
	}
	
	public CityBus(double t, int n, long r, int b, String l, String d){
		super(t,n);
		
		routeNum=r;
		beginOpYr=b;
		lineName=l;
		driverName=d;
		
		
	}
	
	public CityBus(CityBus c){
		
		//father attribute
		setTicketPrice(c.getTicketPrice());
		setNbOfStops(c.getNbOfStops());
		
		//child attribute
		routeNum=c.routeNum;
		beginOpYr=c.beginOpYr;
		lineName=c.lineName;
		driverName=c.driverName;
	}
	
	
	
	//getter and setter
	public long getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(long routeNum) {
		this.routeNum = routeNum;
	}

	public int getBeginOpYr() {
		return beginOpYr;
	}

	public void setBeginOpYr(int beginOpYr) {
		this.beginOpYr = beginOpYr;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	
	//equal() & toString()
	public boolean equals(Object x){
		if(x == null)
			return false;
		else if(this.getClass()!=x.getClass())
			return false;
		else{
			CityBus c = (CityBus) x;
			return (this.getNbOfStops()==c.getNbOfStops() && this.getTicketPrice()==c.getTicketPrice() &&
					this.routeNum==c.routeNum && this.beginOpYr==c.beginOpYr && this.lineName==c.lineName &&
					this.driverName==c.driverName);
		}
	}
	
	public String toString(){
		return "This City bus has " +getNbOfStops()+" stops and the ticket price is "+ getTicketPrice()+"$. Also, the route number "
				+ "is "+routeNum+". It begun its operation on "+lineName+" line since "+beginOpYr+". The name of the driver of this bus is "
				+ driverName;
	}
	
	
	
}
