package tutorial;

//if abstract, it does not need to return any specific value. 
//it has nothing to do with visibility such as public private protected etc. 
public class Shape {
	
	public double getArea(){
		return 0.0;
	}
	
	public static double totalArea(Shape[]s){
		double total =0.0;
		
		for(int i=0; i<s.length;i++){
			 total = s[i].getArea();//getArea method is mandatory to calculate the object's double-form area. 
		}
		return total;
	}
}
