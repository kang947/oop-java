package assignment2.d;

import assignment2.PublicTransportation;
import assignment2.e.*;
import assignment2.f.*;
import assignment2.f2.*;
import assignment2.f2.AirCraft.availClass;
import assignment2.f2.AirCraft.availMaintenance;
import java.util.Scanner;


//---------------------------------------------------------------------
//  Assignment #2
//  Part: 2
//	Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//---------------------------------------------------------------------

/*
 * in part 2, the access rights of all classes changed to private. It is hence
 * more secure but the tradeoff is that the children cannot get the super classes' attributes directly.
 * My driver still runs perfectly because it invokes constructors that has invocation for super();
 * 
 */



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
	
	
	public static PublicTransportation[] copyCityBuss(PublicTransportation[] a){
		//create same size array as the passed array
		PublicTransportation[] pt = new PublicTransportation[a.length];
		
		for(int i=0; i<a.length; i++){
			pt[i]= new PublicTransportation (a[i]);
		}
		return pt;
		
	}
	
	
	// display
	public static void displayInventoryInfo(PublicTransportation[] pt){
		System.out.println("\nHere is the information of publicTransportation in that inventory");
		for(int i =0; i<pt.length; i++){
			System.out.println(pt[i]);
		}
	}
	
	public static void main(String[] args) {
		
		//creating objects...
		System.out.println("Creating various objects from the 6 classes and display the information");
	
		PublicTransportation p1 = new PublicTransportation(), p2 = new PublicTransportation(3.25,15);
		p1.setTicketPrice(3.50);
		
		
		CityBus c1 = new CityBus();
		CityBus c2 = new CityBus(2.50, 25,10002,1975,"Westmount","Jean-Francis");
		c1.setTicketPrice(1.75);
		c1.setNbOfStops(20);
		
		Tram t1= new Tram(4.00, 13, 103928, 1966,"Plateau","Robert",50), t2= new Tram(t1);
		
		Metro m1 = new Metro(3,21,102938, 1955, "Angrinon","Jerry",8,"Montreal"),
				m2 = new Metro(2.50, 14, 102939, 1956, "Cote-Vertu", "Jean",9, "Montreal");
		
		Ferry f1 = new Ferry(7.50, 2, 1992,"Titanic"),
				f2 = new Ferry(13, 1, 1993, "Poseidon");
		f1.setTicketPrice(3.25);
		f1.setNbOfStops(15);
		
		
		
		
		AirCraft a1 = new AirCraft(1050.00, 1, AirCraft.availClass.Airline, AirCraft.availMaintenance.Monthly),
				a2 = new AirCraft(2324, 2, AirCraft.availClass.Helicopter, AirCraft.availMaintenance.Weekly);
		
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
		PublicTransportation [] array = new PublicTransportation[] {p1,c2,m1,t1,a1} ;
		
	
		
		
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
		System.out.println("=====================================================================================");
		System.out.println("Here is the info of inventory 1");
		PublicTransportation[] ptInv1 = new PublicTransportation[] {p1,p2,c1,c2,m1,m2,t1,t2,a1,a2,f1,f2};

		displayInventoryInfo(ptInv1);
		
		
		System.out.println("=====================================================================================");
		
		PublicTransportation [] ptInv2 = copyCityBuss(ptInv1);
		displayInventoryInfo(ptInv2);
		System.out.println("=====================================================================================");
		
		System.out.println("the two inventory are different because copyCityBuss() only calls the copy constructor of PublicTransportation class."
				+ "\nany passing object is subclass of PublicTransportation class, it is possible to invoke PublicTransportation constructor. ");
		
		System.out.println("the minimum value is "+minInd +" and index is " +indMin);
			System.out.println("the maximum value is "+ maxInd +" and the index is "+ indMax);
		
			Scanner kb = new Scanner(System.in);
		double d1;
		d1= kb.nextDouble();
		
		System.out.println(d1);
		
		
	}
	
	

}
