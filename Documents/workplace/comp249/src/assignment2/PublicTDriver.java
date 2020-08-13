package assignment2;


//---------------------------------------------------------------------
//Assignment #2
//Part: 1
//Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//---------------------------------------------------------------------

import assignment2.*;
import assignment2.a.*;
import assignment2.b.*;
import assignment2.b2.AirCraft;
import assignment2.b2.AirCraft.availClass;

public class PublicTDriver {

	//display info by using overridden toString()
	public static void showTransportationInfo (Object x){
		if(x instanceof PublicTransportation){
			System.out.println("Here is the information of this transportation");
			System.out.println(x);
			System.out.println();
		}
		else
			System.out.println("Not a child of PublicTransportation");
		
	}
	

	
	
	
	public static void main(String[] args) {
		
		//creating objects...
		System.out.println("Creating various objects from the 6 classes and display the information");
	
		PublicTransportation p1 = new PublicTransportation(), p2 = new PublicTransportation(3.25,15);
		p1.setTicketPrice(3.50);
		
		
		CityBus c1 = new CityBus(), c2 = new CityBus(2.50, 25,10002,1975,"Westmount","Jean-Francis");
		c1.setTicketPrice(1.75);
		c1.setNbOfStops(20);
		
		Tram t1= new Tram(4.00, 13, 103928, 1966,"Plateau","Robert",50), t2= new Tram(t1);
		
		Metro m1 = new Metro(3,21,102938, 1955, "Angrinon","Jerry",8,"Montreal");
		
		Ferry f1 = new Ferry(7.50, 2, 1992,"Titanic");
		f1.setTicketPrice(3.25);
		f1.setNbOfStops(15);
		
		
		
		AirCraft a1 = new AirCraft(1050.00, 1, AirCraft.availClass.Airline, AirCraft.availMaintenance.Monthly);
		
		//display
		System.out.println(p1);
		System.out.println(c1);
		System.out.println(m1);
		System.out.println(t1);
		System.out.println(a1);
		System.out.println(f1);
		
		if(p1.equals(c1))
			System.out.println("public-trans p1 & city-bus c1 are equal");
		else
			System.out.println("public-trans p1 & city-bus c1 are not equal");

		
		if(t2.equals(t1))
			System.out.println("Tram t1 & tram t2 are equal");
		else
			System.out.println("Tram t1 & tram t2 are not equal");
		
		if(f1.equals(p2))
			System.out.println("ferry f1 & public-trans p2 are equal");
		else
			System.out.println("ferry f1 & public-trans p2 are not equal");
		
		//object array
		PublicTransportation [] array = new PublicTransportation[] {p1,c1,m1,t1,a1} ;
		
		// function
		
		
		//trace min and max
		
		
		double minInd= array[0].getTicketPrice();
		double maxInd= array[0].getTicketPrice();
		int indMax=0;
		int indMin=0;
		
		System.out.println(c1.getTicketPrice());
		
		for(int i =0; i<array.length;i++){
			if(minInd>array[i].getTicketPrice()){
				minInd = array[i].getTicketPrice();
				indMin=i;
			}
			if(maxInd<array[i].getTicketPrice()){
				maxInd = array[i].getTicketPrice();
				indMax=i;
			}
		
		}
			
		
		
		System.out.println("the minimum value is "+minInd +" and index is " +indMin);
			System.out.println("the maximum value is "+ maxInd +" and the index is "+ indMax);
	
		
		
		
	}
	
	

}
