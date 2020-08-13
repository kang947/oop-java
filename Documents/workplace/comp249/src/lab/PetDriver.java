package lab;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class PetDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating object
		Cats c1 = new Cats("Persian",550,10),
				c2 = new Cats(c1);
;		Dogs d1 = new Dogs("Pitbull",600,14,true);
		Cats c3 = new Cats("Nabee", 1390, 23);
		Dogs d2 = new Dogs("Yorkie", 1200,5,false),
				d3 = new Dogs(d2);
		Cats c4= new Cats("StreetCat", 10,30);
		Cats c5 = new Cats();
		Dogs d4 = new Dogs();
		Dogs d5 = new Dogs("Pome", 1100, 4,true);
		
		Pet [] petArray = {c1,c2,c3,c4,c5,d1,d2,d3,d4,d5};
		
//		static void shuffleArray(Object[] ar)
//		{
//			Random rd = ThreadLocalRandom.current();
//			for( int i = ar.length-1; i>0; i--){
//				int index = rd.nextInt(i+1);
//				//simple swap
//				Object a = ar[index];
//				ar[index]= ar[i];
//				ar[i] = a;
//			}
//		}
		
		
		System.out.println(c1);
		System.out.println(c1.computeFeedingCost());
		System.out.println(d4);
	}

}
