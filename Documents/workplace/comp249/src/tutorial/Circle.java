package tutorial;

public class Circle extends Shape {

	private double radius;
	
	
	public Circle(){
		radius=0.0;
	}
	
	public void setRadius(double r){
		radius = r;
	}
	
	public double getArea(){
		return (3.14*radius*radius);
	}
	
	public String toString(){
		return("Area of this Circle: "+getArea());
	}
	
	

}
