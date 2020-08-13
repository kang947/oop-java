package assignment2.a;

//---------------------------------------------------------------------
//Assignment #2
//Part: 1
//Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//---------------------------------------------------------------------

public class Tram extends CityBus{

	private int maxSpeed;
	
	public Tram(){
		maxSpeed=80;
	}
	public Tram(double t, int n, long r, int b, String l, String d, int m){
		super(t,n,r,b,l,d);
		maxSpeed=m;
	}
	public Tram(Tram t){
		//grandfather attribute
		setTicketPrice(t.getTicketPrice());
		setNbOfStops(t.getNbOfStops());
		
		//father attribute
		setRouteNum(t.getRouteNum());
		setBeginOpYr(t.getBeginOpYr());
		setLineName(t.getLineName());
		setDriverName(t.getDriverName());
		
		
		//child attribute
		maxSpeed= t.maxSpeed;
	}
	
	
	
	//getter and setter
	public void setMaxSpeed(int m){
		maxSpeed=m;
	}
	public int getMaxSpeed(){
		return maxSpeed;
	}
	
	//equal() & toString()
	public boolean equals(Object x){
		if(x == null)
			return false;
		else if(this.getClass()!=x.getClass())
			return false;
		else{
			Tram t = (Tram) x;
			return(this.getTicketPrice()==t.getTicketPrice() && this.getNbOfStops()==t.getNbOfStops() &&
					this.getRouteNum()==t.getRouteNum() && this.getBeginOpYr()==t.getBeginOpYr() &&
					this.getLineName()== t.getLineName() && this.getDriverName()==t.getDriverName() &&
					this.maxSpeed== t.maxSpeed);
		}
	}
	public String toString(){
		return "This Tram has " +getNbOfStops()+" stops and the ticket price is "+ getTicketPrice()+"$. Also, the route number "
				+ "is "+getRouteNum()+". It begun its operation on "+getLineName()+" line since "+getBeginOpYr()+". The name of the driver of this tram is"
				+ getDriverName()+" and the maximum speed is "+maxSpeed +"km/h.";
	}
}
