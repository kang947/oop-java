package assignment2.e;

//---------------------------------------------------------------------
//Assignment #2
//Part: 2
//Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//---------------------------------------------------------------------

public class Metro extends CityBus {

	
	private int nbOfV;
	private String cityName;
	
	//ctor
	public Metro(){//default
		nbOfV=3;
		cityName="Montreal";
	}
	
	public Metro(double t, int n, long r, int b, String l, String d, int v, String c){
		super(t,n,r,b,l,d);
		nbOfV=v;
		cityName=c;
	}
	
	public Metro(Metro m){
		//grandfather attribute
		setTicketPrice(m.getTicketPrice());
		setNbOfStops(m.getNbOfStops());
		
		//father attribute
		setRouteNum(m.getRouteNum());
		setBeginOpYr(m.getBeginOpYr());
		setLineName(m.getLineName());
		setDriverName(m.getDriverName());
		
		nbOfV=m.nbOfV;
		cityName=m.cityName;
	}
	
	
	//getter and setter?
	public int getNbOfV() {
		return nbOfV;
	}

	public void setNbOfV(int nbOfV) {
		this.nbOfV = nbOfV;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	
	//equal() & toString()
	public boolean equals(Object x){
		if(x==null)
			return false;
		else if(this.getClass()!=x.getClass())
			return false;
		else{
			Metro m = (Metro)x;
			return(this.getTicketPrice()==m.getTicketPrice() && this.getNbOfStops()==m.getNbOfStops() &&
					this.getRouteNum()==m.getRouteNum() && this.getBeginOpYr()==m.getBeginOpYr() &&
					this.getLineName()== m.getLineName() && this.getDriverName()==m.getDriverName() &&
					this.nbOfV==m.nbOfV && this.cityName==m.cityName);
		}
	}
	
	
	public String toString(){
		return "This Metro has " +getNbOfStops()+" stops and the ticket price is "+ getTicketPrice()+"$. Also, the route number "
				+ "is "+getRouteNum()+". It begun its operation on "+getLineName()+" line since "+getBeginOpYr()+". The name of the driver of this Metro is "
				+ getDriverName() +". Currently, the number of vehicle is "+nbOfV+" operating in " +cityName;
	}

	
	
}
