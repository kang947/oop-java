package lab;

public class Circle {
	private double radius =0;
	
	public Circle(double r){
		radius = r;
	}
	
	public Circle(Circle c){
		
	}
	
	public void setRadius(double r){
		this.radius =r;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public boolean equals(Circle a, Circle b){
		return a == b; 
	}
	
	public double getArea(){
		return radius*radius*Math.PI;
	}
	
	public String toString(){
		return "the radius is "+radius+" and the area of the circle is "+ getArea();
	}
	
	
	public static double getTotalArea(Circle[] a){
		 double totalV=0.0;
		for(int i=0; i<a.length;i++){
			totalV += a[i].getArea();
		}
				return totalV;
	}
	
	public static void main(String[] args) {
	
		//#1
	Circle c1= new Circle(4);
	
	
	System.out.println(c1.getArea());
	
	
	
	//#2
	Circle c2= new Circle(3);
	
	
	System.out.println(c2.getArea());
	
	
	
	//#3
	Circle [] c3 = {c1,c2};

	
	System.out.println(getTotalArea(c3));
	
	
	System.out.println(c1);
	System.out.println(c2);
	
	
	
	}
	
	
}







	


